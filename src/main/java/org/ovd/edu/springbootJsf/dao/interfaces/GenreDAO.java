package org.ovd.edu.springbootJsf.dao.interfaces;

import org.ovd.edu.springbootJsf.entities.Genre;

import java.util.List;

/**
 * Created by Sergey.Ovdienko on 16.10.2016.
 */
public interface GenreDAO {
    Genre getGenre(String Name);
    List<Genre> getGenres();
}
