package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
            Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found with id:" + postId));

            Comment comment= new Comment();
            comment.setId(commentDto.getId());
            comment.setEmail(commentDto.getEmail());
            comment.setText(commentDto.getText());
            comment.setPost(post);

            Comment saved = commentRepository.save(comment);
            CommentDto dto=new CommentDto();
            dto.setId(saved.getId());
            dto.setEmail(saved.getEmail());
            dto.setText(saved.getText());
            return dto;

    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found for id:" + id));

        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment not found for id:" + id));
        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment savedAll = commentRepository.save(c);
        CommentDto commentDto1 = mapToDto(savedAll);
         return commentDto1;

    }
    CommentDto mapToDto(Comment comment){
        CommentDto dto1 = modelMapper.map(comment, CommentDto.class);
        return dto1;
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment dto2 = modelMapper.map(commentDto, Comment.class);
        return dto2;
    }






}
