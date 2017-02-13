package model;

//import filter.MotoroilDirektHarvester;
import filter.MotoroilDirektHarvester;
import sun.awt.image.ImageWatched;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;

@Stateless
public class HarvestClass {

    @PersistenceContext
    EntityManager em;

    public void main() throws IOException, ParseException {
        URL url = new URL("http://www.motoroeldirekt.at/themes/kategorie/index.php?kategorieid=2293");
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("190.153.55.86", 6588)); // or whatever your proxy is
        //HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);

        //uc.connect();
/*
        String line = null;
        StringBuffer tmp = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        while ((line = in.readLine()) != null) {
            tmp.append(line);
        }

        Document doc = Jsoup.parse(String.valueOf(tmp));
*/
        HashMap<String, Product> products = new HashMap<String, Product>();

        //region Motoroil & Additives Links
        LinkedList<String> MotoroilAndAdditives = new LinkedList<String>();
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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(MotoroilAndAdditives));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Automatikgetriebe));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Schaltgetriebe));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(TraktorBaumaschinen));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Lkw));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Motorrad));

        //region Boot
        LinkedList<String> Boot = new LinkedList<>();
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8493&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8311&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8312&kategorieid=4002&source=2&refertype=1&referid=4002");
        Boot.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8520&kategorieid=4002&source=2&refertype=1&referid=4002");
        //endregion
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Boot));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Hydraulik));

        //region Kompressorenöl
        LinkedList<String> Kompressorenöl = new LinkedList<>();
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8469&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8470&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8472&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8466&kategorieid=4004&source=2&refertype=1&referid=4004");
        Kompressorenöl.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8468&kategorieid=4004&source=2&refertype=1&referid=4004");
        //endregion
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Kompressorenöl));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Saegeketten));

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
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Kuehlerschutz));

        //region AdBlue
        LinkedList<String> AdBlue = new LinkedList<>();
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8098&kategorieid=3809&source=2&refertype=1&referid=3809");
        AdBlue.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11192&kategorieid=3809&source=2&refertype=1&referid=3809");
        //endregion
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(AdBlue));

        //region Bremsflüssigkeiten
        LinkedList<String> Bremsfluessigkeiten = new LinkedList<>();
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8117&kategorieid=3948&source=2&refertype=1&referid=3948");
        Bremsfluessigkeiten.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8119&kategorieid=3948&source=2&refertype=1&referid=3948");
        //endregion
        //products.putAll(MotoroilDirektHarvester.HarvestAllSites(Bremsfluessigkeiten));

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
        products.putAll(MotoroilDirektHarvester.HarvestAllSites(Fahrzeugpflege));

        for (int i = 0; i < products.size(); i++) {
            Product p = (Product) products.values().toArray()[i];
            p.set_description("");
            em.persist(p);
        }
        System.out.println("Complete End");
    }
}