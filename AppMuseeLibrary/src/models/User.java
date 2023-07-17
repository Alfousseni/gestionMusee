/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role"),
    @NamedQuery(name = "User.findByEtat", query = "SELECT u FROM User u WHERE u.etat = :etat")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "Role")
    private String role;
    @Basic(optional = false)
    @Column(name = "etat")
    private String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuser", fetch = FetchType.EAGER)
    private List<Billet> billetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuser", fetch = FetchType.EAGER)
    private List<Oeuvre> oeuvreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuser", fetch = FetchType.EAGER)
    private List<Artiste> artisteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuser", fetch = FetchType.EAGER)
    private List<Visiteur> visiteurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuser", fetch = FetchType.EAGER)
    private List<Exposition> expositionList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
     public User(String username, String password, String email, String role, String etat) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.etat = etat;
    }

    public User(Integer id, String etat) {
        this.id = id;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Billet> getBilletList() {
        return billetList;
    }

    public void setBilletList(List<Billet> billetList) {
        this.billetList = billetList;
    }

    @XmlTransient
    public List<Oeuvre> getOeuvreList() {
        return oeuvreList;
    }

    public void setOeuvreList(List<Oeuvre> oeuvreList) {
        this.oeuvreList = oeuvreList;
    }

    @XmlTransient
    public List<Artiste> getArtisteList() {
        return artisteList;
    }

    public void setArtisteList(List<Artiste> artisteList) {
        this.artisteList = artisteList;
    }

    @XmlTransient
    public List<Visiteur> getVisiteurList() {
        return visiteurList;
    }

    public void setVisiteurList(List<Visiteur> visiteurList) {
        this.visiteurList = visiteurList;
    }

    @XmlTransient
    public List<Exposition> getExpositionList() {
        return expositionList;
    }

    public void setExpositionList(List<Exposition> expositionList) {
        this.expositionList = expositionList;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
                return username;

    }
    
}
