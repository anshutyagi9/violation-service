package com.continental.violations.service;

import com.continental.violations.model.VehicleIdRequest;
import com.continental.violations.model.Violation;
import com.continental.violations.repository.OwnerRepository;
import com.continental.violations.repository.ViolationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class ViolationService {

    private static final Logger logger= LoggerFactory.getLogger(ViolationService.class);

    @Autowired
    ViolationRepository violationRepository;

    @Autowired
    OwnerRepository ownerRepository;

    public void createViolation(Violation violation) {
        violationRepository.save(violation);
        emailSend(violation, ownerRepository.findEmailId(violation.getVehicleNumber()));
    }

    public List<Violation> getViolations(VehicleIdRequest vehicleIdRequest){
       return violationRepository.getViolationsByVehicleNumber(vehicleIdRequest.getVehicleIds());
    }

    private void emailSend(Violation violation, String emailAddress) {

        String from = "traffic.authorities@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "Team@1234");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            message.setSubject("Traffic Violation");
            message.setText("You have violated the traffic rules by "+violation.getViolationType() + " the vehicle no:" +violation.getVehicleNumber()+". " +
                    "Kindly fill the the penalty of Rs."+violation.getPenaltyAmount() + " on our official website https://parivahan.gov.in");
            Transport.send(message);
            logger.info("message successfully sent");
        } catch (MessagingException mex) {
            logger.error("Error occurred while sending the message");
        }

    }
}
