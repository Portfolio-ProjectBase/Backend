package com.project.portfolio.service.contact;

import com.project.portfolio.controller.contact.request.CreateContactRequest;
import com.project.portfolio.controller.contact.request.UpdateContactRequest;
import com.project.portfolio.controller.contact.response.ContactResponse;
import com.project.portfolio.repository.contact.Contact;
import com.project.portfolio.repository.contact.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    @Override
    public void create(CreateContactRequest contactRequest) {

        contactRepository.save(toEntity(contactRequest));

    }

    @Override
    public void update(UpdateContactRequest contactRequest) {

        contactRepository.save(toEntity(contactRequest));

    }

    @Override
    public List<ContactResponse> getAll() {

        List<Contact> contactList = contactRepository.findAll();
        List<ContactResponse> responses = contactList.stream().map(Contact::toResponse).toList();
        return responses;

    }

    @Override
    public ContactResponse getById(int id) {

        return contactRepository.findById(id).orElseThrow().toResponse();

    }

    @Override
    public void delete(int id) {

        contactRepository.deleteById(id);

    }

    public Contact toEntity(CreateContactRequest contactRequest){

        return Contact.builder()
                .name(contactRequest.getName())
                .surname(contactRequest.getSurname())
                .emailAddress(contactRequest.getMailAddress())
                .message(contactRequest.getMessage())
                .build();

    }

    public Contact toEntity(UpdateContactRequest contactRequest){

        return Contact.builder()
                .id(contactRequest.getId())
                .name(contactRequest.getName())
                .surname(contactRequest.getSurname())
                .emailAddress(contactRequest.getMailAddress())
                .message(contactRequest.getMessage())
                .build();

    }
}
