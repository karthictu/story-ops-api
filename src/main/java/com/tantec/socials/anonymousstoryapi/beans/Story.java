package com.tantec.socials.anonymousstoryapi.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "story" ,schema = "public")
@ToString(callSuper = true, includeFieldNames = true)
public class Story implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 909218145669809237L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storyId") private BigInteger id;

    @Getter
    @Setter    
    @NotNull
    @Column(name = "authorUserId") private String authorUserId;

    @Getter
    @Setter    
    @NotNull
    @Column(name = "categoryId") private String categoryId;

    @Getter
    @Setter
    @NotNull
    @Column(name = "title") private String title;
    
    @Getter
    @NotNull
    @Column(name = "content") private String content;

    @Getter
    @Setter
    @NotNull
    @Column(name = "createdTimestamp") private Date createdTimestamp;
    
    @Getter
    @Setter
    @NotNull
    @Column(name = "lastUpdatedTimestamp") private Date lastUpdatedTimestamp;

    @Getter
    @Setter
    @NotNull
    @Column(name = "isActive") private boolean isActive;
    
    public Story() {
        super();
        this.authorUserId = "";
        this.categoryId = "";
        this.title = "";
        this.content = "";
        this.createdTimestamp = new Date();
        this.lastUpdatedTimestamp = new Date();
    }

    public void setContent(String content) throws ArrayIndexOutOfBoundsException {
        if (content.length() >  10000) {
            throw new ArrayIndexOutOfBoundsException("content exceeds permitted length restrictions");
        } else {            
            this.content = content;
        }
    }

}