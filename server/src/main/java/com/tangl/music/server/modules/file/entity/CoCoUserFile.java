package com.tangl.music.server.modules.file.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户与文件关联表
 */
@TableName(value = "coco_user_file")
@Data
public class CoCoUserFile implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    @TableId(value = "file_id")
    private Long fileId;

    /**
     * 用户ID
     */
    @TableField(value = "user_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long userId;

    /**
     * 真实文件ID
     */
    @TableField(value = "real_file_id", updateStrategy = FieldStrategy.NOT_NULL)
    private Long realFileId;

    /**
     * 文件名称
     */
    @TableField(value = "filename", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String filename;

    /**
     * 文件大小展示字符
     */
    @TableField(value = "file_size_desc", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String fileSizeDesc;

    /**
     * 文件类型（1 普通文件 2 压缩文件 3 excel 4 word 5 pdf 6 txt 7 图片 8 音频 9 视频 10 ppt 11 源码文件 12 csv）
     */
    @TableField(value = "file_type", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer fileType;

    /**
     * 删除标识（0 正常 1 删除）
     */
    @TableField(value = "del_flag", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String delFlag;

    /**
     * 创建人
     */
    @TableField(value = "create_by", updateStrategy = FieldStrategy.NOT_NULL)
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;
}
