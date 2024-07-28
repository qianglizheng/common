package com.lzq.common.domain.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class PageQuery {
    /**
     * 当前页
     */
    private Integer pageNo;

    /**
     * 总页数
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String sortBy;

    /**
     * 是否升序
     */
    private Boolean isAsc;

    /**
     * 构建分页条件Page
     * @param items 排序规则
     * @return Page
     * @param <T> 记录类型
     */
    public <T> Page<T> toMpPage(OrderItem... items) {
        Page<T> page = Page.of(pageNo, pageSize);
        if (StringUtils.hasText(sortBy)) {
            if (isAsc) {
                page.addOrder(OrderItem.asc(sortBy));
            } else {
                page.addOrder(OrderItem.desc(sortBy));
            }
        } else if (items != null) {
            page.addOrder(items);
        }
        return page;
    }

    /**
     * 创建时间降序排序 构建分页条件Page
     * @return Page
     * @param <T> 记录类型
     */
    public <T> Page<T> toMpPageDefaultSortByCreateTimeDesc() {
        return toMpPage(OrderItem.desc("create_time"));
    }

    /**
     * 更新时间降序排序 构建分页条件Page
     * @return Page
     * @param <T> 记录类型
     */
    public <T> Page<T> toMpPageDefaultSortByUpdateTimeDesc() {
        return toMpPage(OrderItem.desc("update_time"));
    }
}
