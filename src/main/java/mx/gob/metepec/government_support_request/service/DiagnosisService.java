package mx.gob.metepec.government_support_request.service;

import mx.gob.metepec.government_support_request.dto.request.DiagnosisRequest;
import mx.gob.metepec.government_support_request.dto.response.DiagnosisResponse;
import mx.gob.metepec.government_support_request.entity.Diagnosis;
import mx.gob.metepec.government_support_request.entity.TypeService;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;
import mx.gob.metepec.government_support_request.mapper.DiagnosisMapper;
import mx.gob.metepec.government_support_request.repository.DIagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosisService {

    @Autowired
    private DIagnosisRepository diagnosisRepository;

    //GET
    public List<DiagnosisResponse> buscarTodos(){
        return DiagnosisMapper.mapEntityListToResponseList(diagnosisRepository.findAll());
    }

    //GET X UUID
    public DiagnosisResponse getByUuid(UUID uuid){
        Diagnosis diagnosis = diagnosisRepository.findDiagnosisByUuid(uuid).orElseThrow(() -> new ResourceNotException("Type Service not exist with UUID: " + uuid));
        return DiagnosisMapper.mapEntityToResponse(diagnosis);
    }

    //POST
    public DiagnosisResponse save(DiagnosisRequest request){
        Diagnosis diagnosis = DiagnosisMapper.mapRequestToEntity(request);
        Diagnosis saved = diagnosisRepository.save(diagnosis);
        return DiagnosisMapper.mapEntityToResponse(saved);
    }

    //DELETE
    public void delete(UUID uuid){
        Diagnosis diagnosis = diagnosisRepository.findDiagnosisByUuid(uuid).orElseThrow(() -> new ResourceNotException("Type Service not exist with UUID: " + uuid));
        diagnosisRepository.delete(diagnosis);
    }
}
