package mx.gob.metepec.government_support_request.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class DeviceTypeResponse {

    private String nameDevice;
    private String code;
    private UUID uuid;
    private Boolean active = false;
}
