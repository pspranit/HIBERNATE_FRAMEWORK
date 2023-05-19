package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "customer_info")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "book_generator")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_generator")
    @SequenceGenerator(name = "book_generator",sequenceName = "book_sequence",allocationSize = 1)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;

    @OneToMany(mappedBy ="customerRef",cascade = CascadeType.ALL)
    private List<Orders> orderList;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<Orders> getOrdersList() {
        return orderList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.orderList = ordersList;
    }

    @Override
    public String toString() {
        return customerName;
    }

    public void addOrders(Orders ordRef)
    {
        if(orderList==null)
        {
            orderList=new LinkedList<>();
        }
        orderList.add(ordRef);
        ordRef.setCustomerRef(this);
    }
}

