package com.jiang.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Theme extends BaseEntity {
    @Id
    private Long id;

    private String title;

    private String description;

    private String name;

    private String extend;

    private String entranceImg;

    private String internalTopImg;

    private Byte online;

    private String titleImg;

    private String tplName;

}
