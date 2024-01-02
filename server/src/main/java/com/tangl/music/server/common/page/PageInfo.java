package com.tangl.music.server.common.page;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author tangl
 * @description 分页信息
 * @create 2023-12-15 11:42
 */
@Schema(name = "分页入参实体")
@Data
public class PageInfo {

    @Schema(title = "当前页号", name = "pageNo", example = "1")
    @NotNull(message = "页号不能为空")
    private Integer pageNo;

    @Schema(title = "页面大小", name = "pageSize", nullable = true, example = "20")
    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return 20;
        }
        return pageSize;
    }
}
