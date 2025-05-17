package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Administrator\"")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Administrator_id_gen")
    @SequenceGenerator(name = "Administrator_id_gen", allocationSize = 1)
    @Column(name = "\"id_Uzivatel\"", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"id_Uzivatel\"", nullable = false)
    private Shop.entities.Uzivatel uzivatel;

    @Column(name = "interni_telefon", nullable = false, length = 13)
    private String interniTelefon;

    @OneToMany(mappedBy = "idUzivatel")
    private Set<Shop.entities.Kategorie> kategories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUzivatel")
    private Set<Shop.entities.Produkt> produkts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shop.entities.Uzivatel getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(Shop.entities.Uzivatel uzivatel) {
        this.uzivatel = uzivatel;
    }

    public String getInterniTelefon() {
        return interniTelefon;
    }

    public void setInterniTelefon(String interniTelefon) {
        this.interniTelefon = interniTelefon;
    }

    public Set<Shop.entities.Kategorie> getKategories() {
        return kategories;
    }

    public void setKategories(Set<Shop.entities.Kategorie> kategories) {
        this.kategories = kategories;
    }

    public Set<Shop.entities.Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(Set<Shop.entities.Produkt> produkts) {
        this.produkts = produkts;
    }

}