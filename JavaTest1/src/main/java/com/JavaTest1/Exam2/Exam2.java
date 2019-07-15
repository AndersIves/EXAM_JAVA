package com.JavaTest1.Exam2;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogReader;

public class Exam2 {
    // 使用sakila数据库。
    // 下载地址：http://pan.hand-china.com/owncloud/index.php/s/0ZvHkqUaXpkFqW9。密码：handhand。
    // 下载成功之后，根据sakila-schema.sql和sakila-data.sql来创建数据库和数据。
    // 程序使用mysql + jdbc。不得使用spring。
    // 1、根据Country ID。返回所有属于这个Country的CityID及名称。（10分）
    // Country ID: id
    // Country `name` 的城市
    // 城市 ID | 城市名称
    // 1 | A Corua (La Corua)
    // ... | ...
    // 2、根据Customer ID。返回这个Customer中租的所的Film，按租用时间倒排序。（10分）
    // Customer ID: id
    // `name` 租用的Film
    // Film ID | Film 名称 | 租用时间
    // 628 | NORTHWEST POLISH | 2005-08-23 15:35:59
    // ... | ... | ...
    // 5、数据库连接信息需要从java的配置文件变量中读取。包含：ip、端口、数据库名、用户名、密码。（5分）
    // 6、程序中使用的Country ID和Customer ID需要从配置文件变量中读取。（5分）
    public static void main(String[] args) {
        new MyJDBC();
    }
}
