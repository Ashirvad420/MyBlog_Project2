package com.NewProject.Project1.service;

import com.NewProject.Project1.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto); // return back PostDto


    PostDto getPostById(long id);
}

