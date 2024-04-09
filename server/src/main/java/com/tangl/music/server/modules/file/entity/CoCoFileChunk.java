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
 * 文件分片表
 */
@TableName(value = "coco_file_chunk")
@Data
public class CoCoFileChunk implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 分片ID
     */
    @TableId(value = "chunk_id")
    private Long chunkId;

    /**
     * 文件唯一标识
     */
    @TableField(value = "identifier", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String identifier;

    /**
     * 分片的存储路径
     */
    @TableField(value = "real_path", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String realPath;

    /**
     * 分片编号
     */
    @TableField(value = "chunk_number", updateStrategy = FieldStrategy.NOT_NULL)
    private Integer chunkNumber;

    /**
     * 过期时间
     */
    @TableField(value = "expiration_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date expirationTime;

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
