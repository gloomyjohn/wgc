package com.jjy.wgc.entitiy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathRecommendationsVO {
    // 包括driver id 和 currentLocation
    private Long driverId;
    private String currentLocation;
    private String destination;
}
