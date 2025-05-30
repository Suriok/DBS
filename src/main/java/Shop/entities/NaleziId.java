package Shop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class NaleziId implements java.io.Serializable {
    private static final long serialVersionUID = 4341352781858671171L;
    @Column(name = "\"id_Produkt\"", nullable = false)
    private Integer idProdukt;

    @Column(name = "\"id_Kategorie\"", nullable = false)
    private Integer idKategorie;

    public Integer getIdProdukt() {
        return idProdukt;
    }

    public void setIdProdukt(Integer idProdukt) {
        this.idProdukt = idProdukt;
    }

    public Integer getIdKategorie() {
        return idKategorie;
    }

    public void setIdKategorie(Integer idKategorie) {
        this.idKategorie = idKategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NaleziId entity = (NaleziId) o;
        return Objects.equals(this.idProdukt, entity.idProdukt) &&
                Objects.equals(this.idKategorie, entity.idKategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdukt, idKategorie);
    }

}