package filter;

import model.Product;

import static org.junit.Assert.*;

/**
 * Created by andrejsakal on 02.08.17.
 */
public class MotoroilDirektHarvesterTest {

    public final String PRODUCT = "https://www.motoroeldirekt.at/themes/kategorie/detail.php?artikelid=8252&refertype=16";
    public final MotoroilDirektHarvester INSTANCE = new MotoroilDirektHarvester();

    @org.junit.Test
    public void harvestInnerProduct() throws Exception {
        Product p = INSTANCE.HarvestInnerProduct(PRODUCT);
        assertTrue("Getting Price not working",p.getPrice()!=0.0);
        assertTrue("Log-In not working",p.getPrice()<30);
        System.out.printf(String.valueOf(p.getPrice()));
    }

}