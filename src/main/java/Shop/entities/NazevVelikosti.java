package Shop.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"NazevVelikosti\"")
public class NazevVelikosti {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NazevVelikosti_id_gen")
    @SequenceGenerator(name = "NazevVelikosti_id_gen", sequenceName = "NazevVelikosti_id_NazevVelikosti_seq", allocationSize = 1)
    @Column(name = "\"id_NazevVelikosti\"", nullable = false)
    private Integer id;

    @Column(name = "\"NazevVelikosti\"", nullable = false, length = 3)
    private String nazevVelikosti;

    @ManyToMany
    @JoinTable(name = "Velikosti",
            joinColumns = @JoinColumn(name = "id_NazevVelikosti"),
            inverseJoinColumns = @JoinColumn(name = "id_Produkt"))
    private Set<Shop.entities.Produkt> produkts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazevVelikosti() {
        return nazevVelikosti;
    }

    public void setNazevVelikosti(String nazevVelikosti) {
        this.nazevVelikosti = nazevVelikosti;
    }

    public Set<Shop.entities.Produkt> getProdukts() {
        return produkts;
    }

    public void setProdukts(Set<Shop.entities.Produkt> produkts) {
        this.produkts = produkts;
    }

}