import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest02 {
    /*

    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

    Then
      Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 olduğunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    @Test
    public void countryTest() throws SQLException {
        // Kullanıcı veritabanına bağlanır
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "techpro", "password");
        Statement st = con.createStatement();

        // Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir
        String sql = "SELECT country_id FROM countries WHERE region_id = 1";
        ResultSet resultSet = st.executeQuery(sql);

        // Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısının 8 olduğunu doğrular
        int actualData = 0;
        while (resultSet.next()) {
            actualData++;
            }


        int exceptedData = 8;
        Assert.assertEquals(exceptedData,actualData);

       // Kullanıcı, bağlantıyı kapatır
        con.close();
        st.close();

    }

}
