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
public class Unidadmedida {

    /**
     * @return the idunidad
     */
    public Integer getIdunidad() {
        return idunidad;
    }

    /**
     * @param idunidad the idunidad to set
     */
    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the unidad
     */
    public Integer getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }
    private Integer idunidad;
    private String nombre;
    private Integer unidad;
}
