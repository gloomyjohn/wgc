package com.jjy.wgc.entitiy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private Long driverId;

    private String currentStatus;

    private OffsetDateTime onboardedAt;

    private Map<String, Object> vehicleInfo;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
