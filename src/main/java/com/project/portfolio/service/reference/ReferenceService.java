package com.project.portfolio.service.reference;

import com.project.portfolio.controller.reference.request.CreateReferenceRequest;
import com.project.portfolio.controller.reference.request.UpdateReferenceRequest;
import com.project.portfolio.controller.reference.response.ReferenceResponse;

import java.util.List;

public interface ReferenceService {
    void create(CreateReferenceRequest createReferenceRequest);

    void update(UpdateReferenceRequest updateReferenceRequest);
    List<ReferenceResponse> getAll();
    ReferenceResponse getById(int id);
    void delete(int id);
}
