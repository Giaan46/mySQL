package com.tarea;

import java.sql.*;

public class DAO {

    private static   String url = "jdbc:mysql://localhost:3306/tabla_ventas";
    private static String usuario = "root";
    private static String password = "gianluca";
    private Producto producto = new Producto();

    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {

        return DriverManager.getConnection(url,usuario,password);
    }
    public static void insertarProductos(Connection connection,Producto producto)throws SQLException{
        String query = "INSERT INTO productos (id,nombre,precio,peso) VALUES (?,?,?,?)";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,producto.getId());
            statement.setString(2,producto.getNombre());
            statement.setDouble(3, producto.getPrecio());
            statement.setDouble(4,producto.getPeso());

            statement.executeUpdate();
        }

    }
    public static void borrarProducto(Connection connection, String nombre)throws SQLException{
        String query = "DELETE FROM productos WHERE nombre = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,nombre);
            statement.executeUpdate();
        }
    }
    public static void imprimirProductos(Connection connection) throws SQLException{
        String query = "SELECT * FROM productos";

        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                double peso = resultSet.getDouble("peso");

                System.out.println("ID: "+ id +  " nombre: " + nombre + " precio: " + precio + " peso: " + peso);
            }
        }
    }
}

