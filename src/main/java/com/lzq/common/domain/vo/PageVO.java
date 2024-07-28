package com.lzq.common.domain.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PageVO<T> {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 记录集合
     */
    private List<T> records;

    /**
     * 返回封装好的PageVO
     *
     * @param page  分页Page
     * @param clazz 要转换的VO字节码文件
     * @param <PO>  数据表po
     * @param <VO>  返回数据vo
     * @return PageVO
     */
    public static <PO, VO> PageVO<VO> of(Page<PO> page, Class<VO> clazz) {
        PageVO<VO> vo = new PageVO<>();

        vo.setTotal(page.getTotal());
        vo.setPages(page.getPages());
        List<PO> records = page.getRecords();

        if (records.isEmpty()) {
            vo.setRecords(Collections.emptyList());
        }

        vo.setRecords(Collections.emptyList());
        return vo;
    }
}
