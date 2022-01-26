package dev.lee.util;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectionUtilTest {

    private static ConnectionUtil connectionUtil;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connectionUtil = ConnectionUtil.getConnectionUtil();
    }

    @Test
    public void testConnectionFactoryIsAbleToGetConnection() {
        Connection conn = connectionUtil.getConnection();

        assertThat(conn, instanceOf(Connection.class));
    }
}
