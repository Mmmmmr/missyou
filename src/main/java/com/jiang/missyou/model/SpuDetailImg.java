package com.jiang.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
public class SpuDetailImg extends BaseEntity {
    @Id
    private int id;
    private String img;
    private int spuId;
    private int index;


}
