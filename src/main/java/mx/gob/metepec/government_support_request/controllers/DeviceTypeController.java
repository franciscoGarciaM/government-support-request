package mx.gob.metepec.government_support_request.controllers;

import mx.gob.metepec.government_support_request.dto.request.DeviceTypeRequest;
import mx.gob.metepec.government_support_request.dto.response.DeviceTypeResponse;
import mx.gob.metepec.government_support_request.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeService deviceTypeService;

    //GET
    @GetMapping("/devicetype")
    public List<DeviceTypeResponse> getAllDeviceTypes() {
        return deviceTypeService.buscarTodos();
    }

    @GetMapping("/devicetype/{uuid}")
    public ResponseEntity<DeviceTypeResponse> getDeviceTypeByUuid(@PathVariable UUID uuid) {
        DeviceTypeResponse device = deviceTypeService.getByUuid(uuid);
        return ResponseEntity.ok(device);
    }

    //POST
    @PostMapping("/devicetype")
    public ResponseEntity<DeviceTypeResponse> createDeviceType(@RequestBody DeviceTypeRequest deviceTypeRequest) {
        DeviceTypeResponse devicetype = deviceTypeService.save(deviceTypeRequest);
        return ResponseEntity.ok(devicetype);
    }

    //DELETE
    @DeleteMapping("/devicetype/{uuid}")
    public ResponseEntity<String> deleteDeviceTypeByUuid(@PathVariable UUID uuid) {
        deviceTypeService.delete(uuid);
        return ResponseEntity.ok("Se a eliminado el registro en la DB");
    }

}
