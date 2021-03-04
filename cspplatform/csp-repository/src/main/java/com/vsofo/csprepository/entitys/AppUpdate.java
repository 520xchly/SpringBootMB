package com.vsofo.csprepository.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * APK版本更新
 * </p>
 *
 * @author liuyan
 * @since 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 版本号
     */
    @TableField("version_code")
    @ApiModelProperty("版本号")
    private Float versionCode;

    /**
     * 版本名称
     */
    @TableField("version_name")
    private String versionName;

    /**
     * 安装包大小
     */
    @TableField("apk_size")
    private String apkSize;

    /**
     * 下载地址
     */
    @TableField("download_url")
    private String downloadUrl;

    /**
     * 是否强制更新
     */
    @TableField("is_mandatory")
    private String isMandatory;

    /**
     * 是否更新
     */
    @TableField("is_update")
    private String isUpdate;

    /**
     * 预留字段
     */
    @TableField("MD5")
    private String md5;

    /**
     * 预留字段
     */
    @TableField("value3")
    private String value3;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField("is_delete")
    private String isDelete;

    /**
     * 1代表测试版  2代表正式版
     */
    @TableField("system")
    private String system;

    @TableField("update_note")
    private String updateNote;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


}
