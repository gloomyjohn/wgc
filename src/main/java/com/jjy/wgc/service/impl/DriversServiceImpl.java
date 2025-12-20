package com.jjy.wgc.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jjy.wgc.config.RabbitConfig;
import com.jjy.wgc.entitiy.po.Drivers;
import com.jjy.wgc.entitiy.dto.DriverLocationDTO;
import com.jjy.wgc.mapper.DriversMapper;
import com.jjy.wgc.service.IDriversService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * <p>
 * 这张表用于存储系统中每一个运营司机的核心静态信息。在WGC模型中，司机是接受路径推荐和执行运输任务的核心实体。 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
@Service
public class DriversServiceImpl extends ServiceImpl<DriversMapper, Drivers> implements IDriversService {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean saveBatch(Collection<Drivers> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Drivers> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return super.removeBatchByIds(list);
    }

    @Override
    public boolean updateBatchById(Collection<Drivers> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public boolean save(Drivers entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean removeById(Drivers entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<Drivers> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    public boolean removeByIds(Collection<?> list) {
        return super.removeByIds(list);
    }

    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return super.removeByIds(list, useFill);
    }

    @Override
    public boolean updateById(Drivers entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<Drivers> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    public boolean update(Drivers entity, Wrapper<Drivers> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public Drivers getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public Optional<Drivers> getOptById(Serializable id) {
        return super.getOptById(id);
    }

    @Override
    public List<Drivers> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public List<Drivers> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    public Drivers getOne(Wrapper<Drivers> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public Optional<Drivers> getOneOpt(Wrapper<Drivers> queryWrapper) {
        return super.getOneOpt(queryWrapper);
    }

    @Override
    public boolean exists(Wrapper<Drivers> queryWrapper) {
        return super.exists(queryWrapper);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long count(Wrapper<Drivers> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public List<Drivers> list(Wrapper<Drivers> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public List<Drivers> list(IPage<Drivers> page, Wrapper<Drivers> queryWrapper) {
        return super.list(page, queryWrapper);
    }

    @Override
    public List<Drivers> list() {
        return super.list();
    }

    @Override
    public List<Drivers> list(IPage<Drivers> page) {
        return super.list(page);
    }

    @Override
    public <E extends IPage<Drivers>> E page(E page, Wrapper<Drivers> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Drivers>> E page(E page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Drivers> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(IPage<? extends Map<String, Object>> page, Wrapper<Drivers> queryWrapper) {
        return super.listMaps(page, queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Map<String, Object>> listMaps(IPage<? extends Map<String, Object>> page) {
        return super.listMaps(page);
    }

    @Override
    public <E> List<E> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public <E> List<E> listObjs(Wrapper<Drivers> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Drivers> queryWrapper, Function<? super Object, V> mapper) {
        return super.listObjs(queryWrapper, mapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<Drivers> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<Drivers> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<Drivers> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public LambdaQueryChainWrapper<Drivers> lambdaQuery(Drivers entity) {
        return super.lambdaQuery(entity);
    }

    @Override
    public KtQueryChainWrapper<Drivers> ktQuery() {
        return super.ktQuery();
    }

    @Override
    public KtUpdateChainWrapper<Drivers> ktUpdate() {
        return super.ktUpdate();
    }

    @Override
    public UpdateChainWrapper<Drivers> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<Drivers> lambdaUpdate() {
        return super.lambdaUpdate();
    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 更新司机位置 此为producer
    @Override
    public boolean updateLocation(DriverLocationDTO driverLocationDTO) {
        try {// 存入redis
            redisTemplate.opsForGeo().add("drivers:locations", new Point(driverLocationDTO.getLongitude(), driverLocationDTO.getLatitude()), driverLocationDTO.getDriverId());
            // 发送消息给rabbitmq
            System.out.println("📦 [RabbitMQ] 发送位置消息: " + driverLocationDTO.getDriverId());
            rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, driverLocationDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
