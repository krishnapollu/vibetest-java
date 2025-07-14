package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.demoblaze.CartPage;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.pages.demoblaze.ProductPage;
import com.testautomation.tests.common.BaseTest;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
  private HomePage homePage;
  private ProductPage productPage;
  private CartPage cartPage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
  }

  @DataProvider(name = "orderData")
  public Object[][] orderData() throws IOException {
    Properties props = new Properties();
    // Always use forward slashes for resource loading
    props.load(getClass().getClassLoader().getResourceAsStream("testdata/order.properties"));
    return new Object[][] {
      {
        props.getProperty("name"),
        props.getProperty("country"),
        props.getProperty("city"),
        props.getProperty("card"),
        props.getProperty("month"),
        props.getProperty("year")
      }
    };
  }

  @MyTest(
      testCaseId = "DBZ-005",
      description = "Verify placing an order from the cart page",
      author = "Your Name",
      tags = {"cart", "order"})
  @Test(dataProvider = "orderData")
  public void testPlaceOrder(
      String name, String country, String city, String card, String month, String year) {
    LoggerUtil.info("Selecting first product and adding to cart");
    homePage.selectFirstProduct();
    productPage.addToCart();
    homePage.goToCart();
    cartPage.clickPlaceOrder();
    cartPage.fillOrderForm(name, country, city, card, month, year);
    cartPage.clickPurchase();
    // Add assertion for order confirmation as needed
  }
}
