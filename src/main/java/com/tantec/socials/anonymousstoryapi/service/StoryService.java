package com.tantec.socials.anonymousstoryapi.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.tantec.socials.anonymousstoryapi.beans.Story;
import com.tantec.socials.anonymousstoryapi.repositories.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {

    @Autowired StoryRepository storyRepository;

    public List<Story> searchByUserId(String userId) {
        var response = storyRepository.findByAuthorUserId(userId);
        if (response.isPresent()) {
            return response.get();
        } else {
            return null;
        }
    }

    public List<Story> searchByCategoryId(String categoryId) {
        var response = storyRepository.findByCategoryId(categoryId);
        if (response.isPresent()) {
            return response.get();
        } else {
            return null;
        }
    }

    public Story addStory(Story story) {
        try {
            return storyRepository.save(story);
        } catch (Exception e) {
            return null;
        }
    }

    public void updateStory(BigInteger storyId, String content) {
        try {
            System.out.println("content: " + content);
            storyRepository.updateStoryWithId(storyId, new Date(), content);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return;
        }
    }

    public Story getStoryById(BigInteger storyId) {
        var response = storyRepository.findById(storyId);
        if (response.isPresent()) {
            return response.get();
        } else {
            return null;
        }
    }

    public void deleteStory(Story story) {
        storyRepository.delete(story);
    }
    
    public void deleteStory(BigInteger storyId) {
        storyRepository.deActivateStoryWithId(storyId, new Date());
    }

}