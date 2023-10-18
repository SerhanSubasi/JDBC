import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountryTest03 {
     /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

    Then
      Kullanıcı, ülke isimlerini doğrular: "Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest() throws SQLException {
        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        Statement st = con.createStatement();

        // Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir
        String sql = "SELECT country_name FROM countries WHERE region_id = 1";
        ResultSet resultSet = st.executeQuery(sql);

        // Kullanıcı, ülke isimlerini doğrular: "Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom"
        List<String> actualData = new ArrayList<>();
        while (resultSet.next()) {
           String ulkeAdi = resultSet.getString("country_name");
            actualData.add(ulkeAdi);
        }

        List<String> expectedDate = Arrays.asList("Belgium", "Switzerland", "Germany", "Denmark", "France", "Italy", "Netherlands", "United Kingdom");


        Assert.assertEquals(actualData,expectedDate);

    }
}
