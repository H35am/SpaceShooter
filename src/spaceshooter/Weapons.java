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
@Table(name = "weapons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weapons.findAll", query = "SELECT w FROM Weapons w"),
    @NamedQuery(name = "Weapons.findByWeaponName", query = "SELECT w FROM Weapons w WHERE w.weaponName = :weaponName"),
    @NamedQuery(name = "Weapons.findByDamage", query = "SELECT w FROM Weapons w WHERE w.damage = :damage")})
public class Weapons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "weapon_name")
    private String weaponName;
    @Column(name = "damage")
    private Integer damage;
    @OneToMany(mappedBy = "weaponsWeaponName")
    private Collection<Mounts> mountsCollection;

    public Weapons() {
    }

    public Weapons(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
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
        hash += (weaponName != null ? weaponName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weapons)) {
            return false;
        }
        Weapons other = (Weapons) object;
        if ((this.weaponName == null && other.weaponName != null) || (this.weaponName != null && !this.weaponName.equals(other.weaponName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spaceshooter.Weapons[ weaponName=" + weaponName + " ]";
    }
    
}
