package com.NewProject.Project1.service.Impl;

import com.NewProject.Project1.entity.Post;
import com.NewProject.Project1.exception.ResourceNotFoundException;
import com.NewProject.Project1.payload.PostDto;
import com.NewProject.Project1.repository.PostRepository;
import com.NewProject.Project1.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost= postRepository.save(post);  // To save Data using  postRepository


        PostDto dto = new PostDto(); // Return PostDto
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {

        Post post =postRepository.findById(id).orElseThrow( // if record is found give me post Object
                ()->new ResourceNotFoundException("Post not found with id"+id)

        );

        // now convert post object to dto

        PostDto dto = new PostDto(); // Return PostDto
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto; // return back to id
    }
}


/* Id ko found krne ke liye 2 tarika hai
1. try to search based on Id
2.if id is not found then found through an exception
 */

// java 8 feature is Optional Class