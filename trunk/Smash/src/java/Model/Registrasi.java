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

/**
 *
 * @author yosua
 */
public class Registrasi {
    Connection conn;

    public Registrasi(Connection conn){
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
    }}
