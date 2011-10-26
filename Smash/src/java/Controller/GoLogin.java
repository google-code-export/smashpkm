/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.KoneksiDB;
import Model.ModelDB;
import Model.Pengguna;
import com.mysql.jdbc.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yosua
 */
public class GoLogin {
HttpServletRequest request;


public GoLogin( HttpServletRequest request){

this.request=request;

}
public String Login() {

Pengguna pengguna=new Pengguna();
KoneksiDB kondb=new KoneksiDB();
HttpSession session = request.getSession();
ModelDB login=new ModelDB(kondb.getConnection());
String nrp = request.getParameter("nrp");
String password = request.getParameter("password");
pengguna = login.getPengguna(nrp);
 if (nrp.equals(pengguna.getNrp()) && password.equals(pengguna.getPassword())) {
                session.setAttribute("nrp", nrp);
                    request.setAttribute("nrp", nrp);
                    kondb.CloseConnection();
                    return "HalamanUtamaPengguna.jsp";
                }else {
                return "login.jsp";
            }
            }
}
        


