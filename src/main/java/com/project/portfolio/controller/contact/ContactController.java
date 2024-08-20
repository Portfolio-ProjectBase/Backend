package com.project.portfolio.controller.contact;


import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.contact.request.CreateContactRequest;
import com.project.portfolio.controller.contact.request.UpdateContactRequest;
import com.project.portfolio.controller.contact.response.ContactResponse;
import com.project.portfolio.service.contact.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController extends BaseController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateContactRequest contactRequest){
        contactService.create(contactRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateContactRequest updateContactRequest){
        contactService.update(updateContactRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getById(@PathVariable int id){
        ContactResponse response = contactService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(){
        List<ContactResponse> responses = contactService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        contactService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
