package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.PostDto;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;
    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
       // Post post = new Post();

        Post post = mapToEntity(postDto);//the above postDto will convert into post
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        Post savePost=postRepository.save(post);

//        PostDto dto= new PostDto();
//        dto.setTitle(savePost.getTitle());
//        dto.setDescription(savePost.getDescription());
//        dto.setContent(savePost.getContent());

        //or this mapToDto method will automatically convert this entity into Dto obj

        PostDto dto = mapToDto(savePost); //the method will make the things reusable
        return dto;
    }
    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post not found with id:" +id)

        );
        PostDto dto= new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable=PageRequest.of(pageNo,pageSize,sort);

        Page<Post> pagePost = postRepository.findAll(pageable);//here i have list of post so i need to convert it into dtos, i will use stream(API)
        List<Post> posts = pagePost.getContent();//convert pagePost to list<Post>

        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);

//        PostDto dto= new PostDto();
//        dto.setId(post.getId());
//
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());

        return dto;

    }
 Post  mapToEntity(PostDto postDto){

     Post post = modelMapper.map(postDto, Post.class);

//     Post post = new Post();
//     post.setId(postDto.getId());
//
//     post.setTitle(postDto.getTitle());
//     post.setDescription(postDto.getDescription());
//     post.setContent(postDto.getContent());

        return post;
    }



}
