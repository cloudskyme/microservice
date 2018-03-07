/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    AuthorService.java
 *
 *    Description: 服务层，用于查询jooq
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2018年3月6日 下午6:03:19
 *
 *    Revision:
 *
 *    2018年3月6日 下午6:03:19
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import com.cloud.skyme.tables.Author;

/**
 * @ClassName AuthorService
 * @Description 服务层，用于查询jooq
 * @author zhangfeng
 * @Date 2018年3月6日 下午6:03:19
 * @version 1.0.0
 */
@Service
public class AuthorService {
	
	public static final Author AUTHOR = new Author();
	
	public void authSearch() {
		// 用户名
        String userName = "root";
        // 密码
        String password = "123456";
        // mysql连接url
        String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(AUTHOR).fetch();

            for (Record r : result) {
                Integer id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);

                /**
                 * 控制台输出
                 * ID: 1 first name: 3 last name: zhang
                 * ID: 2 first name: 4 last name: li
                 */
                System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }

            // 关闭连接对象
            conn.close();
        }
        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
