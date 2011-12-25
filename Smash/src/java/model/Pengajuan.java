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
    private String paths;
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

    public String getPaths() {
        return paths;
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

    public void setPaths(String paths) {
        this.paths = paths;
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
