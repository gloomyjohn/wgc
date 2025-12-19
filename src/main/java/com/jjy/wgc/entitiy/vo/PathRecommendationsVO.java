package com.jjy.wgc.entitiy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathRecommendationsVO {
    private Long recommendationId;

    private Long driverId;

    private Long startNodeId;

    private Object recommendedPath;

    private Double expectedAllocationTimeSeconds;

    private String status;

    private LocalDateTime recommendationTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
