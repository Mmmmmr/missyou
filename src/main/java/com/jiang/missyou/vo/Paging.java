package com.jiang.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    private Long total;
    private Integer count;
    private Integer page;
    private Integer totalPage;
    private List<T> items;

    public Paging(Page<T> page) {
        this.initPageParameters(page);
        this.items = page.getContent();
    }

    void initPageParameters(Page<T> page) {
        this.total = page.getTotalElements();
        this.count = page.getSize();
        this.totalPage = page.getTotalPages();
        this.page = page.getNumber();
    }


}
