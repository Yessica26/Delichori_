package co.com.delichori.dao;

import co.com.delichori.conexion.Conexion;
import co.com.delichori.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {

//OJO ESTO ES UNA PRUEBA HAY QU AJUSTAR TODO AL DIAGRAMA UML DELICHORI

        public  static void crearProductoDB(Producto registro ){

                try(Connection conexion = Conexion.get_connetion()){

                        PreparedStatement ps =null;

                        try {
                                String query = "INSERT INTO producto(nombre_producto,descripcion_productp, precioCosto, precioVenta, ganancia_producto, existencia) VALUES (?,?,?,?,?,?)";

                                ps = conexion.prepareStatement(query);

                                ps.setString(1,registro.getNombreProducto());
                                ps.setString(2,registro.getDescripcionProducto());
                                ps.setDouble(3,registro.getPrecio());
                                ps.setDouble(4,registro.getCosto());
                                ps.setDouble(5, registro.getCantidad());

                                // para insert delete update
                                ps.executeUpdate();

                                System.out.println("Registro de producto exitoso ");

                        }catch  (SQLException e){
                                System.out.println(e);
                        }


                }catch (SQLException e){
                        System.out.println(e);
                }finally {
                        Conexion.close_connection();
                }

        }


        //TRAER QUERY
        public static  void listarProductoDB(){

                                //manda
                PreparedStatement ps= null;

                //trae el resultado de la consulta
                ResultSet rs =null;

                try(Connection connect = Conexion.get_connetion()){
                        String query = "SELECT * FROM producto";

                        ps = connect.prepareStatement(query);//manda
                        rs = ps.executeQuery();//resive


                        while (rs.next()){
                                System.out.println("\n");
                                System.out.println("Id producto: "+ rs.getInt("id"));
                                System.out.println("Nombre del producto: " + rs.getString("nombre"));
                                System.out.println("Descripcion del producto: " + rs.getString("descripcion"));
                                System.out.println("Precio del producto: " + rs.getDouble("precio"));
                                System.out.println("Costo del producto: " + rs.getDouble("costo"));
                                System.out.println("Cantidad del producto: " + rs.getDouble("cantidad"));

                        }

                }catch (SQLException e){

                        System.out.println("No se recuperaron registros ");
                        System.out.println(e);
                }finally {
                        Conexion.close_connection();
                }

        }

        public  static  void  modificarProductoDB(Producto update ){


                try(Connection connect = Conexion.get_connetion()){

                        PreparedStatement ps = null;

                        try{
                                int opc = update.getOpc();
                                System.out.println(opc);

                                if(opc == 1){


                                        String query ="update producto set nombre =? where id= ? ";

                                        ps =connect.prepareStatement(query);

                                        ps.setString(1,update.getNombreProducto());
                                        ps.setInt(2,update.getIdProducto());
                                        ps.executeUpdate();

                                        System.out.println("Modificacion exitosa ");

                                }

                                if(opc == 2){


                                        String query ="update producto set descripcion =? where id= ? ";

                                        ps =connect.prepareStatement(query);

                                        ps.setString(1,update.getDescripcionProducto());
                                        ps.setInt(2,update.getIdProducto());
                                        ps.executeUpdate();

                                        System.out.println("Modificacion exitosa ");

                                }


                                if(opc == 3){


                                        String query ="update producto set precio =? where id= ? ";

                                        ps =connect.prepareStatement(query);

                                        ps.setDouble(1,update.getPrecio());
                                        ps.setInt(2,update.getIdProducto());
                                        ps.executeUpdate();

                                        System.out.println("Modificacion exitosa ");

                                }

                                if(opc == 4){


                                        String query ="update producto set costo =? where id= ? ";

                                        ps =connect.prepareStatement(query);

                                        ps.setDouble(1,update.getCosto());
                                        ps.setInt(2,update.getIdProducto());
                                        ps.executeUpdate();

                                        System.out.println("Modificacion exitosa ");

                                }


                                if(opc == 5){


                                        String query ="update producto set cantidad =? where id= ? ";

                                        ps =connect.prepareStatement(query);

                                        ps.setDouble(1,update.getCantidad());
                                        ps.setInt(2,update.getIdProducto());
                                        ps.executeUpdate();

                                        System.out.println("Modificacion exitosa ");

                                }








                        }catch (SQLException e){
                                System.out.println("No fue posible modificar el registro");
                                System.out.println(e);
                        }



                }catch (SQLException e){
                        System.out.println(e);
                }finally {
                        Conexion.close_connection();
                }


        }

        public  static  void eliminarProductoDB(int idProducto){

               //conectar DB
                try(Connection connect = Conexion.get_connetion()){

                        PreparedStatement ps =null;

                        try{
                           String query = "DELETE FROM producto WHERE producto.id =? ";

                           ps=connect.prepareStatement(query);
                           ps.setInt(1,idProducto);
                           ps.executeUpdate();

                                System.out.println("El registro ha sido eliminado correctamente ");

                        }catch (SQLException e){
                                System.out.println("No se elimino el registro ");
                                System.out.println(e);
                        }

                }catch (SQLException e){

                        System.out.println(e);

                }finally {
                        Conexion.close_connection();
                }

        }


    }
