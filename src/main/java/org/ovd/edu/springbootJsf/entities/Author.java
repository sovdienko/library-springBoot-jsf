package org.ovd.edu.springbootJsf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */
@Entity
@Table(name="author")
public class Author implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String fio;

    @Column(nullable = false)
    private Date birthday;

    public Author() {
    }

    public Author(String fio) {
        this.fio = fio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


  /*  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void getBooks(Set<Book> books) {
        this.books = books;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (fio != null ? !fio.equals(author.fio) : author.fio != null) return false;
        if (birthday != null ? !birthday.equals(author.birthday) : author.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return fio;
    }
}
