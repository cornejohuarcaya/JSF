/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Erick
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class Comprobante {

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
     * @return the idtipocomprobante
     */
    public Integer getIdtipocomprobante() {
        return idtipocomprobante;
    }

    /**
     * @param idtipocomprobante the idtipocomprobante to set
     */
    public void setIdtipocomprobante(Integer idtipocomprobante) {
        this.idtipocomprobante = idtipocomprobante;
    }

    /**
     * @return the idserie
     */
    public Integer getIdserie() {
        return idserie;
    }

    /**
     * @param idserie the idserie to set
     */
    public void setIdserie(Integer idserie) {
        this.idserie = idserie;
    }

    /**
     * @return the igv
     */
    public double getIgv() {
        return igv;
    }

    /**
     * @param igv the igv to set
     */
    public void setIgv(double igv) {
        this.igv = igv;
    }

    /**
     * @return the retencion
     */
    public Boolean getRetencion() {
        return retencion;
    }

    /**
     * @param retencion the retencion to set
     */
    public void setRetencion(Boolean retencion) {
        this.retencion = retencion;
    }

    /**
     * @return the idusuario
     */
    public Integer getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    private Integer idtrabajo;
    private String fecha;
    private Integer idtipocomprobante;
    private Integer idserie;
    private double igv;
    private Boolean retencion;
    private Integer idusuario;
}
