/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public class ClienteDao extends Connexion{
    public void register(Cliente cliente) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("INSERT INTO `cliente`( `DATOSRAZONSOCIAL`, `RUC`, `DNI`, `REPRESENTANTE`, `DIRECCION`, `TELEFONO`, `CORREO`) VALUES (?,?,?,?,?,?,?)");
            st.setString(1, cliente.getRazonsocial());
            st.setString(2, cliente.getRuc());
            st.setString(3, cliente.getDni());
            st.setString(4, cliente.getRepresentante());
            st.setString(5, cliente.getDireccion());
            st.setString(6, cliente.getTelefono());
            st.setString(7, cliente.getCorreo());
      
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Cliente> list() throws Exception{
        List<Cliente> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT `IDCLIENTE`, `DATOSRAZONSOCIAL`, `RUC`, `DNI`, `REPRESENTANTE`, `DIRECCION`, `TELEFONO`, `CORREO` FROM `cliente`");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Cliente staff = new Cliente();
                
                staff.setIdcliente(rs.getInt("IDCLIENTE"));
                staff.setRazonsocial(rs.getString("DATOSRAZONSOCIAL"));
                staff.setRuc(rs.getString("RUC"));
                staff.setDni(rs.getString("DNI"));
                staff.setRepresentante(rs.getString("REPRESENTANTE"));
                staff.setDireccion(rs.getString("DIRECCION"));
                staff.setTelefono(rs.getString("TELEFONO"));
                staff.setCorreo(rs.getString("CORREO"));
               
                
                lista.add(staff);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    
    public Cliente searchId(Cliente cliente) throws Exception{
        Cliente staff;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("SELECT * FROM `CLIENTE` WHERE `IDCLIENTE` =  ?");
            st.setInt(1, cliente.getIdcliente());
            rs = st.executeQuery();            
            while(rs.next()){
                staff = new Cliente();
                
                staff.setIdcliente(rs.getInt("IDCLIENTE"));
                staff.setRazonsocial(rs.getString("DATOSRAZONSOCIAL"));
                staff.setRuc(rs.getString("RUC"));
                staff.setDni(rs.getString("DNI"));
                staff.setRepresentante(rs.getString("REPRESENTANTE"));
                staff.setDireccion(rs.getString("DIRECCION"));
                staff.setTelefono(rs.getString("TELEFONO"));
                staff.setCorreo(rs.getString("CORREO"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return cliente;
    }
    
    public void modify(Cliente cliente) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("UPDATE `cliente` SET `DATOSRAZONSOCIAL`=?,`RUC`=?,`DNI`=?,`REPRESENTANTE`=?,`DIRECCION`=? ,`TELEFONO`=?,`CORREO`=? WHERE `IDCLIENTE`=?");
            
            st.setString(1, cliente.getRazonsocial());
            st.setString(2, cliente.getRuc());
            st.setString(3, cliente.getDni());
            st.setString(4, cliente.getRepresentante());
            st.setString(5, cliente.getDireccion());
            st.setString(6, cliente.getTelefono());
            st.setString(7, cliente.getCorreo());
            st.setInt(8, cliente.getIdcliente());
          
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Cliente cliente) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareStatement("DELETE FROM `cliente` WHERE `IDCLIENTE` =?");
            st.setInt(1, cliente.getIdcliente());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
}
