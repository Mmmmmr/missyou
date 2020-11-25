package com.jiang.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Spu extends BaseEntity {
    @Id
    private int id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Integer rootCategoryId;
    private byte online;
    private String price;
    private Integer sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private Byte isTest;
    private String spuThemeImg;
    private String forThemeImg;


    @OneToMany
    @JoinColumn(name="spuId")
    private List<Sku> skuList;

    @OneToMany
    @JoinColumn(name="spuId")
    private List<SpuImg> spuImgList;

    @OneToMany
    @JoinColumn(name="spuId")
    private List<SpuDetailImg> spuDetailImgList;


}
