package com.emergentes.controlador;

import com.emergentes.modelo.Seminarios;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhonny
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        ResultSet rs;
        int id;
        String op;
        ArrayList<Seminarios> lista = new ArrayList<Seminarios>();

        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        if (op.equals("list")) {
            String sql = "select * from seminarios";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {

                    Seminarios sem = new Seminarios();
                    System.out.println(rs.getString("titulo"));
                    sem.setId(rs.getInt("id"));
                    sem.setTitulo(rs.getString("titulo"));
                    sem.setExpositor(rs.getString("expositor"));
                    sem.setFecha(rs.getString("fecha"));
                    sem.setHora(rs.getString("hora"));
                    sem.setCupo(rs.getInt("cupo"));
                    lista.add(sem);

                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("nuevo")) {
            Seminarios sem = new Seminarios();
            request.setAttribute("sem", sem);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {

            id = Integer.parseInt(request.getParameter("id"));

            try {
                ps = conn.prepareStatement("delete from seminarios where id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (op.equals("editar")) {
            id = Integer.parseInt(request.getParameter("id"));
             Seminarios sem = new Seminarios();
            try {
                ps = conn.prepareStatement("select * from seminarios where id=?");
                 ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    sem.setId(rs.getInt("id"));
                    sem.setTitulo(rs.getString("titulo"));
                    sem.setExpositor(rs.getString("expositor"));
                    sem.setFecha(rs.getString("fecha"));
                    sem.setHora(rs.getString("hora"));
                    sem.setCupo(rs.getInt("cupo"));
                    
                }
                request.setAttribute("sem",sem);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
               

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
         String titulo=request.getParameter("titulo");
         String expositor=request.getParameter("expositor");
         String fecha=request.getParameter("fecha");
         String hora=request.getParameter("hora");
         int cupo = Integer.parseInt(request.getParameter("cupo"));
         
        Seminarios sem = new Seminarios();
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setExpositor(expositor);
        sem.setFecha(fecha);
        sem.setHora(hora);
        sem.setCupo(cupo);

        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            String sql = "insert into seminarios (titulo,expositor,fecha,hora,cupo)values(?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, sem.getTitulo());
                ps.setString(2, sem.getExpositor());
                ps.setString(3, sem.getFecha());
                ps.setString(4, sem.getHora());
                ps.setInt(5, sem.getCupo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            //modificar tabla productos
            String sql1 = "update seminarios set titulo=?,expositor=?,fecha=?,hora=?,cupo=? where id=?";
            try {
                ps = conn.prepareStatement(sql1);
                
                ps.setString(1, sem.getTitulo());
                ps.setString(2, sem.getExpositor());
                ps.setString(3, sem.getFecha());
                ps.setString(4, sem.getHora());
                ps.setInt(5, sem.getCupo());
                ps.setInt(6,sem.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        response.sendRedirect("MainController");

    }


       

    

}
