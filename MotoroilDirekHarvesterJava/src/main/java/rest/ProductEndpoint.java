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

@Path("product")
public class ProductEndpoint {

    @Inject
    MotoroilDirektHarvester md;

    @Path("start")
    public Response startHarvest(@QueryParam("part") int part) {
        md.initializeLinks();
        LinkedList<String> all = md.getAllLinks();
        LinkedList<String> harvest = new LinkedList<>();

        /*
        if (part==1) {
            for (int i = 0; i <= 350; i++) {
                harvest.add(all.get(i));
            }
        }
        if (part==2) {
            for (int i = 350; i <= 700; i++) {
                harvest.add(all.get(i));
            }
        }
        if (part==3) {
            for (int i = 700; i <= 1050; i++) {
                harvest.add(all.get(i));
            }
        }
        if (part==4) {
            for (int i = 1050; i <= all.size()-1; i++) {
                harvest.add(all.get(i));
            }
        }
        if (part==10) {
            for (int i = 130; i <= 180-1; i++) {
                harvest.add(all.get(i));
            }
        }*/

        for (int i = 0; i < 10; i++) {
            harvest.add(all.get(i));
            md.HarvestAllSites(harvest);
            harvest.clear();
        }
        md.setAllLinks(harvest);
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

        md.ExportDatabase(md.GetProducts(),true,true,true,true,true,true,true,true,true,true,true);

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
