package com.tantec.socials.anonymousstoryapi.repositories;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tantec.socials.anonymousstoryapi.beans.Story;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StoryRepository extends CrudRepository<Story, BigInteger> {

    @Override
    @Query(value = "SELECT * FROM story WHERE story_id = :id AND is_active = true",
        nativeQuery = true)    
    public abstract Optional<Story> findById(@Param("id") BigInteger id);

    @Query(value = "SELECT * FROM story WHERE author_user_id = :authorUserId AND is_active = true",
        nativeQuery = true)
    public abstract Optional<List<Story>> findByAuthorUserId(@Param("authorUserId") String authorUserId);

    @Query(value = "SELECT * FROM story WHERE category_id = :categoryId AND is_active = true",
        nativeQuery = true)
    public abstract Optional<List<Story>> findByCategoryId(@Param("categoryId") String categoryId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE story SET content = :content, last_updated_timestamp=:lastUpdatedTimestamp where story_id = :id AND is_active = true",
        nativeQuery = true)
    public abstract void updateStoryWithId(@Param("id") BigInteger id,
        @Param("lastUpdatedTimestamp") Date lastUpdatedTimestamp, @Param("content") String content);

    @Modifying
    @Transactional
    @Query(value = "UPDATE story SET is_active = false, last_updated_timestamp=:lastUpdatedTimestamp where story_id=:id",
        nativeQuery = true)
    public abstract void deActivateStoryWithId(@Param("id") BigInteger id, @Param("lastUpdatedTimestamp") Date lastUpdatedTimestamp);
    

}