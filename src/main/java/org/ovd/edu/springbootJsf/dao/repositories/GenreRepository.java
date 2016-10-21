package org.ovd.edu.springbootJsf.dao.repositories;

import org.ovd.edu.springbootJsf.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sergey.Ovdienko on 16.10.2016.
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByNameIgnoreCase(String name);
}
