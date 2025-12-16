package com.jjy.wgc.entitiy.vo;

import com.jjy.wgc.common.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestVO {
    private long driverId;
    private Location currentLocation;
}
