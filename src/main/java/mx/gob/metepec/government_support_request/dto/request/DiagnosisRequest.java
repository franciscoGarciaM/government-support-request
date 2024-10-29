package mx.gob.metepec.government_support_request.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DiagnosisRequest {

    private String failure;
    private UUID uuid;
    private Boolean active;
    private LocalDate createdDate;
    private LocalDate updatedDate;

}
