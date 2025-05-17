package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Produkt\"")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_znacka")
    private Znacka idZnacka;

    @Column(name = "\"Barva\"", length = 20)
    private String barva;

    @Column(name = "\"Popis\"", length = Integer.MAX_VALUE)
    private String popis;

    @Column(name = "\"Cena\"", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "\"URL\"")
    private String url;

    @ManyToMany
    @JoinTable(name = "Nalezi",
            joinColumns = @JoinColumn(name = "id_Produkt"),
            inverseJoinColumns = @JoinColumn(name = "id_Kategorie"))
    private Set<Kategorie> kategories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProdukt")
    private Set<Recenze> recenzes = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "Velikosti",
            joinColumns = @JoinColumn(name = "id_Produkt"),
            inverseJoinColumns = @JoinColumn(name = "id_NazevVelikosti"))
    private Set<NazevVelikosti> nazevVelikostis = new LinkedHashSet<>();


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

    public Znacka getIdZnacka() {
        return idZnacka;
    }

    public void setIdZnacka(Znacka idZnacka) {
        this.idZnacka = idZnacka;
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

    public Set<Kategorie> getKategories() {
        return kategories;
    }

    public void setKategories(Set<Kategorie> kategories) {
        this.kategories = kategories;
    }

    public Set<Recenze> getRecenzes() {
        return recenzes;
    }

    public void setRecenzes(Set<Recenze> recenzes) {
        this.recenzes = recenzes;
    }

    public Set<NazevVelikosti> getNazevVelikostis() {
        return nazevVelikostis;
    }

    public void setNazevVelikostis(Set<NazevVelikosti> nazevVelikostis) {
        this.nazevVelikostis = nazevVelikostis;
    }

}