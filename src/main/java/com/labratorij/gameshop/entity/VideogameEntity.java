package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "videogames", schema = "gameshop_new", catalog = "")
public class VideogameEntity implements Serializable {
    private int videogameId;
    private String developer;
    private String publisher;
    private String genre;
    private int ageRating;
    private Date date;
    private double costOfPurchase;
    private double price;
    private int quantity;
    private String videogame;
    private List<OrderEntity> orders;
    private List<PlatformEntity> platfrom;

    public VideogameEntity() {
        orders = new ArrayList<OrderEntity>();
        platfrom = new ArrayList<PlatformEntity>();
    }

    @Id
    @GenericGenerator(name="inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Videogame_ID", nullable = false)
    public int getVideogameId() {
        return videogameId;
    }

    public void setVideogameId(int videogameId) {
        this.videogameId = videogameId;
    }

    @Basic
    @Column(name = "Develop_by", nullable = false, length = 64)
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Basic
    @Column(name = "Publisher", nullable = false, length = 64)
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "Genre", nullable = false, length = 64)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "Age_rating", nullable = false)
    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    @Basic
    @Column(name = "Date_release", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Videogame", nullable = false, length = 45)
    public String getVideogame() {
        return videogame;
    }

    public void setVideogame(String videogame) {
        this.videogame = videogame;
    }

    @Basic
    @Column(name = "Cost_of_purchase", nullable = false)
    public double getCostOfPurchase() {
        return costOfPurchase;
    }
    public void setCostOfPurchase(double costOfPurchase) {
        this.costOfPurchase = costOfPurchase;
    }

    @Basic
    @Column(name = "Price", nullable = false)
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideogameEntity that = (VideogameEntity) o;

        if (videogameId != that.videogameId) return false;
        if (ageRating != that.ageRating) return false;
        if (quantity != that.quantity) return false;
        if (developer != null ? !developer.equals(that.developer) : that.developer != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (videogame != null ? !videogame.equals(that.videogame) : that.videogame != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = videogameId;
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + ageRating;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (videogame != null ? videogame.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "videogames")
    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @ManyToMany(mappedBy = "videogames")
    public List<PlatformEntity> getPlatfrom() {
        return platfrom;
    }

    public void setPlatfrom(List<PlatformEntity> platfrom) {
        this.platfrom = platfrom;
    }
}
