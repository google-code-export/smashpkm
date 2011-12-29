/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Mahasiswa;
import model.Pengajuan;

/**
 *
 * @author yosua
 */
public class ControllerPengajuan {

    HttpServletRequest request;

    public ControllerPengajuan(HttpServletRequest request) {
        this.request = request;
    }

    public void setListStatusByNrp() {
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        Iterator itr = list.listIterator();
        while (itr.hasNext()) {
            Pengajuan pengajuan = (Pengajuan) itr.next();

            if (pengajuan.getStatuspengajuan().equals("Daftar")) {
                itr.remove();
            }
        }
        session.setAttribute("list_pengajuan_by_nrp", list);
    }

    public void setListPengajuanByNrp(Pengajuan pengajuan) {
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        session.setAttribute("list_pengajuan_by_nrp", list);
    }

    public void setListPengajuan(Pengajuan pengajuan) {
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuan();
        session.setAttribute("list_all_pengajuan", list);
    }

    public void setListPengajuanByIdBeasiswa(Pengajuan pengajuan) {
        String idbeasiswa = request.getParameter("pilih");
        String sort = request.getParameter("pilih_sort");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        if (sort.equals("ipk")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByIpk(idbeasiswa);
        } else if (sort.equals("gaji")) {
            list = listPengajuan.getAllPengajuanByIdBeasiswaOrderByGaji(idbeasiswa);
        } else {
            list = listPengajuan.getAllPengajuan();
        }

        session.setAttribute("list_all_pengajuan", list);
    }

    public void setPengajuan() {
        String idPengajuan = request.getParameter("idpengajuan");
        PengajuanJpaController cariPengajuan = new PengajuanJpaController();
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = cariPengajuan.findPengajuanById(idPengajuan);
        HttpSession session = request.getSession();
        session.setAttribute("pengajuan", pengajuan);
    }

    public void setStatusPenerima() {
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        MahasiswaJpaController aturPengajuan = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuan();
        Iterator itr = list.listIterator();
        Date tglSaatIni = null;
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateNow = formatter.format(currentDate.getTime());
        try {
            tglSaatIni = (Date) formatter.parse(dateNow);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerPengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (itr.hasNext()) {
            Pengajuan pengajuan = (Pengajuan) itr.next();
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNrp(pengajuan.getNrp().getNrp());
            mahasiswa = aturPengajuan.findMahasiswaByNrp(mahasiswa.getNrp());

            if (tglSaatIni.after(pengajuan.getIdbeasiswa().getTanggalhabis()) == true) {
                if (pengajuan.getStatuspengajuan().equals("Terima")) {
                    pengajuan.setStatuspengajuan("Berakhir");
                    mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");
                    try {
                        listPengajuan.edit(pengajuan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    itr.remove();
                }
            }
            if (tglSaatIni.before(pengajuan.getIdbeasiswa().getTanggalhabis()) == true) {
                if (pengajuan.getStatuspengajuan().equals("Berakhir")) {
                    pengajuan.setStatuspengajuan("Terima");
                    mahasiswa.setStatuspenerima("Sedang Menerima Beasiswa");
                    try {
                        listPengajuan.edit(pengajuan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                aturPengajuan.edit(mahasiswa);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void setAturStatus() {
        Mahasiswa mahasiswa = new Mahasiswa();
        String nrp = request.getParameter("nrp");
        String idpengajuan = request.getParameter("idpengajuan");
        MahasiswaJpaController aturStatus = new MahasiswaJpaController();
        PengajuanJpaController aturPengajuan = new PengajuanJpaController();
        mahasiswa = aturStatus.findMahasiswaByNrp(nrp);
        Pengajuan pengajuan = new Pengajuan();
        pengajuan = aturPengajuan.findPengajuanById(idpengajuan);
        if (mahasiswa.getStatuspenerima().equals("Sedang Menerima Beasiswa")) {
            mahasiswa.setStatuspenerima("Tidak Sedang Menerima Beasiswa");
        } else {
            mahasiswa.setStatuspenerima("Sedang Menerima Beasiswa");
            pengajuan.setStatuspengajuan("Terima");
            try {
                aturPengajuan.edit(pengajuan);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        try {
            aturStatus.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
