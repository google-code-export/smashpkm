/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "beasiswa")
@NamedQueries({
    @NamedQuery(name = "Beasiswa.findAll", query = "SELECT b FROM Beasiswa b")})
public class Beasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDBEASISWA", nullable = false, length = 767)
    private String idbeasiswa;
    @Column(name = "NAMABEASISWA", length = 767)
    private String namabeasiswa;
    @Column(name = "KETERANGAN", length = 767)
    private String keterangan;
    @Column(name = "TANGGALPUBLISH")
    @Temporal(TemporalType.DATE)
    private Date tanggalpublish;
    @Column(name = "TANGGALKADALUARSA")
    @Temporal(TemporalType.DATE)
    private Date tanggalkadaluarsa;
    @Column(name = "TANGGALMULAI")
    @Temporal(TemporalType.DATE)
    private Date tanggalmulai;
    @Column(name = "TANGGALHABIS")
    @Temporal(TemporalType.DATE)
    private Date tanggalhabis;
    @OneToMany(mappedBy = "idbeasiswa")
    private Set<Pengajuan> pengajuanCollection;

    public Beasiswa() {
    }

    public Beasiswa(String idbeasiswa) {
        this.idbeasiswa = idbeasiswa;
    }

    public String getIdbeasiswa() {
        return idbeasiswa;
    }

    public void setIdbeasiswa(String idbeasiswa) {
        this.idbeasiswa = idbeasiswa;
    }

    public String getNamabeasiswa() {
        return namabeasiswa;
    }

    public void setNamabeasiswa(String namabeasiswa) {
        this.namabeasiswa = namabeasiswa;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggalpublish() {
        return tanggalpublish;
    }

    public void setTanggalpublish(Date tanggalpublish) {
        this.tanggalpublish = tanggalpublish;
    }

    public Date getTanggalkadaluarsa() {
        return tanggalkadaluarsa;
    }

    public void setTanggalkadaluarsa(Date tanggalkadaluarsa) {
        this.tanggalkadaluarsa = tanggalkadaluarsa;
    }

    public Date getTanggalmulai() {
        return tanggalmulai;
    }

    public void setTanggalmulai(Date tanggalmulai) {
        this.tanggalmulai = tanggalmulai;
    }

    public Date getTanggalhabis() {
        return tanggalhabis;
    }

    public void setTanggalhabis(Date tanggalhabis) {
        this.tanggalhabis = tanggalhabis;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbeasiswa != null ? idbeasiswa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beasiswa)) {
            return false;
        }
        Beasiswa other = (Beasiswa) object;
        if ((this.idbeasiswa == null && other.idbeasiswa != null) || (this.idbeasiswa != null && !this.idbeasiswa.equals(other.idbeasiswa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Beasiswa[idbeasiswa=" + idbeasiswa + "]";
    }

}
