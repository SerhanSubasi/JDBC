
/*
PreparedStatement, Statement'ı extend eder. (Statement'ın gelişmiş hali)
PreparedStatement ile önceden hazırlanmış tekrar tekrar kullanılabilen
parametreli sorgular oluşturup çalıştırabiliriz.

 */

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        Statement st = con.createStatement();

  //ÖRNEK1:(Prepared Statement kullanarak) bolumler tablosunda Matematik bölümünün taban_puani'nı 475 olarak güncelleyiniz.
  //st.executeUpdate("UPDATE bolumler SET taban_puani=475 WHERE bolum='Matematik'");

  //Sorguyu parametreli olarak oluşturur '?' ile.
  String query = "UPDATE bolumler SET taban_puani=? WHERE bolum=?";
  PreparedStatement prst = con.prepareStatement(query); // değişkene atadığımız için bu aşama var
  prst.setInt(1,475);
  prst.setString(2,"Matematik");

  int updated=prst.executeUpdate();
  System.out.println("updated = " + updated);

  //ÖRNEK2:(Prepared Statement kullanarak) bolumler tablosunda Edebiyat bölümünün taban_puanı'nı 455 olarak güncelleyiniz.

  prst.setInt(1,455);
  prst.setString(2,"Edebiyat");

  int updated2=prst.executeUpdate();
  System.out.println("updated = " + updated2);

  System.out.println("----------------------------------------------");

  //ÖRNEK3:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.
  PreparedStatement prst2= con.prepareStatement("DELETE FROM ogrenciler WHERE bolum ILIKE ?");
  prst2.setString(1,"Matematik");
  int deleted = prst2.executeUpdate();
  System.out.println("deleted = " + deleted);

  //ÖRNEK4:Prepared Statement kullanarak bolumler tablosuna
  // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.

  System.out.println("----------------------------------------------");

  String sql = "INSERT INTO bolumler VALUES (?,?,?,?) ";
  PreparedStatement prst3 = con.prepareStatement(sql);

  prst3.setInt(1,5006);
  prst3.setString(2,"Yazılım Mühendisliği");
  prst3.setInt(3,475);
  prst3.setString(4,"Merkez");

  int updated3 = prst3.executeUpdate();
  System.out.println("updated3 = " + updated3);


        System.out.println("-------------ÖDEVV---------------");
        //1-Bölüm isimlerini, kampüslerini ve her bir bölümde okuyan öğrencilerin en yüksek puanlarını listeleyiniz.
            ResultSet soru1= st.executeQuery("SELECT b.bolum,b.kampus,MAX(o.puan) AS en_yuksek_puan FROM bolumler AS b LEFT JOIN ogrenciler AS o ON b.bolum=o.bolum GROUP BY b.bolum,b.kampus");
            while (soru1.next()) {
                System.out.println(soru1.getString("bolum") + "--" + soru1.getString("kampus") + "--" + soru1.getInt("en_yuksek_puan"));
            }

        System.out.println("-------------------------------------------------");

        //2-it_persons tablosundan prog_lang css olanları siliniz.
        int deleted5 = st.executeUpdate("DELETE FROM it_persons WHERE prog_lang='Css'");
        System.out.println("Silinenler: " + deleted5);
        System.out.println("--------------------------------------------------");
        //3-it_persons tablosundan prog_lang java olanları siliniz.
        String java1 =("DELETE FROM it_persons WHERE prog_lang='Java'");
        int result7= st.executeUpdate(java1);
        System.out.println("silinenler: "+result7);



        st.close();
        prst.close();
        con.close();
    }
}
