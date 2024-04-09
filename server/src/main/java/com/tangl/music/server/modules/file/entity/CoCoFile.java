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
 * 文件表
 */
@TableName(value = "coco_file")
@Data
public class CoCoFile implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    @TableId(value = "file_id")
    private Long fileId;

    /**
     * 文件名称
     */
    @TableField(value = "filename", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String filename;

    /**
     * 文件存储路径
     */
    @TableField(value = "real_path", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String realPath;

    /**
     * 文件实际大小
     */
    @TableField(value = "file_size", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String fileSize;

    /**
     * 文件大小展示字符
     */
    @TableField(value = "file_size_desc", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String fileSizeDesc;

    /**
     * 文件后缀
     */
    @TableField(value = "file_suffix", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String fileSuffix;

    /**
     * 文件预览的响应头Content-Type的值
     */
    @TableField(value = "file_preview_content_type", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String filePreviewContentType;

    /**
     * 文件唯一标识
     */
    @TableField(value = "identifier", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String identifier;

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
