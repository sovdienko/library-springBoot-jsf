package org.ovd.edu.springbootJsf.dao.interfaces;


import org.ovd.edu.springbootJsf.entities.Author;
import org.ovd.edu.springbootJsf.entities.Book;
import org.ovd.edu.springbootJsf.entities.Genre;

import java.util.List;


public interface BookDAO {

    List<BookNoContent> getBooks();
    List<BookNoContent> getBooksByAuthor(String fio);
    List<BookNoContent> getBooks(String bookName);
    List<BookNoContent> getBooks(Genre genre);
    List<BookNoContent> getBooks(Character letter);
    Book getContent(Long id);
}
