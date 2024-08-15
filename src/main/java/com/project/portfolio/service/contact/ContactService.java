package com.project.portfolio.service.contact;

import com.project.portfolio.controller.contact.request.CreateContactRequest;
import com.project.portfolio.controller.contact.request.UpdateContactRequest;
import com.project.portfolio.controller.contact.response.ContactResponse;

import java.util.List;

public interface ContactService {

    void create(CreateContactRequest contactRequest);
    void update(UpdateContactRequest contactRequest);
    List<ContactResponse> getAll();
    ContactResponse getById(int id);
    void delete(int id);
}
