/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.syncboard.controller;

import edu.eci.arsw.syncboard.model.Clase;
import edu.eci.arsw.syncboard.model.Correo;
import edu.eci.arsw.syncboard.model.Usuario;
import edu.eci.arsw.syncboard.services.ManejadorUsuarioServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2103216
 */
@RestController
@RequestMapping(value = "/Usuario")
public class APIRestUsuarioController {

    @Autowired
    ManejadorUsuarioServices manejador;

    @RequestMapping(value = "/AgregarUsuario", method = RequestMethod.PUT)
    public ResponseEntity<?> AgregarUsuario(@RequestBody Usuario user) {
        try {
            //registrar dato
            manejador.ingresoUsuario(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/AgregarCorreo", method = RequestMethod.PUT)
    public ResponseEntity<?> AgregarUsuario(@RequestBody Correo corr) {
        try {
            //registrar dato
            manejador.agregarCorreo(corr);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/agregarClase", method = RequestMethod.PUT)
    public ResponseEntity<?> agregarClase(@RequestBody Clase clase) {
        try {
            manejador.agregarClase(clase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }

    
            @RequestMapping(value = "/adjuntarEstudiante", method = RequestMethod.PUT)
    public ResponseEntity<?> adjuntarEstudiante(@RequestBody String name) {
        try {
            manejador.adjuntarEstudiante(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }
    
    /*
    @RequestMapping(path = "/{iddibujo}", method = RequestMethod.PUT)
    public ResponseEntity<?> manejadorPutRecursoOrdenes(@PathVariable int iddibujo, @RequestBody String nombre) {
        try{
            System.out.println("hooooooola"+nombre+iddibujo);
            if (lista.containsKey(iddibujo)) {
                ArrayList<String> temp = lista.get(iddibujo);
                temp.add(nombre);
                lista.put(iddibujo, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(nombre);
                lista.put(iddibujo, temp);
            }

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }

    }
    */
    
        @RequestMapping(value = "/usuarioActual", method = RequestMethod.PUT)
    public ResponseEntity<?> setUserActual(@RequestBody String name) {
        try {
            manejador.setUserActual(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }
    
    @RequestMapping(value = "/getUserActual", method = RequestMethod.GET)
    public ResponseEntity<?> getUserActual() {

        return new ResponseEntity<>(manejador.getUserActual(), HttpStatus.ACCEPTED);

    }
    
            @RequestMapping(value = "/claseActual", method = RequestMethod.PUT)
    public ResponseEntity<?> setClaseActual(@RequestBody String name) {
        try {
            manejador.setClaseActual(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(APIRestUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.FORBIDDEN);
        }
    }
    
    
        @RequestMapping(value = "/getClaseActual", method = RequestMethod.GET)
    public ResponseEntity<?> getClaseActual() {

        return new ResponseEntity<>(manejador.getClaseActual(), HttpStatus.ACCEPTED);

    }
    
    @RequestMapping(value = "/getClases", method = RequestMethod.GET)
    public ResponseEntity<?> getClases() {

        return new ResponseEntity<>(manejador.getClases(), HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/getUsuario", method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios() {

        return new ResponseEntity<>(manejador.getUsuarios(), HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/getCorreo", method = RequestMethod.GET)
    public ResponseEntity<?> getCorreos() {

        return new ResponseEntity<>(manejador.getCorreos(), HttpStatus.ACCEPTED);

    }

}
