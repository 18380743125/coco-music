package com.tangl.music.server.modules.song.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * 歌单与歌曲关联表
 */
@TableName(value = "coco_songlist_song")
@Data
public class CoCoSonglistSong implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 歌单ID
     */
    @TableField(value = "songlist_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long songlistId;

    /**
     * 歌曲ID
     */
    @TableField(value = "song_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long songId;

    /**
     * 排序值
     */
    @TableField(value = "order", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer order;
}
