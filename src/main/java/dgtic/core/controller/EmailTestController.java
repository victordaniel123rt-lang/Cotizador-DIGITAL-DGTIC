package dgtic.core.controller;


import dgtic.core.model.dto.auto.LogoDTO;
import dgtic.core.service.Vehiculo.Logo.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmailTestController {
    private String archivoRuta="c:/imagenes/";
    @Autowired
    LogoService logo;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/test-email")
    public String enviarCorreoPrueba() {

        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();

            mensaje.setTo("victorgarcia123rt@gmail.com"); // cámbialo si quieres probar otro
            mensaje.setSubject("Prueba de correo Spring Boot");
            mensaje.setText("Si estás viendo esto, el correo funciona correctamente");

            mailSender.send(mensaje);

            return "Correo enviado correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al enviar correo: " + e.getMessage();
        }
    }


    @PostMapping(value = "salvar-imagen")
    @ResponseBody
    public String salvarImagen(
            @RequestParam("imagenArchivo") MultipartFile multipartFile,
            @RequestParam("marca") Long marcaId) {

        if (multipartFile == null || multipartFile.isEmpty()) {
            return "Error: archivo vacío";
        }

        LogoDTO logoDTO = new LogoDTO();
        logoDTO.setMarca(marcaId);

        logo.save(logoDTO,multipartFile);


        return "Logo actualizado correctamente para la marca: " + logoDTO.getMarca();
    }



}

