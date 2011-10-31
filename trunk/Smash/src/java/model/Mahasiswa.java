/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "mahasiswa")
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswa.findByNrp", query = "SELECT m FROM Mahasiswa m WHERE m.nrp = :nrp"),
    @NamedQuery(name = "Mahasiswa.findByPassword", query = "SELECT m FROM Mahasiswa m WHERE m.password = :password")})
public class Mahasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "nama")
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(name = "nrp")
    private String nrp;
    @Column(name = "password")
    private String password;

    @Column(name = "loginStat")
    private Boolean loginStat;

    public void setLoginStat(Boolean loginstat) {
        this.loginStat = loginstat;
    }

    public Boolean getLoginStat() {
        return loginStat;
    }

    public Mahasiswa() {
    }

    public Mahasiswa(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrp != null ? nrp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.nrp == null && other.nrp != null) || (this.nrp != null && !this.nrp.equals(other.nrp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mahasiswa[nrp=" + nrp + "]";
    }

}
