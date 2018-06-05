package web;

import facade.ProductFacade;
import filter.MotoroilDirektHarvester;
import filter.Status;
import model.Product;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Model
public class IndexController {

    @Inject
    MotoroilDirektHarvester md;

    @Inject
    ProductFacade productFacade;

    private boolean sku = true;
    private boolean baseimage;
    private boolean brand;
    private boolean container;
    private boolean description;
    private boolean instock;
    private boolean metatitle;
    private boolean price;
    private boolean related;
    private boolean deliverytime;
    private boolean orderprocessingTime;

    public void doHarvest() {
        if (!Status.isIsHarvesting()) {
            md.InitializeLinks();
            LinkedList<String> all = md.getAllLinks();
            md.HarvestAllSites(all);
        }
    }

    public void doExport() {
        md.ExportDatabase(productFacade.GetProducts(),sku,baseimage,brand,container,description,instock,metatitle,price,related,deliverytime,orderprocessingTime);
    }

    //region Getter & Setter

    public boolean isHarvesting() {
        return Status.isIsHarvesting();
    }

    public LocalDateTime lastHarvest() {
        return Status.getLastHarvest();
    }

    public int productsToHarvest() {
        return Status.getProductsToHarvest();
    }

    public String logs() {return Status.getLogs();}

    public double duration() { return Status.getEstimatedTime();}

    public boolean isSku() {
        return sku;
    }

    public void setSku(boolean sku) {
        this.sku = sku;
    }

    public boolean isBaseimage() {
        return baseimage;
    }

    public void setBaseimage(boolean baseimage) {
        this.baseimage = baseimage;
    }

    public boolean isBrand() {
        return brand;
    }

    public void setBrand(boolean brand) {
        this.brand = brand;
    }

    public boolean isContainer() {
        return container;
    }

    public void setContainer(boolean container) {
        this.container = container;
    }

    public boolean isDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public boolean isInstock() {
        return instock;
    }

    public void setInstock(boolean instock) {
        this.instock = instock;
    }

    public boolean isMetatitle() {
        return metatitle;
    }

    public void setMetatitle(boolean metatitle) {
        this.metatitle = metatitle;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isRelated() {
        return related;
    }

    public void setRelated(boolean related) {
        this.related = related;
    }

    public boolean isDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(boolean deliverytime) {
        this.deliverytime = deliverytime;
    }

    public boolean isOrderprocessingTime() {
        return orderprocessingTime;
    }

    public void setOrderprocessingTime(boolean orderprocessingTime) {
        this.orderprocessingTime = orderprocessingTime;
    }

    //endregion
}
