/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "mahasiswa")
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m")})
public class Mahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NRP", nullable = false, length = 767)
    private String nrp;
    @Column(name = "NAMA", length = 767)
    private String nama;
    @Column(name = "PASSWORD", length = 767)
    private String password;
    @Column(name = "LOGINSTAT")
    private Boolean loginstat;
    @Column(name = "NOHP", length = 767)
    private String nohp;
    @Column(name = "ALAMATASAL", length = 767)
    private String alamatasal;
    @Column(name = "ALAMATSURABAYA", length = 767)
    private String alamatsurabaya;
    @Column(name = "NILAITOEFL")
    private Integer nilaitoefl;
    @Column(name = "SEMESTER")
    private Integer semester;
    @Column(name = "IPK", precision = 22)
    private Double ipk;
    @Column(name = "NAMAAYAH", length = 767)
    private String namaayah;
    @Column(name = "NAMAIBU", length = 767)
    private String namaibu;
    @Column(name = "PENGHASILANAYAH")
    private Integer penghasilanayah;
    @Column(name = "PENGHASILANIBU")
    private Integer penghasilanibu;
    @Column(name = "PEKERJAANAYAH", length = 767)
    private String pekerjaanayah;
    @Column(name = "PEKERJAANIBU", length = 767)
    private String pekerjaanibu;
    @Column(name = "JUMLAHSAUDARA")
    private Integer jumlahsaudara;
    @Column(name = "ISADMIN")
    private Boolean isadmin;
    //@OneToMany//(cascade = CascadeType.ALL, mappedBy = "idbeasiswa", fetch = FetchType.LAZY)
    //private Pengajuan pengajuan;
    @OneToMany(mappedBy = "nrp")
    private Set<Pengajuan> pengajuanCollection;

    public Mahasiswa() {
    }

    public Mahasiswa(String nrp) {
        this.nrp = nrp;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoginstat() {
        return loginstat;
    }

    public void setLoginstat(Boolean loginstat) {
        this.loginstat = loginstat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getAlamatasal() {
        return alamatasal;
    }

    public void setAlamatasal(String alamatasal) {
        this.alamatasal = alamatasal;
    }

    public String getAlamatsurabaya() {
        return alamatsurabaya;
    }

    public void setAlamatsurabaya(String alamatsurabaya) {
        this.alamatsurabaya = alamatsurabaya;
    }

    public Integer getNilaitoefl() {
        return nilaitoefl;
    }

    public void setNilaitoefl(Integer nilaitoefl) {
        this.nilaitoefl = nilaitoefl;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Double getIpk() {
        return ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public String getNamaayah() {
        return namaayah;
    }

    public void setNamaayah(String namaayah) {
        this.namaayah = namaayah;
    }

    public String getNamaibu() {
        return namaibu;
    }

    public void setNamaibu(String namaibu) {
        this.namaibu = namaibu;
    }

    public Integer getPenghasilanayah() {
        return penghasilanayah;
    }

    public void setPenghasilanayah(Integer penghasilanayah) {
        this.penghasilanayah = penghasilanayah;
    }

    public Integer getPenghasilanibu() {
        return penghasilanibu;
    }

    public void setPenghasilanibu(Integer penghasilanibu) {
        this.penghasilanibu = penghasilanibu;
    }

    public String getPekerjaanayah() {
        return pekerjaanayah;
    }

    public void setPekerjaanayah(String pekerjaanayah) {
        this.pekerjaanayah = pekerjaanayah;
    }

    public String getPekerjaanibu() {
        return pekerjaanibu;
    }

    public void setPekerjaanibu(String pekerjaanibu) {
        this.pekerjaanibu = pekerjaanibu;
    }

    public Integer getJumlahsaudara() {
        return jumlahsaudara;
    }

    public void setJumlahsaudara(Integer jumlahsaudara) {
        this.jumlahsaudara = jumlahsaudara;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
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
