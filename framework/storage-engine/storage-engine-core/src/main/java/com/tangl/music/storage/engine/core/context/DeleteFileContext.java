package com.tangl.music.storage.engine.core.context;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 文件存储引擎删除物理文件的上下文实体
 */
@Data
public class DeleteFileContext implements Serializable {

    @Serial
    private static final long serialVersionUID = -1787715912965233754L;

    /**
     * 要删除的物理文件路径的集合
     */
    private List<String> realFilePathList;
}
