package com.igeek.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author zx
 * @date 2019年8月9日
 * @version 1.0
 * @description：数据源工具类
 */
public class C3P0Util {

    private static DataSource dataSource = new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;
    }

}
