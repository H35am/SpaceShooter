/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 0775768 <Hesam.Zarza>
 */
@Entity
@Table(name = "astroids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Astroids.findAll", query = "SELECT a FROM Astroids a"),
    @NamedQuery(name = "Astroids.findByMass", query = "SELECT a FROM Astroids a WHERE a.mass = :mass"),
    @NamedQuery(name = "Astroids.findByVelocity", query = "SELECT a FROM Astroids a WHERE a.velocity = :velocity"),
    @NamedQuery(name = "Astroids.findByIdAstroid", query = "SELECT a FROM Astroids a WHERE a.idAstroid = :idAstroid")})
public class Astroids implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "mass")
    private String mass;
    @Column(name = "velocity")
    private String velocity;
    @Id
    @Basic(optional = false)
    @Column(name = "id_astroid")
    private String idAstroid;

    public Astroids() {
    }

    public Astroids(String idAstroid, String mass, String velocity) {
        this.idAstroid = idAstroid;
        this.mass = mass;
        this.velocity = velocity;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getIdAstroid() {
        return idAstroid;
    }

    public void setIdAstroid(String idAstroid) {
        this.idAstroid = idAstroid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAstroid != null ? idAstroid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Astroids)) {
            return false;
        }
        Astroids other = (Astroids) object;
        if ((this.idAstroid == null && other.idAstroid != null) || (this.idAstroid != null && !this.idAstroid.equals(other.idAstroid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spaceshooter.Astroids[ idAstroid=" + idAstroid + " ]";
    }
    
}
