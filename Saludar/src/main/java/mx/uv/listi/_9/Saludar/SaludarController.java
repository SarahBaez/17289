package mx.uv.listi._9.Saludar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*")
public class SaludarController {

    Saludador s;

    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    @ResponseBody
    public String obtener() {
        return "Método GET: obtener saludo";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ResponseBody
    public String crear() {
        return "Método POST: crear saludo";
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    @ResponseBody
    public String actualizar() {
        return "Método PUT: actualizar saludo";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    @ResponseBody
    public String eliminar() {
        return "Método DELETE: eliminar saludo";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "Bienvenido al controlador REST de saludos";
    }

    @RequestMapping(value = "/Saludar2/{nombre}", method = RequestMethod.GET)
    @ResponseBody
    public Saludador saludarPath2(@PathVariable String nombre) {
        return new Saludador(nombre);
    }
    
    @GetMapping(value = {"/saludar1","/saludar1/{nombre}"})
    @ResponseBody
    public Saludador saludar1(@PathVariable(required = false) String nombre) {
        if (nombre == null) {
            nombre = "Mundo";
        }
        return new Saludador("Hola " + nombre);
    }

    @PostMapping("/crearSaludo")
    @ResponseBody
    public String saludoCreaer(@RequestBody Saludador parametro){
        System.out.println(parametro.getContenido());
        s = parametro;
        System.out.println(parametro.getContenido());
        return "exito";
    }

    @GetMapping("/obtenerSaludo")
    @ResponseBody
    public Saludador saludoObtener(){
        return s; 
    }

    // --recepción de parámetros por query string--
    @GetMapping("/query")
    public void saludarQuery(@RequestParam String nombre) {
        System.out.println(nombre);     
    }

    @GetMapping("/altas")
    public String altas(Model model) {
        return "sss.html";
    }
}