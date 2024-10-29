package mx.gob.metepec.government_support_request.controllers;

import mx.gob.metepec.government_support_request.dto.request.DiagnosisRequest;
import mx.gob.metepec.government_support_request.dto.response.DiagnosisResponse;
import mx.gob.metepec.government_support_request.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    //GET
    @GetMapping("/diagnosis")
    public List<DiagnosisResponse> getAllDiagnosis() {
        return diagnosisService.buscarTodos();
    }

    @GetMapping("/diagnosis/{uuid}")
    public ResponseEntity<DiagnosisResponse> getDiagnosis(@PathVariable UUID uuid) {
        DiagnosisResponse diagnosis = diagnosisService.getByUuid(uuid);
        return ResponseEntity.ok(diagnosis);
    }

    //POST
    @PostMapping("/diagnosis")
    public ResponseEntity<DiagnosisResponse> createDiagnosis(@RequestBody DiagnosisRequest diagnosisRequest) {
        DiagnosisResponse diagnosisResponse = diagnosisService.save(diagnosisRequest);
        return ResponseEntity.ok(diagnosisResponse);
    }

    //DELETE
    @DeleteMapping("/diagnosis/{uuid}")
    public ResponseEntity<String> deleteDiagnosis(@PathVariable UUID uuid) {
        diagnosisService.delete(uuid);
        return ResponseEntity.ok("Se a eliminado el registro en la DB");
    }
}
