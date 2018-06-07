/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Erick
 */
public class LogueoDao extends  Connexion{
    
    public Usuario searchId(Usuario staf) throws Exception{
        Usuario staff;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("select IDUSUARIO,USUARIO, ACTIVO, CONTRASENA   from USUARIO where USUARIO=? and CONTRASENA=? and ACTIVO=1 ");
            st.setString(1, staf.getUsuario());
            st.setString(2, staf.getContrasena());
            rs = st.executeQuery();            
            while(rs.next()){
                staff = new Usuario();
                
                 staff.setIdusuario(rs.getInt("IDUSUARIO"));
                staff.setUsuario(rs.getString("USUARIO"));
                staff.setActivo(rs.getInt("ACTIVO"));
                staff.setContrasena(rs.getString("CONTRASENA"));
                
                staf=staff;
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return staf;
    }
}
