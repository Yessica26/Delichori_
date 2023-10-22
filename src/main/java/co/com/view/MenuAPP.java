package co.com.view;

import co.com.delichori.service.ProductoService;

import java.util.Scanner;

public class MenuAPP {

    Scanner sc = new Scanner(System.in);

    public  void menuProducto(){
        System.out.println("Indique 1 Para Iniciar : ");
        int init = sc .nextInt();

        while(init !=0){

            System.out.println("1.Registrar Productos \n" + "2.Listar Productos \n" + "3.Modificar Productos \n" + "4.Eliminar Productos \n"
            + "5.Salir");
            int opc = sc.nextInt();

            switch (opc){

                case 1:
                    System.out.println("Registre su producto ");
                    ProductoService.crearProducto();
                    break;


                case 2:
                    System.out.println("Listar producto ");
                    ProductoService.listarProducto();
                    break;

                case 3:
                    System.out.println("Modificar producto ");
                    ProductoService.modificarProducto();
                    break;

                case 4:
                    System.out.println("Eliminar producto");
                    ProductoService.eliminarProducto();
                    break;

                case 5:
                    System.out.println("Salir");
                    init =0;
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");



            }


        }





    }
}
