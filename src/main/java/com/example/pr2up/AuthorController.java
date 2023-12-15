package com.example.pr2up;

import com.example.pr2up.dao.AuthorDao;
import com.example.pr2up.dao.BookDao;
import com.example.pr2up.models.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/books")
public class AuthorController {
    private AuthorDao authorDao;
    @Autowired
    public AuthorController(AuthorDao authorDao  ) {
        this.authorDao = authorDao;

    }
    @PatchMapping("/authors/{adminId}")
    public String updateAuthor(@ModelAttribute("author") AuthorModel author, @PathVariable("adminId") int adminId){
        authorDao.update(adminId,author);
        return "redirect:/books";
    }
    @GetMapping("/authors/{authorId}/authorEdit")
    public String authorEdit(Model model, @PathVariable("authorId") int authorId){
        model.addAttribute("author",authorDao.get(authorId));
        return "books/authorEdit";
    }
    @GetMapping("/authors/{authorId}")
    public String showAuthor(@PathVariable("authorId") int authorId,Model model){
        // Вывод определенного пользователя
        model.addAttribute("author", authorDao.get(authorId));

        return "books/showAuthor";
    }
    @PostMapping("/createAuthor")
    public String createAuthor(@ModelAttribute("author") AuthorModel author){
        authorDao.save(author);
        return "redirect:/books";
    }
    @DeleteMapping("/author/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        authorDao.delete(id);
        return "redirect:/books"; // или другой URL, куда вы хотите перенаправить после удаления
    }
    @GetMapping("/newAuthor")
    public String newAuthor(@ModelAttribute("author") AuthorModel author){

        return "books/newAuthor";
    }
}
