package Shop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Stat\"")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Stat_id_gen")
    @SequenceGenerator(name = "Stat_id_gen", allocationSize = 1)
    @Column(name = "id_stat", nullable = false)
    private Integer id;

    @Column(name = "nazev", nullable = false, length = 100)
    private String nazev;

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

}