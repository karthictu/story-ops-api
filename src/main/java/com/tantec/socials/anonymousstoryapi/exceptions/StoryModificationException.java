package com.tantec.socials.anonymousstoryapi.exceptions;

public class StoryModificationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public StoryModificationException(String errMsg) {
        super(errMsg);      
    }

}