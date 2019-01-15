/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.service.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class SqlResolver implements InitializingBean {

    private JdbcTemplate jdbcTemplate;
    private SimpleDriverDataSource dataSource;


    @Value("${app.simpledatasource.url}")
    private String jdbcUrl = "jdbc:mysql://localhost:3306/test";
    @Value("${app.simpledatasource.username:root}")
    private String username = "root";
    @Value("${app.simpledatasource.password:root}")
    private String password = "root";


    public SqlResolver() throws SQLException {
        this.dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List executeSql(String sql){
        return jdbcTemplate.queryForList(sql);
    }

    public List showAvalibleTables(){
        return jdbcTemplate.queryForList("SHOW TABLES");
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
