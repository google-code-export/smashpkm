/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "beasiswa", catalog = "Smash", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"IDBEASISWA"})})
@NamedQueries({
    @NamedQuery(name = "Beasiswa.findAll", query = "SELECT b FROM Beasiswa b"),
    @NamedQuery(name = "Beasiswa.findByIdbeasiswa", query = "SELECT b FROM Beasiswa b WHERE b.idbeasiswa = :idbeasiswa"),
    @NamedQuery(name = "Beasiswa.findByNamabeasiswa", query = "SELECT b FROM Beasiswa b WHERE b.namabeasiswa = :namabeasiswa")})
public class Beasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "IDBEASISWA", nullable = false, length = 1000)
    private String idbeasiswa;
    @Column(name = "NAMABEASISWA", length = 1000)
    private String namabeasiswa;
    private String keterangan;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalpublish;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalkadaluwarsa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalmulai;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalhabis;
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setTanggalhabis(Date tanggalhabis) {
        this.tanggalhabis = tanggalhabis;
    }

    public void setTanggalkadaluwarsa(Date tanggalkadaluwarsa) {
        this.tanggalkadaluwarsa = tanggalkadaluwarsa;
    }

    public void setTanggalmulai(Date tanggalmulai) {
        this.tanggalmulai = tanggalmulai;
    }

    public void setTanggalpublish(Date tanggalpublish) {
        this.tanggalpublish = tanggalpublish;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getTanggalhabis() {
        return tanggalhabis;
    }

    public Date getTanggalkadaluwarsa() {
        return tanggalkadaluwarsa;
    }

    public Date getTanggalmulai() {
        return tanggalmulai;
    }

    public Date getTanggalpublish() {
        return tanggalpublish;
    }

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

