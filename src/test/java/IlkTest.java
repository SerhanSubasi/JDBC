public class IlkTest {
   /*
        Expected Data: Beklenen Data
        Actual Data: Gerçek Data

        Test, beklenen data ile gerçek datanın karşılaştırılmasıdır.
         */
    public static void main(String[] args) {

        String expectedData = "Selam";
        String actualData = "Selam";

        System.out.println("---------------------Test 1---------------------");
        if (expectedData.equals(actualData)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }




            int expectedNumber = 5;
            int actualNumber = 5;

        System.out.println("---------------------Test 2---------------------");
            if (expectedNumber==actualNumber) {
                System.out.println("Test PASSED");
            } else {
                System.out.println("Test FAILED");
            }




        System.out.println("---------------------Test 3---------------------");
            if (expectedNumber>actualNumber) {
            System.out.println("Test PASSED");
             } else {
            System.out.println("Test FAILED");
            }


            // Otomasyon testleri yapabilmek için bir test framework'üne ihtiyacımız vardır. (JUnit, TestNG, Cucumber)

    }
}
