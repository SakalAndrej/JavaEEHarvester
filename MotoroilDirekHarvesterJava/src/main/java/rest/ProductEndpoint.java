package rest;

import facade.ProductFacade;
import filter.MotoroilDirektHarvester;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Product;
import seo.SeoAudit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Path("product")
@Api("Product")
public class ProductEndpoint {

    @Inject
    MotoroilDirektHarvester md;

    @Inject
    ProductFacade productFacade;

    @Path("start")
    @ApiOperation("Das Harvesten wird gestartet")
    @GET
    public Response startHarvest() {
        md.InitializeLinks();
        LinkedList<String> all = md.getAllLinks();
        md.HarvestAllSites(all);
        return Response.ok().build();
    }

    @Path("seo")
    @ApiOperation("Seo Audit triggern")
    @GET
    public Response seoAudit() {
        SeoAudit.addOilFinderMannol(productFacade.GetMannolProducts());
        return Response.ok().build();
    }

    @Path("export")
    @ApiOperation("Exportieren des Bestandes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response exportStockByBrand(@QueryParam("sku") boolean sku,@QueryParam("baseimage") boolean baseimage, @QueryParam("brand") boolean brand, @QueryParam("container") boolean container, @QueryParam("description") boolean description, @QueryParam("instock") boolean instock, @QueryParam("metatitle") boolean metatitle, @QueryParam("price") boolean price, @QueryParam("related") boolean related, @QueryParam("deliverytime") boolean deliverytime, @QueryParam("orderprocessingTime") boolean orderprocessingTime ) {
        List<Product> all = productFacade.GetProducts();

        md.ExportDatabase(all,sku,baseimage,brand,container,description,instock,metatitle,price,related,deliverytime,orderprocessingTime);
        return Response.ok(all).build();
    }

    @Path("imagename")
    @ApiOperation("Image Names making prettier")
    @GET
    public Response imagename() {
        md.MakeFileNamePrettyDb();
        return Response.ok().build();
    }

    @Path("setRelated")
    @ApiOperation("Setting the Related Product")
    @GET
    public Response setRelated() {
        List<Product> all = productFacade.GetProducts();
        for (int i = 0; i < all.size(); i++) {
            md.CalculateRelatedProducts(all.get(i), all);
        }
        return Response.ok().build();
    }

    @Path("status")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String getStatus() {
        return md.GetStatus();
    }
}
