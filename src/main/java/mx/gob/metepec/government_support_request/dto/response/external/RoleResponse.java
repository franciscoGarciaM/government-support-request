package mx.gob.metepec.government_support_request.dto.response.external;

import java.util.UUID;

public class RoleResponse {

    private String description;
    private UUID uuid;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


}
