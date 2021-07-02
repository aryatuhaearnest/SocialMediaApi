package com.earnest.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.earnest.socialmedia.model.Post;
import com.earnest.socialmedia.model.User;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
	
	List<Post> findPostByUser(User user);
	List<Post> findPostByUserId(int userId);
	
	@Query(nativeQuery = true , value = "SELECT * FROM posts")
	Post p();
}
