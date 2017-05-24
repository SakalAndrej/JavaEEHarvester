package rest;

import filter.MotoroilDirektHarvester;
import model.Products;
import seo.SeoAudit;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by andrejsakal on 27.03.17.
 */
@Path("product")
public class ProductEndpoint {

    @Inject
    MotoroilDirektHarvester md;

    @Path("start")
    public Response startHarvest(@QueryParam("part") int part) {
        md.initializeLinks();
        System.out.println(md.getAllLinks().size());
        return Response.ok().build();
    }

    @Path("seo")
    public Response seoAudit() {
        SeoAudit.addOilFinderMannol(md.GetMannolProducts());
        return Response.ok().build();
    }

    @Path("export")
    public Response exportStockByBrand(@QueryParam("brand") String brand, @QueryParam("type") int type) {
        ArrayList<Products> all = new ArrayList<Products>();

        if (brand!="")
            all = md.GetProductsByBrand(brand);
        if(all.size()<=0) {
            all = md.GetProducts();
            brand = "";
        }
        else
            brand = "_" + brand;

        for (int i = 0; i < all.size(); i++) {
            md.WriteToCSV(brand,type, all.get(i));
        }
        return Response.ok().build();
    }

    @Path("imagename")
    public Response imagename() {
        md.MakeFileNamePrettyDb();
        return Response.ok().build();
    }

    @Path("setRelated")
    public Response setRelated() {
        ArrayList<Products> all = md.GetProducts();
        for (int i = 0; i < all.size(); i++) {
            md.CalculateRelatedProducts(all.get(i), all);
        }
        return Response.ok().build();
    }
}
