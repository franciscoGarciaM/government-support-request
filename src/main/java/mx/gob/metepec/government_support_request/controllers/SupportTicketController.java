package mx.gob.metepec.government_support_request.controllers;


import mx.gob.metepec.government_support_request.dto.request.SupportTicketRequest;
import mx.gob.metepec.government_support_request.dto.response.SupportTicketResponse;
import mx.gob.metepec.government_support_request.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;

    //GET
    @GetMapping("/supportticket")
    public List<SupportTicketResponse> getSupportTicket() {
        return supportTicketService.buscarTodos();
    }

    @GetMapping("/supportticket/{uuid}")
    public ResponseEntity<SupportTicketResponse> getSupportTicketByUuid(@PathVariable UUID uuid) {
        SupportTicketResponse supportTicketResponse = supportTicketService.getByUuid(uuid);
        return ResponseEntity.ok(supportTicketResponse);
    }

    @PostMapping("/supportticket")
    public ResponseEntity<SupportTicketResponse> createSupportTicket(@RequestBody SupportTicketRequest supportTicketRequest) {
        try {
            SupportTicketResponse supportTicketResponse = supportTicketService.save(supportTicketRequest);
            return ResponseEntity.ok(supportTicketResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/supportticket/{uuid}")
    public ResponseEntity<SupportTicketResponse> updateSupportTicket(@PathVariable UUID uuid,
                                                                     @RequestBody SupportTicketRequest supportTicketRequest) {
        try {
            SupportTicketResponse supportTicketResponse = supportTicketService.update(uuid, supportTicketRequest);
            return ResponseEntity.ok(supportTicketResponse);
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/supportticket/{uuid}")
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable UUID uuid){
        try{
            supportTicketService.delete(uuid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
