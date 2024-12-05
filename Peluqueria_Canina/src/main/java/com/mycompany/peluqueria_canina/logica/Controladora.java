
package com.mycompany.peluqueria_canina.logica;

import com.mycompany.peluqueria_canina.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String numDuenio) {
       
        //creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setNumDuenio(numDuenio);
        
        
        //creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setColor(color);
        masco.setRaza(raza);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, masco);
      
    }

  // public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String numDuenio) {
       
   // }

    public List<Mascota> traerMascotas() {
        
        
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        
        controlPersis.borrarMascota(num_cliente);
    }

   

    public Mascota traerMascota(int num_cliente) {
       
       return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String numDuenio) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        
        //modifico la mascota
        controlPersis.modificarMascota(masco);
        
        //seteo nuevos valores del dueño
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setNumDuenio(numDuenio);
        dueno.setNombre(nombreDuenio);
        
        //llamar al modificardueño
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        
        controlPersis.modificarDuenio(dueno);
    }
    
    
    
}
