package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "\"Objednavka\"")
public class Objednavka {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Objednavka_id_gen")
    @SequenceGenerator(name = "Objednavka_id_gen", sequenceName = "Objednavka_id_Objednavky_seq", allocationSize = 1)
    @Column(name = "\"id_Objednavky\"", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"id_Uzivatel\"", nullable = false)
    private Shop.entities.Zakaznik idUzivatel;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "cas_vytvoreni", nullable = false)
    private Instant casVytvoreni;

    @Column(name = "celkova_cena", nullable = false, precision = 10, scale = 2)
    private BigDecimal celkovaCena;

    @Column(name = "stav_objednavky", nullable = false, length = 10)
    private String stavObjednavky;

    @Column(name = "stav_platby", nullable = false, length = 12)
    private String stavPlatby;

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

    public BigDecimal getCelkovaCena() {
        return celkovaCena;
    }

    public void setCelkovaCena(BigDecimal celkovaCena) {
        this.celkovaCena = celkovaCena;
    }

    public String getStavObjednavky() {
        return stavObjednavky;
    }

    public void setStavObjednavky(String stavObjednavky) {
        this.stavObjednavky = stavObjednavky;
    }

    public String getStavPlatby() {
        return stavPlatby;
    }

    public void setStavPlatby(String stavPlatby) {
        this.stavPlatby = stavPlatby;
    }

}