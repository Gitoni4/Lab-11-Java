package javalab11.lab;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class Database
{

    public DriverManagerDataSource getDatabase()
    {
        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/game");
        bds.setUsername("dba");
        bds.setPassword("sql123");

        return bds;
    }

}