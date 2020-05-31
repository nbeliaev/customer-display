package dev.fr13.customerdisplay.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {
    private static final int MAX_FILES_NUMBER = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "in_active")
    private boolean inActive;

    @JsonIgnore
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ad> ads = new ArrayList<>(MAX_FILES_NUMBER);

    public Shop() {
    }

    public Shop(long id, String name, boolean inActive) {
        this.id = id;
        this.name = name;
        this.inActive = inActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

    public List<Ad> getAds() {
        return Collections.unmodifiableList(ads);
    }

    public void addFile(Ad ad) {
        ads.add(ad);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inActive=" + inActive +
                ", ads=" + ads +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (id != shop.id) return false;
        if (inActive != shop.inActive) return false;
        return name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (inActive ? 1 : 0);
        return result;
    }
}
