package com.DevLaps.org.EmailService.Services;

import com.DevLaps.org.EmailService.Models.InvoiceEntity;
import com.DevLaps.org.EmailService.Models.Project;
import com.DevLaps.org.EmailService.Repositories.ProjectRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    public final JavaMailSender javaMailSender;
    public final TemplateEngine templateEngine;
    public static final String UTF_8_ENCODING = "UTF-8";
    public static final String EMAIL_TEMPLATE = "newProject";
    public static final String TEXT_HTML_ENCONDING = "text/html";

    String NEW_USER_ACCOUNT_VERIFICATION = "Your new Project with DevLaps";

    @Value("${spring.mail.verify.host}")
    private String host;

    @Override
    @Async
    public void sendHtmlNewProjectEmail(String email, String owner, String project, String projectType) {
        try {
            Context context = new Context();

            context.setVariables(Map.of( "owner", owner));
            String text = templateEngine.process(EMAIL_TEMPLATE, context);
            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            String fromEmail = "panditmckenzie@gmail.com";
            helper.setFrom(fromEmail);
            helper.setTo(email);
            helper.setText(text, true);
            //Add attachments (Optional)
            /*FileSystemResource fort = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/fort.jpg"));
            FileSystemResource dog = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/dog.jpg"));
            FileSystemResource homework = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/homework.docx"));
            helper.addAttachment(fort.getFilename(), fort);
            helper.addAttachment(dog.getFilename(), dog);
            helper.addAttachment(homework.getFilename(), homework);*/
            javaMailSender.send(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void sendQuickBillEmail(String email, String billing_to, String purpose, String bill, String url) {
        try {
            Context context = new Context();

            context.setVariables(Map.of( "billed_to", billing_to, "bill", bill,"url", url));
            String text = templateEngine.process("quickbill", context);
            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
            helper.setSubject("Upcoming Bill");
            String fromEmail = "pandit.alabi@devlaps.co";
            helper.setFrom(fromEmail);
            helper.setTo(email);
            helper.setText(text, true);
            //Add attachments (Optional)
            /*FileSystemResource fort = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/fort.jpg"));
            FileSystemResource dog = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/dog.jpg"));
            FileSystemResource homework = new FileSystemResource(new File(System.getProperty("user.home") + "/Downloads/images/homework.docx"));
            helper.addAttachment(fort.getFilename(), fort);
            helper.addAttachment(dog.getFilename(), dog);
            helper.addAttachment(homework.getFilename(), homework);*/
            javaMailSender.send(message);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }
    }

    private MimeMessage getMimeMessage() {
        return javaMailSender.createMimeMessage();
    }

    private String getContentId(String filename) {
        return "<" + filename + ">";
    }
}


