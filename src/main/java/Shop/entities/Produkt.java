package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "\"Produkt\"")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produkt_id_gen")
    @SequenceGenerator(name = "Produkt_id_gen", sequenceName = "Produkt_id_Produkt_seq", allocationSize = 1)
    @Column(name = "\"id_Produkt\"", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "\"id_Uzivatel\"")
    private Administrator idUzivatel;

    @Column(name = "artikul", nullable = false, length = 20)
    private String artikul;

    @Column(name = "\"Nazev\"", nullable = false, length = 64)
    private String nazev;

    @Column(name = "\"Barva\"", length = 20)
    private String barva;

    @Column(name = "\"Popis\"", length = Integer.MAX_VALUE)
    private String popis;

    @Column(name = "\"Cena\"", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "\"URL\"")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Administrator getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(Administrator idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    public String getArtikul() {
        return artikul;
    }

    public void setArtikul(String artikul) {
        this.artikul = artikul;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}