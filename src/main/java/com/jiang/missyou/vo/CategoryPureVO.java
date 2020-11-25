package com.jiang.missyou.vo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiang.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
public class CategoryPureVO {
    private Integer id;
    private String name;
    private Boolean isRoot;
    private Integer parentId;
    private String img;
    private Integer index;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }

}
