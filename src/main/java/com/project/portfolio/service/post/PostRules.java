package com.project.portfolio.service.post;

import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.core.exception.AlreadyExistsException;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.repository.post.PostRepository;
import com.project.portfolio.service.BaseRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.portfolio.core.exception.type.AlreadyExistsExceptionType.POST_EXISTS;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.POST_LIST_NOT_FOUND;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.POST_NOT_FOUND;
import static com.project.portfolio.service.ImageRules.validateImage;

@Service
@RequiredArgsConstructor
public class PostRules implements BaseRules {

    private final PostRepository repository;

    public CreatePostRequest fix(CreatePostRequest request){
        request.setTitle(fixName(request.getTitle()));
        return request;
    }

    public UpdatePostRequest fix(UpdatePostRequest request){
        request.setTitle(fixName(request.getTitle()));
        return request;
    }

    public void check(CreatePostRequest request){
        isExistsByName(request.getTitle());
        validateImage(request.getImage());
    }

    public void check(UpdatePostRequest request){
        isExistsByNameAndIdNot(request.getTitle(), request.getId());
        validateImage(request.getImage());
    }

    @Override
    public void checkDataList(List<?> list) {
        if(list.isEmpty()){
            throw new DataNotFoundException(POST_LIST_NOT_FOUND);
        }
    }

    @Override
    public String fixName(String name) {
        return name;
    }

    @Override
    public void isExistsByName(String name) {

        if(repository.existsByTitle(name)){
            throw new AlreadyExistsException(POST_EXISTS);
        }
    }

    @Override
    public void isExistsByNameAndIdNot(String name, int id) {

        if (repository.existsByTitleAndIdNot(name, id)){
            throw new AlreadyExistsException(POST_EXISTS);
        }
    }

    @Override
    public void checkData(int id) {

        if(!repository.existsById(id)){
            throw new DataNotFoundException(POST_NOT_FOUND);
        }
    }


}
