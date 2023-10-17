import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction02 {

    public static void main(String[] args) throws SQLException {
//olması gereken senaryo:birlikte çalışması gereken işlemler
//tek bir transaction içine alınmalı(veri tutarlılığı için)
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","techpro","password");
        //transaction yönetimini ele alalım
        con.setAutoCommit(false);

        //hesap_no:1234 olan müşteri hesap_no:5678 olan müşteriye 1000 para transferi gerçekleştirsin.
        PreparedStatement prst=null;
        try{
            String sql="UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
            prst= con.prepareStatement(sql);

            //1-para transferi yapan hesap
            prst.setInt(1,-1000);
            prst.setInt(2,1234);
           int result = prst.executeUpdate();

            //sistemsel hata oluştu
            if (false){
                throw new Exception();//burada uygulama durur
            }

            //2-para transferi alan hesap
            prst.setInt(1,1000);
            prst.setInt(2,5678);
           int result2 = prst.executeUpdate();

            con.commit();
            prst.close();
            con.close();
            System.out.println("transfer gerçekleşti");

        }catch (Exception e){

            con.rollback();
            System.out.println(e.getMessage());
            System.out.println("işlem başarısız");
            prst.close();
            con.close();

        }






    }
}