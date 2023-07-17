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
@Table(name = "artistes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artiste.findAll", query = "SELECT a FROM Artiste a"),
    @NamedQuery(name = "Artiste.findById", query = "SELECT a FROM Artiste a WHERE a.id = :id"),
    @NamedQuery(name = "Artiste.findByNom", query = "SELECT a FROM Artiste a WHERE a.nom = :nom"),
    @NamedQuery(name = "Artiste.findByDatenaissance", query = "SELECT a FROM Artiste a WHERE a.datenaissance = :datenaissance"),
    @NamedQuery(name = "Artiste.findByNationalite", query = "SELECT a FROM Artiste a WHERE a.nationalite = :nationalite"),
    @NamedQuery(name = "Artiste.findByEmail", query = "SELECT a FROM Artiste a WHERE a.email = :email")})

public class Artiste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "email")
    private String email;
    @Column(name = "Date_naissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @Column(name = "Nationalite")
    private String nationalite;
    @Lob
    @Column(name = "Biographie")
    private String biographie;
    @OneToMany(mappedBy = "iDArtiste", fetch = FetchType.EAGER)
    private List<Oeuvre> oeuvreList;
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User iDuser;

    public Artiste() {
    }

    public Artiste(String nom, Date datenaissance, String nationalite, String biographie, User iDuser) {
        this.nom = nom;
        this.datenaissance = datenaissance;
        this.nationalite = nationalite;
        this.biographie = biographie;
        this.iDuser = iDuser;
    }

    public Artiste(String nom, String email, Date datenaissance, String nationalite, String biographie, User iDuser) {
        this.nom = nom;
        this.email = email;
        this.datenaissance = datenaissance;
        this.nationalite = nationalite;
        this.biographie = biographie;
        this.iDuser = iDuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getiDuser() {
        return iDuser;
    }

    public void setiDuser(User iDuser) {
        this.iDuser = iDuser;
    }
    
    
    
    

    public Artiste(Integer id) {
        this.id = id;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    @XmlTransient
    public List<Oeuvre> getOeuvreList() {
        return oeuvreList;
    }

    public void setOeuvreList(List<Oeuvre> oeuvreList) {
        this.oeuvreList = oeuvreList;
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
        if (!(object instanceof Artiste)) {
            return false;
        }
        Artiste other = (Artiste) object;
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
