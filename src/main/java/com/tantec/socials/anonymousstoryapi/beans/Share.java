package com.tantec.socials.anonymousstoryapi.beans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class Share {

    @Getter
    @Setter    
    @NotNull
    private Integer shareCount;

    @Getter
    @Setter    
    @NotNull
    private List<User> sharedUsers;

    public Share() {
        super();
        this.shareCount = 0;
        this.sharedUsers = new ArrayList<User>();
    }
    
}