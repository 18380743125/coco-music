package com.tangl.music.server.modules.song.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 歌单表
 */
@TableName(value = "coco_songlist")
@Data
public class CoCoSonglist implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 歌单ID
     */
    @TableId(value = "songlist_id")
    private Integer songlistId;

    /**
     * 歌单名称
     */
    @TableField(value = "name", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 用户ID
     */
    @TableField(value = "user_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long userId;

    /**
     * 歌单封面
     */
    @TableField(value = "cover", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String cover;

    /**
     * 歌单描述信息
     */
    @TableField(value = "description", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String description;

    /**
     * 可见性
     */
    @TableField(value = "visibility", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String visibility;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;
}
