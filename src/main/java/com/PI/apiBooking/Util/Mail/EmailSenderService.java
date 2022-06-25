package com.PI.apiBooking.Util.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;


@Service
public class EmailSenderService{
    @Autowired
    private JavaMailSender mailSender;

    public void sendMailLog(String to, String usuario) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("Digital Booking");
        helper.setFrom("correodeautenticacionctd@gmail.com");
        helper.setTo(to);

        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html\n" +
                "\t\txmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "\t\txmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
                "\t\tstyle=\"\n" +
                "\t\twidth: 100%;\n" +
                "\t\tfont-family: lato, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "\t\t-webkit-text-size-adjust: 100%;\n" +
                "\t\t-ms-text-size-adjust: 100%;\n" +
                "\t\tpadding: 0;\n" +
                "\t\tmargin: 0;\n" +
                "\t\"\n" +
                ">\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\" />\n" +
                "\t<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />\n" +
                "\t<meta name=\"x-apple-disable-message-reformatting\" />\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "\t<meta content=\"telephone=no\" name=\"format-detection\" />\n" +
                "\t<title>Confirm</title>\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\t\t\ta {\n" +
                "\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t</style>\n" +
                "\t<xml>\n" +
                "\t\t<o:OfficeDocumentSettings>\n" +
                "\t\t\t<o:AllowPNG></o:AllowPNG>\n" +
                "\t\t\t<o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "\t\t</o:OfficeDocumentSettings>\n" +
                "\t</xml>\n" +
                "\t<link\n" +
                "\t\t\thref=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\"\n" +
                "\t\t\trel=\"stylesheet\"\n" +
                "\t/>\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\t\t#outlook a {\n" +
                "\t\t\t\tpadding: 0;\n" +
                "\t\t\t}\n" +
                "\t\t\t.ExternalClass {\n" +
                "\t\t\t\twidth: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t\t.ExternalClass,\n" +
                "\t\t\t.ExternalClass p,\n" +
                "\t\t\t.ExternalClass span,\n" +
                "\t\t\t.ExternalClass font,\n" +
                "\t\t\t.ExternalClass td,\n" +
                "\t\t\t.ExternalClass div {\n" +
                "\t\t\t\tline-height: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t\t.es-button {\n" +
                "\t\t\t\tmso-style-priority: 100 !important;\n" +
                "\t\t\t\ttext-decoration: none !important;\n" +
                "\t\t\t}\n" +
                "\t\t\ta[x-apple-data-detectors] {\n" +
                "\t\t\t\tcolor: inherit !important;\n" +
                "\t\t\t\ttext-decoration: none !important;\n" +
                "\t\t\t\tfont-size: inherit !important;\n" +
                "\t\t\t\tfont-family: inherit !important;\n" +
                "\t\t\t\tfont-weight: inherit !important;\n" +
                "\t\t\t\tline-height: inherit !important;\n" +
                "\t\t\t}\n" +
                "\t\t\t.es-desk-hidden {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t\tfloat: left;\n" +
                "\t\t\t\toverflow: hidden;\n" +
                "\t\t\t\twidth: 0;\n" +
                "\t\t\t\tmax-height: 0;\n" +
                "\t\t\t\tline-height: 0;\n" +
                "\t\t\t\tmso-hide: all;\n" +
                "\t\t\t}\n" +
                "\t\t\t[data-ogsb] .es-button {\n" +
                "\t\t\t\tborder-width: 0 !important;\n" +
                "\t\t\t\tpadding: 15px 25px 15px 25px !important;\n" +
                "\t\t\t}\n" +
                "\t\t\t[data-ogsb] .es-button.es-button-1 {\n" +
                "\t\t\t\tpadding: 15px 30px !important;\n" +
                "\t\t\t}\n" +
                "\t\t\t@media only screen and (max-width: 600px) {\n" +
                "\t\t\t\tp,\n" +
                "\t\t\t\tul li,\n" +
                "\t\t\t\tol li,\n" +
                "\t\t\t\ta {\n" +
                "\t\t\t\t\tline-height: 150% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th1,\n" +
                "\t\t\t\th2,\n" +
                "\t\t\t\th3,\n" +
                "\t\t\t\th1 a,\n" +
                "\t\t\t\th2 a,\n" +
                "\t\t\t\th3 a {\n" +
                "\t\t\t\t\tline-height: 120% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th1 {\n" +
                "\t\t\t\t\tfont-size: 30px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th2 {\n" +
                "\t\t\t\t\tfont-size: 26px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th3 {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h1 a,\n" +
                "\t\t\t\t.es-content-body h1 a,\n" +
                "\t\t\t\t.es-footer-body h1 a {\n" +
                "\t\t\t\t\tfont-size: 30px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h2 a,\n" +
                "\t\t\t\t.es-content-body h2 a,\n" +
                "\t\t\t\t.es-footer-body h2 a {\n" +
                "\t\t\t\t\tfont-size: 26px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h3 a,\n" +
                "\t\t\t\t.es-content-body h3 a,\n" +
                "\t\t\t\t.es-footer-body h3 a {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-menu td a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body p,\n" +
                "\t\t\t\t.es-header-body ul li,\n" +
                "\t\t\t\t.es-header-body ol li,\n" +
                "\t\t\t\t.es-header-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-content-body p,\n" +
                "\t\t\t\t.es-content-body ul li,\n" +
                "\t\t\t\t.es-content-body ol li,\n" +
                "\t\t\t\t.es-content-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-footer-body p,\n" +
                "\t\t\t\t.es-footer-body ul li,\n" +
                "\t\t\t\t.es-footer-body ol li,\n" +
                "\t\t\t\t.es-footer-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-infoblock p,\n" +
                "\t\t\t\t.es-infoblock ul li,\n" +
                "\t\t\t\t.es-infoblock ol li,\n" +
                "\t\t\t\t.es-infoblock a {\n" +
                "\t\t\t\t\tfont-size: 12px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t*[class='gmail-fix'] {\n" +
                "\t\t\t\t\tdisplay: none !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-c,\n" +
                "\t\t\t\t.es-m-txt-c h1,\n" +
                "\t\t\t\t.es-m-txt-c h2,\n" +
                "\t\t\t\t.es-m-txt-c h3 {\n" +
                "\t\t\t\t\ttext-align: center !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-r,\n" +
                "\t\t\t\t.es-m-txt-r h1,\n" +
                "\t\t\t\t.es-m-txt-r h2,\n" +
                "\t\t\t\t.es-m-txt-r h3 {\n" +
                "\t\t\t\t\ttext-align: right !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-l,\n" +
                "\t\t\t\t.es-m-txt-l h1,\n" +
                "\t\t\t\t.es-m-txt-l h2,\n" +
                "\t\t\t\t.es-m-txt-l h3 {\n" +
                "\t\t\t\t\ttext-align: left !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-r img,\n" +
                "\t\t\t\t.es-m-txt-c img,\n" +
                "\t\t\t\t.es-m-txt-l img {\n" +
                "\t\t\t\t\tdisplay: inline !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-button-border {\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ta.es-button,\n" +
                "\t\t\t\tbutton.es-button {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t\tborder-width: 15px 25px 15px 25px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-btn-fw {\n" +
                "\t\t\t\t\tborder-width: 10px 0px !important;\n" +
                "\t\t\t\t\ttext-align: center !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-adaptive table,\n" +
                "\t\t\t\t.es-btn-fw,\n" +
                "\t\t\t\t.es-btn-fw-brdr,\n" +
                "\t\t\t\t.es-left,\n" +
                "\t\t\t\t.es-right {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-content table,\n" +
                "\t\t\t\t.es-header table,\n" +
                "\t\t\t\t.es-footer table,\n" +
                "\t\t\t\t.es-content,\n" +
                "\t\t\t\t.es-footer,\n" +
                "\t\t\t\t.es-header {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t\tmax-width: 600px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-adapt-td {\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.adapt-img {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t\theight: auto !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0 {\n" +
                "\t\t\t\t\tpadding: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0r {\n" +
                "\t\t\t\t\tpadding-right: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0l {\n" +
                "\t\t\t\t\tpadding-left: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0t {\n" +
                "\t\t\t\t\tpadding-top: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0b {\n" +
                "\t\t\t\t\tpadding-bottom: 0 !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p20b {\n" +
                "\t\t\t\t\tpadding-bottom: 20px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-mobile-hidden,\n" +
                "\t\t\t\t.es-hidden {\n" +
                "\t\t\t\t\tdisplay: none !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttr.es-desk-hidden,\n" +
                "\t\t\t\ttd.es-desk-hidden,\n" +
                "\t\t\t\ttable.es-desk-hidden {\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t\toverflow: visible !important;\n" +
                "\t\t\t\t\tfloat: none !important;\n" +
                "\t\t\t\t\tmax-height: inherit !important;\n" +
                "\t\t\t\t\tline-height: inherit !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttr.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table-row !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttd.es-desk-menu-hidden {\n" +
                "\t\t\t\t\tdisplay: table-cell !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-menu td {\n" +
                "\t\t\t\t\twidth: 1% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-table-not-adapt,\n" +
                "\t\t\t\t.esd-block-html table {\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-social {\n" +
                "\t\t\t\t\tdisplay: inline-block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-social td {\n" +
                "\t\t\t\t\tdisplay: inline-block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table-row !important;\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t\toverflow: visible !important;\n" +
                "\t\t\t\t\tmax-height: inherit !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "</head>\n" +
                "<body\n" +
                "\t\tstyle=\"\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\tfont-family: lato, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "\t\t\t-webkit-text-size-adjust: 100%;\n" +
                "\t\t\t-ms-text-size-adjust: 100%;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\"\n" +
                ">\n" +
                "<div class=\"es-wrapper-color\" style=\"background-color: #f4f4f4\">\n" +
                "\t<!--[if gte mso 9]>\n" +
                "\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t<v:fill type=\"tile\" color=\"#f4f4f4\"></v:fill>\n" +
                "\t</v:background>\n" +
                "\t<![endif]-->\n" +
                "\t<table\n" +
                "\t\t\tclass=\"es-wrapper\"\n" +
                "\t\t\twidth=\"100%\"\n" +
                "\t\t\tcellspacing=\"0\"\n" +
                "\t\t\tcellpadding=\"0\"\n" +
                "\t\t\tstyle=\"\n" +
                "\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\theight: 100%;\n" +
                "\t\t\t\t\tbackground-repeat: repeat;\n" +
                "\t\t\t\t\tbackground-position: center top;\n" +
                "\t\t\t\t\"\n" +
                "\t>\n" +
                "\t\t<tr class=\"gmail-fix\" height=\"0\" style=\"border-collapse: collapse\">\n" +
                "\t\t\t<td style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t<table\n" +
                "\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t>\n" +
                "\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\tline-height: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\tmin-width: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\theight=\"0\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<img\n" +
                "\t\t\t\t\t\t\t\t\tsrc=\"https://jnsxrl.stripocdn.email/content/guids/CABINET_837dc1d79e3a5eca5eb1609bfe9fd374/images/41521605538834349.png\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tdisplay: block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\toutline: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t-ms-interpolation-mode: bicubic;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmax-height: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmin-height: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmin-width: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\talt\n" +
                "\t\t\t\t\t\t\t\t\twidth=\"600\"\n" +
                "\t\t\t\t\t\t\t\t\theight=\"1\"\n" +
                "\t\t\t\t\t\t\t/>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t<td valign=\"top\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t<table\n" +
                "\t\t\t\t\t\tclass=\"es-header\"\n" +
                "\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\tbackground-color: #ffa73b;\n" +
                "\t\t\t\t\t\t\t\tbackground-repeat: repeat;\n" +
                "\t\t\t\t\t\t\t\tbackground-position: center top;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t>\n" +
                "\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\tbgcolor=\"#424972\"\n" +
                "\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; background-color: #424972\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\tclass=\"es-header-body\"\n" +
                "\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 580px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 25px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 25px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"http://54.176.3.26/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttarget=\"_blank\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: underline;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #111111;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 14px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t><img\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"https://jnsxrl.stripocdn.email/content/guids/55bc9dde-24e9-492c-a43e-053c0686ebaf/images/logo_5_2.png\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talt\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdisplay: block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\toutline: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-interpolation-mode: bicubic;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"255\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t/></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t\t<table\n" +
                "\t\t\t\t\t\tclass=\"es-content\"\n" +
                "\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t>\n" +
                "\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; background-color: #424972\"\n" +
                "\t\t\t\t\t\t\t\tbgcolor=\"#424972\"\n" +
                "\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\tclass=\"es-content-body\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 600px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: separate;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground-color: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-radius: 4px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 35px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h1\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 58px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 48px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-style: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-weight: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #111111;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"> Hola, "+usuario+ "!\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</h1>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 1px solid #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: #ffffff none repeat\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tscroll 0% 0%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t\t<table\n" +
                "\t\t\t\t\t\tclass=\"es-content\"\n" +
                "\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t>\n" +
                "\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t<td align=\"center\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\tclass=\"es-content-body\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 600px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: separate;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-radius: 4px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground-color: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEstamos emocionados de que comiences.\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrimero, necesitas confirmar tu cuenta.\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSimplemente presione el botón de abajo.\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 35px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 35px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-button-border\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-style: solid;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-color: #ffa73b;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: #f16f42;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-width: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdisplay: inline-block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-radius: 2px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: auto;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://viewstripo.email/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-button es-button-1\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttarget=\"_blank\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-style-priority: 100 !important;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-style: solid;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-color: #f16f42;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-width: 15px 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdisplay: inline-block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: #f16f42;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-radius: 2px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: helvetica,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t'helvetica neue', arial, verdana,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-weight: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-style: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 24px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: auto;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tConfirmar Cuenta</a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></span\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSi eso no funciona, copie y pegue el\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsiguiente enlace en su navegador:\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttarget=\"_blank\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://viewstripo.email/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: underline;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #f16f42;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>XXX.XXXXXXX.XXX / XXXXXXXXXXXXX</a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSi tiene alguna pregunta, simplemente\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tresponda a este correo electrónico;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsiempre estaremos encantados de ayudarle.\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 40px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSaludos,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl equipo de Digital Booking\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t\t<table\n" +
                "\t\t\t\t\t\tclass=\"es-content\"\n" +
                "\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t>\n" +
                "\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t<td align=\"center\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\tclass=\"es-content-body\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 600px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 1px solid #f4f4f4;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: #ffffff none repeat\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tscroll 0% 0%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t</tr>\n" +
                "\t</table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        helper.setText(content, true);

        mailSender.send(message);
    }

    public void sendMailBooking(String to, String usuario, LocalDate arrival, LocalDate departure, String category, String productName, String location, String imagen) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setSubject("Digital Booking");
        helper.setFrom("correodeautenticacionctd@gmail.com");
        helper.setTo(to);

        String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html\n" +
                "\txmlns=\"http://www.w3.org/1999/xhtml\"\n" +
                "\txmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
                "\tstyle=\"\n" +
                "\t\twidth: 100%;\n" +
                "\t\tfont-family: lato, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "\t\t-webkit-text-size-adjust: 100%;\n" +
                "\t\t-ms-text-size-adjust: 100%;\n" +
                "\t\tpadding: 0;\n" +
                "\t\tmargin: 0;\n" +
                "\t\"\n" +
                ">\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\" />\n" +
                "\t\t<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />\n" +
                "\t\t<meta name=\"x-apple-disable-message-reformatting\" />\n" +
                "\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "\t\t<meta content=\"telephone=no\" name=\"format-detection\" />\n" +
                "\t\t<title>Copia de Nueva plantilla de correo electrC3B3nico 2022-06-23</title>\n" +
                "\t\t<link\n" +
                "\t\t\thref=\"https://fonts.googleapis.com/css?family=Lato:400,400i,700,700i\"\n" +
                "\t\t\trel=\"stylesheet\"\n" +
                "\t\t/>\n" +
                "\t\t<style type=\"text/css\">\n" +
                "\t\t\t#outlook a {\n" +
                "\t\t\t\tpadding: 0;\n" +
                "\t\t\t}\n" +
                "\t\t\t.ExternalClass {\n" +
                "\t\t\t\twidth: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t\t.ExternalClass,\n" +
                "\t\t\t.ExternalClass p,\n" +
                "\t\t\t.ExternalClass span,\n" +
                "\t\t\t.ExternalClass font,\n" +
                "\t\t\t.ExternalClass td,\n" +
                "\t\t\t.ExternalClass div {\n" +
                "\t\t\t\tline-height: 100%;\n" +
                "\t\t\t}\n" +
                "\t\t\t.es-button {\n" +
                "\t\t\t\tmso-style-priority: 100 !important;\n" +
                "\t\t\t\ttext-decoration: none !important;\n" +
                "\t\t\t}\n" +
                "\t\t\ta[x-apple-data-detectors] {\n" +
                "\t\t\t\tcolor: inherit !important;\n" +
                "\t\t\t\ttext-decoration: none !important;\n" +
                "\t\t\t\tfont-size: inherit !important;\n" +
                "\t\t\t\tfont-family: inherit !important;\n" +
                "\t\t\t\tfont-weight: inherit !important;\n" +
                "\t\t\t\tline-height: inherit !important;\n" +
                "\t\t\t}\n" +
                "\t\t\t.es-desk-hidden {\n" +
                "\t\t\t\tdisplay: none;\n" +
                "\t\t\t\tfloat: left;\n" +
                "\t\t\t\toverflow: hidden;\n" +
                "\t\t\t\twidth: 0;\n" +
                "\t\t\t\tmax-height: 0;\n" +
                "\t\t\t\tline-height: 0;\n" +
                "\t\t\t\tmso-hide: all;\n" +
                "\t\t\t}\n" +
                "\t\t\t[data-ogsb] .es-button {\n" +
                "\t\t\t\tborder-width: 0 !important;\n" +
                "\t\t\t\tpadding: 15px 25px 15px 25px !important;\n" +
                "\t\t\t}\n" +
                "\t\t\t@media only screen and (max-width: 600px) {\n" +
                "\t\t\t\tp,\n" +
                "\t\t\t\tul li,\n" +
                "\t\t\t\tol li,\n" +
                "\t\t\t\ta {\n" +
                "\t\t\t\t\tline-height: 150% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th1,\n" +
                "\t\t\t\th2,\n" +
                "\t\t\t\th3,\n" +
                "\t\t\t\th1 a,\n" +
                "\t\t\t\th2 a,\n" +
                "\t\t\t\th3 a {\n" +
                "\t\t\t\t\tline-height: 120% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th1 {\n" +
                "\t\t\t\t\tfont-size: 30px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th2 {\n" +
                "\t\t\t\t\tfont-size: 26px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\th3 {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h1 a,\n" +
                "\t\t\t\t.es-content-body h1 a,\n" +
                "\t\t\t\t.es-footer-body h1 a {\n" +
                "\t\t\t\t\tfont-size: 30px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h2 a,\n" +
                "\t\t\t\t.es-content-body h2 a,\n" +
                "\t\t\t\t.es-footer-body h2 a {\n" +
                "\t\t\t\t\tfont-size: 26px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body h3 a,\n" +
                "\t\t\t\t.es-content-body h3 a,\n" +
                "\t\t\t\t.es-footer-body h3 a {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-menu td a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-header-body p,\n" +
                "\t\t\t\t.es-header-body ul li,\n" +
                "\t\t\t\t.es-header-body ol li,\n" +
                "\t\t\t\t.es-header-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-content-body p,\n" +
                "\t\t\t\t.es-content-body ul li,\n" +
                "\t\t\t\t.es-content-body ol li,\n" +
                "\t\t\t\t.es-content-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-footer-body p,\n" +
                "\t\t\t\t.es-footer-body ul li,\n" +
                "\t\t\t\t.es-footer-body ol li,\n" +
                "\t\t\t\t.es-footer-body a {\n" +
                "\t\t\t\t\tfont-size: 16px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-infoblock p,\n" +
                "\t\t\t\t.es-infoblock ul li,\n" +
                "\t\t\t\t.es-infoblock ol li,\n" +
                "\t\t\t\t.es-infoblock a {\n" +
                "\t\t\t\t\tfont-size: 12px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t*[class='gmail-fix'] {\n" +
                "\t\t\t\t\tdisplay: none !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-c,\n" +
                "\t\t\t\t.es-m-txt-c h1,\n" +
                "\t\t\t\t.es-m-txt-c h2,\n" +
                "\t\t\t\t.es-m-txt-c h3 {\n" +
                "\t\t\t\t\ttext-align: center !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-r,\n" +
                "\t\t\t\t.es-m-txt-r h1,\n" +
                "\t\t\t\t.es-m-txt-r h2,\n" +
                "\t\t\t\t.es-m-txt-r h3 {\n" +
                "\t\t\t\t\ttext-align: right !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-l,\n" +
                "\t\t\t\t.es-m-txt-l h1,\n" +
                "\t\t\t\t.es-m-txt-l h2,\n" +
                "\t\t\t\t.es-m-txt-l h3 {\n" +
                "\t\t\t\t\ttext-align: left !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-txt-r img,\n" +
                "\t\t\t\t.es-m-txt-c img,\n" +
                "\t\t\t\t.es-m-txt-l img {\n" +
                "\t\t\t\t\tdisplay: inline !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-button-border {\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ta.es-button,\n" +
                "\t\t\t\tbutton.es-button {\n" +
                "\t\t\t\t\tfont-size: 20px !important;\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t\tborder-width: 15px 25px 15px 25px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-btn-fw {\n" +
                "\t\t\t\t\tborder-width: 10px 0px !important;\n" +
                "\t\t\t\t\ttext-align: center !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-adaptive table,\n" +
                "\t\t\t\t.es-btn-fw,\n" +
                "\t\t\t\t.es-btn-fw-brdr,\n" +
                "\t\t\t\t.es-left,\n" +
                "\t\t\t\t.es-right {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-content table,\n" +
                "\t\t\t\t.es-header table,\n" +
                "\t\t\t\t.es-footer table,\n" +
                "\t\t\t\t.es-content,\n" +
                "\t\t\t\t.es-footer,\n" +
                "\t\t\t\t.es-header {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t\tmax-width: 600px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-adapt-td {\n" +
                "\t\t\t\t\tdisplay: block !important;\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.adapt-img {\n" +
                "\t\t\t\t\twidth: 100% !important;\n" +
                "\t\t\t\t\theight: auto !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0 {\n" +
                "\t\t\t\t\tpadding: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0r {\n" +
                "\t\t\t\t\tpadding-right: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0l {\n" +
                "\t\t\t\t\tpadding-left: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0t {\n" +
                "\t\t\t\t\tpadding-top: 0px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p0b {\n" +
                "\t\t\t\t\tpadding-bottom: 0 !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-m-p20b {\n" +
                "\t\t\t\t\tpadding-bottom: 20px !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-mobile-hidden,\n" +
                "\t\t\t\t.es-hidden {\n" +
                "\t\t\t\t\tdisplay: none !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttr.es-desk-hidden,\n" +
                "\t\t\t\ttd.es-desk-hidden,\n" +
                "\t\t\t\ttable.es-desk-hidden {\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t\toverflow: visible !important;\n" +
                "\t\t\t\t\tfloat: none !important;\n" +
                "\t\t\t\t\tmax-height: inherit !important;\n" +
                "\t\t\t\t\tline-height: inherit !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttr.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table-row !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttd.es-desk-menu-hidden {\n" +
                "\t\t\t\t\tdisplay: table-cell !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-menu td {\n" +
                "\t\t\t\t\twidth: 1% !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-table-not-adapt,\n" +
                "\t\t\t\t.esd-block-html table {\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-social {\n" +
                "\t\t\t\t\tdisplay: inline-block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\ttable.es-social td {\n" +
                "\t\t\t\t\tdisplay: inline-block !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.es-desk-hidden {\n" +
                "\t\t\t\t\tdisplay: table-row !important;\n" +
                "\t\t\t\t\twidth: auto !important;\n" +
                "\t\t\t\t\toverflow: visible !important;\n" +
                "\t\t\t\t\tmax-height: inherit !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t.h-auto {\n" +
                "\t\t\t\t\theight: auto !important;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t</style>\n" +
                "\t</head>\n" +
                "\t<body\n" +
                "\t\tstyle=\"\n" +
                "\t\t\twidth: 100%;\n" +
                "\t\t\tfont-family: lato, 'helvetica neue', helvetica, arial, sans-serif;\n" +
                "\t\t\t-webkit-text-size-adjust: 100%;\n" +
                "\t\t\t-ms-text-size-adjust: 100%;\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t\tmargin: 0;\n" +
                "\t\t\"\n" +
                "\t>\n" +
                "\t\t<div class=\"es-wrapper-color\" style=\"background-color: #f4f4f4\">\n" +
                "\t\t\t<!--[if gte mso 9]>\n" +
                "\t\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t\t<v:fill type=\"tile\" color=\"#f4f4f4\"></v:fill>\n" +
                "\t\t\t\t</v:background>\n" +
                "\t\t\t<![endif]-->\n" +
                "\t\t\t<table\n" +
                "\t\t\t\tclass=\"es-wrapper\"\n" +
                "\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\theight: 100%;\n" +
                "\t\t\t\t\tbackground-repeat: repeat;\n" +
                "\t\t\t\t\tbackground-position: center top;\n" +
                "\t\t\t\t\"\n" +
                "\t\t\t>\n" +
                "\t\t\t\t<tr class=\"gmail-fix\" height=\"0\" style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t<td style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\tline-height: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\tmin-width: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\theight=\"0\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t<img\n" +
                "\t\t\t\t\t\t\t\t\t\tsrc=\"https://jnsxrl.stripocdn.email/content/guids/CABINET_837dc1d79e3a5eca5eb1609bfe9fd374/images/41521605538834349.png\"\n" +
                "\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tdisplay: block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\toutline: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t-ms-interpolation-mode: bicubic;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmax-height: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmin-height: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmin-width: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\talt\n" +
                "\t\t\t\t\t\t\t\t\t\twidth=\"600\"\n" +
                "\t\t\t\t\t\t\t\t\t\theight=\"1\"\n" +
                "\t\t\t\t\t\t\t\t\t/>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t<td valign=\"top\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\tclass=\"es-header\"\n" +
                "\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\tbackground-color: #ffa73b;\n" +
                "\t\t\t\t\t\t\t\tbackground-repeat: repeat;\n" +
                "\t\t\t\t\t\t\t\tbackground-position: center top;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\tbgcolor=\"#424972\"\n" +
                "\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; background-color: #424972\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\tclass=\"es-header-body\"\n" +
                "\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 580px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 25px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 25px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"http://54.176.3.26/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttarget=\"_blank\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: underline;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #111111;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 14px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t><img\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"https://jnsxrl.stripocdn.email/content/guids/55bc9dde-24e9-492c-a43e-053c0686ebaf/images/logo_5_2.png\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talt\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdisplay: block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\toutline: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-interpolation-mode: bicubic;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"255\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t/></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\tclass=\"es-content\"\n" +
                "\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\ttable-layout: fixed !important;\n" +
                "\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t<td align=\"center\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\tclass=\"es-content-body\"\n" +
                "\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\tbackground-color: transparent;\n" +
                "\t\t\t\t\t\t\t\t\t\t\twidth: 600px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style=\"padding: 0; margin: 0\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 600px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground-color: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 35px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h1\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 44px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: verdana, geneva, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 37px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-style: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-weight: normal;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #111111;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-align: center;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>¡Confirmación&nbsp;de reserva!</strong\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</h1>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalign=\"top\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0; width: 600px\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground-color: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#ffffff\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>Hola "+usuario+"</strong\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t><br />A continuación&nbsp;te dejamos los\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdetalles de la Reserva:<br /><br />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#f6b26b\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 0; margin: 0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 8px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 8px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"adapt-img\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsrc=\""+imagen+"\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talt\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdisplay: block;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\toutline: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-decoration: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-interpolation-mode: bicubic;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t/>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 15px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 15px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 15px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+category+"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 20px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>"+productName+"</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<svg\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"12\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"20\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tviewBox=\"0 0 18 26\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfill=\"none\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\txmlns=\"http://www.w3.org/2000/svg\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<path\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"fill__icon\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\td=\"M9 12.35C8.14752 12.35 7.32995 12.0076 6.72716 11.3981C6.12436 10.7886 5.78571 9.96195 5.78571 9.1C5.78571 8.23805 6.12436 7.4114 6.72716 6.8019C7.32995 6.19241 8.14752 5.85 9 5.85C9.85248 5.85 10.67 6.19241 11.2728 6.8019C11.8756 7.4114 12.2143 8.23805 12.2143 9.1C12.2143 9.5268 12.1311 9.94941 11.9696 10.3437C11.8081 10.738 11.5713 11.0963 11.2728 11.3981C10.9744 11.6999 10.62 11.9393 10.2301 12.1026C9.84008 12.2659 9.42211 12.35 9 12.35ZM9 0C6.61305 0 4.32387 0.958747 2.63604 2.66533C0.948211 4.37191 0 6.68653 0 9.1C0 15.925 9 26 9 26C9 26 18 15.925 18 9.1C18 6.68653 17.0518 4.37191 15.364 2.66533C13.6761 0.958747 11.3869 0 9 0Z\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfill=\"#545776\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></path>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t "+location+"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 2px solid #e69138;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: unset;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>Check in</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-align: right;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>"+arrival+"</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 2px solid #e69138;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: unset;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 10px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>Check out</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #666666;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttext-align: right;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>"+departure+"</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 2px solid #e69138;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: unset;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 1px solid #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: unset;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"es-m-txt-l\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"left\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbgcolor=\"#424972\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-top: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-bottom: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-left: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding-right: 30px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong>Saludos,</strong>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-webkit-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-ms-text-size-adjust: none;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-line-height-rule: exactly;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-family: lato, 'helvetica neue',\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thelvetica, arial, sans-serif;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tline-height: 27px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcolor: #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<strong\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>El equipo de Digital Booking</strong\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\talign=\"center\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 5px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfont-size: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight=\"100%\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trole=\"presentation\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-lspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmso-table-rspace: 0pt;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-collapse: collapse;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-spacing: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr style=\"border-collapse: collapse\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpadding: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tborder-bottom: 1px solid #ffffff;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbackground: unset;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\theight: 1px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\twidth: 100%;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmargin: 0px;\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t></td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t</tr>\n" +
                "\t\t\t</table>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>\n";
        helper.setText(content, true);

        mailSender.send(message);
    }

}