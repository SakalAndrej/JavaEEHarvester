package rest;

import filter.MotoroilDirektHarvester;
import model.Products;
import seo.SeoAudit;

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
    public Response startHarvest() {
        md.initializeLinks();
        System.out.println("works");
        return Response.ok().build();
    }

    @Path("seo")
    public Response seoAudit() {
        SeoAudit.addOilFinderMannol(md.GetMannolProducts());
        return Response.ok().build();
    }

    @Path("export")
    public Response exportAll() {
        ArrayList<Products> all = md.GetProducts();
        for (int i = 0; i < all.size(); i++) {
            md.WriteToCSV(all.get(i));
        }
        return Response.ok().build();
    }

    @Path("exportStock")
    public Response exportStock() {
        ArrayList<Products> all = md.GetProducts();
        for (int i = 0; i < all.size(); i++) {
            md.WriteChangedToCSV(all.get(i));
        }
        return Response.ok().build();
    }

    @Path("imagename")
    public Response imagename() {
        md.MakeFileNamePrettyDb();
        return Response.ok().build();
    }
}
