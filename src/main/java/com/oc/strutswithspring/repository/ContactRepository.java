package com.oc.strutswithspring.repository;


import com.oc.strutswithspring.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
