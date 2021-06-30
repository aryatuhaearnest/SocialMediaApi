package com.earnest.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.earnest.socialmedia.model.Location;
import com.earnest.socialmedia.model.Post;
import com.earnest.socialmedia.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		return postService.createPost(post);
	}
	
	@GetMapping("/posts/{id}")
	public Post getById(@PathVariable("id")int id) {
		return postService.getById(id);
	}
	
	@GetMapping("/posts")
	public List<Post> getPost(@RequestBody Post post) {
		return postService.getPosts();
	}
	
	@DeleteMapping("/posts")
	public void deletePost(@RequestBody Post post) {
		postService.deletePost(post);
	}
	
	@DeleteMapping("/posts/{id}")
	public void deletePostById(@PathVariable("id") int id) {
		postService.deletePostById(id);
	}
	
	@PutMapping("/posts/{id}")
	public Post updatePostById(@PathVariable("id")int id ,@RequestBody Post post) {
		return postService.updatePostById(id, post);
	}
	
	@PutMapping("/posts")
	public Post updatePost(@RequestBody Post post) {
		return postService.updatePost(post) ;
	}
}
