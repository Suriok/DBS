package Shop.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Stat\"")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Stat_id_gen")
    @SequenceGenerator(name = "Stat_id_gen", sequenceName = "Stat_id_stat_seq", allocationSize = 1)
    @Column(name = "id_stat", nullable = false)
    private Integer id;

    @Column(name = "nazev", nullable = false, length = 100)
    private String nazev;

    @OneToMany(mappedBy = "idStat")
    private Set<Adresa> adresas = new LinkedHashSet<>();

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

    public Set<Adresa> getAdresas() {
        return adresas;
    }

    public void setAdresas(Set<Adresa> adresas) {
        this.adresas = adresas;
    }

}