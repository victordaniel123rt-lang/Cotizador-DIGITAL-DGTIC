package dgtic.core.service.cotizacion;


import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.dto.CotizacionDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class PDFService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] generarPDF(CotizacionDTO cotizacionDTO, CotizacionFinalDTO cotizacionFinalDTO, Map<String, Map<String, BigDecimal>> costos, Map<String, Object> adicionales){
        try{
            Context context = new Context();
            context.setVariable("form", cotizacionDTO);
            context.setVariable("genera", cotizacionFinalDTO);
            context.setVariable("costos", costos);
            
            adicionales.forEach(context::setVariable);
            String html = templateEngine.process("cotizar/cotizacion", context);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(baos);
            builder.run();

            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error al generar el PDF");
        }
    }


    public void enviarPdf(String destino, byte[] pdfBytes){
        try{
            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mensaje, true);


            helper.setTo(destino);
            helper.setSubject("Tu cotizacion");
            helper.setText("Adjunto tu cotizacion", true);

            helper.addAttachment(
                    "cotizacion.pdf",
                    new ByteArrayResource(pdfBytes)

            );


            mailSender.send(mensaje);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
