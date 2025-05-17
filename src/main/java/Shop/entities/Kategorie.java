package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Kategorie\"")
public class Kategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Kategorie_id_gen")
    @SequenceGenerator(name = "Kategorie_id_gen", sequenceName = "Kategorie_id_Kategorie_seq", allocationSize = 1)
    @Column(name = "\"id_Kategorie\"", nullable = false)
    private Integer id;

    @Column(name = "\"Nazev\"", nullable = false, length = 64)
    private String nazev;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "\"id_Uzivatel\"")
    private Administrator idUzivatel;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "id_nadkategorii")
    private Kategorie idNadkategorii;

    @OneToMany(mappedBy = "idNadkategorii")
    private Set<Kategorie> kategories = new LinkedHashSet<>();

//    @ManyToMany
//    private Set<Shop.entities.Produkt> produkts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Administrator getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(Administrator idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    public Kategorie getIdNadkategorii() {
        return idNadkategorii;
    }

    public void setIdNadkategorii(Kategorie idNadkategorii) {
        this.idNadkategorii = idNadkategorii;
    }

    public Set<Kategorie> getKategories() {
        return kategories;
    }

    public void setKategories(Set<Kategorie> kategories) {
        this.kategories = kategories;
    }

//    public Set<Shop.entities.Produkt> getProdukts() {
//        return produkts;
//    }

//    public void setProdukts(Set<Shop.entities.Produkt> produkts) {
//        this.produkts = produkts;
//    }

}