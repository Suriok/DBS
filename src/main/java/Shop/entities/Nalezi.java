package Shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "\"Nalezi\"")
public class Nalezi {
    @EmbeddedId
    private NaleziId id;

    @MapsId("idProdukt")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"id_Produkt\"", nullable = false)
    private Produkt idProdukt;

    @MapsId("idKategorie")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "\"id_Kategorie\"", nullable = false)
    private Kategorie idKategorie;

    public NaleziId getId() {
        return id;
    }

    public void setId(NaleziId id) {
        this.id = id;
    }

    public Produkt getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(Produkt idProdukt) {
        this.idProdukt = idProdukt;
    }

    public Kategorie getIdKategorie() {
        return idKategorie;
    }

    public void setIdKategorie(Kategorie idKategorie) {
        this.idKategorie = idKategorie;
    }

}