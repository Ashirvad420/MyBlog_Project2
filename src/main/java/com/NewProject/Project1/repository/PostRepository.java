package com.NewProject.Project1.repository;

import com.NewProject.Project1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
