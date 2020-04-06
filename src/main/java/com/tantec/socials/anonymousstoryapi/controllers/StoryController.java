package com.tantec.socials.anonymousstoryapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tantec.socials.anonymousstoryapi.beans.SearchQueryRequest;
import com.tantec.socials.anonymousstoryapi.beans.Story;
import com.tantec.socials.anonymousstoryapi.beans.StoryCreateRequest;
import com.tantec.socials.anonymousstoryapi.beans.StoryCreateResponse;
import com.tantec.socials.anonymousstoryapi.beans.StoryUpdateRequest;
import com.tantec.socials.anonymousstoryapi.constants.CommonConstants;
import com.tantec.socials.anonymousstoryapi.exceptions.StoryModificationException;
import com.tantec.socials.anonymousstoryapi.service.StoryService;
import com.tantec.socials.anonymousstoryapi.service.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping(path = "/api/stories")
@CrossOrigin(origins = CommonConstants.SYMBOLS_ASTERISK, allowedHeaders = CommonConstants.SYMBOLS_ASTERISK, methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
public class StoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoryController.class);

    @Autowired StoryService storyService;

    @Autowired UserServiceImpl userService;

    @GetMapping(path = "{storyId}", produces = "application/json")
    public ResponseEntity<Story> getStory(@PathVariable(name = "storyId") BigInteger storyId) {

        LOGGER.info("Start of get story");
        Story result = storyService.getStoryById(storyId);
        if (result != null)
            return new ResponseEntity<Story>(result, HttpStatus.OK);
        else
            return new ResponseEntity<Story>(result, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "search", produces = "application/json")
    public ResponseEntity<List<Story>> searchStory(@RequestBody SearchQueryRequest requestBody) {
        LOGGER.info("Start of search by user name");
        List<Story> result = null;
        // SearchQueryValidator searchReqValidator = new SearchQueryValidator();
        // if (!searchReqValidator.isRequestValid(requestBody))
        // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Map<String, String> conditions = requestBody.getFilter().get().getConditions();
        if (conditions.containsKey("authorUserId"))
            result = storyService.searchByUserId(conditions.get("authorUserId"));
        else if (conditions.containsKey("categoryId"))
            result = storyService.searchByCategoryId(conditions.get("categoryId"));

        return new ResponseEntity<List<Story>>(
            result = (result == null) ? new ArrayList<Story>() : result,
            HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StoryCreateResponse> addStory(
            @RequestHeader(required = true, name = "ACTIVE-USER-ID") String userId,
            @RequestBody StoryCreateRequest requestBody) {

        // Map<String, Object> userResponse = userService.getUserById(userId);

        // if (userResponse == null || userResponse.size() < 1) {
        // // If User Service does not return valid data
        // return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
        // }
        if (!(requestBody.validateCreateRequest())) {
            return new ResponseEntity<StoryCreateResponse>(HttpStatus.BAD_REQUEST);
        }
        Story story = new Story();

        Date currentTime = new Date();
        
        story.setAuthorUserId(userId);
        story.setTitle(requestBody.getTitle());
        story.setCategoryId(requestBody.getCategoryId());
        story.setActive(true);
        story.setContent(requestBody.getContent());
        story.setCreatedTimestamp(currentTime);
        story.setLastUpdatedTimestamp(currentTime);

        Story dbResponse = storyService.addStory(story);
        if (dbResponse != null) {
            return new ResponseEntity<StoryCreateResponse>(
                    new StoryCreateResponse(dbResponse.getId(), CommonConstants.STATUS_CREATED), HttpStatus.CREATED);
        } else {
            throw new StoryModificationException(CommonConstants.ERR_RESPONSE_MSG_STORY_MOD_FAILURE);
        }
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Map<String, Object>> updateStory(@PathVariable(name = "id") BigInteger id,
            @RequestHeader(required = true, name = "ACTIVE-USER-ID") String userId,
            @RequestBody StoryUpdateRequest requestBody) {
        if (requestBody.validateUpdateRequest()) {
            storyService.updateStory(id, requestBody.getContent());
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Map<String, Object>> deleteStory(@PathVariable(name = "id") BigInteger id,
            @RequestHeader(required = true, name = "ACTIVE-USER-ID") String userId) {
        storyService.deleteStory(id);
        return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
    }

}