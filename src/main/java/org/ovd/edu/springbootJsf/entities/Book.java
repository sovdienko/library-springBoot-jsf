package org.ovd.edu.springbootJsf.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private byte[] content;
    @Column(nullable = false)
    private int pageCount;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private int publishYear;
    @Column
    private byte[] image;
    @Column
    private String descr;
    @Column
    private Integer rating;
    @Column
    private Long voteCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

   /* @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Vote> votes;

    public Set<Vote> getVotes() {
        return votes;
    }

    public void getVotes(Set<Vote> votes) {
        this.votes = votes;
    }*/

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {this.author = author;}

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pageCount != book.pageCount) return false;
        if (publishYear != book.publishYear) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (!Arrays.equals(content, book.content)) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (!Arrays.equals(image, book.image)) return false;
        if (descr != null ? !descr.equals(book.descr) : book.descr != null) return false;
        if (rating != null ? !rating.equals(book.rating) : book.rating != null) return false;
        if (voteCount != null ? !voteCount.equals(book.voteCount) : book.voteCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + pageCount;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + publishYear;
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (voteCount != null ? voteCount.hashCode() : 0);
        return result;
    }


}
