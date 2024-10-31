package mx.gob.metepec.government_support_request.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String emailId;

    private LocalDate lastAccess;

    private UUID uuid;

    private DepartamentoResponse area; //Datos de Departamento(Area)

    private List<RoleResponse> role; //Datos de Roles

    //Get y set Departamento(Area)
    public DepartamentoResponse getArea() {
        return area;
    }

    public void setArea(DepartamentoResponse area) {
        this.area = area;
    }

    //Get y set Role
    public List<RoleResponse> getRole() {
        return role;
    }

    public void setRole(List<RoleResponse> role) {
        this.role = role;
    }

    //Gets y sets Employee
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDate lastAccess) {
        this.lastAccess = lastAccess;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
