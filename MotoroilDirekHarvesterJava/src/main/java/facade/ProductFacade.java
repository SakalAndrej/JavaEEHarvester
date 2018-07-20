package facade;


import model.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ProductFacade {


    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager==null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public void save(Product product) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(product);
        this.getEntityManager().flush();
        this.getEntityManager().getTransaction().commit();
    }

    public void updateStock(Product productToUpdateStock) {
        Product fromDb = this.getEntityManager().find(Product.class, productToUpdateStock.getSku());

        fromDb.setTitle(productToUpdateStock.getTitle());
        fromDb.setInStock(productToUpdateStock.getInStock());
        fromDb.setDeliveryTime(productToUpdateStock.getDeliveryTime());
        fromDb.setOrderProcessingTime(productToUpdateStock.getOrderProcessingTime());
        fromDb.setPrice(productToUpdateStock.getPrice());
        fromDb.setGewinn(productToUpdateStock.getGewinn());

        this.getEntityManager().merge(fromDb);
    }

    public boolean isExisting(String sku) {
        if (this.getEntityManager().find(Product.class, sku) != null)
            return true;
        else
            return false;
    }

    public List<Product> GetProductsNoCustomDescription() {
        TypedQuery<Product> query = getEntityManager().createNamedQuery("Products.NoCustomDescription", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public Product GetProductBySKU(String sku) {
        try {
            TypedQuery<Product> query = getEntityManager().createQuery("select p FROM Product p where p.sku = '"+sku+"'", Product.class);
            return query.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("SKU NOT EXISTING" + sku);
            return null;
        }
    }

    public LinkedList<Product> GetProducts() {
        TypedQuery<Product> query = getEntityManager().createNamedQuery("Products.getAll", Product.class);
        LinkedList<Product> test = (LinkedList<Product>) query.getResultList();
        return test;
    }

    public List<Product> GetMannolProducts() {
        TypedQuery<Product> query = getEntityManager().createNamedQuery("Products.GetMannolProducts", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public ArrayList<Product> GetProductsByBrand(String brand) {
        TypedQuery<Product> query = getEntityManager().createNamedQuery("Products.GetProductsByBrand", Product.class).setParameter("brand",brand.toUpperCase());
        ArrayList<Product> test = (ArrayList<Product>) query.getResultList();
        return test;
    }
}
