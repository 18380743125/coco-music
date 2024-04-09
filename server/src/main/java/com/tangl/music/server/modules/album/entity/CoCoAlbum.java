package com.tangl.music.server.modules.album.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 专辑表
 */
@TableName(value = "coco_album")
@Data
public class CoCoAlbum implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 专辑ID
     */
    @TableId(value = "album_id")
    private Integer albumId;

    /**
     * 歌手ID
     */
    @TableField(value = "artist_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer artistId;

    /**
     * 专辑名称
     */
    @TableField(value = "name", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 描述
     */
    @TableField(value = "description", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String description;

    /**
     * 封面存储路径
     */
    @TableField(value = "cover", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String cover;

    /**
     * 发行日期
     */
    @TableField(value = "release_date", fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NOT_NULL)
    private Date releaseDate;
}
