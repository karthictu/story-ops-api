package com.tantec.socials.anonymousstoryapi.beans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class StoryReactions {

    @Getter
    @Setter    
    @NotNull
    private Integer likeCount;

    @Getter
    @Setter    
    @NotNull
    private List<Comment> comments;

    @Getter
    @Setter    
    @NotNull
    private Share shares;

    public StoryReactions() {
        super();
        this.likeCount = 0;
        this.comments = new ArrayList<Comment>();
        this.shares = new Share();
    }
}