package com.tangl.music.server.modules.song.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * 歌曲表
 */
@TableName(value = "coco_song")
@Data
public class CoCoSong implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 歌曲ID
     */
    @TableId(value = "song_id")
    private Long songId;

    /**
     * 歌曲名称
     */
    @TableField(value = "name", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 歌手ID
     */
    @TableField(value = "artist_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer artistId;

    /**
     * 专辑ID
     */
    @TableField(value = "album_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer albumId;

    /**
     * 歌曲时长
     */
    @TableField(value = "duration", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer duration;

    /**
     * 歌曲存储路径
     */
    @TableField(value = "url", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String url;

    /**
     * 歌曲封面存储路径
     */
    @TableField(value = "cover", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String cover;
}
