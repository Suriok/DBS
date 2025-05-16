package Shop.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Znacka\"")
public class Znacka {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Znacka_id_gen")
    @SequenceGenerator(name = "Znacka_id_gen", sequenceName = "Znacka_id_znacka_seq", allocationSize = 1)
    @Column(name = "id_znacka", nullable = false)
    private Integer id;

    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @OneToMany(mappedBy = "idZnacka")
    private Set<Produkt> produkts = new LinkedHashSet<>();

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

    public Set<Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(Set<Produkt> produkts) {
        this.produkts = produkts;
    }

}