package com.JavaTest1.Exam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyJDBC {
    MyJDBC(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ip = XMLdispart.getInf().get("ip");
            String port = XMLdispart.getInf().get("port");
            String db_name = XMLdispart.getInf().get("db_name");
            String user_name = XMLdispart.getInf().get("user_name");
            String password = XMLdispart.getInf().get("password");
            Connection connection = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db_name+"?serverTimezone=UTC",user_name,password);

            fun1(connection);
            fun2(connection);

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    void fun1(Connection connection) throws Exception{
        String Country_ID = XMLdispart.getInf().get("Country_ID");
        System.out.println("Country_ID: "+Country_ID);
        String sql = "SELECT country FROM country WHERE country_id = "+Country_ID;
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        resultSet1.next();
        System.out.println("Country "+resultSet1.getString(1)+" 的城市");
        sql = "SELECT city,city_id FROM city WHERE country_id = "+Country_ID;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("城市 ID | 城市名称");
        while (resultSet.next()){
            String out1 = resultSet.getString(1);
            String out2 = resultSet.getString(2);
            System.out.println(out1+"|"+out2);
        }
        resultSet.close();
        preparedStatement.close();
        System.out.println();
    }
    void fun2(Connection connection) throws Exception{
        String Customer_ID = XMLdispart.getInf().get("Customer_ID");
        System.out.println("Customer_ID: "+Customer_ID);
        String sql = "SELECT concat(first_name,\" \",last_name) FROM customer WHERE customer_id ="+Customer_ID;
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        resultSet1.next();
        System.out.println(resultSet1.getString(1)+" 租用的Film");
        sql = "SELECT film.film_id,film.title,rental.rental_date "+
                "FROM customer,rental,inventory, film "+
                "WHERE customer.customer_id = rental.customer_id "+
                "AND rental.inventory_id = inventory.inventory_id "+
                "AND inventory.film_id = film.film_id "+
                "AND customer.customer_id = "+Customer_ID+
                " ORDER BY rental.return_date DESC ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Film ID | Film 名称 | 租用时间");
        while (resultSet.next()){
            String out1 = resultSet.getString(1);
            String out2 = resultSet.getString(2);
            String out3 = resultSet.getString(3);
            System.out.println(out1+"|"+out2+"|"+out3);
        }
        resultSet.close();
        preparedStatement.close();
        System.out.println();
    }
}
