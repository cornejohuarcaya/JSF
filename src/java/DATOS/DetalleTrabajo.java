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
public class DetalleTrabajo {

    public void DetalleTrabajo()
    {
        
    }
    /**
     * @return the iddetalle
     */
    public Integer getIddetalle() {
        return iddetalle;
    }

    /**
     * @param iddetalle the iddetalle to set
     */
    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
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
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the unidad
     */
    public Unidadmedida getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(Unidadmedida unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the tamano
     */
    public Tamano getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    private Integer iddetalle;
    private Producto producto=new Producto();
    private Integer idtrabajo;
    private Integer cantidad;
    private double precio;
    private Unidadmedida unidad;
    private Tamano tamano;
    private String descripcion;
}
