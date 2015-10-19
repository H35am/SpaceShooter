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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 0775768 <Hesam.Zarza>
 */
@Entity
@Table(name = "mounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mounts.findAll", query = "SELECT m FROM Mounts m"),
    @NamedQuery(name = "Mounts.findByIdMount", query = "SELECT m FROM Mounts m WHERE m.idMount = :idMount")})
public class Mounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mount")
    private Integer idMount;
    @JoinColumn(name = "ships_serial", referencedColumnName = "serial")
    @ManyToOne
    private Ships shipsSerial;
    @JoinColumn(name = "weapons_weapon_name", referencedColumnName = "weapon_name")
    @ManyToOne
    private Weapons weaponsWeaponName;

    public Mounts() {
    }

    public Mounts(Integer idMount) {
        this.idMount = idMount;
    }

    public Integer getIdMount() {
        return idMount;
    }

    public void setIdMount(Integer idMount) {
        this.idMount = idMount;
    }

    public Ships getShipsSerial() {
        return shipsSerial;
    }

    public void setShipsSerial(Ships shipsSerial) {
        this.shipsSerial = shipsSerial;
    }

    public Weapons getWeaponsWeaponName() {
        return weaponsWeaponName;
    }

    public void setWeaponsWeaponName(Weapons weaponsWeaponName) {
        this.weaponsWeaponName = weaponsWeaponName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMount != null ? idMount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mounts)) {
            return false;
        }
        Mounts other = (Mounts) object;
        if ((this.idMount == null && other.idMount != null) || (this.idMount != null && !this.idMount.equals(other.idMount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spaceshooter.Mounts[ idMount=" + idMount + " ]";
    }
    
}
