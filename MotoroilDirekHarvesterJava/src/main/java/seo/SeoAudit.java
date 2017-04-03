package seo;

import model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SeoAudit {

    public static final String OilSearcherTextsFileName = " ";

    public static final String AnkerTextsFileName = " ";

    public static void addOilFinderMannol(List<Product> allMannolProducts) {


        for (int i = 0; i < allMannolProducts.size(); i++) {
            Product actProd = allMannolProducts.get(i);
            String actString = "hi";

            if (actProd.is_customDescription() == false) {
                String descrip = actProd.get_description();

                descrip = descrip + "<center><br><br><h1>Mannol Ölfinder</h1><br><br><p>Sie wissen nicht genau welches Motor- oder Getriebelöl sie brauchen? Dann einfach kurz den Mannol Ölfinder öffnen, richtige Marke & Modell aussuchen und schon können Sie alle Informationen über Ihr geliebtes Auto nachlesen!" +
                        "<form action=\"http://sct-catalogue.de/?action=catalog\">\n" +
                        "    <input type=\"submit\" value=\"Ölfinder Mannol\" alt=\""+ actProd.get_brand() +"\" title=\"" + actProd.get_metaTitle() + "\"/>\n" +
                        "</form></center>";
                actProd.set_description(descrip);
            }
        }
    }

    /*public static LinkedList<Product> addLinksToDescription(int amount) {

    }

    public static LinkedList<Product> addTestResultsMannol(int amoutn) {

    }

    public static LinkedList<String> readOilSearcherTexts() {

    }

    public static LinkedList<String> readAnkerTexts() {

    }
    */

    public static LinkedList<String> ReadTags(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        LinkedList<String> tags = new LinkedList<String>();


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                Collections.addAll(tags, line.split(csvSplitBy));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tags;
    }
}
