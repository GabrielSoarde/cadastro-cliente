package com.soardev.Cadastro_Usuario.services;


import com.soardev.Cadastro_Usuario.entities.Client;
import com.soardev.Cadastro_Usuario.repositories.ClientRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> listAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public void sendEmail(String email, String subject, String message) throws MessagingException{
        var mimeMessage = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(message, true);

        mailSender.send(mimeMessage);
    }

}
