package com.tangl.music.server.modules.favorite.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * 歌曲收藏表
 */
@TableName(value = "coco_favorite")
@Data
public class CoCoFavorite implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 收藏ID
     */
    @TableId(value = "favorite_id")
    private Long favoriteId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long userId;

    /**
     * 歌曲ID
     */
    @TableField(value = "song_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long songId;
}