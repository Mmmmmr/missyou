package com.jiang.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Banner extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private String img;
    private String title;

    @OneToMany
    @JoinColumn(name="bannerId")
    private List<BannerItem> items;
}
