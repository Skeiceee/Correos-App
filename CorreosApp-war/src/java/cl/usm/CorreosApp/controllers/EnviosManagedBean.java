/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package cl.usm.CorreosApp.controllers;

import cl.usm.CorreosApp.dao.EnvioModelLocal;
import cl.usm.CorreosApp.dto.Envio;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author labinf10
 */
@Named(value = "enviosManagedBean")
@ViewScoped
public class EnviosManagedBean implements Serializable {

    @EJB
    private EnvioModelLocal envioModel;

    private List<Envio> envios;

    private String nom_cliente;
    private int telefono;
    private String direccion;
    private String ciudad;
    private String pais_origen;

    /**
     * Creates a new instance of EnviosManagedBean
     */
    public EnviosManagedBean() {
    }

    @PostConstruct
    public void init() {
        this.envios = envioModel.getEnvio();
    }

    public void agregarEnvio(ActionEvent ev) {
        Envio envio = new Envio();
        envio.setNom_cliente(nom_cliente);
        envio.setTelefono(telefono);
        envio.setDireccion(direccion);
        envio.setCiudad(ciudad);
        envio.setPais_origen(pais_origen);

        envioModel.agregarEnvio(envio);

        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("ver_envio.xhtml");
        } catch (IOException ex) {

        }

    }

    public void eliminarEnvio(Envio envio) {
        this.envioModel.eliminarEnvio(envio);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("El pedido a sido antendido."));
    }
    
    public void filtrar(){
        envios = this.envioModel.getEnviosByCiudad(ciudad);
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

}
