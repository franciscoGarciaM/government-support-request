package mx.gob.metepec.government_support_request.mapper;

import mx.gob.metepec.government_support_request.dto.request.DiagnosisRequest;
import mx.gob.metepec.government_support_request.dto.response.DiagnosisResponse;
import mx.gob.metepec.government_support_request.entity.Diagnosis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DiagnosisMapper {

    public static Diagnosis mapRequestToEntity(DiagnosisRequest request){
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setFailure(request.getFailure());
        diagnosis.setUuid(UUID.randomUUID());
        diagnosis.setActive(true);
        diagnosis.setCreatedDate(LocalDate.now());
        diagnosis.setUpdatedDate(LocalDate.now());
        return diagnosis;
    }

    public static DiagnosisResponse mapEntityToResponse(Diagnosis diagnosis){
        DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
        diagnosisResponse.setFailure(diagnosis.getFailure());
        diagnosisResponse.setUuid(diagnosis.getUuid());
        diagnosisResponse.setActive(diagnosis.getActive());
        return diagnosisResponse;
    }

    public static List<DiagnosisResponse> mapEntityListToResponseList(List<Diagnosis> diagnosisList){
        List<DiagnosisResponse> diagnosisResponseList = new ArrayList<>();
        for(Diagnosis diagnosis: diagnosisList){
            DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
        }
        return diagnosisResponseList;
    }
}
