package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Zakaznik\"")
public class Zakaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Zakaznik_id_gen")
    @SequenceGenerator(name = "Zakaznik_id_gen", sequenceName = "Uzivatel_id_Uzivatel_seq", allocationSize = 1)
    @Column(name = "\"id_Uzivatel\"", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"id_Uzivatel\"", nullable = false)
    private Uzivatel uzivatel;

    @OneToMany(mappedBy = "idUzivatel")
    private Set<Objednavka> objednavkas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idUzivatel")
    private Set<Recenze> recenzes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzivatel getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(Uzivatel uzivatel) {
        this.uzivatel = uzivatel;
    }

    public Set<Objednavka> getObjednavkas() {
        return objednavkas;
    }

    public void setObjednavkas(Set<Objednavka> objednavkas) {
        this.objednavkas = objednavkas;
    }

    public Set<Recenze> getRecenzes() {
        return recenzes;
    }

    public void setRecenzes(Set<Recenze> recenzes) {
        this.recenzes = recenzes;
    }

/*
 TODO [Reverse Engineering] create field to map the 'pohlavi' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "pohlavi", columnDefinition = "bit not null")
    private Object pohlavi;
*/
}