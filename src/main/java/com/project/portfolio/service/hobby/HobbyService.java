package com.project.portfolio.service.hobby;

import com.project.portfolio.controller.hobby.request.CreateHobbyRequest;
import com.project.portfolio.controller.hobby.request.UpdateHobbyRequest;
import com.project.portfolio.controller.hobby.response.HobbyResponse;

import java.util.List;

public interface HobbyService {

    void create(CreateHobbyRequest hobbyRequest);
    void update(UpdateHobbyRequest hobbyRequest);
    List<HobbyResponse> getAll();
    HobbyResponse getById(int id);
    void delete(int id);

}
