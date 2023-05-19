package Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_info")

public class Product {
    @Id
    @Column(name="product_id")
    private int productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_category")
    private String productCategory;
    @Column(name="product_price")
    private double productPrice;

    public Product() {

    }

    public Product(int productId, String productName, String productCategory, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryl() {
        return productCategory;
    }

    public void setProductCategoryl(String productCategoryl) {
        this.productCategory = productCategoryl;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
