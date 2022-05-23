/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr_code_generate;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AC Tech
 */
public class connection {
    
    static Connection con;
    static String msg ;
    
    public static void getInstance(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc.mysql://localhost:3306/db","root","");
            msg = "success";
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet interrogerDB(String q){
        ResultSet res = null;
        Statement st = null;
        if(con == null)
            getInstance();
        if(msg == "success"){
            try {
                st = con.createStatement();
                res = st.executeQuery(q);
            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
    
    public int updateDB(String q){
        int res = -1;
        Statement st = null;
        if(con == null)
            getInstance();
        if(msg == "success"){
            try {
                st = con.createStatement();
                res = st.executeUpdate(q);
            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
}
    
