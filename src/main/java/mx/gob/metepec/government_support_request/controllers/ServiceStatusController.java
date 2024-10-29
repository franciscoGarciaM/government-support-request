package mx.gob.metepec.government_support_request.controllers;

import mx.gob.metepec.government_support_request.dto.response.ServiceStatusResponse;
import mx.gob.metepec.government_support_request.service.ServiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ServiceStatusController {

    @Autowired
    private ServiceStatusService serviceStatusService;

    //GET
    @GetMapping("/servicestatus")
    public List<ServiceStatusResponse> getServiceStatus(){
        return serviceStatusService.buscarTodos();
    }

    @GetMapping("/servicestatus/{uuid}")
    public ResponseEntity<ServiceStatusResponse> getServiceStatusByUuid(@PathVariable UUID uuid){
        ServiceStatusResponse ssresponse = serviceStatusService.getByUuid(uuid);
        return ResponseEntity.ok(ssresponse);
    }
}
