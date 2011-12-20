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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "mahasiswa", catalog = "Smash", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NRP"})})
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNrp", query = "SELECT m FROM Mahasiswa m WHERE m.nrp = :nrp"),
    @NamedQuery(name = "Mahasiswa.findByJumlahsaudara", query = "SELECT m FROM Mahasiswa m WHERE m.jumlahsaudara = :jumlahsaudara"),
    @NamedQuery(name = "Mahasiswa.findByNamaayah", query = "SELECT m FROM Mahasiswa m WHERE m.namaayah = :namaayah"),
    @NamedQuery(name = "Mahasiswa.findByPenghasilanibu", query = "SELECT m FROM Mahasiswa m WHERE m.penghasilanibu = :penghasilanibu"),
    @NamedQuery(name = "Mahasiswa.findByLoginstat", query = "SELECT m FROM Mahasiswa m WHERE m.loginstat = :loginstat"),
    @NamedQuery(name = "Mahasiswa.findByPassword", query = "SELECT m FROM Mahasiswa m WHERE m.password = :password"),
    @NamedQuery(name = "Mahasiswa.findByIpk", query = "SELECT m FROM Mahasiswa m WHERE m.ipk = :ipk"),
    @NamedQuery(name = "Mahasiswa.findByPekerjaanibu", query = "SELECT m FROM Mahasiswa m WHERE m.pekerjaanibu = :pekerjaanibu"),
    @NamedQuery(name = "Mahasiswa.findByNamaibu", query = "SELECT m FROM Mahasiswa m WHERE m.namaibu = :namaibu"),
    @NamedQuery(name = "Mahasiswa.findByNohp", query = "SELECT m FROM Mahasiswa m WHERE m.nohp = :nohp"),
    @NamedQuery(name = "Mahasiswa.findByAlamatsurabaya", query = "SELECT m FROM Mahasiswa m WHERE m.alamatsurabaya = :alamatsurabaya"),
    @NamedQuery(name = "Mahasiswa.findByAlamatasal", query = "SELECT m FROM Mahasiswa m WHERE m.alamatasal = :alamatasal"),
    @NamedQuery(name = "Mahasiswa.findByPenghasilanayah", query = "SELECT m FROM Mahasiswa m WHERE m.penghasilanayah = :penghasilanayah"),
    @NamedQuery(name = "Mahasiswa.findByNilaitoefl", query = "SELECT m FROM Mahasiswa m WHERE m.nilaitoefl = :nilaitoefl"),
    @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswa.findByPekerjaanayah", query = "SELECT m FROM Mahasiswa m WHERE m.pekerjaanayah = :pekerjaanayah"),
    @NamedQuery(name = "Mahasiswa.findByIsadmin", query = "SELECT m FROM Mahasiswa m WHERE m.isadmin = :isadmin"),
    @NamedQuery(name = "Mahasiswa.findBySemester", query = "SELECT m FROM Mahasiswa m WHERE m.semester = :semester")})
public class Mahasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NRP", nullable = false, length = 1000)
    private String nrp;
    @Column(name = "JUMLAHSAUDARA")
    private Integer jumlahsaudara;
    @Column(name = "NAMAAYAH", length = 1000)
    private String namaayah;
    @Column(name = "PENGHASILANIBU")
    private Integer penghasilanibu;
    @Column(name = "LOGINSTAT")
    private Boolean loginstat;
    @Column(name = "PASSWORD", length = 1000)
    private String password;
    @Column(name = "IPK")
    private Integer ipk;
    @Column(name = "PEKERJAANIBU", length = 1000)
    private String pekerjaanibu;
    @Column(name = "NAMAIBU", length = 1000)
    private String namaibu;
    @Column(name = "NOHP", length = 1000)
    private String nohp;
    @Column(name = "ALAMATSURABAYA", length = 1000)
    private String alamatsurabaya;
    @Column(name = "ALAMATASAL", length = 1000)
    private String alamatasal;
    @Column(name = "PENGHASILANAYAH")
    private Integer penghasilanayah;
    @Column(name = "NILAITOEFL")
    private Integer nilaitoefl;
    @Column(name = "NAMA", length = 1000)
    private String nama;
    @Column(name = "PEKERJAANAYAH", length = 1000)
    private String pekerjaanayah;
    @Column(name = "ISADMIN")
    private Boolean isadmin;
    @Column(name = "SEMESTER")
    private Integer semester;

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

    public Integer getJumlahsaudara() {
        return jumlahsaudara;
    }

    public void setJumlahsaudara(Integer jumlahsaudara) {
        this.jumlahsaudara = jumlahsaudara;
    }

    public String getNamaayah() {
        return namaayah;
    }

    public void setNamaayah(String namaayah) {
        this.namaayah = namaayah;
    }

    public Integer getPenghasilanibu() {
        return penghasilanibu;
    }

    public void setPenghasilanibu(Integer penghasilanibu) {
        this.penghasilanibu = penghasilanibu;
    }

    public Boolean getLoginstat() {
        return loginstat;
    }

    public void setLoginstat(Boolean loginstat) {
        this.loginstat = loginstat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIpk() {
        return ipk;
    }

    public void setIpk(Integer ipk) {
        this.ipk = ipk;
    }

    public String getPekerjaanibu() {
        return pekerjaanibu;
    }

    public void setPekerjaanibu(String pekerjaanibu) {
        this.pekerjaanibu = pekerjaanibu;
    }

    public String getNamaibu() {
        return namaibu;
    }

    public void setNamaibu(String namaibu) {
        this.namaibu = namaibu;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getAlamatsurabaya() {
        return alamatsurabaya;
    }

    public void setAlamatsurabaya(String alamatsurabaya) {
        this.alamatsurabaya = alamatsurabaya;
    }

    public String getAlamatasal() {
        return alamatasal;
    }

    public void setAlamatasal(String alamatasal) {
        this.alamatasal = alamatasal;
    }

    public Integer getPenghasilanayah() {
        return penghasilanayah;
    }

    public void setPenghasilanayah(Integer penghasilanayah) {
        this.penghasilanayah = penghasilanayah;
    }

    public Integer getNilaitoefl() {
        return nilaitoefl;
    }

    public void setNilaitoefl(Integer nilaitoefl) {
        this.nilaitoefl = nilaitoefl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPekerjaanayah() {
        return pekerjaanayah;
    }

    public void setPekerjaanayah(String pekerjaanayah) {
        this.pekerjaanayah = pekerjaanayah;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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
