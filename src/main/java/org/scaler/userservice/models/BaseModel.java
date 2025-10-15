package org.scaler.userservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdAt;
    private Date lastModifiedAt;
    private Boolean isDeleted;
}

/*
4 ways of representing inheritance in Database
1. MappedSuperClass
2. joinedTable
3.Table per class
4.singleTable
 */