package com.tantec.socials.anonymousstoryapi.beans;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class StoryCreateRequest {

    @Getter
    @Setter
    @NotNull
    private String categoryId;

    @Getter
    @Setter
    @NotNull
    private String title;

    @Getter
    @Setter
    @NotNull
    private String content;

    public StoryCreateRequest() {
        super();
        this.categoryId = "";
        this.title = "";
        this.content = "";
    }

    public boolean validateCreateRequest() {
        if (this.getCategoryId() !=null && !this.getCategoryId().isBlank()
                && this.getTitle() !=null && !this.getTitle().isBlank()
                && this.getContent() !=null && !this.getContent().isBlank() && this.getContent().length() < 10000) {
                    return true;                    
        } else {
            return false;
        }
    }

}