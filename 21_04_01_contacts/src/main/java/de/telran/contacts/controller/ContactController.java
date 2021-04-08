package de.telran.contacts.controller;

import de.telran.contacts.entity.Contact;
import de.telran.contacts.service.ContactService;
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

    /*    List<Contact> contacts = new ArrayList();

    {
        contacts.add(new Contact(1, "Vasiliy", "Petrov", "0176 1523 4085"));
        contacts.add(new Contact(2, "Petr", "Ivanov", "0621 1435 2878"));
        contacts.add(new Contact(3, "Ivan", "Vassiliev", "0621 1316 5588"));
    }

    static int lastUsedId = 3;*/

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
/*        if (contact.getId() <= 0){
            contact.setId(++lastUsedId);
            contacts.add(contact);
        } else {
            Contact oldContact = contacts
                    .stream()
                    .filter(cont -> cont.getId() == contact.getId())
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            oldContact.setName(contact.getName());
            oldContact.setLastName(contact.getLastName());
            oldContact.setPhoneNumber(contact.getPhoneNumber());
        }*/
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
}