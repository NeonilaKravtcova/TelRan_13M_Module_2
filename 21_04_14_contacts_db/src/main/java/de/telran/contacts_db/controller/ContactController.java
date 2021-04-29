package de.telran.contacts_db.controller;

import de.telran.contacts_db.dto.SearchFormDto;
import de.telran.contacts_db.entity.Contact;
import de.telran.contacts_db.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * The endpoint should return the page containing the list of contacts
     *
     * @return
     */
    @GetMapping("/contacts")
    public String contacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "contacts";
    }


    /**
     * The endpoint should return the page with the empty form for creating a new contact.
     *
     * @return
     */
    @GetMapping("/add-contact")
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    /**
     * The endpoint should return the page with the form filled in with a certain contact.
     *
     * @param id the id of the specified contact
     * @return
     */
    @GetMapping("/edit-contact/{id}")
    public String editContact(@PathVariable int id, Model model) {
/*        Contact contact = contacts
                .stream()
                .filter(cont -> cont.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);*/
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    /**
     * The endpoint should return the page with the details of a certain contact.
     *
     * @param id
     * @return
     */
    @GetMapping("/contacts/{id}")
    public String contact(@PathVariable int id, Model model) {
/*        Contact contact = contacts.stream()
                .filter(con -> con.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);*/
        Contact contact = contactService.get(id);
        model.addAttribute("contact", contact);
        return "contact-details";
    }

    /**
     * The endpoint saves ether a new contact ot the existing contact (depending on the value of the field "id") and
     * then redirects to the contacts page
     *
     * @return
     */
    @PostMapping("/save-contact")
    public String saveContact(@ModelAttribute Contact contact) {
        contactService.save(contact);
        //contacts.add(lastUsedId++, contact);
        return "redirect:/contacts";
    }

    /**
     * The endpoint removes the contact and return the redirect to the contacts page.
     *
     * @param id
     * @return
     */
    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
/*        contacts.removeIf(contact -> contact.getId() == id);*/
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping("/")
    public String mainPage (){
        return "forward:/contacts";
    }

    @PostMapping("/contacts/search")// data comes as "searchPattern=pattern&id=1&name=15"
    public String searchContacts(@ModelAttribute SearchFormDto searchForm, Model model){
        //fetch
        List<Contact> contacts = contactService.searchAllContactsContainingPattern(searchForm.searchPattern);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}