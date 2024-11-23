package com.soardev.Cadastro_Usuario.controller;


import com.soardev.Cadastro_Usuario.entities.Client;
import com.soardev.Cadastro_Usuario.services.ClientService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = clientService.save(client);
        return ResponseEntity.ok(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> listClients(){
        List<Client> clients = clientService.listAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id){
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-email")
    public ResponseEntity<Void> sendEmail(@RequestParam String email,
                                          @RequestParam String subject,
                                          @RequestParam String message){
        try{
            clientService.sendEmail(email, subject, message);
            return ResponseEntity.ok().build();
        }catch(MessagingException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
        Client updatedClient = clientService.updateClient(id, clientDetails);
        return ResponseEntity.ok(updatedClient);
    }

}
