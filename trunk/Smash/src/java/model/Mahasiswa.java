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
    @UniqueConstraint(columnNames = {"NAMA"})})
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswa.findByNrp", query = "SELECT m FROM Mahasiswa m WHERE m.nrp = :nrp"),
    @NamedQuery(name = "Mahasiswa.findByPassword", query = "SELECT m FROM Mahasiswa m WHERE m.password = :password"),
    @NamedQuery(name = "Mahasiswa.findByLoginstat", query = "SELECT m FROM Mahasiswa m WHERE m.loginstat = :loginstat"),
    @NamedQuery(name = "Mahasiswa.findByNohp", query = "SELECT m FROM Mahasiswa m WHERE m.nohp = :nohp"),
    @NamedQuery(name = "Mahasiswa.findByAlamatasal", query = "SELECT m FROM Mahasiswa m WHERE m.alamatasal = :alamatasal"),
    @NamedQuery(name = "Mahasiswa.findByAlamatsurabaya", query = "SELECT m FROM Mahasiswa m WHERE m.alamatsurabaya = :alamatsurabaya"),
    @NamedQuery(name = "Mahasiswa.findByNilaitoefl", query = "SELECT m FROM Mahasiswa m WHERE m.nilaitoefl = :nilaitoefl"),
    @NamedQuery(name = "Mahasiswa.findBySemester", query = "SELECT m FROM Mahasiswa m WHERE m.semester = :semester"),
    @NamedQuery(name = "Mahasiswa.findByIpk", query = "SELECT m FROM Mahasiswa m WHERE m.ipk = :ipk"),
    @NamedQuery(name = "Mahasiswa.findByNamaayah", query = "SELECT m FROM Mahasiswa m WHERE m.namaayah = :namaayah"),
    @NamedQuery(name = "Mahasiswa.findByPekerjaanayah", query = "SELECT m FROM Mahasiswa m WHERE m.pekerjaanayah = :pekerjaanayah"),
    @NamedQuery(name = "Mahasiswa.findByNamaibu", query = "SELECT m FROM Mahasiswa m WHERE m.namaibu = :namaibu"),
    @NamedQuery(name = "Mahasiswa.findByPekerjaanibu", query = "SELECT m FROM Mahasiswa m WHERE m.pekerjaanibu = :pekerjaanibu"),
    @NamedQuery(name = "Mahasiswa.findByPenghasilanibu", query = "SELECT m FROM Mahasiswa m WHERE m.penghasilanibu = :penghasilanibu"),
    @NamedQuery(name = "Mahasiswa.findByPenghasilanayah", query = "SELECT m FROM Mahasiswa m WHERE m.penghasilanayah = :penghasilanayah"),
    @NamedQuery(name = "Mahasiswa.findByJumlahsaudara", query = "SELECT m FROM Mahasiswa m WHERE m.jumlahsaudara = :jumlahsaudara"),
    @NamedQuery(name = "Mahasiswa.findByIsadmin", query = "SELECT m FROM Mahasiswa m WHERE m.isadmin = :isadmin")})
public class Mahasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAMA", nullable = false, length = 1000)
    private String nama;
    @Column(name = "NRP", length = 1000)
    private String nrp;
    @Column(name = "PASSWORD", length = 1000)
    private String password;
    @Column(name = "LOGINSTAT")
    private boolean loginstat;
    @Column(name = "NOHP", length = 1000)
    private String nohp;
    @Column(name = "ALAMATASAL", length = 1000)
    private String alamatasal;
    @Column(name = "ALAMATSURABAYA", length = 1000)
    private String alamatsurabaya;
    @Column(name = "NILAITOEFL")
    private Integer nilaitoefl;
    @Column(name = "SEMESTER")
    private Integer semester;
    @Column(name = "IPK")
    private Integer ipk;
    @Column(name = "NAMAAYAH", length = 1000)
    private String namaayah;
    @Column(name = "PEKERJAANAYAH", length = 1000)
    private String pekerjaanayah;
    @Column(name = "NAMAIBU", length = 1000)
    private String namaibu;
    @Column(name = "PEKERJAANIBU", length = 1000)
    private String pekerjaanibu;
    @Column(name = "PENGHASILANIBU")
    private Integer penghasilanibu;
    @Column(name = "PENGHASILANAYAH")
    private Integer penghasilanayah;
    @Column(name = "JUMLAHSAUDARA")
    private Integer jumlahsaudara;
    @Column(name = "ISADMIN")
    private boolean isadmin;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama) {
        this.nama = nama;
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

    public boolean getLoginstat() {
        return loginstat;
    }

    public void setLoginstat(boolean loginstat) {
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

    public Integer getIpk() {
        return ipk;
    }

    public void setIpk(Integer ipk) {
        this.ipk = ipk;
    }

    public String getNamaayah() {
        return namaayah;
    }

    public void setNamaayah(String namaayah) {
        this.namaayah = namaayah;
    }

    public String getPekerjaanayah() {
        return pekerjaanayah;
    }

    public void setPekerjaanayah(String pekerjaanayah) {
        this.pekerjaanayah = pekerjaanayah;
    }

    public String getNamaibu() {
        return namaibu;
    }

    public void setNamaibu(String namaibu) {
        this.namaibu = namaibu;
    }

    public String getPekerjaanibu() {
        return pekerjaanibu;
    }

    public void setPekerjaanibu(String pekerjaanibu) {
        this.pekerjaanibu = pekerjaanibu;
    }

    public Integer getPenghasilanibu() {
        return penghasilanibu;
    }

    public void setPenghasilanibu(Integer penghasilanibu) {
        this.penghasilanibu = penghasilanibu;
    }

    public Integer getPenghasilanayah() {
        return penghasilanayah;
    }

    public void setPenghasilanayah(Integer penghasilanayah) {
        this.penghasilanayah = penghasilanayah;
    }

    public Integer getJumlahsaudara() {
        return jumlahsaudara;
    }

    public void setJumlahsaudara(Integer jumlahsaudara) {
        this.jumlahsaudara = jumlahsaudara;
    }

    public boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nama != null ? nama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.nama == null && other.nama != null) || (this.nama != null && !this.nama.equals(other.nama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mahasiswa[nama=" + nama + "]";
    }

}
