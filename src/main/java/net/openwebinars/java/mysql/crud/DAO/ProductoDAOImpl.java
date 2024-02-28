package net.openwebinars.java.mysql.crud.DAO;

import net.openwebinars.java.mysql.crud.model.Producto;
import net.openwebinars.java.mysql.crud.pool.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO{
    private static ProductoDAOImpl instance;

    static {
        instance = new ProductoDAOImpl();
    }
    private ProductoDAOImpl(){

    }
    public static ProductoDAOImpl getInstance(){
        return instance;
    }

    @Override
    public int add(Producto producto) throws SQLException {

        String sql = """
                INSERT INTO products(product_name, description, prize, stock)
                VALUES(?, ?, ?, ?)
                """;
        int result;
        try (Connection conn = MyDataSource.getConnection()) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, producto.getProduct_name());
            pstm.setString(2, producto.getDescription());
            pstm.setDouble(3, producto.getPrize());
            pstm.setInt(4, producto.getStock());


            result = pstm.executeUpdate();

            return result;
        }
    }

    @Override
    public Producto getById(int id) throws SQLException {
        return  null;
    }

    @Override
    public List<Producto> getAll() throws SQLException {
        String sql = "SELECT * FROM products";
        List<Producto> result = new ArrayList<>();
        try(Connection conn = MyDataSource.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()  ) {
            Producto prod;
            while(rs.next()){
                prod = new Producto();
                prod.setProduct_id(rs.getInt("product_id"));
                prod.setProduct_name(rs.getString("product_name"));
                prod.setDescription(rs.getString("description"));
                prod.setPrize(rs.getDouble("prize"));
                prod.setStock(rs.getInt("stock"));


                result.add(prod);
            }

        }

        return result;
    }

    @Override
    public int update(Producto producto) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
