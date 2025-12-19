package com.jjy.wgc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jjy.wgc.entitiy.PathRecommendations;
import com.jjy.wgc.entitiy.vo.PathRecommendationsVO;

import java.util.List;

/**
 * <p>
 * 用于存储系统通过复杂的供需预测计算后，为每一位空闲司机生成的、以最快接到乘客为目标的个性化巡航路径。 服务类
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
public interface IPathRecommendationsService extends IService<PathRecommendations> {

    PathRecommendationsVO getRecommendedPath(double[] driverLocation, double[] passengerLocation);
}
