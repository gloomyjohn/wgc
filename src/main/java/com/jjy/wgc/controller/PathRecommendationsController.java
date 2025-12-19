package com.jjy.wgc.controller;

import com.jjy.wgc.common.Result;
import com.jjy.wgc.entitiy.PathRecommendations;
import com.jjy.wgc.entitiy.dto.PathRecommendationsDTO;
import com.jjy.wgc.entitiy.vo.PathRecommendationsVO;
import com.jjy.wgc.service.IPathRecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用于存储系统通过复杂的供需预测计算后，为每一位空闲司机生成的、以最快接到乘客为目标的个性化巡航路径。 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
@RestController
@RequestMapping("/v1/pathRecommendations")
@CrossOrigin(origins = "*")
public class PathRecommendationsController {
    @Autowired
    private IPathRecommendationsService pathRecommendationsService;

    @RequestMapping("/add")
    public Result add(PathRecommendations pathRecommendations) {
        return pathRecommendationsService.save(pathRecommendations) ? Result.success() : Result.fail();
    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        return pathRecommendationsService.removeById(id) ? Result.success() : Result.fail();
    }

    @RequestMapping("/update")
    public Result update(PathRecommendations pathRecommendations) {
        return pathRecommendationsService.updateById(pathRecommendations) ? Result.success() : Result.fail();
    }

    @RequestMapping("/query")
    public Result query(PathRecommendations pathRecommendations) {
        PathRecommendationsVO pathRecommendationsVO = new PathRecommendationsVO(
                pathRecommendations.getRecommendationId(),
                pathRecommendations.getDriverId(),
                pathRecommendations.getStartNodeId(),
                pathRecommendations.getRecommendedPath(),
                pathRecommendations.getExpectedAllocationTimeSeconds(),
                pathRecommendations.getStatus(),
                pathRecommendations.getRecommendationTime(),
                pathRecommendations.getCreatedAt(),
                pathRecommendations.getUpdatedAt()
        );
        return pathRecommendationsService.getById(pathRecommendationsVO.getRecommendationId()) != null ? Result.success(pathRecommendationsVO) : Result.fail();
    }

    @RequestMapping("/list")
    public Result list() {
        return pathRecommendationsService.list() != null ? Result.success(pathRecommendationsService.list()) : Result.fail();
    }

    // 接受包括司机id、当前位置的坐标、目的地的坐标
    @PostMapping("/getRec")
    public Result getRec(PathRecommendationsDTO pathRecommendationsDTO) {
        // 获取司机id
        Long driverId = pathRecommendationsDTO.getDriverId();
        // 获取当前位置
        String currentLocation = pathRecommendationsDTO.getCurrentLocation();
        // 获取目的地
        String destination = pathRecommendationsDTO.getDestination();
        // 获取推荐路径
        Object recommendedPath = pathRecommendationsService.getRecommendedPath(driverId, currentLocation, destination);
        return recommendedPath != null ? Result.success(recommendedPath): Result.fail();
    }
}
