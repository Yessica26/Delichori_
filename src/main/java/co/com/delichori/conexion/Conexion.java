package co.com.delichori.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection connect;

    public Conexion(){

        try  {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/delichori", "root","");
            if(connect != null){
                System.out.println("La conexion ha sido exitosa");
            }

        }catch (SQLException e){
            System.out.println("falló la conexión en la DB" + e);
        }

    }

    public static Connection get_connetion(){
        System.out.println("Antes de pedir: " + connect);

        if (connect == null){
            new Conexion();
        }
        System.out.printf("Cuando la llamo: "+connect);
        return  connect;

    }
//crear un metodo para cerrar ls conexion a la bd y


    public static void close_connection(){

            try {
                System.out.println("Antes de cerrar: " + connect);
                if(connect != null) {
                    connect.close();
                    connect = null;
                }
            } catch (Exception e) {
                    System.out.println(e);;
            }
        System.out.println("DEspués de cerrar: "+ connect);

        }
    }





