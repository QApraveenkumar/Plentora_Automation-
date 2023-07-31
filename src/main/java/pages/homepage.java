package pages;


import bassclass.MobileInteraction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class homepage extends PomPage {
    
    
    MobileInteraction Action = new MobileInteraction();
    @FindBy(xpath = "//android.view.View[@content-desc='CATEGORIES']/preceding-sibling::android.widget.EditText[1]")
    private WebElement serchbar;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Butter\"]")
    private WebElement ButterImage;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Paneer\"]")
    private WebElement pannerImage;
    
    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"ADD\"])[1]")
    private WebElement addButton;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/descendant::android.widget.ImageView[3]")
    private WebElement viewcart;
    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'PLACE ORDER')]")
    private WebElement click_placeOrder;
    @FindBy(xpath = "(//android.view.View[contains(@content-desc,'Best Price')])[1]/child::android.view.View[2]")
    private WebElement Click_add_plusview;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/descendant::android.widget.ImageView[1]")
    private WebElement backbutton;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"ORDER SUMMARY\"]")
    private WebElement ordersummary;
    @FindBy(xpath = "//android.view.View[@content-desc=\"ORDER PLACED.\"")
    private WebElement oderplased;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Categories\"]")
    private WebElement catalgories;
    @FindBy(xpath = "//android.view.View[@content-desc=\"OILS\"]")
    private WebElement oilmenu;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sunflower Oil\"]")
    private WebElement sunflower;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Showing order placed in last 30 days\"]")
    private WebElement orderplasdviwe;
    @FindBy(xpath = "//android.widget.FrameLayout [@resource-id=\"android:id/content\"]/descendant::android.widget.ImageView[1]")
    private WebElement Click_barview;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='My Orders']")
    private WebElement Clickbar_tomyorderView;
    @FindBy(xpath = "(//android.view.View[contains(@content-desc,'Best Price')])[1]/descendant::android.widget.ImageView[3]")
    private WebElement Shaping_card_delete;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/descendant::android.widget.ImageView[1]")
    private WebElement click_BackbuttonImage;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Frozen Fries\"]")
    private WebElement click_frozenimage;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Showing order placed in last 30 days\"]")
    private WebElement click_toVerify_30Days_only;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/descendant::android.widget.ImageView[6]")
    private WebElement click_order_details;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"ORDER AGAIN\"]/preceding-sibling::android.widget.ImageView[3]")
    private WebElement click_trackorder;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Order ID\"]")
    private WebElement show_ordrer_id;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Potato Pops\"]")
    private WebElement Potato;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Maida\"]")
    private WebElement maida2;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Diced Cheese\"]")
    private WebElement Diced1;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"ORDER AGAIN\"]")
    private WebElement Click_orderagain;
    
    public homepage(AndroidDriver driver) {
        
        super(driver);
    }
    
    public void Validate_Butter_image() {
        //  Assert.assertTrue(pannerImage.isDisplayed());
        pannerImage.click();
    }
    
    public void Validate_frozen_image() {
        click_frozenimage.click();
    }
    
    public void Validate_addtocart_prod() {
        //  Assert.assertTrue(addButton.isEnabled());
        addButton.click();
        Click_add_plusview.click();
    }
    
    public void Validate_viewplaceorder() {
        viewcart.click();
        click_placeOrder.click();
        //  Assert.assertTrue(oderplased.isDisplayed());
        ordersummary.click();
    }
    
    public void catagories() {
        catalgories.click();
    }
    
    public void veriy_sunflower() {
        Action.swipeUp(2);
        sunflower.click();
    }
    
    public void addto_cart() {
        addButton.click();
        Click_add_plusview.click();
    }
    
    public void View_oil() throws InterruptedException {
        viewcart.click();
        click_placeOrder.click();
        ordersummary.click();
        Thread.sleep(5000);
        
    }
    
    public void Verify_orderViwe() throws InterruptedException {
        Click_barview.click();
        Clickbar_tomyorderView.click();
    }
    
    public void verify_trackorderdetiles() throws InterruptedException {
        click_order_details.click();
        click_trackorder.click();
        Thread.sleep(6000);
        Assert.assertTrue(show_ordrer_id.isDisplayed());
        
    }
    
    public void Verify_delete_cart() {
        // catalogimage.click();
        // Action.swipeUp(2);
        ButterImage.click();
        //sunflower.click();
        addButton.click();
    }
    
    public void Validate_viewtodelete() throws InterruptedException {
        //   Click_add_plusview.click();
        Thread.sleep(2000);
        viewcart.click();
        click_order_details.click();
        Thread.sleep(4000);
        click_BackbuttonImage.click();
        Thread.sleep(3000);
    }
    
    public void Verifythe_multilpe_order() {
        Potato.click();
        addButton.click();
        click_BackbuttonImage.click();
        Action.swipeUp(2);
        maida2.click();
        addButton.click();
        click_BackbuttonImage.click();
        Action.swipeUp(2);
        sunflower.click();
        addButton.click();
        click_BackbuttonImage.click();
        Action.swipeUp(3);
        Diced1.click();
        addButton.click();
        click_BackbuttonImage.click();
    }
    
    public void verify_placemultiple_order() {
        viewcart.click();
        click_placeOrder.click();
        ordersummary.click();
    }
    
    public void Verify_OrderAgain() {
        Click_orderagain.click();
        addButton.click();
        viewcart.click();
        click_placeOrder.click();
        ordersummary.click();
    }
    
}

