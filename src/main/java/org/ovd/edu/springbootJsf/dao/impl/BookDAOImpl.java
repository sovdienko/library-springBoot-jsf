package org.ovd.edu.springbootJsf.dao.impl;


import org.ovd.edu.springbootJsf.dao.interfaces.*;
import org.ovd.edu.springbootJsf.dao.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.ovd.edu.springbootJsf.entities.Author;
import org.ovd.edu.springbootJsf.entities.Book;
import org.ovd.edu.springbootJsf.entities.Genre;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;
import java.util.Locale;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

/*
    @Autowired
    private GenreDAO genreDAO;
*/
    @Autowired
    private AuthorDAO authorDAO;


    //private List<Book> books;
    private List<BookNoContent> books;



    @Transactional(readOnly = true)
    @Override
    public List<BookNoContent> getBooks() {

        books = bookRepository.findAllByOrderByNameAsc();
        return books;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookNoContent> getBooksByAuthor(String fio) {
        books = bookRepository.findByAuthorOrderByNameAsc(authorDAO.getAuthor(fio));
        return books;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookNoContent> getBooks(String bookName) {
        books = bookRepository.findByNameLikeIgnoreCaseOrderByNameAsc(bookName+'%');
        return books;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookNoContent> getBooks(Genre genre) {
        return bookRepository.findByGenreOrderByNameAsc(genre);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookNoContent> getBooks(Character letter) {
        return bookRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc(letter);
    }

    @Transactional
    @Override
    public Book getContent(Long id) {
        Book bookContent = bookRepository.findOne(id);
        return bookContent;

    }
}
