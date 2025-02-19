package com.demo.joblisting.mapper;

import com.demo.joblisting.dto.PostDTO;
import com.demo.joblisting.model.Post;

public class PostMapper {

    // Converts PostDTO to Post (Entity)
    public static Post toEntity(PostDTO postDTO) {
        if (postDTO == null) {
            return null;
        }

        Post post = new Post();
        post.setProfile(postDTO.getProfile());
        post.setDesc(postDTO.getDescription());
        post.setExp(postDTO.getExperience());
        post.setTechs(postDTO.getTechs());

        return post;
    }

    // Convert Post (Entity) to PostDTO
    public static PostDTO toDTO(Post post) {
        if (post == null) {
            return null;
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setProfile(post.getProfile());
        postDTO.setDescription(post.getDesc());
        postDTO.setExperience(post.getExp());
        postDTO.setTechs(post.getTechs());

        return postDTO;
    }
}
