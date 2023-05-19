package Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_info")
public class ProductDisplay {
    @Id
    @Column(name="product_id")
    private int productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_category")
    private String productCategory;
    @Column(name="product_price")
    private double productPrice;

    public ProductDisplay() {

    }

    public ProductDisplay(int productId,String productName,String productCategory,double productPrice)
    {
        this.productId=productId;
        this.productName=productName;
        this.productCategory=productCategory;
        this.productPrice=productPrice;
    }

    public int getProductId() {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public String getProductCategory()
    {
        return productCategory;
    }
    public double getProductPrice()
    {
        return productPrice;
    }

}

