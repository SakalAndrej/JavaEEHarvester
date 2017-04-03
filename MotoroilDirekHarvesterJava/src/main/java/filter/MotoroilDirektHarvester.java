package filter;
import model.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@Stateless
public class MotoroilDirektHarvester {

    @PersistenceContext(unitName = "myPU")
    EntityManager em;


    public void initializeLinks() {
        LinkedList<Product> products = new LinkedList<>();

        //region Motoroil & Additives Links
        LinkedList<String> MotoroilAndAdditives = new LinkedList<String>();

        //region Mannol
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13443&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8352&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8353&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8344&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8350&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8340&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8338&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8339&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8397&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8342&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8343&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8347&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8346&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8354&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8355&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8341&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8349&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8348&kategorieid=3995&source=2&refertype=1&referid=3995");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8244&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8242&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8476&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8243&kategorieid=3960&source=2&refertype=1&referid=3960");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8265&kategorieid=3961&source=2&refertype=1&referid=3961");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8266&kategorieid=3961&source=2&refertype=1&referid=3961");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8271&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8478&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8272&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8277&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8275&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13544&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8479&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8276&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8270&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8269&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8114&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8115&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8113&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13543&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8258&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8256&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8645&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8480&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8257&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8112&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8280&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8278&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8477&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8279&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8254&kategorieid=3962&source=2&refertype=1&referid=3962");
        MotoroilAndAdditives.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8251&kategorieid=3962&source=2&refertype=1&referid=3962");
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
        this.HarvestAllSites(MotoroilAndAdditives);

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
        this.HarvestAllSites(Automatikgetriebe);

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
        this.HarvestAllSites(Schaltgetriebe);


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
        this.HarvestAllSites(TraktorBaumaschinen);

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
        this.HarvestAllSites(Lkw);

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
        this.HarvestAllSites(Motorrad);

        //region Boot
        LinkedList<String> Boot = new LinkedList<>();
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8493&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8311&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8312&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8520&kategorieid=4002&source=2&refertype=1&referid=4002");
        //endregion
        this.HarvestAllSites(Boot);
        //SaveToDatabase(products);
        //products.clear();


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
        this.HarvestAllSites(Hydraulik);

        //region Kompressorenöl
        LinkedList<String> Kompressorenöl = new LinkedList<>();
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8469&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8470&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8472&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8466&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8468&kategorieid=4004&source=2&refertype=1&referid=4004");
        //endregion
        this.HarvestAllSites(Kompressorenöl);

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
        this.HarvestAllSites(Saegeketten);

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
        this.HarvestAllSites(Kuehlerschutz);

        //region AdBlue
        LinkedList<String> AdBlue = new LinkedList<>();
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8098&kategorieid=3809&source=2&refertype=1&referid=3809");
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11192&kategorieid=3809&source=2&refertype=1&referid=3809");
        //endregion
        this.HarvestAllSites(AdBlue);

        //region Bremsflüssigkeiten
        LinkedList<String> Bremsfluessigkeiten = new LinkedList<>();
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8117&kategorieid=3948&source=2&refertype=1&referid=3948");
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8119&kategorieid=3948&source=2&refertype=1&referid=3948");
        //endregion
        this.HarvestAllSites(Bremsfluessigkeiten);

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
        this.HarvestAllSites(Fahrzeugpflege);

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
        this.HarvestAllSites(KlebenDichte);

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
        this.HarvestAllSites(FettePasten);

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
        this.HarvestAllSites(LiquiMolyAdditive);


        System.out.println("Complete End");
    }

    //Harvest the given ad and then makes a car of this ad
    private Product HarvestInnerProduct(String justLink) throws InterruptedException {


        //region Build Connection
        String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";
        Connection.Response res = null;
        Document documentForLogin = null;

        try {
            //first connection with GET request
            res = Jsoup.connect("http://www.motoroeldirekt.at/themes/user/index.php")
                    .userAgent(USER_AGENT)
                    .method(Connection.Method.GET)
                    .execute();
        } catch (Exception ex) {
            System.out.println("Jsoup Connect Error -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Download the Product Page \nError Message:" + ex.getMessage());
        }
        try {
            documentForLogin = Jsoup.connect("http://www.motoroeldirekt.at/themes/user/index.php")
                    .userAgent(USER_AGENT)
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
        boolean success = false;

        try {
            do {
                if (success)
                    Thread.sleep(3000);

                doc = Jsoup.connect(justLink).cookies(res.cookies()).get();

                success = true;
            } while(doc.body()==null);
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

        p.set_title(title.select("h1").text().replace("-","").replace(" ml","ml"));
        p.set_metaTitle(p.get_title().replace("Motoröl","").replace("MANNOL","Mannol").replace("Kanister","").replace("Fass","").replace("mororöl","").replace("Blechdose","").replace("Flasche","").replace("Kanne","").replace("LongLife","LL").replace("for","für").replace("  60l "," 60l").replace("  1l "," 1l").replace("  10l "," 10l").replace("  208l "," 208l").replace("  5l "," 5l").replace("  20l "," 20l"));


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
                try {

                    //Making pretty filenames for the pictures
                    String fileName = p.get_metaTitle().replace(" (", "").replace(")", "").replace("/", " ").replace("-", "").replace("vollsynth.", "").replace(".", "-").replace(" for", "").replace(" für", "").replace(" ", "-").replace("ü", "ue").replace("®", "").replace("+", "").replace("ö", "oe").replace("ä", "ae").replace(",", "") + ".jpg";
                    String filePath = "/Users/andrejsakal/Downloads/pictures/" + fileName;

                    if (!Files.exists(Paths.get(filePath)))
                        Files.copy(in, Paths.get(filePath));
                    else
                        System.out.print("Picture already exists\n");

                    p.set_baseImage(fileName);
                    p.set_smallImage(fileName);

                } catch (IOException e) {
                    System.out.println("Files Error IOException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
                }
            } catch (MalformedURLException e) {
                System.out.println("InputStream Error MalformedURLException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("InputStream Error IOException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Save the downloaded Image \nError Message:" + e.getMessage());
            }
        //endregion

        //Save the artikelid from the imagename -----------------------------------------------------------------------------
        if(justLink.contains("artikelid="))
            p.set_sku(justLink.substring(justLink.indexOf("artikelid=") + 10, justLink.indexOf("&")));
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
            p.set_sku(baseImageForArtikelId);
        }

        //Save the price ---------------------------------------------------------------------------------
        double price = 0.0;
        try {
            price = Double.parseDouble(title.select("div.artikelDetailInfos").select("span#artikelPreis").text().replace(" €", "").replace(".", "").replace(",", "."));
            double oldPrice = price;
            if (price <= 3) {
                price = price * 1.2 * 1.6;
            } else if (price <= 9.9) {
                price = price * 1.2 * 1.38;
            } else if (price <= 20) {
                price = price * 1.2 * 1.33;
            } else if (price <= 30) {
                price = price * 1.2 * 1.30;
            } else if (price <= 50) {
                price = price * 1.2 * 1.24;
            } else if (price <= 100) {
                price = price * 1.2 * 1.24;
            } else if (price > 100) {
                price = price * 1.2 * 1.22;
            } else if (price > 1000) {
                price = price * 1.2 * 1.20;
            } else {
                System.out.println("------------------------------> ERROR IN PRICE CALC <---------------------------------\nThe Problematic Price: " + price);
                return null;
            }
            p.set_brand(String.valueOf(price-oldPrice));

            int temp = (int) price;
            price = temp + 0.9;
            p.set_price(price);
        } catch (NumberFormatException ex) {
            System.out.println("DoubleParse Error NumberFormatException -> MotoroilDirektHarvester in the Method HarvesterInnerProduct() -> Calculate the price The Problematic Price: " + price + "\nError Message:" + ex.getMessage());
            return null;
        }

        //Calculating the Weight of the Product through the String
        p.set_container(RecognationOfContainer(p));

        //Save the description -------------------------------------------------------------------
        p.set_description(descript.select("div.artikelDetailTabBox").html().replace("\n", ""));

        //Edit the description ---------------------------------------------
        String description = p.get_description();
        String betweenStrong = p.get_metaTitle();

        //replace the first paragraph
        int startSplitter = description.indexOf("<strong>");
        int endSplitter = description.length();

        if (startSplitter != -1) { //If strong element is in the descript
            String temp = description.substring(startSplitter, endSplitter - 1);
            temp = temp.substring(0, temp.indexOf("</strong>") + 9);
            p.set_description(p.get_description().replace(temp, "<h1>" + betweenStrong + "</h1>"));
        }
        else {
            p.set_description("<h1>"+p.get_metaTitle()+"</h1> <br>" + p.get_description());
        }
        //--------------------------------------------------------------------

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
    public double RecognationOfContainer(Product p) {
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
                if (test.toLowerCase().equals("l")) {
                    break;
                } else if (test.toLowerCase().equals("m") && String.valueOf(p.get_title().charAt(i + 1)).toLowerCase().equals("l")) {
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
     * This Method harvest all Sites with the specific algorithm to get all of the ads in willhaben
     * Then it gives one page to the other method -> the other method harvests all ads and gives the
     * ads to another method -> the last method makes of the ads cars.
     * So this methods gives all cars on willhaben
     *
     * @return
     * @throws IOException
     */
    public List<Product> HarvestAllSites(LinkedList<String> allSites) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Start: " + sdf.format(cal.getTime()));

        LinkedList<Product> allProducts = new LinkedList<>();
        HashMap<String, Product> write = new HashMap<String, Product>();

        for (int i = 0; i < allSites.size(); i++) {

            //Den aktuellen Link des Produktes hinschicken und dann den produkt des linkes zurückkriegen
            Product p = null;
            try {
                p = HarvestInnerProduct(allSites.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (p != null) {
                allProducts.add(p);
                if (GetProductBySKU(p.get_sku())==null)
                    em.persist(p);
                write.put(p.get_sku(),p);
                WriteToCSV(write);
                System.out.print("Waitin 5 Sec. - Did " + (i + 1) + " Products - Last Product: " + p.get_title() + " - Link to Pic: " + p.get_baseImage() + "\n");
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
        //WriteToCSV(allProducts);
        return allProducts;
    }

    private void WriteToCSV(HashMap<String, Product> c) {

        FileWriter writer = null;
//sku;tax_class_id;visibility;status;weight;_product_website;_type;_attribute_set;short_description;description;name;qty;price;image;small_image;thumbnail;weight
        try(FileWriter fw = new FileWriter("/Users/andrejsakal/Dokumente/Cloud Drive/Git-Repository/MotoroilDirektHarvester/MotoroilDirekHarvesterJava/test.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            Product p = (Product) c.values().toArray()[0];
            out.print(p.toString());
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void SaveToDatabase(LinkedList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (GetProductBySKU(products.get(i).get_sku()) == null) {
                Product p = (Product) products.get(i);
                try {
                    em.persist(p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.print("ALREADY IN DB");
            }
        }
        em.flush();
    }

    public List<Product> GetProducts() {
        TypedQuery<Product> query = em.createNamedQuery("Product.getAll", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public List<Product> GetMannolProducts() {
        TypedQuery<Product> query = em.createNamedQuery("Product.GetMannolProducts", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public Product GetProductBySKU(String sku) {
        TypedQuery<Product> query = em.createNamedQuery("Product.getProductBySku", Product.class).setParameter("sku",sku);

        Product test = null;
        try {
            test = query.getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println("SKU NOT EXISTING");
            return null;
        }
        return test;
    }

    public List<Product> GetProductsNoCustomDescription() {
        TypedQuery<Product> query = em.createNamedQuery("Product.NoCustomDescription", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }
}
