package mx.gob.metepec.government_support_request.mapper;

import mx.gob.metepec.government_support_request.dto.request.DeviceTypeRequest;
import mx.gob.metepec.government_support_request.dto.response.DeviceTypeResponse;
import mx.gob.metepec.government_support_request.entity.DeviceType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeviceTypeMapper {

    public static DeviceType mapRequestToEntity(DeviceTypeRequest request) {
        DeviceType deviceType = new DeviceType();
        deviceType.setNameDevice(request.getNameDevice());
        deviceType.setCode(request.getCode());
        deviceType.setUuid(UUID.randomUUID());
        deviceType.setActive(true);
        deviceType.setCreatedDate(LocalDate.now());
        deviceType.setUpdatedDate(LocalDate.now());
        return deviceType;
    }

    public static DeviceTypeResponse mapEntityToResponse(DeviceType deviceType) {
        DeviceTypeResponse response = new DeviceTypeResponse();
        response.setNameDevice(deviceType.getNameDevice());
        response.setCode(deviceType.getCode());
        response.setUuid(deviceType.getUuid());
        response.setActive(deviceType.getActive());
        return response;
    }

    public static List<DeviceTypeResponse> mapEntityListToResponseList(List<DeviceType> deviceTypes) {
        List<DeviceTypeResponse> responseList = new ArrayList<>();
        for (DeviceType deviceType : deviceTypes) {
            DeviceTypeResponse response = new DeviceTypeResponse();
        }
        return responseList;
    }
}
