package com.jiang.missyou.vo;

import com.jiang.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriesAllVO {
    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;

    public CategoriesAllVO(Map<Integer, List<Category>> map) {
        List<Category> roots = map.get(1);
        this.roots = roots.stream().map(CategoryPureVO::new)
        .collect(Collectors.toList());
        List<Category> subs = map.get(2);
        this.subs = subs.stream().map(CategoryPureVO::new)
                .collect(Collectors.toList());
    }
}
