package com.tangl.music.server.modules.song.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * 播放列表与歌曲关联表
 */
@TableName(value = "coco_playlist_song")
@Data
public class CoCoPlaylistSong implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 播放列表ID
     */
    @TableField(value = "playlist_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long playlistId;

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