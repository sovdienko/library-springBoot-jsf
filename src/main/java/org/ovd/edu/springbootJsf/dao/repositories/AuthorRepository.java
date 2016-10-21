package org.ovd.edu.springbootJsf.dao.repositories;

import org.ovd.edu.springbootJsf.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByFioLikeIgnoreCase(String fio);

}
