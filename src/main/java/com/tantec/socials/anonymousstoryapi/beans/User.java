package com.tantec.socials.anonymousstoryapi.beans;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7972472393408697671L;

    @Getter
    @Setter    
    @NotNull
    private String userName;

    @Getter
    @Setter    
    @NotNull
    private String fullName;

    @Getter
    @Setter    
    @NotNull
    private String emailId;

    public User() {
        super();
        this.userName = "";
        this.fullName = "";
        this.emailId = "";
    }
}