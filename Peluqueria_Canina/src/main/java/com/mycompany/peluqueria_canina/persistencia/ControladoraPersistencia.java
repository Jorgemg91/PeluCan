
package com.mycompany.peluqueria_canina.persistencia;

import com.mycompany.peluqueria_canina.logica.Duenio;
import com.mycompany.peluqueria_canina.logica.Mascota;
import com.mycompany.peluqueria_canina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    DuenioJpaController dueniojpa = new DuenioJpaController();
    MascotaJpaController mascojpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
        
        //Crear en la DB el dueño
        dueniojpa.create(duenio);
        
        //Crear en la DB la mascota
        mascojpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        
        return mascojpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        
        try {
            mascojpa.destroy(num_cliente);
        } catch(NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Mascota traerMascota(int num_cliente) {
        
       return mascojpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        
        try {
            mascojpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        
        return dueniojpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio dueno) {
        
        try {
            dueniojpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
