package mx.uv.listi.SaludarDatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class App {
    @Autowired
    Isaludadores Isaludadores;
    
    //consulta
    @RequestMapping(value = "/saludos", method = RequestMethod.GET)
    public Iterable<Saludadores> dameSaludo() {
        return Isaludadores.findAll();
    }

    //alta
    @RequestMapping(value = "/CrearSaludos", method = RequestMethod.POST)
    public void crearSaludos(@RequestBody Saludadores s) {
        Isaludadores.save(s);
    }
}
