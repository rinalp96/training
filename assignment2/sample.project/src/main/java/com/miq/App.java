package com.miq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        System.out.println( "Hello World!" );2
        mysqlAccess m1 = new mysqlAccess();
//        m1.create("lasdl", 3, "test", "test", "address", 123123, "car", 123132);
//
//        m1.readAll();
//        //m1.delete(5);
//        m1.readAll();
 //       m1.update("testupdate", 1, "test", "test", "address", 000, "car", 123132);
 //       m1.readAll();
        boolean running = true;
        while (running){
            System.out.println("enter 0 to quit");
            System.out.println("1 to create ");
            System.out.println("2 to read ");
            System.out.println("3 to update");
            System.out.println("4 to delete");

            int num = in.nextInt();
            if(num == 0){
                break;
            }
            else if (num == 1){
                String name = in.nextLine();
                int id = in.nextInt();
                String designation = in.nextLine();
                String department = in.nextLine();
                String address = in.nextLine();
                int contact = in.nextInt();
                String vehicle = in.nextLine();
                int compensation = in.nextInt();
                m1.create(name,id,designation,department,address,contact,vehicle,compensation);
            }
            else if (num == 2){
                System.out.println("enter 1 to read all ");
                System.out.println("enter 2 to read an id");
                int choice = in.nextInt();
                if(choice == 1){
                    m1.readAll();
                }
                else if(choice == 2){
                    System.out.print("Enter id : ");
                    int id = in.nextInt();
                    m1.readId(id);
                }
            }
            else if (num == 3){
                String name = in.nextLine();
                int id = in.nextInt();
                String designation = in.nextLine();
                String department = in.nextLine();
                String address = in.nextLine();
                int contact = in.nextInt();
                String vehicle = in.nextLine();
                int compensation = in.nextInt();
                m1.update(name,id,designation,department,address,contact,vehicle,compensation);
            }
            else if (num == 4){
                System.out.print("Enter id : ");
                int id = in.nextInt();
                m1.delete(id);
            }
        }
    }
}
