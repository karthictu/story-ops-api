package com.tantec.socials.anonymousstoryapi.beans;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class StoryUpdateRequest {

    @Getter
    @Setter
    @NotNull
    private String content;

    public StoryUpdateRequest() {
        this.content = "";
    }

    public boolean validateUpdateRequest() {
        if (this.content != null && !this.content.isBlank() && this.content.length() < 10000) return true;
        else return false;
    }
}