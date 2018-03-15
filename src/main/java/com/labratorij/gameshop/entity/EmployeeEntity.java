package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "gameshop_new", catalog = "")
public class EmployeeEntity implements Serializable {
    private int employeeId;
    private String name;
    private Integer passport;
    private String adress;
    private Integer telephone;
    private Collection<OrderEntity> ordersByEmployeeId;

    @Id
    @GenericGenerator(name="inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Employee_ID", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Passport", nullable = true)
    public Integer getPassport() {
        return passport;
    }

    public void setPassport(Integer passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "Adress", nullable = true, length = 128)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "Telephone", nullable = true)
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employee")
    public Collection<OrderEntity> getOrdersByEmployeeId() {
        return ordersByEmployeeId;
    }

    public void setOrdersByEmployeeId(Collection<OrderEntity> ordersByEmployeeId) {
        this.ordersByEmployeeId = ordersByEmployeeId;
    }
}
