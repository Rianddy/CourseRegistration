/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cmsc.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KevinZhou
 */
@WebServlet(name = "StudentDropServlet", urlPatterns = {"/StudentDropServlet"})
public class StudentDropServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String stuID = (String) session.getAttribute("stuID");
        
        ArrayList<String> clsDropIDList = (ArrayList) session.getAttribute("clsDropID");
        ArrayList<String> clsDropIDListCopy = new ArrayList<String>();
        
        int i = 0;
        
        if (stuID != null) {
            if (clsDropIDList != null && clsDropIDList.size() > 0) {
                while(i < clsDropIDList.size()) {
                    if (request.getParameter("chk"+i) != null) {
                        String checked = request.getParameter("chk"+i);
                        if (checked.equals("on")) {
                            clsDropIDListCopy.add(clsDropIDList.get(i));
                        }
                    }
                    i++;
                }
                
                session.removeAttribute("clsDropID");
                
                session.setAttribute("clsDropID", clsDropIDListCopy);
                
                
            }
        }
        request.getRequestDispatcher("/DropCourseConfirm.jsp").forward(request, response);
        //request.getRequestDispatcher("/BrowseClass.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
