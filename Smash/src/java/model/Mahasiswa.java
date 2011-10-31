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

    @Column(name = "noHp")
    private String noHp;

    @Column(name = "alamatAsal")
    private String alamatAsal;

    @Column(name = "alamatSurabaya")
    private String alamatSurabaya;

    @Column(name = "nilaiToefl")
    private long nilaiToefl;

    @Column(name = "semester")
    private long semester;

    @Column(name = "ipk")
    private long ipk;

    @Column(name = "namaAyah")
    private String namaAyah;

    @Column(name = "pekerjaanAyah")
    private String pekerjaanAyah;

    @Column(name = "penghasilanAyah")
    private long penghasilanAyah;

    @Column(name = "namaIbu")
    private String namaIbu;

    @Column(name = "pekerjaanIbu")
    private String pekerjaanIbu;

    @Column(name = "penghasilanIbu")
    private long penghasilanIbu;

     @Column(name = "jumlahSaudara")
    private long jumlahSaudara;

    public void setAlamatAsal(String alamatAsal) {
        this.alamatAsal = alamatAsal;
    }

    public void setAlamatSurabaya(String alamatSurabaya) {
        this.alamatSurabaya = alamatSurabaya;
    }

    public void setIpk(long ipk) {
        this.ipk = ipk;
    }

    public void setJumlahSaudara(long jumlahSaudara) {
        this.jumlahSaudara = jumlahSaudara;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public void setNilaiToefl(long nilaiToefl) {
        this.nilaiToefl = nilaiToefl;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public void setPenghasilanAyah(long penghasilanAyah) {
        this.penghasilanAyah = penghasilanAyah;
    }

    public void setPenghasilanIbu(long penghasilanIbu) {
        this.penghasilanIbu = penghasilanIbu;
    }

    public void setSemester(long semester) {
        this.semester = semester;
    }

    public String getAlamatAsal() {
        return alamatAsal;
    }

    public String getAlamatSurabaya() {
        return alamatSurabaya;
    }

    public long getIpk() {
        return ipk;
    }

    public long getJumlahSaudara() {
        return jumlahSaudara;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public long getNilaiToefl() {
        return nilaiToefl;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public long getPenghasilanAyah() {
        return penghasilanAyah;
    }

    public long getPenghasilanIbu() {
        return penghasilanIbu;
    }

    public long getSemester() {
        return semester;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
