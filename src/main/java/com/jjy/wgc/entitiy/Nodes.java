package com.jjy.wgc.entitiy;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 论文在第二章开篇就将路网建模为有向图 G(V, E)，其中 V 是节点的集合 。在数据库中，集合里的每一个元素（节点）都需要一个唯一的ID来区分和引用。
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
@Getter
@Setter
@ToString
@ApiModel(value = "Nodes对象", description = "论文在第二章开篇就将路网建模为有向图 G(V, E)，其中 V 是节点的集合 。在数据库中，集合里的每一个元素（节点）都需要一个唯一的ID来区分和引用。")
public class Nodes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("node_id")
    private Long nodeId;

    /**
     * Geographic location (e.g., longitude, latitude) of the node using PostGIS geometry.
     */
    @ApiModelProperty("Geographic location (e.g., longitude, latitude) of the node using PostGIS geometry.")
    private Object coordinates;

    /**
     * Type of the node, e.g., 'INTERSECTION', 'DEPOT', 'CHARGING_STATION'.
     */
    @ApiModelProperty("Type of the node, e.g., 'INTERSECTION', 'DEPOT', 'CHARGING_STATION'.")
    private String nodeType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
