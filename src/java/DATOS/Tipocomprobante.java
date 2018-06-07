/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Erick
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class Tipocomprobante {
    Integer idtipocomprobante;
    String comprobante;
    String detalle;
            
}
