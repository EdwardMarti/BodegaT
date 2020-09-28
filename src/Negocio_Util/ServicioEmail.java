/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Util;

//import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//
//import javax.mail.internet.AddressException;


/**
 * Clase que permite enviar correo electrónico a través de los servidores de
 * gmail
 *
 * @author Marco Adarme
 * @version 2.0
 */
public class ServicioEmail {

    //Dirección del servidor smtp, puede cambiarlo a su servidor de su cuenta particular, en el caso de gmail es smtp.gmail.com
    private final String direccionServidorEmail = "smtp.gmail.com";
    //Numéro del puerto del servidor smtp, en el caso de gmail es el 587
    private final String puertoServidor = "587";
    private Properties props = new Properties();
    //Dirección del email del usario que envía el mensaje
    private String emailUsuarioEmisor;
    //Contraseña del usuario que envía el correo electrónico
    private String claveEmailUsuarioEmisor;

    /**
     *
     * Crea un objeto para enviar correo electrónico a través de los servidores
     * de gmail
     *
     */
//    public ServicioEmail(String emailUsuarioEmisor, String claveEmailUsuarioEmisor) {
//        
//        this.emailUsuarioEmisor = emailUsuarioEmisor;
//        this.claveEmailUsuarioEmisor = claveEmailUsuarioEmisor;
//        inicializarPropiedades();
//                
//    }
    public ServicioEmail() {
   this.emailUsuarioEmisor = "confirmation.registry@gmail.com";
        this.claveEmailUsuarioEmisor = "analistainformacion1";
//        this.emailUsuarioEmisor = "nocontestar.solicitudservicio@gmail.com";
//        this.claveEmailUsuarioEmisor = "soporte201";
//        this.emailUsuarioEmisor = "dictamenescertiretie@gmail.com";
//        this.claveEmailUsuarioEmisor = "soporte201";
        inicializarPropiedades();
    }

    /**
     * Inicia las propiedades del servicio de correo
     */
    private void inicializarPropiedades() {

        props.setProperty("mail.smtp.host", this.direccionServidorEmail);
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", this.puertoServidor);
        props.setProperty("mail.smtp.user", this.emailUsuarioEmisor);
        props.setProperty("mail.smtp.auth", "true");
        //LE AGREGUE ESTA LINEA Y CORRE BIEN ME LLEGAN CORREOS A MI MIRE A VER SIA USTED LE FUNCIONA
        props.setProperty("mail.smtp.ssl.trust",this.direccionServidorEmail);  
    }

    /**
     * Método que permite enviar un correo electrónico en texto plano
     *
     * @param receptor dirección email del usuario a quien se le envía el
     * mensaje
     * @param asunto asunto del correo electrónico
     * @param cuerpoMensaje cuerpo del mensaje del correo electrónico
     */
    public void enviarEmail(String receptor, String asunto, String cuerpoMensaje) {
      

        try {

            Session session = Session.getDefaultInstance(props);
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(this.emailUsuarioEmisor));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
           
            message.setSubject(asunto);
            message.setText(cuerpoMensaje);

            Transport t = session.getTransport("smtp");
            t.connect(this.emailUsuarioEmisor, this.claveEmailUsuarioEmisor);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
    }
    
    public void enviarEmailBcc(String receptor,String copireceptor, String asunto, String cuerpoMensaje) {
      
        try {

            Session session = Session.getDefaultInstance(props);
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("destino@server.com"));

//Estableciendo el destino de la copia (CC)
//            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("con.copia@gmail.com"));

//Estableciendo el destino de la copia oculta (BCC)
//            generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress("bcc@hotmail.com"));

            message.setFrom(new InternetAddress(this.emailUsuarioEmisor));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
           
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(copireceptor));
            message.setSubject(asunto);
            message.setText(cuerpoMensaje);

            Transport t = session.getTransport("smtp");
            t.connect(this.emailUsuarioEmisor, this.claveEmailUsuarioEmisor);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
    }


    /**
     * Método get que retona la clave del email
     *
     * @return un tipo String que contiene la clave del email
     */
    public String getClaveEmailUsuarioEmisor() {

        return claveEmailUsuarioEmisor;

    }

    /**
     * Método set que modifica la clave del email
     *
     * @param claveEmailUsuarioEmisor es de tipo String y contiene la nueva
     * clave
     */
    public void setClaveEmailUsuarioEmisor(String claveEmailUsuarioEmisor) {

        this.claveEmailUsuarioEmisor = claveEmailUsuarioEmisor;

    }

    /**
     * Método get que retorna el email
     *
     * @return un tipo String que ocntiene el email
     */
    public String getEmailUsuarioEmisor() {

        return emailUsuarioEmisor;

    }

    /**
     * Método set que modifica el email
     *
     * @param emailUsuarioEmisor es de tipo String y contiene el nuevo email
     */
    public void setEmailUsuarioEmisor(String emailUsuarioEmisor) {

        this.emailUsuarioEmisor = emailUsuarioEmisor;

    }

}//Fin de la Clase 

