/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ovd.edu.springbootJsf.servlets;

import org.ovd.edu.springbootJsf.dao.interfaces.BookNoContent;
import org.ovd.edu.springbootJsf.entities.Book;
import org.ovd.edu.springbootJsf.objects.LibraryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

@Component
public class ShowImage extends HttpServlet {

//    private static Map<Long, Byte[]> imageMap = new HashMap();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */

    @Autowired
    LibraryFacade libraryFacade;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        getServletContext();
        OutputStream out = response.getOutputStream();
        try {
            Long index = Long.parseLong(request.getParameter("index"));
           // LibraryFacade libraryFacade = (LibraryFacade) getServletContext().getAttribute("libraryFacade");
            byte[] image=null;
            Book book = null;
            List<BookNoContent> bookNoContentList = libraryFacade.getBooks();
            for (int i=0; i < bookNoContentList.size(); i++) {
                book = (Book)bookNoContentList.get(i);
                if (book.getId()==index) {
                    image = book.getImage();
                    break;
                }
            }
            response.setContentLength(image.length);
            out.write(image);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException if a servlet-specific error occurs
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
