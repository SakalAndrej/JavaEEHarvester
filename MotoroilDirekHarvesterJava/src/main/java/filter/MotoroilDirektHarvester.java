package filter;
import model.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

public class MotoroilDirektHarvester {

    //Harvest the given ad and then makes a car of this ad
    private static Product HarvestInnerProduct(String justLink) {


        //region Build Connection
        String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
        Connection.Response res = null;
        Document documentForLogin = null;

        try {
            //first connection with GET request
            res = Jsoup.connect("http://www.motoroeldirekt.at/themes/user/index.php")
                    .userAgent(USER_AGENT)
                    //  .header("Accept", WhateverTheSiteSends)
                    //  .timeout(Utilities.timeout)
                    .method(Connection.Method.GET)
                    .execute();
        } catch (Exception ex) {
            //Do some exception handling here
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Product Page \nError Message:" + ex.getMessage());
        }
        try {
            documentForLogin = Jsoup.connect("http://www.motoroeldirekt.at/themes/user/index.php")
                    .userAgent(USER_AGENT)
                    //          .referrer(Referer)
                    //          .header("Content-Type", ...)
                    .cookies(res.cookies())
                    .data("action", "login")
                    .data("formaction", "login")
                    .data("source", "post")
                    .data("kundenid", "")
                    .data("location", "")
                    .data("sourceid", "1")
                    .data("location", "")
                    .data("bwartikelid", "")
                    .data("email", "office@oel-billiger.at")
                    .data("passwort", "andiiana1")
                    .data("einloggen", "Login")
                    .post();
        } catch (Exception ex) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Product Page \nError Message:" + ex.getMessage());
        }

        //The downloaded Productpage
        Document doc = null;
        try {
            doc = Jsoup.connect(justLink).cookies(res.cookies()).get();
        } catch (IOException e) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Product Page \nError Message:" + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Jsoup Null Pointer Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Product Page \nError Message:" + e.getMessage());
        }

        //Filter the Information - Use the information of the Header to build my ad
        String head = String.valueOf(doc.body());
        Elements artikelDetailBox = doc.select("section.artikelDetailBox");
        Elements descript = doc.select("section.artikelDetailOther");
        //endregion

        //Here I am going to save all infos ---------------------------------
        Product p = new Product();
        Elements title = artikelDetailBox;
        Elements pic = artikelDetailBox;

        //region Save the pictures (SmallImage, BaseImage)
        String f = pic.select("div.artikelDetailBildBox").select("span#artikelDetailBild").outerHtml();
        f = f.substring(f.indexOf("href=") + 6, f.length()).replace(" ", "");
        f = f.substring(0, f.indexOf("\">"));

        try (InputStream in = new URL(f).openStream()) {
            try {
                f = f.substring(f.lastIndexOf("/") + 1, f.length());

                if (!Files.exists(Paths.get("/Applications/XAMPP/xamppfiles/htdocs/website/magento/media/import/" + f)))
                    Files.copy(in, Paths.get("/Applications/XAMPP/xamppfiles/htdocs/website/magento/media/import/" + f));
                else
                    System.out.print("Picture already exists\n");
                p.set_baseImage(f);
                p.set_smallImage(f);
            } catch (IOException e) {
                System.out.println("Files Error IOException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.out.println("InputStream Error MalformedURLException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("InputStream Error IOException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
        }
        //endregion

        //Save the artikelid -----------------------------------------------------------------------------
        p.set_sku(justLink.substring(justLink.indexOf("artikelid=") + 10, justLink.indexOf("&")));

        //Save the price ---------------------------------------------------------------------------------
        p.set_title(title.select("h1").text());

        if (p.get_title().toLowerCase().contains("mororöl"))
            p.set_title(p.get_title().replace("Mororöl", "Motoröl"));

        try {
            double price = Double.parseDouble(title.select("div.artikelDetailInfos").select("span#artikelPreis").text().replace(" €", "").replace(",", "."));

            if (price <= 3) {
                price = price * 1.2 * 1.5;
            } else if (price <= 5) {
                price = price * 1.2 * 1.40;
            } else if (price <= 50) {
                price = price * 1.2 * 1.35;
            } else if (price <= 100) {
                price = price * 1.2 * 1.30;
            } else if (price > 100) {
                price = price * 1.2 * 1.25;
            } else if (price > 1000) {
                price = price * 1.2 * 1.23;
            } else {
                System.out.println("------------------------------> ERROR IN PRICE CALC <---------------------------------\nThe Problematic Price: " + price);
            }
            int temp = (int) price;
            price = temp + 0.9;
            p.set_price(price);
        } catch (NumberFormatException ex) {
            System.out.println("DoubleParse Error NumberFormatException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Calculate the price \nError Message:" + ex.getMessage());
        }

        //Calculating the Weight of the Product through the String
        p.set_container(RecognationOfContainer(p));

        //Save the description -------------------------------------------------------------------
        p.set_description(descript.select("div.artikelDetailTabBox").html().replace("\n", ""));

        //Save the stock status ------------------------------------------------------------------
        String stock = title.select("div.artikelDetailInfos").select("div#filialBestaende").text();

        if (stock.contains("0 Stk. verfügbar in Filiale Wr Neustadt") && stock.contains("0 Stk. verfügbar in Filiale Schwechat")) {
            p.set_inStock(0);
        } else {
            //Go through the string an get the stock out
            String helper = stock.substring(stock.indexOf("Schwechat") + 10, stock.length());
            helper = helper.substring(0, helper.indexOf("Stk.") - 1);

            if (helper.contains("mehr als 100"))
                p.set_inStock(100);
            else
                p.set_inStock(Integer.parseInt(helper));
        }
        return p;
    }

    /**
     * Filtering the Weight of the Product
     *
     * @param p Give the Product of which have to be calculated the Container
     * @return The Weigth of the Product
     */
    private static double RecognationOfContainer(Product p) {
        double container = 0;
        int found = 0;
        boolean lastNumeric = false;

        for (int i = 0; i < p.get_title().length(); i++) {
            String test = String.valueOf(p.get_title().charAt(i));
            if (isNumeric(test)) {
                if (found == 0) {
                    container = Double.parseDouble(test) + container;
                    found++;
                } else {
                    container = container * 10;
                    container = (Double.parseDouble(test) + container);
                }
                lastNumeric = true;
            } else if (lastNumeric) {
                if (test.equals("l")) {
                    break;
                } else if (test.equals("m") && String.valueOf(p.get_title().charAt(i + 1)).equals("l")) {
                    container = container / 1000;
                } else {
                    container = 0;
                    lastNumeric = false;
                    found = 0;
                }
            }
        }
        if (container == 0)
            System.out.print("------------------------------------> ERROR <-----------------------------------------");

        return container;
    }

    /**
     * @param s The String which have to be checked if it is a number
     * @return Tells me if the given String is a Number
     */
    private static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     * This Method harvest all Sites with the specific algorithm to get all of the ads in willhaben
     * Then it gives one page to the other method -> the other method harvests all ads and gives the
     * ads to another method -> the last method makes of the ads cars.
     * So this methods gives all cars on willhaben
     *
     * @return
     * @throws IOException
     */
    public static HashMap<String, Product> HarvestAllSites(LinkedList<String> allSites) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Start: " + sdf.format(cal.getTime()));

        HashMap<String, Product> allProducts = new HashMap<String, Product>();
        HashMap<String, Product> write = new HashMap<String, Product>();

        for (int i = 0; i < allSites.size(); i++) {

            //Den aktuellen Link des Produktes hinschicken und dann den produkt des linkes zurückkriegen
            Product p = HarvestInnerProduct(allSites.get(i));

            if (p != null) {
                write.put(p.get_sku(), p);
                allProducts.put(p.get_sku(), p);
                WriteToCSV(write);
                System.out.print("Waitin 5 Sec. - Did " + (i + 1) + " Products - Last Product: " + p.get_title() + " - Link to Pic: " + p.get_baseImage() + "\n");
            }
            try {
                Thread.sleep(4 * 1000);
            } catch (InterruptedException e) {
                System.out.println("ThreadSleep Error InterruptedException -> MotoroilDirektHarvester in the Method HarvestAllSites() -> Sleep the Thread for 4 sec \nError Message:" + e.getMessage());
            }
        }

        sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("End-Time: " + sdf.format(cal.getTime()));
        System.out.println("Anzahl der Produkte: " + allProducts.size() + "\n");
        return allProducts;
    }

    private static void WriteToCSV(HashMap<String, Product> c) {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter("/Users/sakal_andrej/Desktop/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/test.csv", "UTF-8");
            writer.print("sku;tax_class_id;visibility;status;weight;_product_website;_type;_attribute_set;short_description;description;name;qty;price;image;small_image;thumbnail;weight\n");
            for (int i = 0; i < c.size(); i++) {
               writer.append(c.values().toArray()[i].toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}
