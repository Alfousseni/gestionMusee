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
@Table(name = "visiteurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visiteur.findAll", query = "SELECT v FROM Visiteur v"),
    @NamedQuery(name = "Visiteur.findById", query = "SELECT v FROM Visiteur v WHERE v.id = :id"),
    @NamedQuery(name = "Visiteur.findByNom", query = "SELECT v FROM Visiteur v WHERE v.nom = :nom"),
    @NamedQuery(name = "Visiteur.findByPrenom", query = "SELECT v FROM Visiteur v WHERE v.prenom = :prenom"),
    @NamedQuery(name = "Visiteur.findByEmail", query = "SELECT v FROM Visiteur v WHERE v.email = :email"),
    @NamedQuery(name = "Visiteur.findByDatenaissance", query = "SELECT v FROM Visiteur v WHERE v.datenaissance = :datenaissance")})
public class Visiteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "Email")
    private String email;
    @Column(name = "Date_naissance")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @OneToMany(mappedBy = "iDVisiteur", fetch = FetchType.EAGER)
    private List<Billet> billetList;
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User iDuser;

    public Visiteur() {
    }

    public Visiteur(Integer id) {
        this.id = id;
    }

    public Visiteur(String nom, String prenom, String email, Date datenaissance, User iDuser) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datenaissance = datenaissance;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
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
        if (!(object instanceof Visiteur)) {
            return false;
        }
        Visiteur other = (Visiteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return nom +" "+prenom;

    }
    
}
