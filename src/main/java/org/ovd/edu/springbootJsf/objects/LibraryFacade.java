package org.ovd.edu.springbootJsf.objects;


import org.ovd.edu.springbootJsf.dao.interfaces.BookNoContent;
import org.ovd.edu.springbootJsf.entities.Author;
import org.ovd.edu.springbootJsf.entities.Book;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.ovd.edu.springbootJsf.dao.interfaces.BookDAO;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.ServletContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@Component("libraryFacade")
@Scope("singleton")
public class LibraryFacade {


    private static final String FIELD_CONTENT = "content";

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private SearchCriteria searchCriteria;

    private List<BookNoContent> books;

    public List<BookNoContent> getBooks() {
        if (books == null){
            books = bookDAO.getBooks();
        }
        return books;
    }

    public void searchBooksByLetter() {
        books = bookDAO.getBooks(searchCriteria.getLetter());
    }

    public void searchBooksByGenre() {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText() {

        switch (searchCriteria.getSearchType()){
            case TITLE:
                books = bookDAO.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDAO.getBooksByAuthor(searchCriteria.getText());
                break;
        }

    }

    public byte[] getContent(long id){

        return bookDAO.getContent(id).getContent();
    }

/*    public StreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

  *//*      if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {*//*
            // So, browser is requesting the image. Get ID value from actual request param.
            String id = context.getExternalContext().getRequestParameterMap().get("id");
            Book book = (Book) books.get(Integer.parseInt(id));
            return new DefaultStreamedContent(new ByteArrayInputStream(book.getImage()));
    *//*    }*//*

    }*/


}
