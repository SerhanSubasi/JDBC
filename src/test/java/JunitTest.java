import org.junit.Assert;
import org.junit.Test;

public class JunitTest {
    // Assertion: Test sonuçlarını doğrulamak için yaptığımız işlemlerdir.
    // Testin kaldığını ya da geçtiğini anlamak için assertion methodlarını kullanırız.


    // ASSERTION TÜRLERİ
    // 1. assertEquals() --> İçerisine eklenen parametreler birbiriyle eşitse test geçer, değilse fail olur.

    @Test
    public void test01() {
        String expectedData = "Selam";
        String actualData = "Selam";

        Assert.assertEquals(expectedData, actualData);
    }

    // 2. assertTrue() --> İçerisine eklenen işlemin sonucu TRUE ise test geçer, FALSE ise test kalır.
    @Test
    public void test02() {
        int sayi = 5;

        Assert.assertTrue(sayi > 5);

    }

    // 3. assertNotEquals() --> İçerisine eklenen parametreler birbiriyle eşit değilse test geçer, eşitse fail olur.
    @Test
    public void test03 () {
        int sayi1= 5;
        int sayi2= 6;

        Assert.assertNotEquals(sayi1,sayi2);

    }

    // 4. assertFalse() --> İçerisine eklenen işlemin sonucu FALSE ise test geçer, TRUE ise test kalır.
@Test
    public void test04 () {
    int sayi = 5;

    Assert.assertFalse(sayi > 5);

}




}