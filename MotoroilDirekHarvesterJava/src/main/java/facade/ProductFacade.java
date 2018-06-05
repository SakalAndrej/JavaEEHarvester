package facade;


import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductFacade {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Product product) {
        this.entityManager.persist(product);
    }

    public void updateStock(Product productToUpdateStock) {
        Product fromDb = this.entityManager.find(Product.class, productToUpdateStock.getSku());

        fromDb.setTitle(productToUpdateStock.getTitle());
        fromDb.setInStock(productToUpdateStock.getInStock());
        fromDb.setDeliveryTime(productToUpdateStock.getDeliveryTime());
        fromDb.setOrderProcessingTime(productToUpdateStock.getOrderProcessingTime());
        fromDb.setPrice(productToUpdateStock.getPrice());
        fromDb.setGewinn(productToUpdateStock.getGewinn());

        this.entityManager.merge(fromDb);
    }

    public boolean isExisting(String sku) {
        if (this.entityManager.find(Product.class, sku) != null)
            return true;
        else
            return false;
    }

    public List<Product> GetProductsNoCustomDescription() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Products.NoCustomDescription", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public Product GetProductBySKU(String sku) {
        try {
            TypedQuery<Product> query = entityManager.createQuery("select p FROM Product p where p.sku = '"+sku+"'", Product.class);
            return query.getSingleResult();
        }
        catch (Exception e) {
            System.out.println("SKU NOT EXISTING" + sku);
            return null;
        }
    }

    public ArrayList<Product> GetProducts() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Products.getAll", Product.class);
        ArrayList<Product> test = (ArrayList<Product>) query.getResultList();
        return test;
    }

    public List<Product> GetMannolProducts() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Products.GetMannolProducts", Product.class);
        List<Product> test = query.getResultList();
        return test;
    }

    public ArrayList<Product> GetProductsByBrand(String brand) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Products.GetProductsByBrand", Product.class).setParameter("brand",brand.toUpperCase());
        ArrayList<Product> test = (ArrayList<Product>) query.getResultList();
        return test;
    }
}
