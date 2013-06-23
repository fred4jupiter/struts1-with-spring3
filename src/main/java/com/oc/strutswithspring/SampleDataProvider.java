package com.oc.strutswithspring;

import com.oc.strutswithspring.domain.Contact;
import com.oc.strutswithspring.domain.Employee;
import com.oc.strutswithspring.repository.ContactRepository;
import com.oc.strutswithspring.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Populates demo data at startup to query some data at runtime.
 */
@Component
public class SampleDataProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SampleDataProvider.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void populateDemoCustomers() {
        Assert.notNull(contactRepository, "contactRepository must not be null!");
        LOG.info("populating demo contacts...");

        Employee employee1 = new Employee("John", "Doe");
        employee1.addContact(new Contact("phone1", "999-123-5678"));
        employee1.addContact(new Contact("cell", "999-345-4557"));

        employeeRepository.save(employee1);

        Employee employee2 = new Employee("Bob", "Smith");
        employee2.addContact(new Contact("phone1", "888-222-4444"));
        employee2.addContact(new Contact("mobile", "222-111-3333"));

        employeeRepository.save(employee2);

        Employee employee3 = new Employee("Sue", "Boe");
        employee3.addContact(new Contact("pager", "999-333-8888"));
        employee3.addContact(new Contact("cell", "999-111-6666"));

        employeeRepository.save(employee3);
    }
}
