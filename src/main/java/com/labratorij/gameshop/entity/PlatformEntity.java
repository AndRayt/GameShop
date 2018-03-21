package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "platforms", schema = "gameshop_new", catalog = "")
public class PlatformEntity implements Serializable {
    private int platformId;
    private String producer;
    private int relevance;
    private String platformcol;
    private String platform;
    private List<VideogameEntity> videogames;

    public PlatformEntity() {
        videogames = new ArrayList<VideogameEntity>();
    }

    @Id
    @GenericGenerator(name="inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Platform_ID", nullable = false)
    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "Producer", nullable = false, length = 64)
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Basic
    @Column(name = "Relevance", nullable = false)
    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    @Basic
    @Column(name = "Platformcol", nullable = false, length = 45)
    public String getPlatformcol() {
        return platformcol;
    }

    public void setPlatformcol(String platformcol) {
        this.platformcol = platformcol;
    }

    @Basic
    @Column(name = "Platform", nullable = false, length = 45)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformEntity that = (PlatformEntity) o;

        if (platformId != that.platformId) return false;
        if (relevance != that.relevance) return false;
        if (producer != null ? !producer.equals(that.producer) : that.producer != null) return false;
        if (platformcol != null ? !platformcol.equals(that.platformcol) : that.platformcol != null) return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = platformId;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + relevance;
        result = 31 * result + (platformcol != null ? platformcol.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        return result;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "platform_has_videogame", joinColumns = @JoinColumn(name = "Platform_Platform_ID", referencedColumnName = "Platform_ID"), inverseJoinColumns = @JoinColumn(name = "Videogame_Videogame_ID", referencedColumnName = "Videogame_ID"))
    public List<VideogameEntity> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<VideogameEntity> platforms) {
        this.videogames = platforms;
    }

    public void addVideogame(VideogameEntity videogame){
        videogames.add(videogame);
        videogame.getPlatfrom().add(this);
    }
}
