/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "pengajuan", catalog = "Smash", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"IDPENGAJUAN"})})
@NamedQueries({
    @NamedQuery(name = "Pengajuan.findAll", query = "SELECT p FROM Pengajuan p"),
    @NamedQuery(name = "Pengajuan.findByIdpengajuan", query = "SELECT p FROM Pengajuan p WHERE p.idpengajuan = :idpengajuan"),
    @NamedQuery(name = "Pengajuan.findByPaths", query = "SELECT p FROM Pengajuan p WHERE p.paths = :paths"),
    @NamedQuery(name = "Pengajuan.findByMahasiswaNrp", query = "SELECT p FROM Pengajuan p WHERE p.mahasiswaNrp = :mahasiswaNrp"),
    @NamedQuery(name = "Pengajuan.findByBeasiswaIdbeasiswa", query = "SELECT p FROM Pengajuan p WHERE p.beasiswaIdbeasiswa = :beasiswaIdbeasiswa")})
public class Pengajuan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPENGAJUAN", nullable = false, length = 1000)
    private String idpengajuan;
    @Basic(optional = false)
    @Column(name = "PATHS", nullable = false, length = 1000)
    private String paths;
    @Column(name = "MAHASISWA_NRP", length = 1000)
    private String mahasiswaNrp;
    @Column(name = "BEASISWA_IDBEASISWA", length = 255)
    private String beasiswaIdbeasiswa;

    public Pengajuan() {
    }

    public Pengajuan(String idpengajuan) {
        this.idpengajuan = idpengajuan;
    }

    public Pengajuan(String idpengajuan, String paths) {
        this.idpengajuan = idpengajuan;
        this.paths = paths;
    }

    public String getIdpengajuan() {
        return idpengajuan;
    }

    public void setIdpengajuan(String idpengajuan) {
        this.idpengajuan = idpengajuan;
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths;
    }

    public String getMahasiswaNrp() {
        return mahasiswaNrp;
    }

    public void setMahasiswaNrp(String mahasiswaNrp) {
        this.mahasiswaNrp = mahasiswaNrp;
    }

    public String getBeasiswaIdbeasiswa() {
        return beasiswaIdbeasiswa;
    }

    public void setBeasiswaIdbeasiswa(String beasiswaIdbeasiswa) {
        this.beasiswaIdbeasiswa = beasiswaIdbeasiswa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpengajuan != null ? idpengajuan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengajuan)) {
            return false;
        }
        Pengajuan other = (Pengajuan) object;
        if ((this.idpengajuan == null && other.idpengajuan != null) || (this.idpengajuan != null && !this.idpengajuan.equals(other.idpengajuan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pengajuan[idpengajuan=" + idpengajuan + "]";
    }

}
