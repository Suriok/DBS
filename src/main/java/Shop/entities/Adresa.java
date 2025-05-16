package Shop.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Adresa\"")
public class Adresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Adresa_id_gen")
    @SequenceGenerator(name = "Adresa_id_gen", sequenceName = "Adresa_id_adresa_seq", allocationSize = 1)
    @Column(name = "id_adresa", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_stat")
    private Shop.entities.Stat idStat;

    @Column(name = "\"PSC\"", nullable = false, length = 6)
    private String psc;

    @Column(name = "ulice", nullable = false, length = 30)
    private String ulice;

    @Column(name = "cislo_popisne", nullable = false)
    private Integer cisloPopisne;

    @Column(name = "mesto", nullable = false, length = 30)
    private String mesto;

    @ManyToMany
    @JoinTable(name = "AdresaObjednavky",
            joinColumns = @JoinColumn(name = "id_adresa"),
            inverseJoinColumns = @JoinColumn(name = "id_Objednavky"))
    private Set<Shop.entities.Objednavka> objednavkas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shop.entities.Stat getIdStat() {
        return idStat;
    }

    public void setIdStat(Shop.entities.Stat idStat) {
        this.idStat = idStat;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public Integer getCisloPopisne() {
        return cisloPopisne;
    }

    public void setCisloPopisne(Integer cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public Set<Shop.entities.Objednavka> getObjednavkas() {
        return objednavkas;
    }

    public void setObjednavkas(Set<Shop.entities.Objednavka> objednavkas) {
        this.objednavkas = objednavkas;
    }

}