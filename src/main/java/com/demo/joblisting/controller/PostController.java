package com.demo.joblisting.controller;

import com.demo.joblisting.dto.PostDTO;
import com.demo.joblisting.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="posts")
@RequestMapping(value = "/api")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    @Operation(description = "Creates a job post")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        PostDTO savedPostDTO = postService.save(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPostDTO);
    }

    @GetMapping("/posts/{searchText}")
    @Operation(description = "Find job posts by search text")
    public ResponseEntity<List<PostDTO>> getPostsBySearchOption(
                                                        @PathVariable("searchText") String searchText) {
        List<PostDTO> postDTOPage = postService.findByText(searchText);
        return ResponseEntity.ok(postDTOPage);
    }

    @GetMapping("/posts")
    @Operation(description = "Get all a job posts paginated")
    public ResponseEntity<Page<PostDTO>> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        Page<PostDTO> postDTOPage = postService.getAll(page, size);
        return ResponseEntity.ok(postDTOPage);
    }
}
