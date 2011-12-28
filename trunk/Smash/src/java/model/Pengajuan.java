/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "pengajuan")
@NamedQueries({
    @NamedQuery(name = "Pengajuan.findAll", query = "SELECT p FROM Pengajuan p")})
public class Pengajuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idpengajuan;
    //@Column(name = "PATHS", length = 767)
    private String pathsipk;
    private String pathsgaji;
    private String pathssurattidakmampu;
    private String pathsktp;
    private String pathsktm;
    private String pathskk;
    private String pathscv;
    private String pathssertifikat;
    private String pathsrekening;
    private Boolean statusPengajuan;

    public void setStatusPengajuan(Boolean statusPengajuan) {
        this.statusPengajuan = statusPengajuan;
    }

    public Boolean getStatusPengajuan() {
        return statusPengajuan;
    }

    public String getPathscv() {
        return pathscv;
    }

    public String getPathskk() {
        return pathskk;
    }

    public String getPathsktm() {
        return pathsktm;
    }

    public String getPathsktp() {
        return pathsktp;
    }

    public String getPathsrekening() {
        return pathsrekening;
    }

    public String getPathssertifikat() {
        return pathssertifikat;
    }

    public String getPathssurattidakmampu() {
        return pathssurattidakmampu;
    }

    public void setPathscv(String pathscv) {
        this.pathscv = pathscv;
    }

    public void setPathskk(String pathskk) {
        this.pathskk = pathskk;
    }

    public void setPathsktm(String pathsktm) {
        this.pathsktm = pathsktm;
    }

    public void setPathsktp(String pathsktp) {
        this.pathsktp = pathsktp;
    }

    public void setPathsrekening(String pathsrekening) {
        this.pathsrekening = pathsrekening;
    }

    public void setPathssertifikat(String pathssertifikat) {
        this.pathssertifikat = pathssertifikat;
    }

    public void setPathssurattidakmampu(String pathssurattidakmampu) {
        this.pathssurattidakmampu = pathssurattidakmampu;
    }
    

    public void setPathsgaji(String pathsgaji) {
        this.pathsgaji = pathsgaji;
    }

    public void setPathsipk(String pathsipk) {
        this.pathsipk = pathsipk;
    }

    public String getPathsgaji() {
        return pathsgaji;
    }

    public String getPathsipk() {
        return pathsipk;
    }
    private String tanggalpengajuan;
    // @Column(name = "idbeasiswa", length = 767)
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "IDBEASISWA", nullable= false)
    private Beasiswa idbeasiswa;
    //@Column(name = "nrp", length = 767)
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "NRP", nullable = false)
    private Mahasiswa nrp;

    public void setTanggalpengajuan(String tanggalpengajuan) {
        this.tanggalpengajuan = tanggalpengajuan;
    }

    public String getTanggalpengajuan() {
        return tanggalpengajuan;
    }

    public Beasiswa getIdbeasiswa() {
        return idbeasiswa;
    }

    public String getIdpengajuan() {
        return idpengajuan;
    }

    public Mahasiswa getNrp() {
        return nrp;
    }

   

    public void setIdbeasiswa(Beasiswa idbeasiswa) {
        this.idbeasiswa = idbeasiswa;
    }

    public void setIdpengajuan(String idpengajuan) {
        this.idpengajuan = idpengajuan;
    }

    public void setNrp(Mahasiswa nrp) {
        this.nrp = nrp;
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
