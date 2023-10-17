
/*
Transaction: Database'deki parçalanamaz atomic en küçük işlemdir.
Birden fazla işlemi paket halinde tek bir transaction olarak kullanabiliriz.
Bu işlemlerden en az bir tanesi başarısız olursa ROLLBACK ile diğerlerini de iptal edebiliyor ve
böylece verilerde tutarlılık sağlanıyor.

Bu işlemlerin tamamı başarılı olursa, değişiklikleri  DB'de kalıcı hale getirmek için Transaction COMMIT edilir.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction01 {
    public static void main(String[] args) throws Exception {
// olmaması gereken senaryo.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");

        //hesap_no:1234 olan müşteri hesap_no:5678 olan müşteriye 1000 para transferi gerçekleştirsin.
        String sql= "UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
        PreparedStatement prst = con.prepareStatement(sql);

         prst.setInt(1,-1000);
         prst.setInt(2,1234);

         int result1 = prst.executeUpdate();

         // Sistemsel hata anı
        if (true) {
            throw new Exception();
        }

         prst.setInt(1,1000);
         prst.setInt(2,5678);

         int result2 = prst.executeUpdate();




    }
}
