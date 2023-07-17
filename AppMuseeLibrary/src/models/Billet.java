/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author couly
 */
@Entity
@Table(name = "billets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billet.findAll", query = "SELECT b FROM Billet b"),
    @NamedQuery(name = "Billet.findById", query = "SELECT b FROM Billet b WHERE b.id = :id"),
    @NamedQuery(name = "Billet.findByDateachat", query = "SELECT b FROM Billet b WHERE b.dateachat = :dateachat"),
    @NamedQuery(name = "Billet.findByTypebillet", query = "SELECT b FROM Billet b WHERE b.typebillet = :typebillet")})
public class Billet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Date_achat")
    @Temporal(TemporalType.DATE)
    private Date dateachat;
    @Column(name = "Type_billet")
    private String typebillet;
    @JoinColumn(name = "ID_Visiteur", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Visiteur iDVisiteur;
    @JoinColumn(name = "ID_Exposition", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Exposition iDExposition;
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User iDuser;

    public Billet() {
    }

    public Billet(Integer id) {
        this.id = id;
    }

    public Billet(Date dateachat, String typebillet, Visiteur iDVisiteur, Exposition iDExposition, User iDuser) {
        this.dateachat = dateachat;
        this.typebillet = typebillet;
        this.iDVisiteur = iDVisiteur;
        this.iDExposition = iDExposition;
        this.iDuser = iDuser;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateachat() {
        return dateachat;
    }

    public void setDateachat(Date dateachat) {
        this.dateachat = dateachat;
    }

    public String getTypebillet() {
        return typebillet;
    }

    public void setTypebillet(String typebillet) {
        this.typebillet = typebillet;
    }

    public Visiteur getIDVisiteur() {
        return iDVisiteur;
    }

    public void setIDVisiteur(Visiteur iDVisiteur) {
        this.iDVisiteur = iDVisiteur;
    }

    public Exposition getIDExposition() {
        return iDExposition;
    }

    public void setIDExposition(Exposition iDExposition) {
        this.iDExposition = iDExposition;
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
        if (!(object instanceof Billet)) {
            return false;
        }
        Billet other = (Billet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Billet[ id=" + id + " ]";
    }
    
}
