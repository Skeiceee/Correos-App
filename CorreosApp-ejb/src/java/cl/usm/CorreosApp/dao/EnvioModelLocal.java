/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.CorreosApp.dao;

import cl.usm.CorreosApp.dto.Envio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author labinf10
 */
@Local
public interface EnvioModelLocal {

    void agregarEnvio(Envio envio);

    List<Envio> getEnvio();

    void eliminarEnvio(Envio envio);

    List<Envio> getEnviosByCiudad(String ciudad);
    
}
