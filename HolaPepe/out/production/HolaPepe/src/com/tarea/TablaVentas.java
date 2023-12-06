package com.tarea;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TablaVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operacion = 0;
        try {

            do {
              //  Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DAO.obtenerConexion();

                System.out.println("seleccione una operacion ");
                System.out.println("1. ingresar un producto");
                System.out.println("2. borrar un producto cargado");
                System.out.println("3. ver lista de productos ");
                System.out.println("4. salir");

                operacion = scanner.nextInt();
                scanner.nextLine();


                switch (operacion) {
                    case 1:
                        System.out.println("introduzca el nombre del producto ");
                        String nombre_Producto = scanner.nextLine();
                        System.out.println("introduzca el precio del producto ");
                        double precio = scanner.nextDouble();
                        System.out.println("introduzca el peso ");
                        double peso = scanner.nextDouble();

                        Producto nuevoProducto = new Producto(nombre_Producto, precio, peso);
                        DAO.insertarProductos(connection,nuevoProducto);
                        System.out.println("Producto ingresado correctamente ");
                        break;

                    case 2:
                        System.out.println("introduzca el producto que desea eleminiar");
                        String producto_eliminado = scanner.nextLine();
                        DAO.borrarProducto(connection, producto_eliminado);
                        System.out.println("producto borrado correctamente ");
                        break;
                    case 3:
                        System.out.println("<--- lista de productos: --->");
                        DAO.imprimirProductos(connection);
                        break;

                }
                connection.close();


            }
            while (operacion != 4);



        } catch(SQLException | ClassNotFoundException e){
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }
    }
