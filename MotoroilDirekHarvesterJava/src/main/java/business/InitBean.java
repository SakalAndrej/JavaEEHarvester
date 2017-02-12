package business;

import model.HarvestClass;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.text.ParseException;

@Startup
@Singleton
public class InitBean {

    @Inject
    HarvestClass hc;

    @PostConstruct
    public void init() throws IOException, ParseException {
        hc.main();
    }
}
