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
public class Tamano {
    private Integer idtamano;
    private String tamano;

    /**
     * @return the idtamano
     */
    public Integer getIdtamano() {
        return idtamano;
    }

    /**
     * @param idtamano the idtamano to set
     */
    public void setIdtamano(Integer idtamano) {
        this.idtamano = idtamano;
    }

    /**
     * @return the tamano
     */
    public String getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}
