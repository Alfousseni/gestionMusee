/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author couly
 */
@Entity
@Table(name = "oeuvres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oeuvre.findAll", query = "SELECT o FROM Oeuvre o"),
    @NamedQuery(name = "Oeuvre.findById", query = "SELECT o FROM Oeuvre o WHERE o.id = :id"),
    @NamedQuery(name = "Oeuvre.findByNom", query = "SELECT o FROM Oeuvre o WHERE o.nom = :nom"),
    @NamedQuery(name = "Oeuvre.findByAnnee", query = "SELECT o FROM Oeuvre o WHERE o.annee = :annee"),
    @NamedQuery(name = "Oeuvre.findByPrixestime", query = "SELECT o FROM Oeuvre o WHERE o.prixestime = :prixestime")})
public class Oeuvre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Annee")
    private Integer annee;
    @Lob
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prix_estime")
    private float prixestime;
    @OneToMany(mappedBy = "iDOeuvre", fetch = FetchType.EAGER)
    private List<OeuvresExposition> oeuvresExpositionList;
    @JoinColumn(name = "ID_Artiste", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Artiste iDArtiste;
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User iDuser;

    public Oeuvre() {
    }

    public Oeuvre(Integer id) {
        this.id = id;
    }

    public Oeuvre(String nom, Integer annee, String description, float prixestime, Artiste iDArtiste, User iDuser) {
        this.nom = nom;
        this.annee = annee;
        this.description = description;
        this.prixestime = prixestime;
        this.iDArtiste = iDArtiste;
        this.iDuser = iDuser;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrixestime() {
        return prixestime;
    }

    public void setPrixestime(float prixestime) {
        this.prixestime = prixestime;
    }

    @XmlTransient
    public List<OeuvresExposition> getOeuvresExpositionList() {
        return oeuvresExpositionList;
    }

    public void setOeuvresExpositionList(List<OeuvresExposition> oeuvresExpositionList) {
        this.oeuvresExpositionList = oeuvresExpositionList;
    }

    public Artiste getIDArtiste() {
        return iDArtiste;
    }

    public void setIDArtiste(Artiste iDArtiste) {
        this.iDArtiste = iDArtiste;
    }

    public User getIDuser() {
        return iDuser;
    }

    public void setIDuser(User iDuser) {
        this.iDuser = iDuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oeuvre)) {
            return false;
        }
        Oeuvre other = (Oeuvre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
                return nom;

    }
    
}
