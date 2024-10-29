package mx.gob.metepec.government_support_request.controllers;

import mx.gob.metepec.government_support_request.dto.request.TypeServiceRequest;
import mx.gob.metepec.government_support_request.dto.response.TypeServiceResponse;
import mx.gob.metepec.government_support_request.entity.TypeService;
import mx.gob.metepec.government_support_request.service.TypeServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TypeServiceController {

    @Autowired
    private TypeServiceService typeServiceService;

    //GET
    @GetMapping("/typeservice")
    public List<TypeServiceResponse> getTypeServices() {
        return typeServiceService.buscarTodos();
    }

    @GetMapping("/typeservice/{uuid}")
    public ResponseEntity<TypeServiceResponse> getTypeServiceByUuid(@PathVariable UUID uuid) {
        TypeServiceResponse typeServiceResponse = typeServiceService.getByUuid(uuid);
        return ResponseEntity.ok(typeServiceResponse);
    }

    //POST
    @PostMapping("/typeservice")
    public ResponseEntity<TypeServiceResponse> createTypeService(@RequestBody TypeServiceRequest typeServiceRequest) {
        TypeServiceResponse typeServiceResponse = typeServiceService.save(typeServiceRequest);
        return ResponseEntity.ok(typeServiceResponse);
    }
}
