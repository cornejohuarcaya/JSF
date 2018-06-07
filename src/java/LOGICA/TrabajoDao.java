/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Cliente;
import DATOS.Producto;
import DATOS.Trabajo;
import DATOS.Unidadmedida;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erick
 */
public  class TrabajoDao extends Connexion{
    public int register(Trabajo trabajo) throws Exception{
        int IDTRAB=0;
        try {
            this.Conectar();
             CallableStatement proc = getCnn().prepareCall("CALL REGISTRARTRABAJO(?,?,?,?) ");
            proc.setInt(1, trabajo.getCliente().getIdcliente() );
            proc.setDouble(2, trabajo.getTotal());
            proc.setInt(3, trabajo.getUsuaio().getIdusuario());
            proc.setDouble(4, trabajo.getSaldo() );
            proc.execute();            
            
      
        } catch (Exception e) {
IDTRAB = 0;            throw e;
            
        }
        return IDTRAB;
                
                
                
       
    }
    
    public List<Trabajo> listresumen(String Cliente ) throws Exception{
        List<Trabajo> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCnn().prepareCall("SELECT c.DATOSRAZONSOCIAL, c.RUC, t.IDTRABAJO, t.FECHACONTRATO, t.TOTAL, t.SALDO from trabajo t\n" +
"INNER JOIN  cliente c ON t.IDCLIENTE =  c.IDCLIENTE \n" +
"where c.DATOSRAZONSOCIAL LIKE '%"+Cliente+"%' \n" +
"order BY  t.FECHACONTRATO");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Trabajo trab = new Trabajo();
                Cliente cli = new Cliente();
                    cli.setRazonsocial(rs.getString("DATOSRAZONSOCIAL"));
                    cli.setRuc(rs.getString("RUC"));
                
                trab.setCliente(cli);
                trab.setIdtrabajo(rs.getInt("IDTRABAJO"));
                trab.setFechacontrato(rs.getString("FECHACONTRATO"));
                trab.setTotal(rs.getDouble("TOTAL"));
                trab.setSaldo(rs.getDouble("SALDO"));
                
                lista.add(trab);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
}
