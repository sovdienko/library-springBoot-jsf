package org.ovd.edu.springbootJsf.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */
@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;


 /*   @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void getBooks(Set<Book> books) {
        this.books = books;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


