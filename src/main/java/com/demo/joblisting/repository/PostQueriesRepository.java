package com.demo.joblisting.repository;

import com.demo.joblisting.model.Post;

import java.util.List;

public interface PostQueriesRepository {

    List<Post> findByText(String text);
}
