package Shop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Uzivatel\"")
public class Uzivatel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Uzivatel_id_gen")
    @SequenceGenerator(name = "Uzivatel_id_gen", sequenceName = "Uzivatel_id_Uzivatel_seq", allocationSize = 1)
    @Column(name = "\"id_Uzivatel\"", nullable = false)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "jmeno", nullable = false, length = 64)
    private String jmeno;

    @Column(name = "prijmeni", nullable = false, length = 64)
    private String prijmeni;

    @Column(name = "telefon", columnDefinition = "bpchar(13)", nullable = false)
    private String telefon;

    @Column(name = "heslo", nullable = false)
    private String heslo;

    @OneToOne(mappedBy = "uzivatel")
    private Administrator administrator;

    @OneToOne(mappedBy = "uzivatel")
    private Shop.entities.Zakaznik zakaznik;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Shop.entities.Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Shop.entities.Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

}