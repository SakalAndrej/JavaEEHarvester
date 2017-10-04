package rest;

import filter.MotoroilDirektHarvester;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Products;
import seo.SeoAudit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;

@Path("product")
@Api("Product")
public class ProductEndpoint {

    @Inject
    MotoroilDirektHarvester md;

    @Path("start")
    @ApiOperation("Das Harvesten wird gestartet")
    @GET
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

        for (int i = 0; i < all.size(); i++) {
            harvest.add(all.get(i));
            md.HarvestAllSites(harvest);
            harvest.clear();
        }
        md.setAllLinks(harvest);
        return Response.ok().build();
    }

    @Path("seo")
    @ApiOperation("Seo Audit triggern")
    @GET
    public Response seoAudit() {
        SeoAudit.addOilFinderMannol(md.GetMannolProducts());
        return Response.ok().build();
    }

    @Path("export")
    @ApiOperation("Exportieren des Betandes")
    @GET
    public Response exportStockByBrand(@QueryParam("brand") String brand, @QueryParam("type") int type) {
        ArrayList<Products> all = new ArrayList<Products>();

        md.ExportDatabase(md.GetProducts(),true,false,false,true,true,true,true,true,true,false,true);

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
    @ApiOperation("Image Names making pretier")
    @GET
    public Response imagename() {
        md.MakeFileNamePrettyDb();
        return Response.ok().build();
    }

    @Path("setRelated")
    @ApiOperation("Setting the Related Products")
    @GET
    public Response setRelated() {
        ArrayList<Products> all = md.GetProducts();
        for (int i = 0; i < all.size(); i++) {
            md.CalculateRelatedProducts(all.get(i), all);
        }
        return Response.ok().build();
    }

    @Path("status")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String getStatus() {
        return md.getStatus();
    }
}
