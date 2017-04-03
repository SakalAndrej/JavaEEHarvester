package business;

import model.Product;
import seo.SeoAudit;

import javax.annotation.PostConstruct;
import javax.ejb.AfterBegin;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;

@Startup
@Singleton
public class InitBean {


    public void init() throws IOException, ParseException {
    }

}
