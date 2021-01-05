package com.jiang.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class BannerItem  extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String keyword;
    private int type;
    private String img;
    private Long bannerId;

}
