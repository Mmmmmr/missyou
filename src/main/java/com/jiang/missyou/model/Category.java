package com.jiang.missyou.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online = 1")
public class Category extends BaseEntity {

    @Id
    private Integer id;

    private String name;

    private String description;

    private Boolean isRoot;

    private Integer parentId;

    private String img;

    private Integer index;

}