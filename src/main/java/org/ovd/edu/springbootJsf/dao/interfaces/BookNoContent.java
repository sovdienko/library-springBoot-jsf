package org.ovd.edu.springbootJsf.dao.interfaces;

import org.ovd.edu.springbootJsf.entities.Author;
import org.ovd.edu.springbootJsf.entities.Genre;
import org.ovd.edu.springbootJsf.entities.Publisher;
import org.ovd.edu.springbootJsf.entities.Vote;

import java.util.Set;

public interface BookNoContent {
    Long getId();

    String getName();

   /* Set<Vote> getVotes();*/

    Genre getGenre();

    Publisher getPublisher();

    Author getAuthor();

    Integer getPageCount();

    String getIsbn();

    Integer getPublishYear();

    byte[] getImage();

    String getDescr();

    Integer getRating();

    Long getVoteCount();
}

