/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DATOS.Usuario;

/**
 *
 * @author Oran Alca
 */
public class UsuarioDao extends Connexion{
    public void register(Usuario staff) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("INSERT INTO `usuario`(`USUARIO`, `CONTRASENA`, `ACTIVO`) VALUES (?,?,?)");
            st.setString(1, staff.getUsuario());
            st.setString(2, staff.getContrasena());
            st.setInt(3, staff.getActivo());
      
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Usuario> list() throws Exception{
        List<Usuario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT `IDUSUARIO`, `USUARIO`, `CONTRASENA`, `ACTIVO` FROM `usuario` ");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Usuario staff = new Usuario();
                
                staff.setIdusuario(rs.getInt("IDUSUARIO"));
                staff.setUsuario(rs.getString("USUARIO"));
                staff.setActivo(rs.getInt("ACTIVO"));
                staff.setContrasena(rs.getString("CONTRASENA"));
                
               
                
                lista.add(staff);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    
    public Usuario searchId(Usuario staf) throws Exception{
        Usuario staff;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("select * from USUARIO where IDUSUARIO = ?");
            st.setInt(1, staf.getIdusuario());
            rs = st.executeQuery();            
            while(rs.next()){
                staff = new Usuario();
                
                 staff.setIdusuario(rs.getInt("IDUSUARIO"));
                staff.setUsuario(rs.getString("USUARIO"));
                staff.setActivo(rs.getInt("ACTIVO"));
                staff.setContrasena(rs.getString("CONTRASENA"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return staf;
    }
    
    public void modify(Usuario staff) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("UPDATE `usuario` SET `USUARIO`=?,`CONTRASENA`=?,`ACTIVO`=? WHERE IDUSUARIO=?");
            st.setString(1, staff.getUsuario());
            st.setString(2, staff.getContrasena());
            st.setInt(3, staff.getActivo());
            st.setInt(4, staff.getIdusuario());
          
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Usuario staff) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement(""
                    + "DELETE FROM USUARIO WHERE IDUSUARIO=?");
            st.setInt(1, staff.getIdusuario());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
}

