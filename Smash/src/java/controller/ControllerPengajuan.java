/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Beasiswa;
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

    public void setListPengajuan(Pengajuan pengajuan){
        String nrp = request.getParameter("nrp");
        PengajuanJpaController listPengajuan = new PengajuanJpaController();
        HttpSession session = request.getSession();
        List<Pengajuan> list = new ArrayList<Pengajuan>();
        list = listPengajuan.getAllPengajuanByNrp(nrp);
        session.setAttribute("list_pengajuan", list);
    }
}
