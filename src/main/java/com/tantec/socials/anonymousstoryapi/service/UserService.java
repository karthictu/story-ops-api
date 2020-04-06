package com.tantec.socials.anonymousstoryapi.service;

import java.util.Map;

public interface UserService {
    
    public abstract Map<String, Object> getUserById(String userId);
    
}