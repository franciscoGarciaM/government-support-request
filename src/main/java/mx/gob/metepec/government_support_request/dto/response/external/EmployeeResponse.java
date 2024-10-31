package mx.gob.metepec.government_support_request.dto.response.external;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String emailId;

    private LocalDate lastAccess;

    private UUID uuid;

    private DepartamentoResponse area; //Datos de Departamento(Area)

    private List<RoleResponse> role; //Datos de Roles

}
