package ua.kiev.prog.service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    @Transactional
    void addContact(Contact contact);

    @Transactional
    void addGroup(Group group);

    void deleteContacts(long[] idList);

    List<Group> findGroups();

    List<Contact> findAll(Pageable pageable);

    List<Contact> findByGroup(Group group, Pageable pageable);

    @Transactional(readOnly = true)
    long countByGroup(Group group);

    List<Contact> findByPattern(String pattern, Pageable pageable);

    @Transactional(readOnly = true)
    long count();

    Optional<Group> findGroup(long id);
}
