package mx.gob.metepec.government_support_request.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DeviceTypeRequest {

    private String nameDevice;
    private String code;
    private UUID uuid;
    private Boolean active = false;

}
