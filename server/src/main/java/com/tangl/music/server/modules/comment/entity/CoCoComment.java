package com.tangl.music.server.modules.comment.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 评论表
 */
@TableName(value = "coco_comment")
@Data
public class CoCoComment implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    @TableId(value = "comment_id")
    private Long commentId;

    /**
     * 回复ID
     */
    @TableField(value = "reply_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long replyId;

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

    /**
     * 评论内容
     */
    @TableField(value = "content", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String content;

    /**
     * 评论日期
     */
    @TableField(value = "create_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;
}