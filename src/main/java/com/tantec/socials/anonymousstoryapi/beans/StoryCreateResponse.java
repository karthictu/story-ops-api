package com.tantec.socials.anonymousstoryapi.beans;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import com.tantec.socials.anonymousstoryapi.constants.CommonConstants;

import lombok.Getter;
import lombok.Setter;

public class StoryCreateResponse {

    @Getter
    @Setter
    @NotNull
    private BigInteger storyId;

    @Getter
    @Setter
    @NotNull
    private String message;

    public StoryCreateResponse(BigInteger id, String status) {
        super();
        this.storyId = id;
        if (status.equalsIgnoreCase(CommonConstants.STATUS_CREATED)) this.message = CommonConstants.RESPONSE_MSG_STORY_CREATED;
        else if (status.equalsIgnoreCase(CommonConstants.STATUS_FAILED)) this.message = CommonConstants.ERR_RESPONSE_MSG_STORY_MOD_FAILURE;
    }

}