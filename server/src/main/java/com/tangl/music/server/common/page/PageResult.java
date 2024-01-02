package com.tangl.music.server.common.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author tangl
 * @description 分页返回实体
 * @create 2023-12-15 11:46
 */
@Schema(name = "分页查询响应实体")
@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -1098515362006463762L;

    @Schema(title = "当前页号", name = "pageNo", example = "1")
    private Integer pageNo = 1;

    @Schema(title = "页面大小", name = "pageSize", example = "20")
    private Integer pageSize = 20;

    @Schema(title = "偏移行数", name = "offset", example = "0")
    private Integer offset = 0;

    @Schema(title = "总记录条数", name = "total", example = "100")
    private Integer total = 0;

    @Schema(title = "总页数", name = "totalPages", example = "8")
    private Integer totalPages = 0;

    @Schema(title = "开始位置", name = "start", example = "1")
    private Integer start = 0;

    @Schema(title = "结束位置", name = "end", example = "8")
    private Integer end = 0;

    @Schema(title = "列表数据", name = "result", example = "[]")
    private List<T> list = Collections.emptyList();

    public void setRecords(List<T> result) {
        this.list = result;
    }

    public void setTotal(Integer totalCount) {
        this.total = totalCount;
        if (this.pageSize > 0) {
            this.totalPages = (totalCount / this.pageSize) + (totalCount % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0;
        }
        if (totalCount != 0) {
            this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
            this.end = this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0);
        }
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
        this.setOffset();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.setOffset();
    }

    public void setOffset() {
        this.offset = (this.pageNo - 1) * this.pageSize;
    }
}
