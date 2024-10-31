package mx.gob.metepec.government_support_request.client;


import mx.gob.metepec.government_support_request.dto.response.external.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Component
public class EmployeeApiClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.rest.client.employees}")
    private String EMPLOYEE_BASE_URL;

    public EmployeeResponse getEmployeeByUUID(UUID employeeUuid) {
        EmployeeResponse employeeResponse = null;
        try {
            employeeResponse = restTemplate.getForObject(
                    EMPLOYEE_BASE_URL +"/"+ employeeUuid,
                    EmployeeResponse.class
            );
        } catch (HttpClientErrorException e) {
            // Manejar el error si no se encuentra el empleado
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Loguear o manejar el caso donde el cliente no se encontró
                System.out.println("Empleado no encontrado: " + employeeUuid);
            }
        }
        return employeeResponse;
    }

}
