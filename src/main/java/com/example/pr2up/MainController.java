package com.example.pr2up;

import com.example.pr2up.dao.*;
import com.example.pr2up.models.AuthorModel;
import com.example.pr2up.models.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class MainController {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private LibraryDao libraryDao;
    private PublisherDao publisherDao;
    private ReviewDao reviewDao;
    @Autowired
    public MainController(BookDao bookDao, AuthorDao authorDao, LibraryDao libraryDao, PublisherDao publisherDao,
                          ReviewDao reviewDao)       {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.libraryDao =  libraryDao;
        this.publisherDao =  publisherDao;
        this.reviewDao =  reviewDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDao.getAll());
        model.addAttribute("authors", authorDao.getAll());
        model.addAttribute("libraries", libraryDao.getAll());
        model.addAttribute("publishers", publisherDao.getAll());
        model.addAttribute("reviews", reviewDao.getAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("book", bookDao.get(id));

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") BookModel book){

        return "books/new";
    }



    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("book",bookDao.get(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") BookModel book, @PathVariable("id") int id){
        bookDao.update(id,book);
        return "redirect:/books";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") BookModel bookModel){
        bookDao.save(bookModel);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDao.delete(id);
        return "redirect:/books";
    }


}