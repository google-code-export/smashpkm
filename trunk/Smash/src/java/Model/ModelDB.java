/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author yosua
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yosua
 */
public class ModelDB {
    Connection conn;

    public ModelDB(Connection conn){
    this.conn=conn;
    }

    public void insertReg(String nama,String nrp,String password) throws Exception{
    String sql="insert into Mahasiswa values (?,?,?)";
    PreparedStatement st=conn.prepareStatement(sql);
    st.setString(1,nama);
    st.setString(2,nrp);
    st.setString(3,password);
    st.executeUpdate();
    st.close();
    }

    public Pengguna getPengguna(String nrp){
    Pengguna pengguna= new Pengguna();
    String sql="SELECT * FROM Mahasiswa WHERE nrp = ?";
    try{
    PreparedStatement st;
    st=this.conn.prepareStatement(sql);
    st.setString(1, nrp);
    ResultSet rs = st.executeQuery();
    if (rs != null) {
        if (rs.next()) {
            pengguna.setNama(rs.getString(1));
            pengguna.setNrp(rs.getString(1));
            pengguna.setPassword(rs.getString(1));


                }
            }
    }
    catch(Exception ex){
    ex.printStackTrace();}


        return pengguna;





}
}
