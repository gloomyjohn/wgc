package com.jjy.wgc.listener;

import com.jjy.wgc.entitiy.po.DriverStatusLocations;
import com.jjy.wgc.entitiy.dto.DriverLocationDTO;
import com.jjy.wgc.service.IDriverStatusLocationsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverLocationConsumer {
    @Autowired
    private IDriverStatusLocationsService driverStatusLocationsService;

    @RabbitListener(queues = "driver.track.queue")
    public void handleLocationDTO(DriverLocationDTO driverLocationDTO) {
        System.out.println("📦 [RabbitMQ] 收到位置消息: " + driverLocationDTO.getDriverId());
        // 构造一个DriverStatusLocations对象
        DriverStatusLocations driverStatusLocations = new DriverStatusLocations();
        driverStatusLocations.setDriverId(driverLocationDTO.getDriverId());
        driverStatusLocations.setLatitude(driverLocationDTO.getLatitude());
        driverStatusLocations.setLongitude(driverLocationDTO.getLongitude());
        driverStatusLocationsService.save(driverStatusLocations);
    }

}
