/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Amortizacion;
import java.sql.CallableStatement;

/**
 *
 * @author Erick
 */
public class AmortizacionDao extends Connexion{
     public void register(Amortizacion abono) throws Exception{
        try {
            this.Conectar();
             CallableStatement proc = getCnn().prepareCall("CALL REGISTRARABONO(?,?,?,?) ");
            proc.setInt(1, 0 );
            proc.setDouble(2, abono.getMonto());
            proc.setInt(3, abono.getusuario().getIdusuario());
            proc.setInt(4, 2 );
            proc.execute();            
            
      
        } catch (Exception e) {
         throw e;            
        }          
                
     }        
       
    
}
