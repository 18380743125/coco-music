package com.tangl.music.server.modules.artist.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 歌手表
 */
@TableName(value ="coco_artist")
@Data
public class CoCoArtist implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 歌手ID
     */
    @TableId(value = "artist_id")
    private Integer artistId;

    /**
     * 歌手的艺名或姓名
     */
    @TableField(value = "name", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 出生日期
     */
    @TableField(value = "birth_date", updateStrategy = FieldStrategy.NOT_NULL)
    private Date birthDate;

    /**
     * 国籍
     */
    @TableField(value = "nationality", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String nationality;

    /**
     * 性别（0 - 男，1 - 女，2 - 未知）
     */
    @TableField(value = "gender", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String gender;

    /**
     * 职业
     */
    @TableField(value = "occupation", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String occupation;

    /**
     * 歌手头像
     */
    @TableField(value = "photo", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String photo;

    /**
     * 歌手介绍信息
     */
    @TableField(value = "description", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String description;
}