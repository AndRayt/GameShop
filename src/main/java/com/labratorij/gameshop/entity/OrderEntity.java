package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "orders", schema = "gameshop_new", catalog = "")
public class OrderEntity implements Serializable {
    private int orderId;
    private Date date;
    private EmployeeEntity employee;
    private ClientEntity client;
    private Collection<VideogameEntity> videogames;

    @Id
    @GenericGenerator(name="inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Order_ID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Date_order", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee_ID", referencedColumnName = "Employee_ID", nullable = false)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employeeByEmployeeId) {
        this.employee = employeeByEmployeeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID", nullable = false)
    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity clientByClientId) {
        this.client = clientByClientId;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_has_videogame", joinColumns = @JoinColumn(name = "Order_Order_ID", referencedColumnName = "Order_ID"), inverseJoinColumns = @JoinColumn(name = "Videogame_Videogame_ID", referencedColumnName = "Videogame_ID"))
    public Collection<VideogameEntity> getVideogames() {
        return videogames;
    }

    public void setVideogames(Collection<VideogameEntity> videogames) {
        this.videogames = videogames;
    }

    public void addVideogame(VideogameEntity videogame){
        videogames.add(videogame);
        videogame.getOrders().add(this);
    }
}
