package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "\"Recenze\"")
public class Recenze {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Recenze_id_gen")
    @SequenceGenerator(name = "Recenze_id_gen", sequenceName = "Recenze_id_recenze_seq", allocationSize = 1)
    @Column(name = "id_recenze", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"id_Uzivatel\"", nullable = false)
    private Shop.entities.Zakaznik idUzivatel;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "\"casVytvoreni\"", nullable = false)
    private Instant casVytvoreni;

    @Column(name = "hodnoceni", nullable = false)
    private Integer hodnoceni;

    @Column(name = "komentar", length = Integer.MAX_VALUE)
    private String komentar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shop.entities.Zakaznik getIdUzivatel() {
        return idUzivatel;
    }

    public void setIdUzivatel(Shop.entities.Zakaznik idUzivatel) {
        this.idUzivatel = idUzivatel;
    }

    public Instant getCasVytvoreni() {
        return casVytvoreni;
    }

    public void setCasVytvoreni(Instant casVytvoreni) {
        this.casVytvoreni = casVytvoreni;
    }

    public Integer getHodnoceni() {
        return hodnoceni;
    }

    public void setHodnoceni(Integer hodnoceni) {
        this.hodnoceni = hodnoceni;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

}