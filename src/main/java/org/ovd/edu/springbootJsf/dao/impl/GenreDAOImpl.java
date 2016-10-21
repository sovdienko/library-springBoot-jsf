package org.ovd.edu.springbootJsf.dao.impl;

import org.ovd.edu.springbootJsf.dao.interfaces.GenreDAO;
import org.ovd.edu.springbootJsf.dao.repositories.GenreRepository;
import org.ovd.edu.springbootJsf.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GenreDAOImpl implements GenreDAO{

    @Autowired
    private GenreRepository genreRepository;
    @Transactional(readOnly = true)
    @Override
    public Genre getGenre(String name) {
        return genreRepository.findByNameIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
