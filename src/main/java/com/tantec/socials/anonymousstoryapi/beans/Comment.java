package com.tantec.socials.anonymousstoryapi.beans;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class Comment {

    @Getter
    @Setter    
    @NotNull
    private User user;

    @Getter
    @Setter    
    @NotNull
    private String comments;

    public Comment() {
        super();
        this.user = new User();
        this.comments = "";
    }
}