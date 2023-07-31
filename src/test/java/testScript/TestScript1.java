package testScript;

import bassclass.AppiumDriverManager;
import bassclass.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.homepage;
import pages.verify;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestScript1 extends BaseClass {

    @Test
    public void test1() throws InterruptedException {
        homepage home=new homepage(driver);
        home.Validate_Butter_image();
        home.Validate_addtocart_prod();
        home.Validate_viewplaceorder();

    }
    @Test
    public void test2() throws InterruptedException {
        homepage home=new homepage(driver);
         home.catagories();
         home.veriy_sunflower();
        home.addto_cart();
         home.View_oil();
    }
    @Test
    public void validate_todelete_cart() throws InterruptedException {
        homepage home=new homepage(driver);
        home.Verify_delete_cart();
        home.Validate_viewtodelete();

    }
    @Test
    public void Vlidate_track_order() throws InterruptedException {
        homepage home=new homepage(driver);
        home.Verify_orderViwe();
        home.verify_trackorderdetiles();
    }
    @Test
       public void Validate_multilple_order(){
          homepage home=new homepage(driver);
        home.catagories();
        home.Verifythe_multilpe_order();

    }
    @Test
    public void Validate_placemultiple_order(){
        homepage home=new homepage(driver);
        home.catagories();
        home.verify_placemultiple_order();

    }
    @Test
    public void Order_again() throws InterruptedException {
        homepage home=new homepage(driver);
        home.Verify_orderViwe();
        home.verify_trackorderdetiles();
        home.Verify_OrderAgain();

    }

}
