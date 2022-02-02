package com.mycompany.animals;

import javax.persistence.*;

@Entity
@Table(name ="animals")
public class Animal {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

   @Column(nullable = false, length = 30,name = "tur")
    private String tur;

   @Column(nullable = false, length = 45, name = "cins")
    private String cins;

    @Column(nullable = false, length = 45,name = "isim")
    private String isim;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                ", isim='" + isim + '\'' +
                ", yas=" + yas +
                ", aciklama='" + aciklama + '\'' +
                ", sahipAd='" + sahipAd + '\'' +
                '}';
    }

    @Column(length = 3)
    private Integer yas;

    @Column(length = 100,name = "aciklama")
    private String aciklama;

    @Column( length = 30,name = "sahipAdi")
    private String sahipAd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getCins() {
        return cins;
    }

    public void setCins(String cins) {
        this.cins = cins;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getSahipAd() {
        return sahipAd;
    }

    public void setSahipAd(String sahipAd) {
        this.sahipAd = sahipAd;
    }
}
