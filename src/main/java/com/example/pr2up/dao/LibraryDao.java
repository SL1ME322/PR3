package com.example.pr2up.dao;

import com.example.pr2up.models.LibraryModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryDao implements Dao<LibraryModel>{
    private List<LibraryModel> libraries = new ArrayList<>();
    private static int LIBRARIES_COUNT;

    public LibraryDao() {
        libraries.add(new LibraryModel(++LIBRARIES_COUNT, "Library1", "Address1", "Librarian1", 100, "9:00 AM - 5:00 PM"));
        libraries.add(new LibraryModel(++LIBRARIES_COUNT, "Library2", "Address2", "Librarian2", 150, "10:00 AM - 6:00 PM"));
    }

    @Override
    public LibraryModel get(int id) {

        return libraries.stream().filter(library -> library.getLibraryId() == id).findFirst().orElse(null);
    }

    @Override
    public List<LibraryModel> getAll() {
        return libraries;
    }

    @Override
    public void save(LibraryModel libraryModel) {
        libraryModel.setLibraryId(++LIBRARIES_COUNT);
        libraries.add(libraryModel);
    }

    @Override
    public void update(int id, LibraryModel updatedLibrary) {
        LibraryModel existingLibrary = get(id);

        if (existingLibrary != null) {
            existingLibrary.setName(updatedLibrary.getName());
            existingLibrary.setAddress(updatedLibrary.getAddress());
            existingLibrary.setLibrarian(updatedLibrary.getLibrarian());
            existingLibrary.setCapacity(updatedLibrary.getCapacity());
            existingLibrary.setOpeningHours(updatedLibrary.getOpeningHours());
        }
    }

    @Override
    public void delete(int id) {
        libraries.removeIf(library -> library.getLibraryId() == id);
    }
}

