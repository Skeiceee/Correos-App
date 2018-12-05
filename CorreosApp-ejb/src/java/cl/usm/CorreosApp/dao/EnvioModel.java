/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.CorreosApp.dao;

import cl.usm.CorreosApp.dto.Envio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Singleton;

/**
 *
 * @author labinf10
 */
@Singleton
public class EnvioModel implements EnvioModelLocal {
    
    private List<Envio> envios = new ArrayList<>();
    
    @Override
    public void agregarEnvio(Envio envio) {
        envios.add(envio);
    }
    
    @Override
    public void eliminarEnvio(Envio envio) {
        envios.remove(envio);
    }    
    
    @Override
    public List<Envio> getEnvio() {
        return envios;
    }

    @Override
    public List<Envio> getEnviosByCiudad(String ciudad) {
        List<Envio> filtrada;
        
        filtrada = envios.stream()
                .filter(p -> p.getCiudad().equals(ciudad))
                .collect(Collectors.toList());
        
        return filtrada;
    }
    
    
}
