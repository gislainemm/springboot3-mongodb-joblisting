package com.demo.joblisting.service;

import com.demo.joblisting.dto.PostDTO;
import com.demo.joblisting.model.Post;
import com.demo.joblisting.repository.PostQueriesRepository;
import com.demo.joblisting.repository.PostRepository;
import com.demo.joblisting.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostQueriesRepository postQueriesRepository;

    public Page<PostDTO> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Post> postPage = postRepository.findAll(pageRequest);
        return postPage.map(PostMapper::toDTO);
    }

    public List<PostDTO> findByText(String text) {
        List<Post> posts = postQueriesRepository.findByText(text);
        return posts.stream()
                .map(PostMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PostDTO save(PostDTO postDTO) {
        Post post = PostMapper.toEntity(postDTO);
        Post savedPost = postRepository.save(post);
        return PostMapper.toDTO(savedPost);
    }

}
