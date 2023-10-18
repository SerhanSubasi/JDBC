import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest04ÖDEV {
       /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir

    Then
      Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest() throws SQLException {
        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        Statement st = con.createStatement();

        //  Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir
        String sql = "SELECT region_id FROM countries WHERE region_id>1";
        ResultSet resultSet = st.executeQuery(sql);

        // Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrular
        int actualData = 0;
        while (resultSet.next()) {
            actualData++;
        }
        int expectedData = 17;
        Assert.assertEquals(expectedData,actualData);
    }
}
