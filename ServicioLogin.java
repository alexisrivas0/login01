package com.cice.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.IOException;

import java.sql.*;

public class ServicioLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LLAMADO A DOPOST");


        String user = req.getParameter("user");
        String pass =  req.getParameter("pass");

        System.out.println(user+" "+pass);



        //PrintWriter writer = resp.getWriter();

        String sql = "INSERT INTO prueba VALUES (null, '"+user+"', '"+pass+"')";
        //Manager manager = new Manager();
        //manager.insertarActualizarEliminar(sql);

        //String sql = "SELECT * FROM prueba WHERE user = '"+user+"' AND pass = '"+pass+"'";
        // SELECT * FROM prueba WHERE user = 'user' AND pass = ''or '1'='1'

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/BBDD1","root","root");

            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

            //String sql = "SELECT * FROM Prueba";

            //ResultSet resultSet = statement.executeQuery(sql);

            //CachedRowSet resultado = RowSetProvider.newFactory().createCachedRowSet();

            //resultado.populate(resultSet);


            //resultado.close();

            //resultSet.close();


            statement.close();
            connection.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    }




