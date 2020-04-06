package com.tantec.socials.anonymousstoryapi.constants;

public class CommonConstants {

    private CommonConstants() { }

    public static final String SYMBOLS_ASTERISK = "*";
    public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    public static final String AUTHOR_USER_ID = "authorUserId";
    public static final String STORY_ID = "storyId";
    public static final String CATEGORY_ID = "categoryId";
    public static final String OR = "or";
    public static final String NOT = "not";
    public static final String AND = "and";
    public static final String SORT_ASCENDING = "ASC";
    public static final String SORT_DESCENDING = "DESC";
    public static final String CREATED_TIMESTAMP = "createdTimeStamp";
    public static final String LAST_UPDATED_TIMESTAMP = "lastUpdatedTimeStamp";

    public static final String STATUS_CREATED = "CREATED";
    public static final String STATUS_FAILED = "FAILED";

    /**
     * Response message strings.
     */
    public static final String RESPONSE_MSG_STORY_CREATED = "Story saved successfully";

    /**
     * Error response code strings.
     */
    public static final int ERR_RESPONSE_CODE_STORY_MOD_FAILURE = 400201;

    /**
     * Error response message strings.
     */
    public static final String ERR_RESPONSE_MSG_STORY_MOD_FAILURE = "Exception occurred during modification.";
}