/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipi.myservlet;

import com.ipi.myservlet.bean.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glassfish
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
    
    private static final int barisPerPage = 5;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String host = request.getServerName();
        String port = String.valueOf(request.getServerPort());
        String url = "http://"+host+":"+port+"/";
        
        int page = 0;
        int baris = barisPerPage;
        List<Siswa> list = getListSiswa();
        int jmlPage = list.size() / baris;
        if (list.size() % baris > 0){
            jmlPage = jmlPage +1;
        }
        
        String stPage = request.getParameter("page");
        if (stPage != null){
            page= Integer.parseInt(stPage);
        }
        
        if (page < jmlPage){
            page++;
        }else if (page >= jmlPage){
            page = 1;
        }
        
        int start = (page-1) * baris +1;
        int end = start + (baris-1);
        
        List<Siswa> listBaru = new ArrayList<Siswa>();
        for (int i=start-1; i<end;i++){
            if (i < list.size()){
                listBaru.add(list.get(i));
            }
        }
        
        request.setAttribute("page", page);
        request.setAttribute("list", listBaru);
        
        RequestDispatcher view = request.getRequestDispatcher("/tampil.jsp");
        view.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

    private List<Siswa> getListSiswa(){
        
        List<Siswa> list = new ArrayList<>();
        
        list.add(new Siswa("1", "Satu"));
        list.add(new Siswa("2", "Dua"));
        list.add(new Siswa("3", "Tiga"));
        list.add(new Siswa("4", "Empat"));
        list.add(new Siswa("5", "Lima"));
        list.add(new Siswa("6", "Enam"));
        list.add(new Siswa("7", "Tujuh"));
        list.add(new Siswa("8", "Delapan"));
        list.add(new Siswa("9", "Sembilan"));
        list.add(new Siswa("10", "Sepuluh"));
        list.add(new Siswa("11", "Sebelas"));
        list.add(new Siswa("12", "Dua Belas"));
        list.add(new Siswa("13", "Tiga Belas"));
        list.add(new Siswa("14", "Empat Belas"));
        
        return list;
    }
}
