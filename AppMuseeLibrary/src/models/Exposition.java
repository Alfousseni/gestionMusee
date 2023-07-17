/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author couly
 */
@Entity
@Table(name = "expositions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exposition.findAll", query = "SELECT e FROM Exposition e"),
    @NamedQuery(name = "Exposition.expoDispo", query = "SELECT e FROM Exposition e WHERE e.datefin > :currentDate"),
    @NamedQuery(name = "Exposition.expoPrice", query = "SELECT e FROM Exposition e WHERE e.datefin < :currentDate"),
    @NamedQuery(name = "Exposition.findById", query = "SELECT e FROM Exposition e WHERE e.id = :id"),
    @NamedQuery(name = "Exposition.findByNom", query = "SELECT e FROM Exposition e WHERE e.nom = :nom"),
    @NamedQuery(name = "Exposition.findByDatedebut", query = "SELECT e FROM Exposition e WHERE e.datedebut = :datedebut"),
    @NamedQuery(name = "Exposition.findByDatefin", query = "SELECT e FROM Exposition e WHERE e.datefin = :datefin")})
public class Exposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "heurDebut")
    private String heurDebut;
    
    @Column(name = "heurFin")
    private String heurFin;
    @Column(name = "Date_debut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "Date_fin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Lob
    @Column(name = "Description")
    private String description;
    
    @Column(name = "prix_vip")
    private float prix_vip;
    
    @Column(name = "prix_classique")
    private float prix_clssique;
    
    @OneToMany(mappedBy = "iDExposition", fetch = FetchType.EAGER)
    private List<OeuvresExposition> oeuvresExpositionList;
    @OneToMany(mappedBy = "iDExposition", fetch = FetchType.EAGER)
    private List<Billet> billetList;
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User iDuser;

    public Exposition() {
    }

    public Exposition(Integer id) {
        this.id = id;
    }

    public Exposition(String nom, Date datedebut, Date datefin, String description, User iDuser) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
        this.iDuser = iDuser;
    }

    public Exposition(String nom, String heurDebut, String heurFin, Date datedebut, Date datefin, String description, float prix_vip, float prix_clssique, User iDuser) {
        this.nom = nom;
        this.heurDebut = heurDebut;
        this.heurFin = heurFin;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
        this.prix_vip = prix_vip;
        this.prix_clssique = prix_clssique;
        this.iDuser = iDuser;
    }
    

    public Exposition(String nom, Date datedebut, Date datefin, String description, float prix_vip, float prix_clssique, User iDuser) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.description = description;
        this.prix_vip = prix_vip;
        this.prix_clssique = prix_clssique;
        this.iDuser = iDuser;
    }

    public String getHeurDebut() {
        return heurDebut;
    }

    public void setHeurDebut(String heurDebut) {
        this.heurDebut = heurDebut;
    }

    public String getHeurFin() {
        return heurFin;
    }

    public void setHeurFin(String heurFin) {
        this.heurFin = heurFin;
    }

    public User getiDuser() {
        return iDuser;
    }

    public void setiDuser(User iDuser) {
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

    public float getPrix_vip() {
        return prix_vip;
    }

    public void setPrix_vip(float prix_vip) {
        this.prix_vip = prix_vip;
    }

    public float getPrix_clssique() {
        return prix_clssique;
    }

    public void setPrix_clssique(float prix_clssique) {
        this.prix_clssique = prix_clssique;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<OeuvresExposition> getOeuvresExpositionList() {
        return oeuvresExpositionList;
    }

    public void setOeuvresExpositionList(List<OeuvresExposition> oeuvresExpositionList) {
        this.oeuvresExpositionList = oeuvresExpositionList;
    }

    @XmlTransient
    public List<Billet> getBilletList() {
        return billetList;
    }

    public void setBilletList(List<Billet> billetList) {
        this.billetList = billetList;
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
        if (!(object instanceof Exposition)) {
            return false;
        }
        Exposition other = (Exposition) object;
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
