package com.example.pr2up;

import com.example.pr2up.dao.PublisherDao;
import com.example.pr2up.models.PublisherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class PublisherController {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @PatchMapping("/publishers/{publisherId}")
    public String updatePublisher(@ModelAttribute("publisher") PublisherModel publisher, @PathVariable("publisherId") int publisherId) {
        publisherDao.update(publisherId, publisher);
        return "redirect:/books";
    }

    @GetMapping("/publishers/{publisherId}/publisherEdit")
    public String publisherEdit(Model model, @PathVariable("publisherId") int publisherId) {
        model.addAttribute("publisher", publisherDao.get(publisherId));
        return "books/publisherEdit";
    }

    @GetMapping("/publishers/{publisherId}")
    public String showPublisher(@PathVariable("publisherId") int publisherId, Model model) {
        model.addAttribute("publisher", publisherDao.get(publisherId));
        return "books/showPublisher";
    }

    @PostMapping("/createPublisher")
    public String createPublisher(@ModelAttribute("publisher") PublisherModel publisher) {
        publisherDao.save(publisher);
        return "redirect:/books";
    }

    @DeleteMapping("/publisher/{id}")
    public String deletePublisher(@PathVariable("id") int id) {
        publisherDao.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/newPublisher")
    public String newPublisher(@ModelAttribute("publisher") PublisherModel publisher) {
        return "books/newPublisher";
    }
}
