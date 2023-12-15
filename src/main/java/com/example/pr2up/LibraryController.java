package com.example.pr2up;

import com.example.pr2up.dao.LibraryDao;
import com.example.pr2up.models.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class LibraryController {
    private LibraryDao libraryDao;

    @Autowired
    public LibraryController(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @PatchMapping("/libraries/{libraryId}")
    public String updateLibrary(@ModelAttribute("library") LibraryModel library, @PathVariable("libraryId") int libraryId) {
        libraryDao.update(libraryId, library);
        return "redirect:/books";
    }

    @GetMapping("/libraries/{libraryId}/libraryEdit")
    public String libraryEdit(Model model, @PathVariable("libraryId") int libraryId) {
        model.addAttribute("library", libraryDao.get(libraryId));
        return "books/libraryEdit";
    }

    @GetMapping("/libraries/{libraryId}")
    public String showLibrary(@PathVariable("libraryId") int libraryId, Model model) {
        model.addAttribute("library", libraryDao.get(libraryId));
        return "books/showLibrary";
    }

    @PostMapping("/createLibrary")
    public String createLibrary(@ModelAttribute("library") LibraryModel library) {
        libraryDao.save(library);
        return "redirect:/books";
    }

    @DeleteMapping("/library/{id}")
    public String deleteLibrary(@PathVariable("id") int id) {
        libraryDao.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/newLibrary")
    public String newLibrary(@ModelAttribute("library") LibraryModel library) {
        return "books/newLibrary";
    }
}
