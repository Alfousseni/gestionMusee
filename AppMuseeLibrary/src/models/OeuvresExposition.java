/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author couly
 */
@Entity
@Table(name = "oeuvres_expositions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OeuvresExposition.findAll", query = "SELECT o FROM OeuvresExposition o"),
    @NamedQuery(name = "OeuvresExposition.findById", query = "SELECT o FROM OeuvresExposition o WHERE o.id = :id")})
public class OeuvresExposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_Oeuvre", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Oeuvre iDOeuvre;
    @JoinColumn(name = "ID_Exposition", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Exposition iDExposition;

    public OeuvresExposition() {
    }

    public OeuvresExposition(Integer id) {
        this.id = id;
    }

    public OeuvresExposition(Oeuvre iDOeuvre, Exposition iDExposition) {
        this.iDOeuvre = iDOeuvre;
        this.iDExposition = iDExposition;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Oeuvre getIDOeuvre() {
        return iDOeuvre;
    }

    public void setIDOeuvre(Oeuvre iDOeuvre) {
        this.iDOeuvre = iDOeuvre;
    }

    public Exposition getIDExposition() {
        return iDExposition;
    }

    public void setIDExposition(Exposition iDExposition) {
        this.iDExposition = iDExposition;
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
        if (!(object instanceof OeuvresExposition)) {
            return false;
        }
        OeuvresExposition other = (OeuvresExposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OeuvresExposition[ id=" + id + " ]";
    }
    
}
