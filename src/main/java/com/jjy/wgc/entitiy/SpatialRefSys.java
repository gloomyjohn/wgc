package com.jjy.wgc.entitiy;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2025-12-11
 */
@Getter
@Setter
@ToString
@TableName("spatial_ref_sys")
@ApiModel(value = "SpatialRefSys对象", description = "")
public class SpatialRefSys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("srid")
    private Integer srid;

    private String authName;

    private Integer authSrid;

    private String srtext;

    private String proj4text;
}
