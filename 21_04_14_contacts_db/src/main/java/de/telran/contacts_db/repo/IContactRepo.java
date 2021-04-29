package de.telran.contacts_db.repo;

import de.telran.contacts_db.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IContactRepo extends CrudRepository<Contact, Integer> {

/*    @Override
    Collection<Contact> findAll();*/

    Collection<Contact> findAllByName(String name);

    //TODO compose a method which will be returning all contacts whose names or lastnames contain a pattern

    Collection<Contact> findContactsByNameIsContainingIgnoreCaseOrLastNameIsContainingIgnoreCase(String patternName, String patternLastName);

/*    @Query("select c from Contact c where UPPER(c.name) like concat('%',UPPER(:pattern),'%') or UPPER(c.lastName) like concat('%',UPPER(:pattern),'%')")
    Collection<Contact> findAllContainingPattern(@Param("pattern") String pattern);*/

}