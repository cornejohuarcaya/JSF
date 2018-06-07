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
public class Amortizacion {

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idamortizacion
     */
    public Integer getIdamortizacion() {
        return idamortizacion;
    }

    /**
     * @param idamortizacion the idamortizacion to set
     */
    public void setIdamortizacion(Integer idamortizacion) {
        this.idamortizacion = idamortizacion;
    }

    /**
     * @return the idtrabajo
     */
    public Integer getIdtrabajo() {
        return idtrabajo;
    }

    /**
     * @param idtrabajo the idtrabajo to set
     */
    public void setIdtrabajo(Integer idtrabajo) {
        this.idtrabajo = idtrabajo;
    }

    /**
     * @return the idusuario
     */
    public Usuario getusuario() {
        return usuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    private String fecha;
    private Integer idamortizacion;
    private Integer idtrabajo;
    private Usuario usuario;
    private double monto =0;
            
}
