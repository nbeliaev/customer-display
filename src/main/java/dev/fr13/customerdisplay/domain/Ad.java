package dev.fr13.customerdisplay.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "shop_ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ad")
    private String ad;

    @JsonInclude
    @Transient
    private long shopId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Ad() {
    }

    public Ad(long id, String ad, Shop shop) {
        this.id = id;
        this.ad = ad;
        this.shop = shop;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad1 = (Ad) o;

        if (id != ad1.id) return false;
        if (!ad.equals(ad1.ad)) return false;
        return shop.equals(ad1.shop);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + ad.hashCode();
        result = 31 * result + shop.hashCode();
        return result;
    }
}
