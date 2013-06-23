package com.oc.strutswithspring.repository;

import com.oc.strutswithspring.AbstractTestingBase;
import com.oc.strutswithspring.domain.Contact;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class ContactRepositoryTest extends AbstractTestingBase {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void insertContactAndCheckIfPersisted() {
        assertNotNull(contactRepository);
        Contact contact = new Contact("fred", "123456");
        contact = contactRepository.saveAndFlush(contact);

        assertNotNull(contact);
        assertNotNull(contact.getId());

        Contact foundContact = contactRepository.findOne(contact.getId());
        assertNotNull(foundContact);
        assertThat(foundContact, equalTo(contact));
    }

}
