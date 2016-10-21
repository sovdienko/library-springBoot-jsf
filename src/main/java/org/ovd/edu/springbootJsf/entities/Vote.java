package org.ovd.edu.springbootJsf.entities;

import javax.persistence.*;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */
@Entity
@Table(name="vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private Integer value;
    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (value != null ? !value.equals(vote.value) : vote.value != null) return false;
        if (username != null ? !username.equals(vote.username) : vote.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
