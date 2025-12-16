package com.jjy.wgc.controller;

import com.jjy.wgc.common.Result;
import com.jjy.wgc.entitiy.Drivers;
import com.jjy.wgc.entitiy.dto.DriverDto;
import com.jjy.wgc.service.IDriversService;
import com.jjy.wgc.service.impl.DriversServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.sql.SQLOutput;

/**
 * <p>
 * 这张表用于存储系统中每一个运营司机的核心静态信息。在WGC模型中，司机是接受路径推荐和执行运输任务的核心实体。 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
@RestController
@RequestMapping("/v1/drivers")
@CrossOrigin(origins = "*")
public class DriversController {

    @Autowired
    private IDriversService driversService;

    // driver增删查改
    @PostMapping("/add")
    public Result add(Drivers drivers) {
        if (drivers.getDriverId() == null)
            return Result.fail();
        return driversService.save(drivers) ? Result.success() : Result.fail();
    }
    @DeleteMapping("/delete")
    public Result delete(Integer id) {
        return driversService.removeById(id) ? Result.success() : Result.fail();
    }
    @PostMapping("/update")
    public Result update(@RequestBody Drivers drivers) {
        System.out.println(drivers.getDriverId());
        try {
            // 若table中没有数据
            if (driversService.getById(drivers.getDriverId()) == null)
                return Result.fail("No such driver./n");
            boolean result = driversService.updateById(drivers);
            return result ? Result.success() : Result.fail("update faild.\n");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("更新异常：" + e.getMessage());
        }
    }


    @PostMapping("/query")
    public Result query(Drivers drivers) {
        DriverDto driverDto = new DriverDto(drivers.getDriverId(), drivers.getCurrentStatus(), drivers.getOnboardedAt(), drivers.getVehicleInfo(), drivers.getCreatedAt(), drivers.getUpdatedAt());
        return driversService.getById(driverDto.getDriverId()) != null ? Result.success(driverDto) : Result.fail();
    }

    @GetMapping("/list")
    public Result list() {
        return driversService.list() != null ? Result.success(driversService.list()) : Result.fail();
    }
}
