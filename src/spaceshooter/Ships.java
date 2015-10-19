/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 0775768 <Hesam.Zarza>
 */
@Entity
@Table(name = "ships")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ships.findAll", query = "SELECT s FROM Ships s"),
    @NamedQuery(name = "Ships.findByShield", query = "SELECT s FROM Ships s WHERE s.shield = :shield"),
    @NamedQuery(name = "Ships.findByArmor", query = "SELECT s FROM Ships s WHERE s.armor = :armor"),
    @NamedQuery(name = "Ships.findByName", query = "SELECT s FROM Ships s WHERE s.name = :name"),
    @NamedQuery(name = "Ships.findBySerial", query = "SELECT s FROM Ships s WHERE s.serial = :serial")})
public class Ships implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "shield")
    private String shield;
    @Column(name = "armor")
    private String armor;
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    @OneToMany(mappedBy = "shipsSerial")
    private Collection<Mounts> mountsCollection;

    public Ships() {
    }

    public Ships(String serial) {
        this.serial = serial;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @XmlTransient
    public Collection<Mounts> getMountsCollection() {
        return mountsCollection;
    }

    public void setMountsCollection(Collection<Mounts> mountsCollection) {
        this.mountsCollection = mountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ships)) {
            return false;
        }
        Ships other = (Ships) object;
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spaceshooter.Ships[ serial=" + serial + " ]";
    }
    
}
