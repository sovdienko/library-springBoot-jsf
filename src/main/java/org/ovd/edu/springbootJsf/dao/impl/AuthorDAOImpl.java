package org.ovd.edu.springbootJsf.dao.impl;

import org.ovd.edu.springbootJsf.dao.interfaces.AuthorDAO;
import org.ovd.edu.springbootJsf.dao.repositories.AuthorRepository;
import org.ovd.edu.springbootJsf.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author getAuthor(String fio) {
        return authorRepository.findByFioLikeIgnoreCase(fio+'%');
    }
}
