package com.NewProject.Project1.controller;

import com.NewProject.Project1.payload.PostDto;
import com.NewProject.Project1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService; // this is interface this is parent of PostServiceImpl

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createDto(@RequestBody PostDto postDto) // this is method
    {
        PostDto dto=postService.createPost(postDto);
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // How to Create Get Id


    // http://localhost:8080/api/posts?id=1
    @RequestMapping
    public  ResponseEntity<PostDto> getPostById(@RequestParam long id)
    {
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}

// if the Record is found return back if Not through a message no post found for this message
// throwing  the exception not handing the exception here
/*  how do you hand an exception in Spring Boot
   1.@ControllerAdvice Class
   2. and in develop exception handler method
 */