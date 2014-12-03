/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cmsc.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.netbeans.xml.schema.coursexmlschema.Course;

/**
 *
 * @author KevinZhou
 */
@WebServlet(name = "StudentPreRegistrationServlet", urlPatterns = {"/StudentPreRegistrationServlet"})
public class StudentPreRegistrationServlet extends HttpServlet {

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
        
        List<org.netbeans.xml.schema.classxmlschema.Class> classes = (List) session.getAttribute("clsRegID");
        List<org.netbeans.xml.schema.classxmlschema.Class> clsRegID = new ArrayList<org.netbeans.xml.schema.classxmlschema.Class>();
        
        int i=0;
        
        if (stuID != null) {
            if (classes != null && classes.size() > 0) {
                while(i < classes.size()) {
                    if (request.getParameter("ck"+i) != null) {
                        String checked = request.getParameter("ck"+i);
                        if (checked.equals("on")) {
                            clsRegID.add(classes.get(i));
                        }
                    }
                    i++;
                }
                
                session.removeAttribute("clsRegID");
                
                session.setAttribute("clsRegID", clsRegID);
                
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
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
