package rest;

import filter.MotoroilDirektHarvester;
import seo.SeoAudit;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by andrejsakal on 27.03.17.
 */
@Path("product")
public class ProductEndpoint {

    @Inject
    MotoroilDirektHarvester md;

    //@Inject
    //SeoAudit seo;

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
}
