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

            String Country_ID = XMLdispart.getInf().get("Country_ID");
            System.out.println("Country_ID: "+Country_ID);


            String sql = "SELECT city,city_id FROM city WHERE country_id = "+Country_ID;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("城市 ID | 城市名称");
            while (resultSet.next()){
                String out1 = resultSet.getString(1);
                String out2 = resultSet.getString(2);
                System.out.println(out1+"|"+out2);
            }
            String Customer_ID = XMLdispart.getInf().get("Customer_ID");
            System.out.println("Customer_ID: "+Customer_ID);

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
