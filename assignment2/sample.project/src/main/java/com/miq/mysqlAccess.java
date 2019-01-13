package com.miq;

import java.sql.*;

public class mysqlAccess {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/project";

    //  Database credentials
    static final String USER = "rinal";
    static final String PASS = "test";

    public void readAll(){
        try{
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employeeDetails");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "
                        +rs.getInt(2) + " "
                        +rs.getString(3) + " "
                        +rs.getString(4) + " "
                        +rs.getString(5) + " "
                        +rs.getInt(6) + " "
                        +rs.getString(7) + " "
                        +rs.getInt(8) + " "
                );
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void readId(int id){
        try{
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL,USER,PASS);

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employeeDetails where id = " + id);
            while(rs.next())
                System.out.println(rs.getString(1)+"  "
                        +rs.getInt(2) + " "
                        +rs.getString(3) + " "
                        +rs.getString(4) + " "
                        +rs.getString(5) + " "
                        +rs.getInt(6) + " "
                        +rs.getString(7) + " "
                        +rs.getInt(8) + " "
                );
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void create(String name, int id, String designation, String department, String address, int contact, String vehicle, int compensation){
        try{
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=con.createStatement();
//            stmt.executeUpdate("insert into employeeDetails " +
//                    "values (" + name + id +  designation + department + address + contact + vehicle + compensation +");"
//            );
            stmt.executeUpdate("insert into employeeDetails values (" + name + ", " + id + ", " + designation + ", "+ department + ", "+ address + ", " + contact + ", " + vehicle + ", " + compensation + ");");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void update(String name, int id, String designation, String department, String address, int contact, String vehicle, int compensation){
        try{
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=con.createStatement();
//            stmt.executeUpdate("insert into employeeDetails " +
//                    "values (" + name + id +  designation + department + address + contact + vehicle + compensation +");"
//            );
            stmt.executeUpdate("update employeeDetails set contact = " + contact + " where id = 1;");
//            stmt.executeUpdate("update employeeDetails " +
//                    "set name = " + name + //", deignation = " + designation + ", department = "+ department + ", address = "+ address + ", contact = " + contact + ", vehicle = " + vehicle + ", compensatoin = " + compensation +
//                    " where id = " + id + ";");
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void delete(int id){
        try{
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt=con.createStatement();
            stmt.executeUpdate("DELETE FROM employeeDetails " +
                    "WHERE id = " + id + ";"
            );
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

