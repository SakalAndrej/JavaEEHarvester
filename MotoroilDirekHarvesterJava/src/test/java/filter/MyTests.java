package filter;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by andrejsakal on 07.03.17.
 */
public class MyTests {

    public final int ANZAHL = 100;

    public LinkedList<String> fillListWithLinks(int cnt){
        LinkedList<String> all = new LinkedList<>();
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13443&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8352&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8353&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8344&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8350&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8340&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8338&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8339&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8397&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8342&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8343&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8347&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8346&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8354&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8355&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8341&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8349&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8348&kategorieid=3995&source=2&refertype=1&referid=3995");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8244&kategorieid=3960&source=2&refertype=1&referid=3960");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8242&kategorieid=3960&source=2&refertype=1&referid=3960");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8476&kategorieid=3960&source=2&refertype=1&referid=3960");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8243&kategorieid=3960&source=2&refertype=1&referid=3960");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8265&kategorieid=3961&source=2&refertype=1&referid=3961");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8266&kategorieid=3961&source=2&refertype=1&referid=3961");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8271&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8478&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8272&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8277&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8275&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13544&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8479&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8276&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8270&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8269&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8114&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8115&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8113&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13543&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8258&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8256&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8645&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8480&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8257&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8112&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8280&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8278&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8477&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8279&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8254&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8251&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8255&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8253&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8252&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8111&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8523&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8521&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8522&kategorieid=3962&source=2&refertype=1&referid=3962");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8526&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8528&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8527&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11178&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11180&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11179&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8261&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8259&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8730&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8261&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8259&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8730&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8481&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8260&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8729&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8262&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8727&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8482&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8263&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8511&kategorieid=3963&source=2&refertype=1&referid=3963");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8248&kategorieid=3993&source=2&refertype=1&referid=3993");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8483&kategorieid=3993&source=2&refertype=1&referid=3993");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8249&kategorieid=3993&source=2&refertype=1&referid=3993");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11182&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11184&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11183&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11185&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8281&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8284&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8283&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8118&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8109&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8529&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8533&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8531&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8530&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8532&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8534&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8535&kategorieid=3964&source=2&refertype=1&referid=3964");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8247&kategorieid=3965&source=2&refertype=1&referid=3965");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8245&kategorieid=3965&source=2&refertype=1&referid=3965");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8484&kategorieid=3965&source=2&refertype=1&referid=3965");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8246&kategorieid=3965&source=2&refertype=1&referid=3965");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8513&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8515&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8514&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12746&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11186&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11188&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11187&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11189&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8490&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8489&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11181&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8286&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8728&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8110&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8285&kategorieid=3966&source=2&refertype=1&referid=3966");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8486&kategorieid=4022&source=2&refertype=1&referid=4022");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8488&kategorieid=4022&source=2&refertype=1&referid=4022");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8487&kategorieid=4022&source=2&refertype=1&referid=4022");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8290&kategorieid=3967&source=2&refertype=1&referid=3967");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8288&kategorieid=3967&source=2&refertype=1&referid=3967");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8485&kategorieid=3967&source=2&refertype=1&referid=3967");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8289&kategorieid=3967&source=2&refertype=1&referid=3967");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Longlife-III-Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Longlife-III-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4200-Longlife-III-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4300-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4400-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4500-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600--Motoroel-1l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-205l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-20l-Kanister?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-5l?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-5W-30-Top-Tec-4600-Motoroel-60l-Fass?source=2&refertype=1&referid=2063");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-1l?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-205l-Fass?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-5l?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-High-Tech-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-1l?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-205l-Fass?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-20l-Kanister?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-5l?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Top-Tec-4100-5W-40-Motoroel-60l-Fass?source=2&refertype=1&referid=2064");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Leichtlauft-10W-40-Motoroel-Basic-60l-Fass?source=2&refertype=1&referid=2065");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-1l?source=2&refertype=1&referid=2066");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-205l-Fass?source=2&refertype=1&referid=2066");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-20l-Kanister?source=2&refertype=1&referid=2066");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-5l?source=2&refertype=1&referid=2066");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Synthoil-Race-Tech-GT1-10W-60-Motoroel-60l-Fass?source=2&refertype=1&referid=2066");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Gasmotorenoel-15W-40-205l?source=2&refertype=1&referid=2718");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Touring-15W-40-Basic-205l?source=2&refertype=1&referid=2718");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Profi-Touring-15W-40-Basic-60l-Fass?source=2&refertype=1&referid=2718");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Touring-High-Tech-20W-50-20l-Kanister?source=2&refertype=1&referid=2700");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-WIV-50601-0W-30-%28vollsynth.%29-1l?source=2&refertype=1&referid=2787");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-WIV-50601-0W-30-%28vollsynth.%29-5l?source=2&refertype=1&referid=2787");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-1l?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-200l-Fass?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-20l-Kanister?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-5l?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Compatible-SAE-5W-30-60l-Fass?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-New-Generation-SAE-5W-30-1l?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-New-Generation-SAE-5W-30-5l?source=2&refertype=1&referid=2778");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-1l?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-20l-Kanister?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-5l?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Super-Leichtlauf-5W-40-%28vollsynth.%29-60l-Fass?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-1l?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-20l-Kanister?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-5l?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Ultra-Performance-Longlife-SAE-5W-40-60l-Fass?source=2&refertype=1&referid=2779");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Power-Synt-SAE-10W-40-1l?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Power-Synt-SAE-10W-40-5l?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-1l?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-20l-Kanister?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-5l?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/Meguin-megol-Motoroel-Syntech-Premium-SAE-10W-40-60l-Fass?source=2&refertype=1&referid=2780");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8320&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8502&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8454&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8508&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8455&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8458&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8456&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8507&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8457&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8433&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8450&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8453&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8451&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8428&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8427&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8425&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8509&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8426&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8318&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8506&kategorieid=4013&source=2&refertype=1&referid=4013");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8431&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8432&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8732&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8322&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8505&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8323&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8726&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8314&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8510&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8315&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8418&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8416&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8419&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8417&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8734&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8415&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8316&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8413&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8414&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8422&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8420&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8423&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8421&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8733&kategorieid=4014&source=2&refertype=1&referid=4014");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8462&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11208&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8731&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8412&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8411&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8459&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8460&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8461&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8490&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8489&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11181&kategorieid=3998&source=2&refertype=1&referid=3998");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8550&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8549&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8539&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8537&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8536&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8538&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8547&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8548&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8540&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8541&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8544&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8542&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8543&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8545&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8546&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8552&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8553&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8554&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8555&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8556&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8557&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8558&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8559&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8562&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8560&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8561&kategorieid=3999&source=2&refertype=1&referid=3999");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8300&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8303&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8301&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8491&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8492&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8494&kategorieid=4010&source=2&refertype=1&referid=4010");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8304&kategorieid=4012&source=2&refertype=1&referid=4012");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8565&kategorieid=4012&source=2&refertype=1&referid=4012");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8305&kategorieid=4012&source=2&refertype=1&referid=4012");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8308&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8307&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8504&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8501&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13134&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8310&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8309&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8503&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8500&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8297&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8296&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8299&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8298&kategorieid=4011&source=2&refertype=1&referid=4011");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8495&kategorieid=4001&source=2&refertype=1&referid=4001");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8493&kategorieid=4002&source=2&refertype=1&referid=4002");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8311&kategorieid=4002&source=2&refertype=1&referid=4002");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8312&kategorieid=4002&source=2&refertype=1&referid=4002");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8520&kategorieid=4002&source=2&refertype=1&referid=4002");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8474&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8473&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8475&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8424&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8410&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8408&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8409&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12747&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8407&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8406&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8512&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8107&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8405&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8563&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12751&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12752&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12758&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12760&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12753&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12759&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8430&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8429&kategorieid=3946&source=2&refertype=1&referid=3946");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8469&kategorieid=4004&source=2&refertype=1&referid=4004");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8470&kategorieid=4004&source=2&refertype=1&referid=4004");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8472&kategorieid=4004&source=2&refertype=1&referid=4004");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8466&kategorieid=4004&source=2&refertype=1&referid=4004");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8468&kategorieid=4004&source=2&refertype=1&referid=4004");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8497&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8498&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8293&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8291&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=12754&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8294&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8292&kategorieid=3994&source=2&refertype=1&referid=3994");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8295&kategorieid=3994&source=2&refertype=1&referid=3994");        //endregion
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8325&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8101&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8400&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8102&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8324&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8099&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8399&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8100&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8326&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8103&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8401&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8104&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8327&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8105&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8402&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8106&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8403&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8404&kategorieid=3945&source=2&refertype=1&referid=3945");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8098&kategorieid=3809&source=2&refertype=1&referid=3809");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11192&kategorieid=3809&source=2&refertype=1&referid=3809");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8117&kategorieid=3948&source=2&refertype=1&referid=3948");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8119&kategorieid=3948&source=2&refertype=1&referid=3948");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8383&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8385&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8384&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8390&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8391&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8333&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8334&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8329&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8394&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8393&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8392&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=13432&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8335&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8378&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11191&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8381&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8389&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8330&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8398&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8336&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8331&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8380&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8382&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11176&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8332&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8328&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8379&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8387&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8386&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8377&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8388&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8396&kategorieid=4006&source=2&refertype=1&referid=4006");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8371&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8367&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8365&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8366&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8368&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8370&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8369&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8372&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8374&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8376&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8373&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8364&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8375&kategorieid=4007&source=2&refertype=1&referid=4007");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8358&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=11177&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8359&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8360&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8361&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8362&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8363&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8357&kategorieid=4008&source=2&refertype=1&referid=4008");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8337&kategorieid=4009&source=2&refertype=1&referid=4009");
        all.add("http://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8356&kategorieid=4009&source=2&refertype=1&referid=4009");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly--Pro-Line-Visco-Stabil-300ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-ATF-Additive-250-ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Automatik-Getriebe-Reiniger-300ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Cera-Tec-Verschleisschutz-300ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Gear-Protect-80ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Getriebe-Oel-Additiv-20g?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Getriebeoel-Verlust-Stop-50ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-all-System-Additiv-1l?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Hydro-Stoessel-Additiv-300ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-Clean-500ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-Protect-500ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-125-ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-200-ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Additiv-MoS2-500-ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Schlamm-Spuelung-300-ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Oel-Verlust-Stop-300ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Getriebeoel-Verlust-Stop-500ml?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Oel-Verlust-Stop-1l?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Getriebeoel-Additiv?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Motor-Verschleiss-Schutz?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Visco-Stabil-1l?source=2&refertype=1&referid=2069");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Benzin-Stabilisator-250ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Benzin-Systempflege-300ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Blei-Ersatz-250ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Injection-Reiniger-300-ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-System-Reiniger-Benzin-300ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-mtx-Vergaser-Reiniger-300ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Benzin-System-Reiniger-500ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Benzin-Zusatz-1l?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Benzin-250ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Konzentrat-Benzin-20l-Kanister-1%3A1000?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Ventil-Sauber-150ml?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Ventilschutz-fuer-Gasfahrzeuge-1l?source=2&refertype=1&referid=2070");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Anti-Bakterien-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Bio-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Bio-Diesel-Additiv-250ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-150ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-K-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Fliess-Fit-K-5l-Kanne?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Russ-STOP-150-ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Schmier-Additiv-150ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Spuelung-500ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Diesel-Systempflege-250ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Dieselpartikelfilter-Schutz-250ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Motor-System-Reiniger-Diesel-300ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Diesel-System-Reiniger-500ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Diesel-System-Reiniger-K-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Pro-Line-Super-Diesel-Additiv-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Diesel-Zusatz-1l?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Speed-Tec-Diesel-250ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Super-Diesel-Additiv-250ml?source=2&refertype=1&referid=2071");
        all.add("http://www.motoroeldirekt.at/Liqui-Moly-Super-Diesel-Additiv-5l-Kanne?source=2&refertype=1&referid=2071");

        LinkedList<String> returnList = new LinkedList<>();
        for (int i = 0; i <cnt; i++) {
            returnList.add(all.get(i));
        }
        return returnList;
    }

    @Test
    /**
     * Teste ob alle Links auch wirklich ausgeführt werden
     */
    public void t001() {
        LinkedList<String> testLinks = new LinkedList<String>();
        HashMap<String, Product> products = new HashMap<String, Product>();

        //Produkte die eingelesen werden sollen
        testLinks = fillListWithLinks(ANZAHL);

        products.putAll(MotoroilDirektHarvester.HarvestAllSites(testLinks));
            assertEquals( ANZAHL, products.values().size(),"Es wurden nicht alle Produkte geharvested");
    }

    @Test
    /**
     * Es wird getestet was passiert wenn ein Link ungültig ist
     */
    public void t002() {
        LinkedList<String> testLinks = new LinkedList<String>();
        HashMap<String, Product> products = new HashMap<String, Product>();

        //Produkte die eingelesen werden sollen
        testLinks.add("NOLINK");
        testLinks = fillListWithLinks(ANZAHL);
        testLinks.add("NOLINK");

        products.putAll(MotoroilDirektHarvester.HarvestAllSites(testLinks));
        assertEquals( ANZAHL, products.values().size(),"Der fehlerhafte Link wurde nicht behandelt");
    }

    @Test
    /**
     * Es wird getestet ob die berrechnung des Containers richtig ist
     */
    public void t003() {
        Product p = new Product();
        p.set_title("Mannol 5W30 5L");

        assertEquals( 5, MotoroilDirektHarvester.RecognationOfContainer(p),"Das Gewicht wurde falsch berrechnet #1");

        p.set_title("Mannol 5l");
        assertEquals( 5, MotoroilDirektHarvester.RecognationOfContainer(p),"Groß und Kleinschreibung könnte Probleme bereiten");


        p.set_title("5l TEST MANNOL 6L");
        assertEquals( 5, MotoroilDirektHarvester.RecognationOfContainer(p),"Das Gewicht wird weiter berrechnet nachdem es schon einmal erfolgreich gefunden wurde");


        p.set_title("80ml");
        assertEquals( 0.08, MotoroilDirektHarvester.RecognationOfContainer(p),"Kommerstelle falsch oder index fehler");

        p.set_title("180ml");
        assertEquals( 0.18, MotoroilDirektHarvester.RecognationOfContainer(p),"Kommerstelle falsch oder index fehler");


        //p.set_title("0,80l");
        //assertEquals( 0.8, MotoroilDirektHarvester.RecognationOfContainer(p),"Kommerstelle wird nicht berücksichtigt");

    }


}
