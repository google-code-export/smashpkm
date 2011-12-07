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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Pengajuan.findByNama", query = "SELECT p FROM Pengajuan p WHERE p.nama = :nama"),
    @NamedQuery(name = "Pengajuan.findByIdbeasiswa", query = "SELECT p FROM Pengajuan p WHERE p.idbeasiswa = :idbeasiswa")})
public class Pengajuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "IDPENGAJUAN", nullable = false, length = 1000)
    private String idpengajuan;
    @Column(name = "PATHS", nullable = false, length = 1000)
    private String paths;

    public void setPaths(String paths) {
        this.paths = paths;
    }

    public String getPaths() {
        return paths;
    }
    @Basic(optional = false)
    @JoinColumn(name = "nama",
    referencedColumnName = "nama")
    @ManyToOne
    //@Column(name = "NAMA", nullable = false, length = 1000)
    private String nama;
    @JoinColumn(name = "idbeasiswa",
    referencedColumnName = "idbeasiswa")
    @ManyToOne
    @Basic(optional = false)
    //@Column(name = "IDBEASISWA", nullable = false, length = 1000)
    private String idbeasiswa;





    public Pengajuan() {
    }

    public Pengajuan(String idpengajuan) {
        this.idpengajuan = idpengajuan;
    }

    public Pengajuan(String idpengajuan, String nama, String idbeasiswa) {
        this.idpengajuan = idpengajuan;
        this.nama = nama;
        this.idbeasiswa = idbeasiswa;
    }

    public String getIdpengajuan() {
        return idpengajuan;
    }

    public void setIdpengajuan(String idpengajuan) {
        this.idpengajuan = idpengajuan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdbeasiswa() {
        return idbeasiswa;
    }

    public void setIdbeasiswa(String idbeasiswa) {
        this.idbeasiswa = idbeasiswa;
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
