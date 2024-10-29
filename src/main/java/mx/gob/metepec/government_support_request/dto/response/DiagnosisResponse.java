package mx.gob.metepec.government_support_request.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DiagnosisResponse {

    private String failure;
    private UUID uuid;
    private Boolean active;
}
