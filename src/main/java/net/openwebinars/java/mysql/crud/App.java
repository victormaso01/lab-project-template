package net.openwebinars.java.mysql.crud;

import net.openwebinars.java.mysql.crud.DAO.ProductoDAO;
import net.openwebinars.java.mysql.crud.DAO.ProductoDAOImpl;
import net.openwebinars.java.mysql.crud.model.Producto;
import net.openwebinars.java.mysql.crud.pool.MyDataSource;

import java.sql.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        testDAO();


    }
    public static void testDAO(){
        ProductoDAO dao = ProductoDAOImpl.getInstance();
        Producto prod = new Producto("Cigarros", "Cigarros winston", 5, 100);

        try {
            int n= dao.add(prod);
            System.out.println("Se ha insertado " + n + " registros nuevos");

            List<Producto>productos = dao.getAll();

            if(productos.isEmpty()){
                System.out.println("No hay ningun elemento");
            }
            else{
                productos.forEach(System.out::println);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void testPool(){
        try (Connection conn = MyDataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
