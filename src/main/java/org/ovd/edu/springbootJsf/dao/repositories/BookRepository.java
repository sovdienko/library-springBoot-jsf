package org.ovd.edu.springbootJsf.dao.repositories;

import org.ovd.edu.springbootJsf.dao.interfaces.BookNoContent;
import org.ovd.edu.springbootJsf.entities.Author;
import org.ovd.edu.springbootJsf.entities.Book;
import org.ovd.edu.springbootJsf.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sergey.Ovdienko on 16.10.2016.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<BookNoContent> findAllByOrderByNameAsc();
    List<BookNoContent> findByNameLikeIgnoreCaseOrderByNameAsc(String name);
    List<BookNoContent> findByAuthorOrderByNameAsc(Author author);
    List<BookNoContent> findByGenreOrderByNameAsc(Genre genre);
    List<BookNoContent> findByNameStartingWithIgnoreCaseOrderByNameAsc(Character letter);

}
