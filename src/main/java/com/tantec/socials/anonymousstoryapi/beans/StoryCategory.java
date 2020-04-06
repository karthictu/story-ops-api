package com.tantec.socials.anonymousstoryapi.beans;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class StoryCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id") private BigInteger _id;

    @Getter
    @Setter    
    @NotNull
    private String name;

    @Getter
    @Setter    
    @NotNull
    private String subCategory;

    public StoryCategory() {
        super();
        this.name = "";
        this.subCategory = "";
    }

}