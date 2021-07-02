package com.earnest.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.model.Post;
import com.earnest.socialmedia.model.User;
import com.earnest.socialmedia.repository.PostRepository;

@Service
public class PostService {
	@Autowired
private PostRepository postRepository;	
private List<Post> posts = new ArrayList();


	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public Post getById(int id) {
		Optional<Post> postOp =postRepository.findById(id);
		if(postOp.isPresent()) {
			return postOp.get();		}
		
		return null;
	
	}
	
	public List <Post>getPosts() {
		Iterable<Post> postI=postRepository.findAll();
		List<Post> posts=new ArrayList<Post>();
		postI.forEach((post)-> posts.add(post));
		return posts;
	}
	
	public void deletePost(Post post) {
		
		if(post != null)
		postRepository.delete(post);
		
	}
	
	public void deletePostById(int id) {
		postRepository.deleteById(id);
		
	}
	
	public Post updatePostById(int id , Post post) {
		Post postToUpdate = postRepository.findById(id).get();
	
		if(postToUpdate !=null) {
			postToUpdate.setPostDate(post.getPostDate());
			postToUpdate.setUser(post.getUser());
			postToUpdate.setDetails(post.getDetails());
			postToUpdate=postRepository.save(postToUpdate);
			
		}
		return postToUpdate;
	}
	
	public Post updatePost(Post post) {
		Post postToUpdate = postRepository.findById(post.getId()).get();
		
		if(postToUpdate !=null) {
			postToUpdate.setPostDate(post.getPostDate());
			postToUpdate.setUser(post.getUser());
			postToUpdate.setDetails(post.getDetails());
			postToUpdate=postRepository.save(postToUpdate);
			
		}
		return postToUpdate;
	}
	
	
	public List<Post> getPostByUser(User user) {
		return postRepository.findPostByUser(user);
	}
	
	
}
