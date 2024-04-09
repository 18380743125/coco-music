package com.tangl.music.server.modules.lyric.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 歌词表
 */
@TableName(value = "coco_lyric")
@Data
public class CoCoLyric implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 歌词ID
     */
    @TableId(value = "lyric_id")
    private Long lyricId;

    /**
     * 歌曲ID
     */
    @TableField(value = "song_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long songId;

    /**
     * 歌曲内容
     */
    @TableField(value = "content", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;
}