package com.jiang.missyou.model;

import com.jiang.missyou.util.ListAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private byte online;
    private String img;
    private String title;
    private Long spuId;
    private String code;
    private int stock;
    private Long categoryId;
    private Long rootCategoryId;

    @Convert(converter = ListAndJson.class)
    private List<Object> specs;



}
