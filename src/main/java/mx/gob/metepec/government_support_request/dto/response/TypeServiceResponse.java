package mx.gob.metepec.government_support_request.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TypeServiceResponse {

    private String description;
    private Integer slaHours;
    private UUID uuid;
    private Boolean active;
}
