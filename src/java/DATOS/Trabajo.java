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
public class Trabajo {

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
     * @return the fechacontrato
     */
    public String getFechacontrato() {
        return fechacontrato;
    }

    /**
     * @param fechacontrato the fechacontrato to set
     */
    public void setFechacontrato(String fechacontrato) {
        this.fechacontrato = fechacontrato;
    }

    /**
     * @return the fechaentrega
     */
    public String getFechaentrega() {
        return fechaentrega;
    }

    /**
     * @param fechaentrega the fechaentrega to set
     */
    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    /**
     * @return the entregado
     */
    public int getEntregado() {
        return entregado;
    }

    /**
     * @param entregado the entregado to set
     */
    public void setEntregado(int entregado) {
        this.entregado = entregado;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the usuaio
     */
    public Usuario getUsuaio() {
        return usuaio;
    }

    /**
     * @param usuaio the usuaio to set
     */
    public void setUsuaio(Usuario usuaio) {
        this.usuaio = usuaio;
    }

    private Integer idtrabajo;
    private String fechacontrato;
    private String fechaentrega;
    private int entregado;
    private Cliente cliente;
    private Double total;
    private Double saldo;
    private Usuario usuaio;
}
