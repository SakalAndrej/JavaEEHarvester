package filter;
import model.Products;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@Stateless
public class MotoroilDirektHarvester {

    @PersistenceContext
    EntityManager em;


    public final String FILENAME = "/home/manager/www/var/import/";
    //public final String MACFILENAME = "/Users/andrejsakal/Dropbox/Projects/JavaEEHarvester/MotoroilDirekHarvesterJava/src/main/resources/";

    public final String FILEPATHIMAGE = "/home/manager/www/media/import/";
    //public final String MACFILEPATHIMAGE = "/Users/andrejsakal/Dropbox/Projects/JavaEEHarvester/media/";

    public int getAvgDurationPerProduct() {
        return (int) (duration/allProducts.size());
    }

    public void setAllLinks(LinkedList<String> allLinks) {
        this.allLinks = allLinks;
    }

    private int avgDurationPerProduct;

    private int eat;

    private LinkedList<String> allLinks = new LinkedList<>();

    private long duration;

    private LinkedList<Products> allProducts = new LinkedList<>();

    public void InitializeLinks() {
        LinkedList<Products> products = new LinkedList<>();

        //region Part End:

        //region Fette & Pasten
        LinkedList<String> FettePasten = new LinkedList<>();
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8358&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11177&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8359&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8360&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8361&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8362&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8363&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8357&kategorieid=4008&source=2&refertype=1&referid=4008");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8337&kategorieid=4009&source=2&refertype=1&referid=4009");
        FettePasten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8356&kategorieid=4009&source=2&refertype=1&referid=4009");
        //endregion

        //region Motoroil & Additives Links
        LinkedList<String> MotoroilAndAdditives = new LinkedList<String>();

        //region Mannol
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13443&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8352&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8353&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8344&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8350&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8340&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8338&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8339&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8397&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8342&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8343&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8347&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8346&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8354&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8355&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8341&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8349&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8348&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8244&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8242&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8476&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8243&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8265&kategorieid=3961&source=2&refertype=1&referid=3961");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8266&kategorieid=3961&source=2&refertype=1&referid=3961");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8271&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8478&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8272&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8277&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8275&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13544&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8479&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8276&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8270&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8269&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8114&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8115&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8113&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13543&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8258&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8256&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8645&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8480&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8257&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8112&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8280&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8278&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8477&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8279&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8254&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8251&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8255&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8253&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8252&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8111&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8523&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8521&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8522&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8526&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8528&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8527&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11178&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11180&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11179&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8261&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8259&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8730&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8261&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8259&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8730&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8481&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8260&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8729&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8262&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8727&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8482&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8263&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8511&kategorieid=3963&source=2&refertype=1&referid=3963");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8248&kategorieid=3993&source=2&refertype=1&referid=3993");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8483&kategorieid=3993&source=2&refertype=1&referid=3993");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8249&kategorieid=3993&source=2&refertype=1&referid=3993");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11182&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11184&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11183&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11185&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8281&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8284&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8283&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8118&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8109&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8529&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8533&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8531&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8530&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8532&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8534&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8535&kategorieid=3964&source=2&refertype=1&referid=3964");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8247&kategorieid=3965&source=2&refertype=1&referid=3965");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8245&kategorieid=3965&source=2&refertype=1&referid=3965");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8484&kategorieid=3965&source=2&refertype=1&referid=3965");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8246&kategorieid=3965&source=2&refertype=1&referid=3965");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8513&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8515&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8514&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12746&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11186&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11188&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11187&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11189&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8490&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8489&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11181&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8286&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8728&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8110&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8285&kategorieid=3966&source=2&refertype=1&referid=3966");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8486&kategorieid=4022&source=2&refertype=1&referid=4022");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8488&kategorieid=4022&source=2&refertype=1&referid=4022");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8487&kategorieid=4022&source=2&refertype=1&referid=4022");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8290&kategorieid=3967&source=2&refertype=1&referid=3967");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8288&kategorieid=3967&source=2&refertype=1&referid=3967");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8485&kategorieid=3967&source=2&refertype=1&referid=3967");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8289&kategorieid=3967&source=2&refertype=1&referid=3967");
        //endregion

        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Longlife-III-Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Longlife-III-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600--Motoroel-1l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-5l?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-1l?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-205l-Fass?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-5l?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-1l?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-205l-Fass?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-5l?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2064");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Leichtlauft-10W-40-Motoroel-Basic-60l-Fass?source=2&refertype=1&referid=2065");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-1l?source=2&refertype=1&referid=2066");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-205l-Fass?source=2&refertype=1&referid=2066");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-20l-Kanister?source=2&refertype=1&referid=2066");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-5l?source=2&refertype=1&referid=2066");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-60l-Fass?source=2&refertype=1&referid=2066");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Gasmotorenoel-15W-40-205l?source=2&refertype=1&referid=2718");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Touring-15W-40-Basic-205l?source=2&refertype=1&referid=2718");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Touring-15W-40-Basic-60l-Fass?source=2&refertype=1&referid=2718");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Liqui-Moly-Touring-High-Tech-20W-50-20l-Kanister?source=2&refertype=1&referid=2700");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-WIV-50601-0W-30-%28vollsynth.%29-1l?source=2&refertype=1&referid=2787");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-WIV-50601-0W-30-%28vollsynth.%29-5l?source=2&refertype=1&referid=2787");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-1l?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-200l-Fass?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-20l-Kanister?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-5l?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-60l-Fass?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-New-Generation-SAE-5W-30-1l?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-New-Generation-SAE-5W-30-5l?source=2&refertype=1&referid=2778");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-1l?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-20l-Kanister?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-5l?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-60l-Fass?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-1l?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-20l-Kanister?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-5l?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-60l-Fass?source=2&refertype=1&referid=2779");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Power-Synt-SAE-10W-40-1l?source=2&refertype=1&referid=2780");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Power-Synt-SAE-10W-40-5l?source=2&refertype=1&referid=2780");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-1l?source=2&refertype=1&referid=2780");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-20l-Kanister?source=2&refertype=1&referid=2780");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-5l?source=2&refertype=1&referid=2780");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-60l-Fass?source=2&refertype=1&referid=2780");
        //endregion

        //region Automatikgetriebe
        LinkedList<String> Automatikgetriebe = new LinkedList<String>();
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8320&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8502&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8454&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8508&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8455&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8458&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8456&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8507&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8457&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8433&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8450&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8453&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8451&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8428&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8427&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8425&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8509&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8426&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8318&kategorieid=4013&source=2&refertype=1&referid=4013");
        Automatikgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8506&kategorieid=4013&source=2&refertype=1&referid=4013");
        //endregion

        //region Schaltgetriebe
        LinkedList<String> Schaltgetriebe = new LinkedList<>();
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8431&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8432&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8732&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8322&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8505&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8323&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8726&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8314&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8510&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8315&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8418&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8416&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8419&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8417&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8734&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8415&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8316&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8413&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8414&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8422&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8420&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8423&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8421&kategorieid=4014&source=2&refertype=1&referid=4014");
        Schaltgetriebe.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8733&kategorieid=4014&source=2&refertype=1&referid=4014");
        //endregion

        //region TrektorBaumaschinen
        LinkedList<String> TraktorBaumaschinen = new LinkedList<>();
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8462&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11208&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8731&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8412&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8411&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8459&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8460&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8461&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8490&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8489&kategorieid=3998&source=2&refertype=1&referid=3998");
        TraktorBaumaschinen.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11181&kategorieid=3998&source=2&refertype=1&referid=3998");
        //endregion

        //region LKW
        LinkedList<String> Lkw = new LinkedList<>();
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8550&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8549&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8539&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8537&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8536&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8538&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8547&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8548&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8540&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8541&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8544&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8542&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8543&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8545&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8546&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8552&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8553&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8554&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8555&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8556&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8557&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8558&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8559&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8562&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8560&kategorieid=3999&source=2&refertype=1&referid=3999");
        Lkw.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8561&kategorieid=3999&source=2&refertype=1&referid=3999");
        //endregion

        //region Motorrad/Motorroller
        LinkedList<String> Motorrad = new LinkedList<>();
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8300&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8303&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8301&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8491&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8492&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8494&kategorieid=4010&source=2&refertype=1&referid=4010");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8304&kategorieid=4012&source=2&refertype=1&referid=4012");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8565&kategorieid=4012&source=2&refertype=1&referid=4012");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8305&kategorieid=4012&source=2&refertype=1&referid=4012");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8308&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8307&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8504&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8501&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13134&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8310&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8309&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8503&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8500&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8297&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8296&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8299&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8298&kategorieid=4011&source=2&refertype=1&referid=4011");
        Motorrad.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8495&kategorieid=4001&source=2&refertype=1&referid=4001");
        //endregion

        //region Boot
        LinkedList<String> Boot = new LinkedList<>();
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8493&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8311&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8312&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8520&kategorieid=4002&source=2&refertype=1&referid=4002");
        //endregion

        //region Hydraulik
        LinkedList<String> Hydraulik = new LinkedList<>();
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8474&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8473&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8475&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8424&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8410&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8408&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8409&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12747&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8407&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8406&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8512&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8107&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8405&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8563&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12751&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12752&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12758&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12760&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12753&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12759&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8430&kategorieid=3946&source=2&refertype=1&referid=3946");
        Hydraulik.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8429&kategorieid=3946&source=2&refertype=1&referid=3946");
        //endregion

        //region Kompressorenöl
        LinkedList<String> Kompressorenöl = new LinkedList<>();
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8469&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8470&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8472&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8466&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8468&kategorieid=4004&source=2&refertype=1&referid=4004");
        //endregion

        //region Saegenkettenöl
        LinkedList<String> Saegeketten = new LinkedList<>();
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8497&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8498&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8293&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8291&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12754&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8294&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8292&kategorieid=3994&source=2&refertype=1&referid=3994");
        Saegeketten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8295&kategorieid=3994&source=2&refertype=1&referid=3994");        //endregion

        //region Kuehlerschutz
        LinkedList<String> Kuehlerschutz = new LinkedList<>();
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8325&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8101&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8400&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8102&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8324&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8099&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8399&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8100&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8326&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8103&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8401&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8104&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8327&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8105&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8402&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8106&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8403&kategorieid=3945&source=2&refertype=1&referid=3945");
        Kuehlerschutz.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8404&kategorieid=3945&source=2&refertype=1&referid=3945");
        //endregion

        //region AdBlue
        LinkedList<String> AdBlue = new LinkedList<>();
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8098&kategorieid=3809&source=2&refertype=1&referid=3809");
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11192&kategorieid=3809&source=2&refertype=1&referid=3809");
        //endregion

        //region Bremsflüssigkeiten
        LinkedList<String> Bremsfluessigkeiten = new LinkedList<>();
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8117&kategorieid=3948&source=2&refertype=1&referid=3948");
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8119&kategorieid=3948&source=2&refertype=1&referid=3948");
        //endregion

        //region Fahrzeugpflege
        LinkedList<String> Fahrzeugpflege = new LinkedList<>();
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8383&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8385&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8384&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8390&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8391&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8333&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8334&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8329&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8394&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8393&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8392&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13432&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8335&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8378&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11191&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8381&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8389&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8330&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8398&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8336&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8331&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8380&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8382&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11176&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8332&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8328&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8379&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8387&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8386&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8377&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8388&kategorieid=4006&source=2&refertype=1&referid=4006");
        Fahrzeugpflege.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8396&kategorieid=4006&source=2&refertype=1&referid=4006");
        //endregion

        //region Kleben & Dichten
        LinkedList<String> KlebenDichte = new LinkedList<>();

        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8371&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8367&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8365&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8366&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8368&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8370&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8369&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8372&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8374&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8376&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8373&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8364&kategorieid=4007&source=2&refertype=1&referid=4007");
        KlebenDichte.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8375&kategorieid=4007&source=2&refertype=1&referid=4007");

        //endregion


        //region Part 2
        //region Liqui Moly Additive
        LinkedList<String> LiquiMolyAdditive = new LinkedList<>();
        //region Öl Additive
        LinkedList<String> OilAdditive = new LinkedList<>();
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly--Pro-Line-Visco-Stabil-300ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-ATF-Additive-250-ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Automatik-Getriebe-Reiniger-300ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Cera-Tec-Verschleisschutz-300ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Gear-Protect-80ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Getriebe-Oel-Additiv-20g?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Getriebeoel-Verlust-Stop-50ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Hydraulik-System-Additiv-1l?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Hydro-Stoessel-Additiv-300ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-Clean-500ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-Protect-500ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-125-ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-200-ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-500-ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Schlamm-Spuelung-300-ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Verlust-Stop-300ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Getriebeoel-Verlust-Stop-500ml?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Oel-Verlust-Stop-1l?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Getriebeoel-Additiv?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Motor-Verschleiss-Schutz?source=2&refertype=1&referid=2069");
        OilAdditive.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Visco-Stabil-1l?source=2&refertype=1&referid=2069");
        //endregion
        LiquiMolyAdditive.addAll(OilAdditive);
        //region Kraftstoff-Additive Benzin
        LinkedList<String> KraftstoffAdditiveBenzin = new LinkedList<>();
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Benzin-Stabilisator-250ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Benzin-Systempflege-300ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Blei-Ersatz-250ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Injection-Reiniger-300-ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-System-Reiniger-Benzin-300ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-mtx-Vergaser-Reiniger-300ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Benzin-System-Reiniger-500ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Benzin-Zusatz-1l?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Benzin-250ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Konzentrat-Benzin-20l-Kanister-1%3A1000?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Ventil-Sauber-150ml?source=2&refertype=1&referid=2070");
        KraftstoffAdditiveBenzin.add("http://www.motoroeldirekt.at/Liqui-Moly-Ventilschutz-fuer-Gasfahrzeuge-1l?source=2&refertype=1&referid=2070");

        //endregion
        LiquiMolyAdditive.addAll(KraftstoffAdditiveBenzin);
        //region Kraftstoff-Additive Diesel
        LinkedList<String> KraftstoffAdditiveDiesel = new LinkedList<>();
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Anti-Bakterien-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Bio-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Bio-Diesel-Additiv-250ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-150ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-K-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-K-5l-Kanne?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Russ-STOP-150-ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Schmier-Additiv-150ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Spuelung-500ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Systempflege-250ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Dieselpartikelfilter-Schutz-250ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-System-Reiniger-Diesel-300ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Diesel-System-Reiniger-500ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Diesel-System-Reiniger-K-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Super-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Diesel-Zusatz-1l?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Diesel-250ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Super-Diesel-Additiv-250ml?source=2&refertype=1&referid=2071");
        KraftstoffAdditiveDiesel.add("http://www.motoroeldirekt.at/Liqui-Moly-Super-Diesel-Additiv-5l-Kanne?source=2&refertype=1&referid=2071");
        //endregion
        LiquiMolyAdditive.addAll(KraftstoffAdditiveDiesel);
        //endregion

        //region meguiars Pflegemittel
        LinkedList<String> meguars = new LinkedList<>();

        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Quik-Detailer-Spray-Sprayreiniger-%C3%A0-650ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Gold-Class-Endurance-Reifenpflege-Gel--%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Hot-Rims-Felgenreiniger--%C3%A0-710-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Gold-Class-Lederreiniger-%26--pflege-Spray-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Wash-%26-Wax-Anywhere-Trigger-768ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Natuerlicher-Glanzschutz-fuer-Vinyl-und-Gummi-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Quik-Detailer-Spray-Schnellreiniger-Innen-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Quik-Wax-Spruehwachs-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Auto-Shampoo-mit-Wachsschutz--%C3%A0-1.42-l?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Spray-Wax-SPRUeHWACHS--%C3%A0-450ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Quik-Detailer-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Waesche-Handschuh-Microfaser-Super-Dick-%28gestrickt%29?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Pure-Clarity-Class-Cleaner-%28aero%29-538g?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Paint-Protect-473ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Tyre-Dressing-Applicator-Pad?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Compound-%C3%A0-450-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Gold-Class-Tiefenpflege-fuer-Kunststoff-%28aussen%29-296ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-NXT-GENERATION-Politur-fuer-alle-Metalle-%C3%A0-148-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-SCRATCH-X-Kratzer-Entferner-%C3%A0-207-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Wax-Paste-%C3%A0-11-oz?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Polish-16oz473ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Gold-Class-Shampoo-und-Konditionierer-%C3%A0-473ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Polster-%2C-Teppich--%26-Innenraumreiniger--%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Auftragungsschwaemme-%282-Stueck%29?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Superabsorber-Wasser-Magnet-Meguiar%26%23039%3Bs-%28gewirkt%29?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-MOTORREINIGER-Engine-Clean-Spray--%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Swirl-Remover-Hologramm-%26-Wirbelkratzer-Entferner-450ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Wax-Liquid-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-One-Step-Headlight-Restoration-Kit?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-MOTORKONSERVIERER-Engine-Dressing-Spray--%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Supreme-Shine-Microfiber-3er-Pack-%28gestrickt%29?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Kalkflecken-Entferner-%C3%A0-473ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Gold-Class-Polish-Liquid-Wax-Fluessigwachs-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Bootswaschmittel--%C3%A0-1.89-l?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Flagship-Premium-Marine-Wachs-%C3%A0-946ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Flagship-Premium-Marine-Shampoo-%26-Conditioner?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Mittlere-Schleifpolitur-2-in-1-M-67-%C3%A0-945ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Even-Coat-Applicator-Pad-%282er-Pack%29?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Ultimate-Set-Gross?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Car-Wash-Set?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Set-Ultimate-klein?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-BootsRV-Hochglanz-Politur-M-45-%C3%A0-473-ml?source=2&refertype=5&referid=182238");
        meguars.add("https://www.motoroeldirekt.at/Meguiars-Spray-Schnell-Wachs-M-59-%C3%A0-473-ml?source=2&refertype=5&referid=182238");

        //endregion

        //region Sonax Pflegemittel

        LinkedList<String> sonax = new LinkedList<>();

        sonax.add("https://www.motoroeldirekt.at/SONAX-KlimaPowerCleaner-antibakteriell-150-ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Felgen-Reiniger-PLUS-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Reifen-Glanz-Spray-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Clean-%26-Drive-Turbo-InnenTuch?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Kunststoff-PflegeTuecher-glaenzend?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Microfaser-Tuecher-Aussen---der-Lackpflegeprofi-%282-St.%29?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Cockpit-Pfleger-Vanilla-fresh-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Polster--%26-Alcantara-Reiniger-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Leder-Pflege-Lotion-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Scheiben-Reiniger-Konzentrat-Citrus-2l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Chrom--%26-Alu-Paste-75ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Scheiben-Reiniger-Konzentrat-Red-Summer-2l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Cockpit-Reiniger-Matteffect-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Kunststoff-Gel-Aussen-NanoPro-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Scheiben-Klar-NanoPro-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Applikations-Schwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Auto-Innen-Reiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Cockpit-Pfleger-Apple-fresh-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Scheibenenteiser-500ml-%2B-250ml-Aktionsgroesse?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AntiFrost-%26amp%3B-KlarSicht-gebrauchsfertig-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Smoke-Ex-Der-Geruchskiller-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Polish-%26-Wax-3-Hybrid-NPT-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Scheiben-Reinigungs-Tuecher-Box?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-FelgenReiniger-PLUS-750ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Polish-%26-Wax-2-Hybrid-NPT-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-Brilliant-Wax-1-Hybrid-NPT-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Polish-%26-Wax-Color-NanoPro-schwarz-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-CockpitPfleger-Matteffect-Red-Summer-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-GummiPfleger-100ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-FelgenReiniger-1l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Microfaser-Tuecher-PLUS-Innen-%26amp%3B-Scheibe-%282-St.%29?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-InnenReinigungstuecher-Box?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-FelgenReiniger-PLUS-500ml-%2BGratis-Reifen-Glanz-Spray-300-ML?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-AntiFrost-%26-KlarSicht-Konzentrat-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-GummiPfleger-100ml-610?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-TurboWaxTuch-Clean%26amp%3BDrive?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-FelgenBuerste-ultra-soft?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPflegeTuecher-Box-matteffect?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-XTREME-FelgenVersiegelung-NanoPro-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-Microfaser-Schwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Premium-Class-Nano-Lackversiegelung?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ReifenPfleger-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Schleif-Paste-75ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CarShampoo-Konzentrat-RedSummer-3l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polster-Schaum-Reiniger-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-ScheibenReiniger-gebrauchsfertig-Marillen-Duft-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Polish-%26-Wax-2-Hybrid-NPT-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KlimaPowerCleaner-GreenLemon-150ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KlimaPowerCleaner-Tropical-Sun-150ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ScheibenReiniger-Gebrauchsfertig-Tropical-Sun-3l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-PolierVliesTuecher?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-BrillantShine-Detailer-750ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Brillant-Wax-1-Hybrid-NPT-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Polish-und-Wax-3-Hybrid-NPT-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Polster---%26-AlcantaraReinige-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-ScheibenReiniger-1%3A100-NanoPro-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Motor--und-Kaltreiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-MotorPlast?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-FelgenVersiegelung-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ColorWax-schwarz-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Scheinwerfer-AufbereitungsSet-75ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-InsektenStar-750ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-Vanille-Fresh-Mattef?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-Sport-Fresh-Matteffefect-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-NewCar-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AntiFrost-%26-KlarSicht-Konzentrat-1l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-MultiSchwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-AutoPflegeTuch-PLUS?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-P-Ball-Applikator?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Premium-Class-Lack-Cleaner-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Plasti-Dip-Felgenreiniger-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Protect%2BShine-Hybrid-NPT-210ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-LederPflegerSchaum-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Silikon-Gleit--u.-Trennspray-EasySpray-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-GummiPfleger-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Lack-Reiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-FlugrostEntferner-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Insekten-Entferner-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-TeerEntferner-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-BaumharzEntferner-100ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polish-%26-Wax-COLOR-weiss-NanoPro-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polish-%26-Wax-COLOR-NanoPro-blau-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Cabrio-Verdeck-%26-Textilimpraegnierung-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Tiefenpfleger-glaenzend-mit-Duft-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-LederPflegeTuecher-Box?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-PremiumClass-LederReiniger-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-Green-Lemon-Fresh-matteffect-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-Green-Lemon-Fresh-matteffect-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Fleck--und-KlebstoffrestEntferner-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Cockpitpfleger-Lemon-Fresh-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-LackInsektenSchwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-PremiumLeder?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-SchwammApplikator--Super-Soft?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-MicrofaserTrockenTuch?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-SchmutzRadierer?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-Textil--%26amp%3B-LederBuerste?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-ScheibenSchwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-SpezialBuerste-zur-Entfernung-von-Tierhaaren?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-FolienReiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-MoS2-Oil-NanoPro-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-GlanzShampoo-Konzentrat-1l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Wasch-%26-Wax-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Auto-Politur-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Baumharz-Entferner-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polish-%26-Wax-COLOR-NanoPro-rot-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Cabrio-Verdeck-Reiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KratzerEntfernerSet-Lack-2x25ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KratzerEntferner-Kunststoff-75ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Kunststoff-Neu-Schwarz-100ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ScheibenStar-750ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-ScheibenReiniger-gebrauchsfertig-3l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AutoInnenreiniger-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ScheibenKlar-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-LederPflegeLotion-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-PremiumClass-LederPflegeCreme-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polster-Schaum-Reiniger-treibgasfrei-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Klarsicht-1%3A100-Konz.-Red-Summer-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-FlexiBlade?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-AutoPflegeTuch?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-MicrofaserTuch?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-InsektenSchwamm?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AntiFrost-%26-KlarSicht-Blue-Energy-bis--20%C2%B0C-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-FelgenStar-Felgenreiniger-750ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-ActiveShampoo-2-in-1%2C-1l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Spray-%26-Clay-LackReinigungsSet-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-Spray-%26-Clay-LackReinigungsSet-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-FolienPflege-%26--Versiegelung-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Kuehler-Dichtung-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SchnellRostLoeser-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SX-BIO90-EasySpray-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-MoS2-Oil-NanoPro-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SX-90-Plus-Easy-Spray-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ReifenFix-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ReifenFix-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Motor-Starthilfe-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Xtreme-FelgenReiniger-PLUS-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-FelgenReiniger-Gel-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-WaschPolitur-1l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-HighSpeedWax-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Turbo-LackSchutz-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Auto-Hart-Wax-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Metallic-Hochglanz-Politur-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Polish-%26-Wax-COLOR-Nanopro-silbergrau-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Tiefenpfleger-seidenmatt-mit-Duft-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KunststoffPflege-Innen-und-Aussen-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-GFK-%2C-Boot--%26-CaravanReiniger?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-InnenReinigungsTuecher?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-KunststoffPflegeTuecher-glaenzend?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Cockpit-Pfleger-300ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Cockpitpfleger-Sport-Fresh-400ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Klarsicht-1%3A100-Konz.-GreenLemon-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-Klarsicht-1%3A100-Konz.-Tropical-Sun-250ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-ScheibenReiniger-Sommer-Gebrauchsfertig-Green-Lemon-3l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-IntensivReinigungsBuerste?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-Ersatzschwamm-fuer-P-Ball?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-MicrofaserTuch-ultrafein?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-Scheiben--%26-FensterTuch?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-SONAX-MicrofaserPflegePad?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-CockpitPfleger-Tropical-Sun-Matteff-500ml?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-CockpitPflegeTuecher-Matteffect-Green-Lemon-Box?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AntiFrost-%26-KlarSicht-Ice-Fresh-bis--20%C2%B0C-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/Sonax-AutoShampoo-Konzentrat-Green-Lemon-2l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-LackReinigungsTuecher-Box?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Scheiben-Reinigungs-Tuecher-Box-%2B-Gratis-Microfasertuch-Plus?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-ScheibenReiniger-gebrauchsfertig-Red-Summer-5l?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-ScheibenReiniger-gebrauchsfertig-Citrus-5-L?source=2&refertype=5&referid=182240");
        sonax.add("https://www.motoroeldirekt.at/SONAX-Felgen-Reiniger-Plus-1%2B1-Gratis?source=2&refertype=5&referid=182240");


        //endregion

        //region Nigrin Pflegemittel

        LinkedList<String> nigrin = new LinkedList<>();


        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lackspray-schwarz-matt-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Unterbodenschutz-Spray-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Reifen-Pflege-Spray-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lackspray-schwarz-glaenzend-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Felgen-Reiniger-1000ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-EvoTec-Felgenreiniger-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Insekten-Entferner-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Quick-Shine?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Unterbodenschutz-1000-ml%2C-Pistolendose?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Schnell-Trockentuch-Groesse-54-x-40-cm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Felgenbuerste%2C-runde-Form?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auto-Shampoo-Konzentrat-Orange-1000ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Spray-Apfel-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kettenreiniger%2C-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lackspray-silber-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Klarsichtkissen?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Reifendicht-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Scheiben-Reiniger-mit-Nikotinloeser-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Textil-Reinigung-und--Pflege-400ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Rostumwandler-200-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Spray-Vanille-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Unterbodenwachs-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-Vanille?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Leder-Pflege-Set-Seife%2BBalsam?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-EvoTec-Felgenreiniger-3-Liter?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Tuch-2-St.-Groesse-35-X-35-cm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Spray-Meeresbrise-400ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Klarlack-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoffpflege-Tuecher?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Haftgrund-grau-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-hitzebest.-Lackspray-bis-600-Grad-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Gummi-Pflegestift-75ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Flugrost-Entferner-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hohlraumkonservierer-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-Wildbeeren?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Textil-Reiniger-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-New-Car?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Felgenreiniger-Turbo--Doppelpack-2x500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Klimaanlagen-Desinfektion-150-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Spray-Neutral-400ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auto-Supertuch?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Autoleder-1858-qcm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Silikon-Trockner-%2B-Leder?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Gummi-Pflegespray-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Lufterfrischer-TUNING-New-Car?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Colorpolitur-schwarz-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Glasfaserspachtel-500-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Karosserie-Spachtelsatz%2C-4-teilig?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Reinigungs-Politur-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Politur-300-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kettenspruehfett-vollsynthetisch%2C-400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Schleifpapier-Sortiment-3%2C-Nassschliff?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auspuff-Kitt-200-ml%2C-asbestfrei?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Politurpaste-250-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Lufterfrischer-TUNING-Meeresbrise?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-Meeresfrische?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Wash-%26-Wax-Turbo-1000ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Profi-Poliertuecher-50-St.?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Lackschutz-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Aufbereitung-Color-schwarz-300-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Autoschwamm-Super-Soft-Knochenform?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Insektenschwamm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Teer-und-Baumharz-Entferner-250ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-AMBIENTE-Vanille?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Feinspachtel-250-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Schleifpapier-Sortiment-2%2C-Zwischenschliff?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auspuff-Montagepaste%2C-150-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-RepairTec-Kupferspray-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-Kirsche?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Brillant-Politur-Turbo-Set-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Lufterfrischer-TUNING-Vanille?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Felgenschwamm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Antibeschlag-Tuch?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Duftdose-regulierbar-Vanille?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Verdeck-Impraegnierer-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Frischer-Duft-Limone?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Tiefenpflege-300-ml-seidenmatt?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Scheiben-Versiegelung-Set?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Rostprimer-Spray-grau---400-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Stossstangen-Schwarz-200-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Profi-Spachtel-500-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kontaktspray-250-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auto-Shampoo-Konzentrat-3-Liter?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Klarsichtkissen-mit-Microfaser?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Duftdose-regulierbar-Designer-Duft?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Turbo-Hartwachs-Lackschutz-Set-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Scheibenreiniger---200-mm-x-245-mm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Colorpolitur-silber-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kratzer-Entferner-150g?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Felgen-Versiegelung-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Minutenwaesche-Turbo-1000ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Scheibenreinigungs-Tuecher?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Anti-Beschlag-300ml-Pumpzerstaeuber?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Scheiben-Politur-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Steinschlagschutzgrund-500-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Tierhaar-Entferner-Handschuh-blau%2Cgrau%2Crot?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-AMBIENTE-Zitrone?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-AMBIENTE-New-Car?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Fuellspachtel-1000-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auspuff-Bandage-100-cm%2C-asbestfrei?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-74028-Metall-Politurpaste-75ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-RepairTec-Silikonentferner-500-ml-Trigger?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Unterbodenschutz-2%2C5-kg?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Cockpit-Lotion-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Rost-Bremse-200-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Haerter-30-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Hartwachs-Politur-Turbo-Set-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Polierwatte-380-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Ausgiesshilfe-fuer-Kanister?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-AMBIENTE-Ocean?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-AMBIENTE-Anti-Tabak?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Versiegelung-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Reparatur-Box-250-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Leder-Pflege-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Polyesterharz-500-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Colorpolitur-blau-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Reiniger-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-MoS2-Graphit-Hybrid-400ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lufterfrischer-Hawaii%2C-Vanille?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Performance-Silikon--Gleitspray-Hybrid?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Colorpolitur-rot-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoffscheiben-Politur-Set?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Metall-Pflege-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Tiefenpflege-300-ml-glaenzend?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kombispachtel-100-Gramm-Tube?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/NIGRIN-Lufterfrischer-Membran?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auto-Allzwecktuch-5-St.-Groesse-40-x-38-cm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Auto-Vorwaesche-500ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Display-Reiniger-75ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Vignetten-und-Kleber-Entferner-8ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Glasfasermatte-0%2C5-qm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Glasfaservlies-0%2C8-qm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Glasfasergewebe-0%2C5-qm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Metallspachtel-500-Gramm?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Feinmechanik-Oel-100ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Lackreparatur-Set?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Aufbereitung-Color-grau-300ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-GEL-Motorradreiniger-1000-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Kunststoff-Aufbereitung-Color-weiss-300-ml?source=2&refertype=5&referid=182269");
        nigrin.add("https://www.motoroeldirekt.at/Nigrin-Hartwachs-Colorpolitur-gruen-300ml?source=2&refertype=5&referid=182269");

        //endregion

        //region Auto Finesse Pflegemittel
        LinkedList<String> autoFinesse = new LinkedList<>();


        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Spritz-500ml-%28Quick-Detailer-Innenraum%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Finale-500ml-%28glanzverstaerkender-Detailer%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Clay-Bar-Fine-%28Reinigungs-Knete%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Citrus-Power-1l-%28Reiniger-und-Insektenentferner%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Glisten-500ml-%28Sprueh-Wachs%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Imperial-500ml-%28Felgenreiniger-saeurefrei%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Glide-%28Gleitmittel-Knete%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Polishing-Compound-500ml-%28Politur%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Satin-500ml-%28Reifenpflege%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Crystal-500ml-%28Glasreiniger%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Revive-Trim-Dressing-250ml-%28KunststoffGummi-Dressing%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Total-500ml-%28Allzweckreiniger%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Temptation-200ml-%28Wachs%2C-Standard%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Dressle-500ml-%28Dressing-Innen-u.-aussen%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Lather-Shampoo-500ml?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Mercury-100ml-%28Metallpolish-Metallpolitur%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Restoring-Compound-500ml-%28Politur%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Power-Seal-500ml-%28Lackversiegelung%29?source=2&refertype=5&referid=182290");
        autoFinesse.add("https://www.motoroeldirekt.at/Auto-Finesse---Iron-Out-500ml-%28Reaktiver-Flugrostentferner%29?source=2&refertype=5&referid=182290");

        //endregion

        /*
        this.HarvestAllSites(LiquiMolyAdditive);
        this.HarvestAllSites(meguars);
        this.HarvestAllSites(sonax);
        this.HarvestAllSites(nigrin);
        this.HarvestAllSites(autoFinesse);
        */

        //endregion

        //region Part 3
        //region armor all Pflegemittel
        LinkedList<String> armorAll = new LinkedList<>();

        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Extrem-Reifenglanz-Gel-530ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunstststoff-Tiefenpfleger-seidenmatt-300-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Lederpflege-Gel-530ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunstststoff-Tiefenpfleger-glaenzend-300-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunststoffpflege-Tuecher-seidenmatt-30-Stk?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Orangen-Reinigungstuecher-seidenmatt-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Reifenpfleger-500ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Lederpflege-Tuecher-24-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunststoffpflege-Tuecher-glaenzend-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunstststoff-Tiefenpfleger-glaenzend-500-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Shield-Felgenversiegelung-300ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Scheibenreinigungs-Tuecher-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Lederpflege-Tuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Extrem-Felgenreiniger-500-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Display-%26amp%3B-Scheiben--Tuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Reinigungs-Tuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Shield-Lackversiegelung-500ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Anti-Beschlag-Tuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Speed-Wax-Spray-500ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Hochglanzpflege-Tuecher-glaenzend-12-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunststoffpflege-Tuecher-seiden-matt-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunststoffpflege-Tuecher-glaenzend-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Car-Wash-Superkonzentrat-1000-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Tuerdichtungs-Pflegetuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Car-Cleaner-500ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Polsterreiniger-Tuecher-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Scheibenreiniger-500-ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Scheibenreinigungstuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Kunststoffpflege-Aussen-Tuecher-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Polsterreiniger-Tuecher-20-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Insekten-Reinigungstuecher-30-Stk.?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Car-Wash-Speed-Dry-1000ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Shield-Autowaesche-520ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Wash-%26-Wax-Speed-Shine-1000ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Speed-Hard-Wax?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/ARMOR-ALL-Ultra-Lackreiniger-500ml?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Shield-Scheibenveriegelung?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Insektenentferner?source=2&refertype=5&referid=182292");
        armorAll.add("https://www.motoroeldirekt.at/Armor-All-Heavy-Duty-Car-Wash-1000ml?source=2&refertype=5&referid=182292");

        //endregion

        //region Bremsenreiniger
        LinkedList<String> bremsenreiniger = new LinkedList<>();

        bremsenreiniger.add("https://www.motoroeldirekt.at/Wuerth-saBesto-Bremsenreiniger-XXL-750ml?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Eurolub-Bremsenreiniger-Spray-600ml?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Mannol-Bremsenreiniger-Montage-Cleaner-600ml?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/CRC-Braklen-Bremsenreiniger-Spray-500ml-%28extrem-ergiebig%29?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Eurolub-Bremsenreiniger-5l?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Eurolub-Bremsenreiniger-60l-Fass?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Eurolub-Bremsenreiniger-20l-Kanister?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/Wuerth-saBesto-Bremsenreiniger-500ml?source=2&refertype=5&referid=182294");
        bremsenreiniger.add("https://www.motoroeldirekt.at/CRC-Braklen-Bremsenreiniger-20l-Kanister-%28extrem-ergiebig%29?source=2&refertype=5&referid=182294");

        //endregion

        //region Xenon

        //region D1S
        LinkedList<String> d1s = new LinkedList<>();

        d1s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D1S/Gread-Xenon-Brenner-D1S-6000K?source=2&refertype=1&referid=3124");
        d1s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D1S/PHILIPS-D1S-35W-PK32d-2-Vision-Xenon-4600K-1st?source=2&refertype=1&referid=3124");

        //endregion

        //region D1R
        LinkedList<String> d1r = new LinkedList<>();

        d1r.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D1R/Osram-D1R-XENARC-electronic-CLASSIC-66154CLC?source=2&refertype=1&referid=3123");

        //endregion

        //region D2S
        LinkedList<String> d2s = new LinkedList<>();

        d2s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D2S/Gread-Xenon-Brenner-D2S-6000K?source=2&refertype=1&referid=1896");
        d2s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D2S/Xenon-Brenner-D2S-10.000K?source=2&refertype=1&referid=1896");

        //endregion

        //region d2r
        LinkedList<String> d2r = new LinkedList<>();

        d2r.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D2R/Osram-D2R-35-W-P32d-3-Xenarc-Classic-1st.-Osram?source=2&refertype=1&referid=1895");
        d2r.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D2R/Xenon-Brenner-D2R-6000K?source=2&refertype=1&referid=1895");
        d2r.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D2R/Xenon-Brenner-D2R-8000K?source=2&refertype=1&referid=1895");

        //endregion

        //region D3S
        LinkedList<String> d3s = new LinkedList<>();
        d3s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D3S/OSRAM-D3S-66340-Xenarc-electronic-Xenon-Brenner?source=2&refertype=1&referid=3706");
        //endregion

        //region d4s
        LinkedList<String> d4s = new LinkedList<>();

        d4s.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D4S/OSRAM-D4S-66440-Xenarc-ORIGINAL-Xenon-Brenner?source=2&refertype=1&referid=3708");

        //endregion

        //region d4r
        LinkedList<String> d4r = new LinkedList<>();

        d4r.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/D4R/PHILIPS-D4R-42406C1-XenEco-Standard-Essential-Xenon-Brenner?source=2&refertype=1&referid=3709");


        //endregion

        //region H7 HID Xenon
        LinkedList<String> h7 = new LinkedList<>();

        h7.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/H7/H7-4300K-35W-TC-Cristal-HID-Xenon-Ersatz-Brenner-1Stk.?source=2&refertype=1&referid=3720");
        h7.add("https://www.motoroeldirekt.at/BeleuchtungLED/Xenon-Brenner/H7/H7-6000K-35W-TC-Cristal-HID-Xenon-Ersatz-Brenner-1-Stk.?source=2&refertype=1&referid=3720");


        //endregion

        //endregion

        //region LED

        //region HB4
        LinkedList<String> hb4 = new LinkedList<>();

        hb4.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-HB4/LED-Nebelscheinwerfer-Birne-Lampe-HB4-100-Watt-Cree-LED-860-Lumen?source=2&refertype=1&referid=4399");
        hb4.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-HB4/LED-Nebelscheinwerfer-Birne-Lampe-HB4-18x-5050-SMD-Xenon-Weiss?source=2&refertype=1&referid=4399");
        hb4.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-HB4/LED-Nebelscheinwerfer-Birne-Lampe-HB4-24x-2835-SMD?source=2&refertype=1&referid=4399");
        hb4.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-HB4/LED-Nebelscheinwerfer-Birne-Lampe-HB4-4G-Orange?source=2&refertype=1&referid=4399");
        hb4.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-HB4/LED-Nebelscheinwerfer-Birne-Lampe-HB4-4G-Weiss?source=2&refertype=1&referid=4399");

        //endregion

        //region H6W
        LinkedList<String> h6w = new LinkedList<>();
        h6w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H6W/Metalsockel-H6W-Bax9s-8x-3030-SMD-Weiss-Canbus?source=2&refertype=1&referid=4119");
        h6w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H6W/Metalsockel-T4W-Ba9s-8x-3030-SMD-Weiss-Canbus?source=2&refertype=1&referid=4119");

        //endregion

        //region LedH7
        LinkedList<String> LedH7 = new LinkedList<>();

        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H7-100-Watt-Cree-LED-860-Lumen?source=2&refertype=1&referid=4398");
        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H7-18x-5050-SMD-Xenon-Weiss?source=2&refertype=1&referid=4398");
        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H7-24x-2835-SMD?source=2&refertype=1&referid=4398");
        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H7-4G-Orange?source=2&refertype=1&referid=4398");
        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H7-4G-Weiss?source=2&refertype=1&referid=4398");
        LedH7.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H7/LED-Nebelscheinwerfer-Birne-Lampe-H8-18x-5050-SMD-Xenon-Weiss?source=2&refertype=1&referid=4398");

        //endregion

        //region H8
        LinkedList<String> h8 = new LinkedList<>();
        h8.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H8/LED-Nebelscheinwerfer-Birne-Lampe-H8-100-Watt-Cree-LED-860-Lumen?source=2&refertype=1&referid=4397");
        h8.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H8/LED-Nebelscheinwerfer-Birne-Lampe-H8-24x-2835-SMD?source=2&refertype=1&referid=4397");
        h8.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H8/LED-Nebelscheinwerfer-Birne-Lampe-H8-4G-Orange?source=2&refertype=1&referid=4397");
        h8.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H8/LED-Nebelscheinwerfer-Birne-Lampe-H8-4G-Weiss?source=2&refertype=1&referid=4397");

        //endregion

        //region H10
        LinkedList<String> h10 = new LinkedList<>();

        h10.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H10/LED-Nebelscheinwerfer-Birne-Lampe-H10-18x-5050-SMD-Xenon-Weiss?source=2&refertype=1&referid=4395");
        h10.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H10/LED-Nebelscheinwerfer-Birne-Lampe-H10-24x-2835-SMD?source=2&refertype=1&referid=4395");
        h10.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H10/LED-Nebelscheinwerfer-Birne-Lampe-H10-4G-Orange?source=2&refertype=1&referid=4395");
        h10.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H10/LED-Nebelscheinwerfer-Birne-Lampe-H10-4G-Weiss?source=2&refertype=1&referid=4395");

        //endregion

        //region H11
        LinkedList<String> h11 = new LinkedList<>();

        h11.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H11/LED-Nebelscheinwerfer-Birne-Lampe-H11-100-Watt-Cree-LED-860-Lumen?source=2&refertype=1&referid=4396");
        h11.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H11/LED-Nebelscheinwerfer-Birne-Lampe-H11-18x-5050-SMD-Xenon-Weiss?source=2&refertype=1&referid=4396");
        h11.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H11/LED-Nebelscheinwerfer-Birne-Lampe-H11-24x-2835-SMD?source=2&refertype=1&referid=4396");
        h11.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H11/LED-Nebelscheinwerfer-Birne-Lampe-H11-4G-Orange?source=2&refertype=1&referid=4396");
        h11.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-H11/LED-Nebelscheinwerfer-Birne-Lampe-H11-4G-Weiss?source=2&refertype=1&referid=4396");


        //endregion

        //region PY21W
        LinkedList<String> py21w = new LinkedList<>();
        py21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-PY21W/LED-Lampe-BAU15S-PY21W-4G-Technik-Orange?source=2&refertype=1&referid=4401");
        //endregion

        //region p21W
        LinkedList<String> p21w = new LinkedList<>();

        p21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-P21W/LED-Lampe-BA15S-P21W-4G-Technik-Orange?source=2&refertype=1&referid=4403");
        p21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-P21W/LED-Signallampe-P21W-24x-2835-SMD-Weiss?source=2&refertype=1&referid=4403");
        p21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-P21W/LED-Signallampe-P21W-BA15S-4G-Weiss?source=2&refertype=1&referid=4403");
        p21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-P21W/LED-Signallampe-P21W5W-Rot?source=2&refertype=1&referid=4403");
        p21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-P21W/LED-Signallampe-P21W5W-Weiss?source=2&refertype=1&referid=4403");
        //endregion

        //region T20 W21W
        LinkedList<String> t20w21w = new LinkedList<>();

        t20w21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-T20-W21W/LED-Lampe-T20-W21W-7440-4G-Technik-Orange?source=2&refertype=1&referid=4402");
        t20w21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-T20-W21W/LED-Signallampe-T20-W215W-Weiss?source=2&refertype=1&referid=4402");
        t20w21w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-T20-W21W/LED-Signallampe-T20-W21W-Weiss?source=2&refertype=1&referid=4402");


        //endregion

        //region W5W
        LinkedList<String> w5w = new LinkedList<>();

        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Foliatec-SMD-LED-Cockpit-Light-ultraweiss%2C-T10%2C-160mA%2C-mit-Widerstand?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Foliatec-SMD-LED-Cockpit-Light%2C-ultraweiss%2C-T10%2C-150mA%2C-mit-Widerstand?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Foliatec-SMD-LED-Cockpit-Light%2C-ultraweiss%2C-T10%2C-170mA%2C-mit-Widerstand?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Foliatec-SMD-LED-Cockpit-Light%2C-ultraweiss%2C-T10%2C-40mA%2C-mit-Widerstand?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-12x-3030-SMD-Weiss-T10-Canbus?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-18x-3104-SMD-Weiss-T10-Canbus-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-8x-3030-SMD-Weiss-T10-Canbus?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-9x-3030-SMD-Weiss-Canbus?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-10x-5630-LED-Canbus-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-24x-3104-LED-Canbus-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-3x-2835-LED-Canbus-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-5x-5050-SMD-Blau?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-5x-5050-SMD-Gelb?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-5x-5050-SMD-Gruen?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-5x-5050-SMD-Rot?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-5x-5050-SMD-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-6x-2835-LED-Canbus-Weiss-147?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-6x-2835-LED-Canbus-Weiss?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-8x-2835-SMD-Weiss-Canbus?source=2&refertype=1&referid=3127");
        w5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-W5W/Glassockel-W5W-T10-9x-2835-LED-Canbus-Orange?source=2&refertype=1&referid=3127");


        //endregion

        //region C5W
        LinkedList<String> c5w = new LinkedList<>();
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Foliatec-SMD-LED-Cab-LightSoffitte%2C-ultraweiss%2C-mit-Widerstand?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Foliatec-SMD-LED-Cab-LightSoffitte%2C-ultraweiss%2C-mit-Widerstand-52?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Foliatec-SMD-LED-Cab-LightSoffitte%2C-ultraweiss%2C-mit-Widerstand-54?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Foliatec-SMD-LED-Cab-LightSoffitte%2C-ultraweiss%2C-mit-Widerstand-56?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Foliatec-SMD-LED-Cab-LightSoffitte%2C-ultraweiss%2C-mit-Widerstand-58?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-31mm-LEDriving-Cool-White-6000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-31mm-LEDriving-WarmWhite-4000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-36-38mm-LEDriving-Cool-White-6000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-36-38mm-LEDriving-Warm-White-4000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-41-mm-LEDriving-Cool-White-6000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Osram-C5W-12V-1W-SV8%2C-5-8-41-mm-LEDriving-Warm-White-4000K?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-31mm-3x-3030-SMD-Weiss?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-31mm-6x-2835-SMD-Weiss-250-Lumen?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-36mm-6x-2835-SMD-Weiss-250-Lumen?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-36mm-6x-3030-SMD-Weiss?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-36mm-6x-5630-SMD-Blau?source=2&refertype=1&referid=3128");
        c5w.add("https://www.motoroeldirekt.at/BeleuchtungLED/LIMOX-LED/LED-C5W/Soffitte-C5W-36mm-6x-5630-SMD-Gelb?source=2&refertype=1&referid=3128");
        //endregion

        //endregion

        //region castrol
        LinkedList<String> castrol5w40 = new LinkedList<>();
        LinkedList<String> castrol10w40 = new LinkedList<>();
        LinkedList<String> castrol15w40 = new LinkedList<>();
        LinkedList<String> castrol5w30 = new LinkedList<>();
        LinkedList<String> castrol10w60 = new LinkedList<>();
        LinkedList<String> castrol20w50 = new LinkedList<>();
        LinkedList<String> castrol0w20 = new LinkedList<>();
        LinkedList<String> castrol0w30 = new LinkedList<>();
        LinkedList<String> castrol0w40 = new LinkedList<>();
        LinkedList<String> castrol5w20 = new LinkedList<>();



        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-4l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-5l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Titanium-FST-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Turbo-Diesel-5W-40-Titanium-FST-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Turbo-Diesel-5W-40-Titanium-FST-Motoroel-208l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Turbo-Diesel-5W-40-Titanium-FST-Motoroel-20l-Kanister?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Turbo-Diesel-5W-40-Titanium-FST-Motoroel-4l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Edge-Turbo-Diesel-5W-40-Titanium-FST-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-GTX-5W-40-A3B4-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-GTX-5W-40-A3B4-Motoroel-5l-Kanne?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-GTX-High-Mileage-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-GTX-High-Mileage-5W-40-Motoroel-5l-Kanne?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-GTX-High-Mileage-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-208l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-20l-Kanister?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-4l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-5l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-5W-40-C3-Motoroel-60l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Diesel-5W-40-DPF-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Diesel-5W-40-DPF-Motoroel-208l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Diesel-5W-40-DPF-Motoroel-20l-Kanister?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Diesel-5W-40-DPF-Motoroel-5l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-A3-5W-40-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Diesel-5W-40-DPF-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-A3-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-A3-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-B4-5W-40-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-OE-5W-40-Motoroel-1l?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-OE-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1987");
        castrol5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-40/Castrol-Magnatec-Professional-OE-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=1987");

        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-10W-40-A3B4-Motoroel-1l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-10W-40-A3B4-Motoroel-208l-Fass?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-10W-40-A3B4-Motoroel-20l-Kanister?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-10W-40-A3B4-Motoroel-5l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-10W-40-A3B4-Motoroel-60l-Fass?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-GTX-Professional-A3-10W-40-Motoroel-1l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-A3B4-Motoroel-1l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-A3B4-Motoroel-208l-Fass?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-A3B4-Motoroel-5l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-A3B4-Motoroel-60l-Fass?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-B4-Diesel-Motoroel-1l?source=2&refertype=1&referid=1988");
        castrol10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-40/Castrol-Magnatec-10W-40-B4-Diesel-Motoroel-5l-Kanne?source=2&refertype=1&referid=1988");

        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-EDGE-10W-60-Supercar-Motoroel-208l-Fass?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-EDGE-10W-60-Supercar-Motoroel-20l-Kanister?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-EDGE-10W-60-Supercar-Motoroel-1l?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-EDGE-10W-60-Supercar-Motoroel-5l-Kanister?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-EDGE-10W-60-Supercar-Motoroel-60l-Fass?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-Edge-Professional-10W-60-TWS-Motoroel-1l?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-Edge-Titanium-FST-10W-60-Motoroel-208l-Fass?source=2&refertype=1&referid=1989");
        castrol10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-10W-60/Castrol-Edge-Titanium-FST-10W-60-Motoroel-60l-Fass?source=2&refertype=1&referid=1989");

        castrol15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-15W-40/Castrol-GTX-15W-40-A3B3-Motoroel-1l?source=2&refertype=1&referid=1990");
        castrol15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-15W-40/Castrol-GTX-15W-40-A3B3-Motoroel-208l-Fass?source=2&refertype=1&referid=1990");
        castrol15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-15W-40/Castrol-GTX-15W-40-A3B3-Motoroel-5l-Kanne?source=2&refertype=1&referid=1990");
        castrol15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-15W-40/Castrol-Magnatec-15W-40-A3B4-Motoroel-1l?source=2&refertype=1&referid=1990");
        castrol15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-15W-40/Castrol-Tection-Gas-15W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1990");

        castrol20w50.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-20W-50/Castrol-Classic-XL-20W-50-Motoroel-5l?source=2&refertype=1&referid=1991");

        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A3B4-5l-Kanne?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-C3-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-C3-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-C3-Motoroel-20l-Kanister?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-C3-Motoroel-4l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-C3-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-5W-30-FST-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-LL-Titanium-FST-Motoroel-LonglifeIII-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-LL-Titanium-FST-Motoroel-LonglifeIII-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-LL-Titanium-FST-Motoroel-LonglifeIII-20l-Kanister?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-LL-Titanium-FST-Motoroel-LonglifeIII-5l-Kanne?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-5W-30-LL-Titanium-FST-Motoroel-LonglifeIII-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-Professional-Longlife-III-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-Professional-Longlife-III-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-Professional-Longlife-III-Titanium-FST-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-EDGE-Professional-Longlife-III-Titanium-FST-5W-30-Motoroel-4l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-OE-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-OE-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-A5-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-A5-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-A5-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-BMW-LL04-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-C1-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-C1-5W-30-Motoroel-208l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-C4-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Edge-Professional-Titanium-C4-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-A3B4-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-A3B4-Motoroel-4l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-A3B4-Motoroel-5l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-A3B4-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-C2-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-C3-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-5W-30-C3-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A3-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A3-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A3-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A5-5W-30-Ford-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A5-5W-30-Ford-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A5-5W-30-Ford-Motoroel-5l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A5-5W-30-Ford-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-A5-5W-30-Ford-Motoroel-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-C2-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-C2-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-MP-5W-30-Motoroel-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Professional-MP-5W-30-Motoroel-1l-488?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A3B4-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A3B4-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A3B4-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A5-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A5-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A5-20l-Kanister?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A5-5l-Kanne?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-A5-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C2-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C2-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C2-20l-Kanister?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C2-5l-Kanne?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C2-60l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C3-1l?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C3-208l-Fass?source=2&refertype=1&referid=1986");
        castrol5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-30/Castrol-Magnatec-Stop-Start-5W-30-C3-20l-Kanister?source=2&refertype=1&referid=1986");


        castrol0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-20/Castrol-Edge-Professional-Titanium-FST-V-0W20-Motoroel-1l?source=2&refertype=1&referid=4483");
        castrol0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-20/Castrol-Edge-Professional-Titanium-FST-E-0W20-Motoroel-1l?source=2&refertype=1&referid=4483");


        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-0W-30-Titanium-FST-Motoroel-1l?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-0W-30-Titanium-FST-Motoroel-208l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-0W-30-Titanium-FST-Motoroel-5l-Kanne?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-0W-30-Titanium-FST-Motoroel-20l-Kanister?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-0W-30-Titanium-FST-Motoroel-60l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-EDGE-Longlife-II-0W-30-Titanium-FST-Motoroel-1l-%28VW-506.01%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-A5-0W-30-Titanium-FST-Motoroel-1l-%28for-VOLVO-A5B5%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-A5-0W-30-Titanium-FST-Motoroel-208l-Fass-%28for-VOLVO-A5B5%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-A5-0W-30-Titanium-FST-Motoroel-60l-Fass-%28for-VOLVO-A5B5%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-C3-0W-30-Motoroel-1l?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-C3-0W-30-Titanium-FST-Motoroel-1l?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-C3-0W-30-Titanium-FST-Motoroel-208l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-C3-0W-30-Titanium-FST-Motoroel-60l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-Titanium-A3-0W-30-Motoroel-1l?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-Titanium-A3-0W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-Titanium-A3-0W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Edge-Professional-Titanium-BMW-LL04-0W-30-Motoroel-1l?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Magnatec-Stop-Start-0W-30-D-1l-%28Ford-WSS-M2C950-A%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Magnatec-Stop-Start-0W-30-D-208l-Fass-%28Ford-WSS-M2C950-A%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Magnatec-Stop-Start-0W-30-D-20l-Kanister-%28Ford-WSS-M2C950-A%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Magnatec-Stop-Start-0W-30-D-5l-Kanne-%28Ford-WSS-M2C950-A%29?source=2&refertype=1&referid=1983");
        castrol0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-30/Castrol-Magnatec-Stop-Start-0W-30-D-60l-Fass-%28Ford-WSS-M2C950-A%29?source=2&refertype=1&referid=1983");


        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-FST-0W-40-A3B4-Motoroel-4l-Kanne?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Professional-A3-0W-40-Motoroel-1l?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Professional-Titanium-FST-A3-0W-40-Motoroel-1l?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Professional-Titanium-FST-A3-0W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Professional-Titanium-FST-A3-0W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Titanium-FST-0W-40-A3B4-Motoroel-1l?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Titanium-FST-0W-40-A3B4-Motoroel-208l-Fass?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Titanium-FST-0W-40-A3B4-Motoroel-20l-Kanister?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Titanium-FST-0W-40-A3B4-Motoroel-5l-Kanne?source=2&refertype=1&referid=1984");
        castrol0w40.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-0W-40/Castrol-Edge-Titanium-FST-0W-40-A3B4-Motoroel-60l-Fass?source=2&refertype=1&referid=1984");


        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Edge-Professional-Titanium-A1-5W-20-Motoroel-1l?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Professional-E-5W-20-Motoroel-1l-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Professional-E-5W-20-Motoroel-5l-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Professional-E-5W-20-Motoroel-60l-Fass-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Stop-Start-5W-20-E-Motoroel-1l-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Stop-Start-5W-20-E-Motoroel-208l-Fass-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Stop-Start-5W-20-E-Motoroel-20l-Kanister-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Stop-Start-5W-20-E-Motoroel-5l-Kanne-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");
        castrol5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Castrol/PKW-Motoroele/SAE-5W-20/Castrol-Magnatec-Stop-Start-5W-20-E-Motoroel-60l-Fass-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=1985");


        //endregion

        /*
        this.HarvestAllSites(t20w21w);
        this.HarvestAllSites(p21w);
        this.HarvestAllSites(py21w);
        this.HarvestAllSites(h11);
        this.HarvestAllSites(h10);
        this.HarvestAllSites(h8);
        this.HarvestAllSites(LedH7);
        this.HarvestAllSites(hb4);
        this.HarvestAllSites(h6w);
        this.HarvestAllSites(c5w);
        this.HarvestAllSites(w5w);
        this.HarvestAllSites(d1s);
        this.HarvestAllSites(d1r);
        this.HarvestAllSites(d2s);
        this.HarvestAllSites(h7);
        this.HarvestAllSites(d4r);
        this.HarvestAllSites(d4s);
        this.HarvestAllSites(d3s);
        this.HarvestAllSites(d2r);
        this.HarvestAllSites(armorAll);
        this.HarvestAllSites(bremsenreiniger);
        this.HarvestAllSites(castrol0w20);
        this.HarvestAllSites(castrol0w30);
        this.HarvestAllSites(castrol0w40);
        this.HarvestAllSites(castrol5w20);
        this.HarvestAllSites(castrol5w30);
        this.HarvestAllSites(castrol5w40);
        this.HarvestAllSites(castrol10w40);
        this.HarvestAllSites(castrol15w40);
        this.HarvestAllSites(castrol20w50);
        this.HarvestAllSites(castrol10w60);
*/
        //endregion

        //region Part 4

            //region Eurolub Motoroil

        //region 0W16
                LinkedList<String> eurolub0w16 = new LinkedList<String>();
                eurolub0w16.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-16/Eurolub-SUPER-ECO-SAE-0W-16-Motoroel-1l?source=2&refertype=1&referid=4114");
                //endregion

                //region 0W20
                LinkedList<String> eurolub0w20 = new LinkedList<>();
                eurolub0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-20/Eurolub-ECO-VO-SAE-0W-20-Motoroel-1l?source=2&refertype=1&referid=2140");
                eurolub0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-20/Eurolub-FE-LL4-0W-20-Motoroel-1l-Flasche?source=2&refertype=1&referid=2140");
                eurolub0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-20/Eurolub-FE-LL4-0W-20-Motoroel-208l-Fass?source=2&refertype=1&referid=2140");
                eurolub0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-20/Eurolub-FE-LL4-0W-20-Motoroel-20l-Kanister?source=2&refertype=1&referid=2140");
                eurolub0w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-20/Eurolub-FE-LL4-0W-20-Motoroel-60l-Fass?source=2&refertype=1&referid=2140");
                //endregion

                //region 0W30
                LinkedList<String> eurolub0w30 = new LinkedList<>();

                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Eco-B12-0W-30-Motoroel-1l-Flasche?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Eco-B12-0W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Eco-B12-0W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Eco-B12-0W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-ECO-LL-SAE-0W-30-Motoroel-1l?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-ECO-PS-C-SAE-0W-30-Motoroel-1l?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Motor-VO-SAE-0W-30--ACEA-A5B5%2C-Volvo-Motoroel-1l?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Motor-VO-SAE-0W-30--ACEA-A5B5%2C-Volvo-Motoroel-20l-Kanister?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-Motor-VO-SAE-0W-30--ACEA-A5B5%2C-Volvo-Motoroel-60l-Fass?source=2&refertype=1&referid=4111");
                eurolub0w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-0W-30/Eurolub-MULTITEC-FO-SAE-0W-30-Motoroel-1l?source=2&refertype=1&referid=4111");


                //endregion

                //region 5W20
                LinkedList<String> eurolub5w20 = new LinkedList<>();
                eurolub5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-20/Eurolub-Supertec-5W-20-Motoroel-1l?source=2&refertype=1&referid=2683");
                eurolub5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-20/Eurolub-Supertec-5W-20-Motoroel-208l-Fass?source=2&refertype=1&referid=2683");
                eurolub5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-20/Eurolub-Supertec-5W-20-Motoroel-20l-%28Ford-EcoBoost-WSS-M2C948-B%29?source=2&refertype=1&referid=2683");
                eurolub5w20.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-20/Eurolub-Supertec-5W-20-Motoroel-60l-Fass?source=2&refertype=1&referid=2683");

                //endregion

                //region 5W30
                LinkedList<String> eurolub5w30 = new LinkedList<>();

                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanpower-C1-5W-30-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanpower-C1-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanpower-C1-5W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanpower-C1-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanpower-C1-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanstar-C2-5W-30-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanstar-C2-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanstar-C2-5W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanstar-C2-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleanstar-C2-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-CLEANTEC-5W-30-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-CLEANTEC-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-CLEANTEC-5W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-CLEANTEC-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-CLEANTEC-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleantop-C4-5W-30-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleantop-C4-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleantop-C4-5W-30-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleantop-C4-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Cleantop-C4-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Multitec-5W-30-%28Ford%29-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Multitec-5W-30-%28Ford%29-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Multitec-5W-30-%28Ford%29-Motoroel-20l-Kanister?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Multitec-5W-30-%28Ford%29-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-Multitec-5W-30-%28Ford%29-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-1l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-208l-Fass?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-5l?source=2&refertype=1&referid=2141");
                eurolub5w30.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-30/Eurolub-WIV-ECO-5W-30-Motoroel-60l-Fass?source=2&refertype=1&referid=2141");

                //endregion

                //region 5W40
                LinkedList<String> eurolub5w40 = new LinkedList<>();

                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-Formel-1-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-Formel-1-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-Formel-1-5W-40-Motoroel-5l?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-Formel-1-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-5W-40-Motoroel-1l?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-5W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-5W-40-Motoroel-5l?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-PDI-SAE-5W-40-Motoroel-1l?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-PDI-SAE-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-PDI-SAE-5W-40-Motoroel-5l?source=2&refertype=1&referid=2142");
                eurolub5w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-5W-40/Eurolub-SYNT-PDI-SAE-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2142");


                //endregion

                //region 10W40
                LinkedList<String> eurolub10w40 = new LinkedList<>();


                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-Formel2-10W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-Formel2-10W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-Formel2-10W-40-Motoroel-5l?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-Formel2-10W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-GT-10W-40-Motoroel-1l?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-GT-10W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-GT-10W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-GT-10W-40-Motoroel-5l?source=2&refertype=1&referid=2143");
                eurolub10w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-40/Eurolub-GT-10W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2143");

                //endregion

                //region 10W60
                LinkedList<String> eurolub10w60 = new LinkedList<>();

                eurolub10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-60/Eurolub-GT2-10W-60-Motoroel-1l?source=2&refertype=1&referid=2144");
                eurolub10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-60/Eurolub-GT2-10W-60-Motoroel-208l-Fass?source=2&refertype=1&referid=2144");
                eurolub10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-60/Eurolub-GT2-10W-60-Motoroel-20l-Kanister?source=2&refertype=1&referid=2144");
                eurolub10w60.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-10W-60/Eurolub-GT2-10W-60-Motoroel-60l-Fass?source=2&refertype=1&referid=2144");


                //endregion

                //region 15w40
                LinkedList<String> eurolub15w40 = new LinkedList<>();
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Formel-V-15W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Formel-V-15W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Formel-V-15W-40-Motoroel-5l?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Formel-V-15W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Turbo-Star-15W-40-Motoroel-1l?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Turbo-Star-15W-40-Motoroel-208l-Fass?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Turbo-Star-15W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Turbo-Star-15W-40-Motoroel-5l?source=2&refertype=1&referid=2145");
                eurolub15w40.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-15W-40/Eurolub-Turbo-Star-15W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2145");
                //endregion

                //region 20W50
                LinkedList<String> eurolub20w50 = new LinkedList<>();

                eurolub20w50.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-20W-50/Eurolub-Multigrade-SAE-20W-50-Classic-Motoroel-1l?source=2&refertype=1&referid=2393");
                eurolub20w50.add("https://www.motoroeldirekt.at/Oel-Marken/Eurolub/PKW-Motoroele/SAE-20W-50/Eurolub-Multigrade-SAE-20W-50-Classic-Motoroel-60l-Fass?source=2&refertype=1&referid=2393");

                //endregion

            //endregion




        //endregion

        allLinks.addAll(meguars);
        allLinks.addAll(c5w);
        allLinks.addAll(AdBlue);
        allLinks.addAll(armorAll);
        allLinks.addAll(autoFinesse);
        allLinks.addAll(Automatikgetriebe);
        allLinks.addAll(Boot);
        allLinks.addAll(bremsenreiniger);
        allLinks.addAll(Bremsfluessigkeiten);
        allLinks.addAll(castrol0w20);
        allLinks.addAll(castrol0w30);
        allLinks.addAll(castrol0w40);
        allLinks.addAll(castrol5w20);
        allLinks.addAll(castrol5w30);
        allLinks.addAll(castrol5w40);
        allLinks.addAll(castrol10w40);
        allLinks.addAll(castrol10w60);
        allLinks.addAll(castrol15w40);
        allLinks.addAll(castrol20w50);
        allLinks.addAll(d1r);
        allLinks.addAll(d1s);
        allLinks.addAll(d2r);
        allLinks.addAll(d2s);
        allLinks.addAll(d3s);
        allLinks.addAll(d4r);
        allLinks.addAll(d4s);
        allLinks.addAll(eurolub0w16);
        allLinks.addAll(eurolub0w20);
        allLinks.addAll(eurolub0w30);
        allLinks.addAll(eurolub5w20);
        allLinks.addAll(eurolub5w30);
        allLinks.addAll(eurolub5w40);
        allLinks.addAll(eurolub10w40);
        allLinks.addAll(eurolub15w40);
        allLinks.addAll(eurolub20w50);
        allLinks.addAll(Fahrzeugpflege);
        allLinks.addAll(FettePasten);
        allLinks.addAll(h6w);
        allLinks.addAll(h7);
        allLinks.addAll(h8);
        allLinks.addAll(h10);
        allLinks.addAll(h11);
        allLinks.addAll(hb4);
        allLinks.addAll(Hydraulik);
        allLinks.addAll(KlebenDichte);
        allLinks.addAll(Kompressorenöl);
        allLinks.addAll(KraftstoffAdditiveBenzin);
        allLinks.addAll(KraftstoffAdditiveDiesel);
        allLinks.addAll(Kuehlerschutz);
        allLinks.addAll(LedH7);
        allLinks.addAll(LiquiMolyAdditive);
        allLinks.addAll(Lkw);
        allLinks.addAll(MotoroilAndAdditives);
        allLinks.addAll(Motorrad);
        allLinks.addAll(nigrin);
        allLinks.addAll(OilAdditive);
        allLinks.addAll(p21w);
        allLinks.addAll(py21w);
        allLinks.addAll(Saegeketten);
        allLinks.addAll(Schaltgetriebe);
        allLinks.addAll(sonax);
        allLinks.addAll(t20w21w);
        allLinks.addAll(TraktorBaumaschinen);
        allLinks.addAll(w5w);
        System.out.println("Links: " + allLinks.size());
    }

    /**
     * Harvest the given product in shape of a link and
     * returns the finished product filled with all entities
     * @param justLink ProductAd Link
     * @return finished Products with all entities
     * @throws InterruptedException
     */
    public Products HarvestInnerProduct(String justLink) throws InterruptedException {

        Date date1 = new Date();

        long l1 = date1.getTime();

        //region Build Connection
        String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
        Connection.Response res = null;
        Connection.Response login;
        Document documentForLogin = null;

        try {
            //first connection with GET request
            res = Jsoup.connect("https://www.motoroeldirekt.at/themes/user/index.php")
                    //.userAgent(USER_AGENT)
                    .method(Connection.Method.GET)
                    .execute();
        } catch (Exception ex) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Products Page \nError Message:" + ex.getMessage());
        }
        try {
            CookieManager initalCookies = null;
             login = Jsoup
                    .connect("https://www.motoroeldirekt.at/themes/user/index.php")
                    //.userAgent(USER_AGENT)
                    .cookies(res.cookies())
                    //.cookies(initial.cookies)
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
                     //.data("c_user","100001372713592")
                    .method(Connection.Method.POST)
                    .execute();
        } catch (Exception ex) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Products Page \nError Message:" + ex.getMessage());
        }
        //The downloaded Productpage
        Document doc = null;
        boolean success = false;

        try {

            do {
                if (success==true)
                    Thread.sleep(3000);

                doc = Jsoup.connect(justLink).cookies(res.cookies()).get();

                success = true;
            } while(doc.body()==null);

        } catch (IOException e) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Products Page \nURL:" + justLink + "\nError Message:" + e.getMessage());
            return null;
        } catch (NullPointerException e) {
            System.out.println("Jsoup Null Pointer Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Products Page \nURL:" + justLink + "\nError Message:" + e.getMessage());
            return null;
        }

        //Filter the Information - Use the information of the Header to build my ad
        String head = String.valueOf(doc.body());
        Elements artikelDetailBox = doc.select("section.artikelDetailBox");
        Elements descript = doc.select("section.artikelDetailOther");
        //endregion

        //Here I am going to save all infos ------------------------------------------------------------------
        Products p = new Products();
        Elements title = artikelDetailBox;
        Elements pic = artikelDetailBox;

        p.setTitle(title.select("h1").text().replace("W-","W").replace(" ml","ml"));
        p.setMetaTitle(p.getTitle().replace("Motoröl","").replace("CASTROL","Castrol").replace("EUROLUB","Eurolub   ").replace("SOFFITTE","Soffitte").replace("FOLIATEC","Foliatec").replace("OSRAM","Osram").replace("PHILIPS","Philips").replace("SONAX","Sonax").replace("NIGRIN","Nigrin").replace("MANNOL","Mannol").replace("Kanister","").replace("Fass","").replace("mororöl","").replace("Blechdose","").replace("Flasche","").replace("Kanne","").replace("LongLife","LL").replace("for","für").replace("  60l "," 60l").replace("  1l "," 1l").replace("  10l "," 10l").replace("  208l "," 208l").replace("  5l "," 5l").replace("  20l "," 20l"));

        //region Get Brands
        if(p.getTitle().toLowerCase().contains("mannol")) {
            p.setBrand("Mannol");
        }
        else if (p.getTitle().toLowerCase().contains("meguin")) {
            p.setBrand("Meguin Megol");
        }
        else if (p.getTitle().toLowerCase().contains("liqui moly")) {
            p.setBrand("Liqui Moly");
        }
        else if (p.getTitle().toLowerCase().contains("sonax")) {
            p.setBrand("Sonax");
        }
        else if (p.getTitle().toLowerCase().contains("meguiars")) {
            p.setBrand("Meguiars");
        }
        else if (p.getTitle().toLowerCase().contains("nigrin")) {
            p.setBrand("Nigrin");
        }
        else if (p.getTitle().toLowerCase().contains("auto finesse")) {
            p.setBrand("Auto Finesse");
        }
        else if (p.getTitle().toLowerCase().contains("armor all")) {
            p.setBrand("Armor All");
        }
        else if (p.getTitle().toLowerCase().contains("eurolub")) {
            p.setBrand("Eurolub");
        }
        else if (p.getTitle().toLowerCase().contains("würth sabesto")) {
            p.setBrand("Würth saBesto");
        }
        else if (p.getTitle().toLowerCase().contains("crc braklen")) {
            p.setBrand("CRC Braklen");
        }
        else if (p.getTitle().toLowerCase().contains("osram")) {
            p.setBrand("Osram");
        }
        else if (p.getTitle().toLowerCase().contains("gread")) {
            p.setBrand("Gread");
        }
        else if (p.getTitle().toLowerCase().contains("foliatec")) {
            p.setBrand("Foliatex");
        }
        else if (p.getTitle().toLowerCase().contains("soffitte")) {
            p.setBrand("Soffitte");
        }
        else if (p.getTitle().toLowerCase().contains("castrol")) {
            p.setBrand("Castrol");
        }
        else if (p.getTitle().toLowerCase().contains("eurolub")) {
            p.setBrand("Eurolub");
        }
        else if (p.getTitle().toLowerCase().contains("led") && p.getTitle().toLowerCase().contains("lampe")) {
        }
        else {
            System.out.print(p.getTitle());
        }
        //endregion

        //region Save the pictures (SmallImage, BaseImage)
        String imagePath = pic.select("div.artikelDetailBildBox").select("span#artikelDetailBild").outerHtml();

        if (!imagePath.contains("href=")) {
            System.out.print("NOT FOUND");
            return null;
        }

        imagePath = imagePath.substring(imagePath.indexOf("href=") + 6, imagePath.length()).replace(" ", "");
        imagePath = imagePath.substring(0, imagePath.indexOf("\">"));
        String baseImageForArtikelId = imagePath.substring(imagePath.lastIndexOf("/") + 1, imagePath.length());
        try (InputStream in = new URL(imagePath).openStream()) {
                    //Making pretty filenames for the pictures
                    String fileName = MakeFileNamePretty(p.getMetaTitle());
                    String filePath = FILEPATHIMAGE + fileName;

                    if (!Files.exists(Paths.get(filePath)))
                        Files.copy(in, Paths.get(filePath));
                    else
                        System.out.print("Picture already exists\n");

                    p.setBaseImage(fileName);
                    p.setSmallImage(fileName);
            } catch (MalformedURLException e) {
                System.out.println("InputStream Error MalformedURLException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("InputStream Error IOException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
            }
        //endregion

        //region Save the artikelid from the imagename -----------------------------------------------------------------------------
        if (justLink.contains("artikelid=")) {
            p.setSku(justLink.substring(justLink.indexOf("artikelid=") + 10, justLink.indexOf("&")));
        }
        else {
            baseImageForArtikelId = baseImageForArtikelId.substring(baseImageForArtikelId.indexOf("_")+1,baseImageForArtikelId.length());
            baseImageForArtikelId = baseImageForArtikelId.substring(0,baseImageForArtikelId.indexOf("_"));
            boolean numberFound = false;
            int i = 0;
            while (!numberFound) {
                if (baseImageForArtikelId.charAt(i)=='0') {
                    i++;
                }
                else {
                    numberFound=true;
                }
            }
            baseImageForArtikelId = baseImageForArtikelId.substring(i,baseImageForArtikelId.length());
            p.setSku(baseImageForArtikelId);
        }
        //endregion

        //region Save the price ---------------------------------------------------------------------------------
        double price = 0.0;
        try {
            price = Double.parseDouble(title.select("div.artikelDetailInfos").select("span#artikelPreis").text().replace(" €", "").replace(".", "").replace(",", "."));
            double oldPrice = price;

            /*if (p.getTitle() == "iwas") {
                price = price * 1,2 * iwasss
            }*/

            if (price <= 1) {
                price = price * 1.2 * 1.55;
            }
            else if (price <= 2) {
                price = price * 1.2 * 1.50;
            }
            else if (price <= 3) {
                price = price * 1.2 * 1.45;
            }
            else if (price <= 4) {
                price = price * 1.2 * 1.40;
            }
            else if (price <= 5) {
                price = price * 1.2 * 1.35;
            }
            else if (price <= 12) {
                price = price * 1.2 * 1.33;
            }
            else if (price <= 20) {
                price = price * 1.2 * 1.3;
            }
            else if (price <= 30) {
                price = price * 1.2 * 1.27;
            }
            else if (price <= 50) {
                price = price * 1.2 * 1.24;
            }
            else if (price <= 100) {
                price = price * 1.2 * 1.21;
            }
            else if (price > 100) {
                price = price * 1.2 * 1.21;
            }
            else if (price > 1000) {
                price = price * 1.2 * 1.20;
            }
            else {
                System.out.println("------------------------------> ERROR IN PRICE CALC <---------------------------------\nThe Problematic Price: " + price + " The Problematic Product: " + justLink);
                return null;
            }

            int temp = (int) price;
            price = temp + 0.9;
            p.setPrice(price);
        } catch (NumberFormatException ex) {
            System.out.println("DoubleParse Error NumberFormatException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Calculate the price The Problematic Price: " + price + "\nError Message:" + ex.getMessage());
            return null;
        }
        //endregion

        //Calculating the Weight of the Products through the String
        p.setContainer(RecognationOfContainer(p));

        //Save the description -------------------------------------------------------------------
        p.setDescription(descript.select("div.artikelDetailTabBox").html().replace("\n", ""));

        //Edit the description ---------------------------------------------
        String description = p.getDescription();
        String betweenStrong = p.getMetaTitle();

        //replace the first paragraph
        int startSplitter = description.indexOf("<strong>");
        int endSplitter = description.length();

        if (startSplitter != -1) { //If strong element is in the descript
            String temp = description.substring(startSplitter, endSplitter - 1);
            temp = temp.substring(0, temp.indexOf("</strong>") + 9);
            p.setDescription(p.getDescription().replace(temp, "<h1>" + betweenStrong + "</h1>"));
        }
        else
            p.setDescription("<h1>"+p.getMetaTitle()+"</h1> <br>" + p.getDescription());

        if (p.getContainer()>=60) {
            p.setOrderProcessingTime(3);
        }
        else {
            p.setOrderProcessingTime(2);
        }

        //region Save the stock status ------------------------------------------------------------------
        String stock = title.select("div.artikelDetailInfos").select("div#filialBestaende").text();

        if (stock.contains("0 Stk. verfügbar in Filiale Wr Neustadt") && stock.contains("0 Stk. verfügbar in Filiale Schwechat")) {
            p.setInStock(0);
            p.setDeliveryTime("14 Werktage");
            p.setOrderProcessingTime(14);
        } else {
            //Go through the string an get the stock out
            String helper = stock.substring(stock.indexOf("Schwechat") + 10, stock.length());
            helper = helper.substring(0, helper.indexOf("Stk.") - 1);

            if (helper.contains("mehr als 100"))
                p.setInStock(100);
            else
                p.setInStock(Integer.parseInt(helper));
        }
        if(p.getInStock()<=0) {
            p.setDeliveryTime("14 Werktage");
            p.setOrderProcessingTime(14);
        }
        else if (p.getOrderProcessingTime()>2){
            p.setDeliveryTime("2-3 Werktage");
        }
        else {
            p.setDeliveryTime("1-2 Werktage");
            p.setOrderProcessingTime(2);
        }
        //endregion

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                CalculateRelatedProducts(p, GetProducts());
            }
        });*/

        Date date2 = new Date();
        System.out.println( "End: " + date2.getTime());
        long l2 = date2.getTime();
        long difference = l2 - l1;
        System.out.println(difference);
        duration += difference;

        return p;
    }

    /**
     * Calculate Related Products
     * @param p
     * @param plist
     */
    public void CalculateRelatedProducts(Products p, ArrayList<Products> plist) {
        if (p.getRelated() == null) {
            p.setRelated("");
            if (p.getRelated().length()<=100) {
                ArrayList<Products> all = plist;

                for (int i = 0; i < 15; i++) {
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(all.size());

                    if (p.getRelated().length()<=0)
                        p.setRelated(all.get(randomInt).getSku());
                    else
                        p.setRelated(all.get(randomInt).getSku() + "," + p.getRelated());

                    this.SaveToDatabase(p);
                }
            }
        }
    }

    /**
     * Filtering the Weight of the Products
     *
     * @param p Give the Products of which have to be calculated the Container
     * @return The Weigth of the Products
     */
    public double RecognationOfContainer(Products p) {
        double container = 0;
        int found = 0;
        boolean lastNumeric = false;

        for (int i = 0; i < p.getTitle().length(); i++) {
            String test = String.valueOf(p.getTitle().charAt(i));
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
                if (test.toLowerCase().equals("l")) {
                    break;
                } else if (test.toLowerCase().equals("m") && String.valueOf(p.getTitle().charAt(i + 1)).toLowerCase().equals("l")) {
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
    private boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     * This Method is the main heart of this programm. It calls all other important methods
     * which do prework for Harvest the inner of a product and gives us the finished product
     * then we are saving or updating it in our database and puting it out in a csv file
     *
     * @return All Harvested Products
     * @throws IOException
     */
    public List<Products> HarvestAllSites(LinkedList<String> allSites) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Start: " + sdf.format(cal.getTime()));

        HashMap<String, Products> write = new HashMap<String, Products>();

        for (int i = 0; i < allSites.size(); i++) {

            //Den aktuellen Link des Produktes hinschicken und dann den produkt des linkes zurückkriegen
            Products p = null;
            try {
                p = HarvestInnerProduct(allSites.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (p != null) {
                allProducts.add(p);
                int mode = 0;
                if((mode = SaveToDatabase(p))==1) {
                    WriteToCSV("",1,p);
                }
                else if (mode == 2) {
                    WriteToCSV("",3,p);
                }

                System.out.print("Waitin four Sec. - Did " + (i + 1) + " Products - Last Products: " + p.getTitle() + " - Link to Pic: " + p.getBaseImage() + " EAT: " + ((GetEat(allLinks.size())/100.0)/60.0) + " AVG DUR: " + getAvgDurationPerProduct() + "\n");
                write.clear();
            }
            try {
                Thread.sleep(4 * 1000);
            } catch (InterruptedException e) {
                System.out.println("ThreadSleep Error InterruptedException -> MotoroilDirektHarvester in the Method HarvestAllSites() -> Sleep the Thread for 4 sec \nError Message:" + e.getMessage());
            }
        }

        cal = Calendar.getInstance();
        System.out.println("End-Time: " + sdf.format(cal.getTime()));
        System.out.println("Anzahl der Produkte: " + allProducts.size() + "\n");

        return allProducts;
    }

    /**
     * Writing all new Products to the new.csv file
     */
    public void WriteToCSV(String brandName, int type, Products c) {

        FileWriter writer = null;
        String filename;

        //sku;tax_class_id;visibility;status;weight;_product_website;_type;_attribute_set;name;qty;price;image;small_image;thumbnail;weight;manufacturer
        if (type==1) {
            filename = "/Users/andrejsakal/Dokumente/CloudDrive/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/FullExport" + brandName + ".csv";
        }
        else if (type==2) {
            filename = "/Users/andrejsakal/Dokumente/CloudDrive/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/WithoutPicturesExport" + brandName + ".csv";
        }
        else if (type==4) {
            filename = "/Users/andrejsakal/Dokumente/CloudDrive/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/RelatedUpdate" + brandName + ".csv";
        }
        else {
            filename = "/Users/andrejsakal/Dokumente/CloudDrive/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/StockUpdateExport" + brandName + ".csv";
            //filename = currentDir + "StockUpdateExport" + brandName + ".csv";

        }

        if(Files.exists(Paths.get(filename))) {

        }

        try (FileWriter fw = new FileWriter(filename, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            Products p = c;
            if (type==1)
                out.print(p.toStringFullExport());
            else if(type==2)
                out.print(p.toStringWithoutPicturesImport());
            else if(type==4)
                out.print(p.toStringRelatedExport());
            else
                out.print(p.toStringStockExport());

        } catch (IOException e) {
        }
    }

    public void ExportDatabase(ArrayList<Products> p, boolean sku, boolean baseImage, boolean brand, boolean container, boolean description, boolean inStock, boolean metaTitle, boolean price, boolean related, boolean deliveryTime, boolean orderprocessingtime) {

        FileWriter writer = null;
        String filename;
        //sku;tax_class_id;visibility;status;weight;_product_website;_type;_attribute_set;name;qty;price;image;small_image;thumbnail;weight;manufacturer
        String header = "";
        String actProd = "";

        File currentDirFile = new File("CustomExport.csv");
        String helper = currentDirFile.getAbsolutePath();
        System.out.printf(helper);
        String currentDir = helper.replace(".\\","");
        filename = currentDir;
        boolean writeHeader = false;
        filename = FILENAME + "CustomExport.csv";
        //sku;tax_class_id;visibility;status;weight;_product_website;_type;_attribute_set;name;qty;price;image;small_image;thumbnail;weight;manufacturer;description;cjm_ships_in
        //String.format("^"+ sku +"^;" + "^1^;" + "^4^;" + "^1^;" + "^0^;" + "^base^;" + "^simple^;" + "^Default^;" + "^"+ metaTitle + "^"+ ";" + "^"+ inStock + "^"+ ";" + "^"+ price +"^;^"+ baseImage +"^;^" + baseImage +"^;^" + baseImage +"^;^" + container + "^;^" + brand +"^" + ";^"+description+";^"+orderprocessingtime+"^\n");


        for (int i = 0; i < p.size(); i++) {
            System.out.println(i);
            if (sku) {
                header += "sku;";
                actProd += "^" + p.get(i).getSku() + "^;";
            }
            if (baseImage) {
                header += "image;";
                header += "thumbnail;";
                header += "small_image;";
                actProd += "^" + p.get(i).getBaseImage() + "^;";
                actProd += "^" + p.get(i).getBaseImage() + "^;";
                actProd += "^" + p.get(i).getBaseImage() + "^;";
            }
            if (brand) {
                header += "manufacturer;";
                actProd += "^" + p.get(i).getBrand() + "^;";
            }
            if (container) {
                header += "weight;";
                actProd += "^" + p.get(i).getContainer() + "^;";
            }
            if (description) {
                header += "description;";
                actProd += "^" + p.get(i).getDescription() + "^;";
            }
            if (inStock) {
                header += "qty;";
                actProd += "^" + p.get(i).getInStock() + "^;";
            }
            if (metaTitle) {
                header += "name;";
                actProd += "^" + p.get(i).getMetaTitle() + "^;";
            }
            if (price) {
                header += "price;";
                actProd += "^" + p.get(i).getPrice() + "^;";
            }
            if (related && p.get(i).getRelated() != null) {
                actProd += "^" + p.get(i).getRelated() + "^;";
                header += "related;";
            }
            if (deliveryTime) {
                actProd += "^" + p.get(i).getDeliveryTime() + "^;";
                header += "cjm_stockmessage;";
            }
            if (orderprocessingtime) {
                actProd += "^" + p.get(i).getOrderProcessingTime() + "^;";
                header += "cjm_ships_in;";
            }

            try {
                    writeHeader = !Files.exists(Paths.get(filename));
                try (FileWriter fw = new FileWriter(filename, true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                        if (writeHeader)
                            out.print(header+"\n");

                        out.print(actProd+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            actProd="";
        }
    }

    /**
     * This method saves the given product to the database if it doesnt exists
     * if it exists then we are lookin if something changed (import purposes)
     * if exists and nothing changed we are doing nothing
     * @param product
     * @return
     */
    public int SaveToDatabase(Products product) {
        Products p;
            if ((p = GetProductBySKU(product.getSku())) == null) {
                try {
                    em.persist(product);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 1;
            }
            else {
                if (p.getPrice()!=product.getPrice() || p.getInStock() != product.getInStock()) {
                    p.setPrice(product.getPrice());
                    p.setInStock(product.getInStock());
                    p.setDeliveryTime(product.getDeliveryTime());
                    //p.setBaseImage(product.getBaseImage());
                    //p.setSmallImage(product.getBaseImage());
                    //p.setMetaTitle(product.getMetaTitle());
                    p.setOrderProcessingTime(product.getOrderProcessingTime());
                    p.setTitle(product.getTitle());
                    p.setBrand(product.getBrand());
                    p.setRelated(product.getRelated());
                    return 2;
                }
                else {
                    //p.setBaseImage(product.getBaseImage());
                    //p.setSmallImage(product.getBaseImage());
                    //p.setMetaTitle(product.getMetaTitle());
                    p.setDeliveryTime(product.getDeliveryTime());
                    p.setOrderProcessingTime(product.getOrderProcessingTime());
                    p.setTitle(product.getTitle());
                    p.setBrand(product.getBrand());
                    p.setRelated(product.getRelated());
                    return 3;
                }
            }
    }

    public ArrayList<Products> GetProducts() {
        TypedQuery<Products> query = em.createNamedQuery("Products.getAll", Products.class);
        ArrayList<Products> test = (ArrayList<Products>) query.getResultList();
        return test;
    }

    public List<Products> GetMannolProducts() {
        TypedQuery<Products> query = em.createNamedQuery("Products.GetMannolProducts", Products.class);
        List<Products> test = query.getResultList();
        return test;
    }

    public ArrayList<Products> GetProductsByBrand(String brand) {
        TypedQuery<Products> query = em.createNamedQuery("Products.GetProductsByBrand", Products.class).setParameter("brand",brand.toUpperCase());
        ArrayList<Products> test = (ArrayList<Products>) query.getResultList();
        return test;
    }

    public Products GetProductBySKU(String sku) {

        try {
            //Products query = em.createNamedQuery("Products.getProductBySku", Products.class).setParameter("sku","'"+sku+"'").getSingleResult();
            Products query = getSingleResultOrNull(em.createQuery("select p FROM Products p where p.sku = '"+sku+"'", Products.class));
            return query;
        }
        catch (Exception e) {
            System.out.println("SKU NOT EXISTING" + sku);
            return null;
        }

    }

    public static Products getSingleResultOrNull(Query query){
        List<Products> results = query.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return results.get(0);
        throw new NonUniqueResultException();
    }

    public List<Products> GetProductsNoCustomDescription() {
        TypedQuery<Products> query = em.createNamedQuery("Products.NoCustomDescription", Products.class);
        List<Products> test = query.getResultList();
        return test;
    }

    public String MakeFileNamePretty(String name) {
        name = name.replace(" (", "").replace(")", "").replace("/", " ").replace("-", "").replace("vollsynth.", "").replace(".", "-").replace(" for", "").replace(" für", "").replace(" ", "-").replace("ü", "ue").replace("®", "").replace("+", "").replace("ö", "oe").replace("ä", "ae").replace(",", "").replace("à","a").replace("ß","ss").replace("--","-").replace(":"," ") + ".jpg";
        return name;
    }

    public void MakeFileNamePrettyDb() {
        ArrayList<Products> all = GetProducts();
        for (int i = 0; i < all.size(); i++) {
            String filename = MakeFileNamePretty(all.get(i).getMetaTitle());
            all.get(i).setSmallImage(filename);
            all.get(i).setBaseImage(filename);
        }
    }

    public LinkedList<String> getAllLinks() {
        return allLinks;
    }

    public int GetEat(int cnt) {
        return getAvgDurationPerProduct() * (cnt-allProducts.size());
    }

    public String GetStatus() {
        LinkedList<String> products_test = new LinkedList<>();
        products_test.add("https://www.motoroeldirekt.at/Soffitte-C5W-36mm-6x-5630-SMD-Gelb?source=2&refertype=5&referid=228057");
        products_test.add("https://www.motoroeldirekt.at/Eurolub-Bremsenreiniger-5l?source=2&refertype=5&referid=228060");
        products_test.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8252&refertype=16");
        products_test.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8251&refertype=16");
        products_test.add("https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8111&refertype=16");
        String message = "";

        for (int i = 0; i < products_test.size(); i++) {
            try {
                Products p1 = HarvestInnerProduct(products_test.get(i));
                Products p2 = new Products();
                message +=  p1.getMetaTitle() + " Stock: " + p1.getInStock() + " Price: " + p1.getPrice() + "\n";

                p2 = this.GetProductBySKU(p1.getSku());
                if (p2 != null) {
                    System.out.println(p2.toStringFullExport());
                    message += p2.getMetaTitle() + " Stock: " + p2.getInStock() + " Price: " + p2.getPrice();
                    if (p1.getPrice() == p2.getPrice() && p1.getInStock() == p2.getInStock())
                        message += " ✓";

                    message += "\n";
                }
                else {
                    message += p1.getMetaTitle() + " Not existing in db\n";
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message+="\n\n";
        }

        return message;
    }
}
