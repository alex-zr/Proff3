package ua.kiev.prog.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kiev.prog.domain.Contact;
import ua.kiev.prog.domain.Group;
import ua.kiev.prog.exception.UserException;
import ua.kiev.prog.service.ContactService;
import ua.kiev.prog.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;
    private UserService userService;
    private ContactService contactService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<Contact> contacts = contactService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("allPages", getPageCount());

        return "index";
    }

    @RequestMapping("/auto_user")
    public String autoUserPage(Model model) {
        model.addAttribute("no_name", "none");
        model.addAttribute("no_pass", "none");
        model.addAttribute("ok_login", "none");
        return "auto_user_page";
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.POST)
    public String autoUserLogin(Model model, @RequestParam  String login,
                                  @RequestParam String pass) {
        try {
            if (userService.login(login, pass)) {
                model.addAttribute("no_name", "none");
                model.addAttribute("no_pass", "none");
                model.addAttribute("ok_login", "block");
                model.addAttribute("login", login);
            }else {
                model.addAttribute("no_name", "none");
                model.addAttribute("no_pass", "block");
                model.addAttribute("ok_login", "none");
            }
        } catch (UserException e){
            model.addAttribute("no_name", "block");
            model.addAttribute("no_pass", "none");
            model.addAttribute("ok_login", "none");
            model.addAttribute("login", login);
        }
        return "auto_user_page";
    }

    @RequestMapping("/contact_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("groups", contactService.findGroups());
        return "contact_add_page";
    }

    @RequestMapping("/group_add_page")
    public String groupAddPage() {
        return "group_add_page";
    }

    @RequestMapping("/new_user_page")
    public String newUserserLogin(Model model) {
        model.addAttribute("exists", "none");
        model.addAttribute("ok_add", "none");
        model.addAttribute("no_connect", "none");
        return "new_user_page";
    }

    @RequestMapping(value = "/new/user", method = RequestMethod.POST)
    public String newUserAdd(Model model, @RequestParam String login, @RequestParam String pass) {
        try {
            if ((Long) userService.registration(login,pass) != null){
                model.addAttribute("exists", "none");
                model.addAttribute("ok_add", "block");
                model.addAttribute("login", login);
            } else {
                model.addAttribute("exists", "none");
                model.addAttribute("ok_add", "none");
                model.addAttribute("no_connect", "block");
            }

        }catch (UserException e){
            model.addAttribute("exists", "block");
            model.addAttribute("ok_add", "none");
        }
        return "new_user_page";
    }

    @RequestMapping(value = "/contact_edit_page", method = RequestMethod.POST)
    public String contactEditPage(Model model, @RequestParam(value = "idcontact") long editUserId) {
        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contact", contactService.findById(editUserId));
        return "contact_edit_page";
    }

    @RequestMapping("/group/{id}")
    public String listGroup(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        Group group = (groupId != DEFAULT_GROUP_ID)
                ? contactService.findGroup(groupId).orElse(new Group())
                : null;
        if (page < 0) page = 0;

        List<Contact> contacts = contactService
                .findByGroup(group, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("byGroupPages", getPageCount(group));
        model.addAttribute("groupId", groupId);

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String pattern, Model model) {
        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contactService.findByPattern(pattern, null));
        return "index";
    }

    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            contactService.deleteContacts(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam(value = "group") long groupId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email) {
        Group group = (groupId != DEFAULT_GROUP_ID)
                ? contactService.findGroup(groupId).orElse(new Group())
                : null;

        Contact contact = new Contact(group, name, surname, phone, email);
        contactService.addContact(contact);

        return "redirect:/";
    }

    @RequestMapping(value = "/contact/edit", method = RequestMethod.POST)
    public String contactEdit(@RequestParam(value = "group") long groupId,
                              @RequestParam(value = "userId") long userId,
                              @RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String phone,
                              @RequestParam String email) {
        Group group = (groupId != DEFAULT_GROUP_ID)
                ? contactService.findGroup(groupId).orElse(new Group())
                : null;

        Contact contact = contactService.findById(userId);
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setGroup(group);
        contactService.addContact(contact);

        return "redirect:/";
    }


    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        contactService.addGroup(new Group(name));
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }

    private long getPageCount() {
        long totalCount = contactService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(Group group) {
        long totalCount = contactService.countByGroup(group);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
