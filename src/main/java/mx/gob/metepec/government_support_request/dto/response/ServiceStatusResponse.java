package mx.gob.metepec.government_support_request.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class ServiceStatusResponse {

    private String nameStatus;
    private String description;
    private UUID uuid;
    private Boolean active;
    private LocalDate createdDate;
    private LocalDate updatedDate;

}
