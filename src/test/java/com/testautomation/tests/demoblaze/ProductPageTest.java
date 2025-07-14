package com.testautomation.tests.demoblaze;

import com.testautomation.core.LoggerUtil;
import com.testautomation.core.MyTest;
import com.testautomation.pages.demoblaze.HomePage;
import com.testautomation.pages.demoblaze.ProductPage;
import com.testautomation.tests.common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
  private HomePage homePage;
  private ProductPage productPage;

  @BeforeClass
  public void setUpClass() {
    super.setUpClass();
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
  }

  @MyTest(
      testCaseId = "DBZ-004",
      description = "Verify adding a product to cart from product page",
      author = "Your Name",
      tags = {"cart", "product"})
  @Test
  public void testAddToCart() {
    LoggerUtil.info("Selecting first product");
    homePage.selectFirstProduct();
    LoggerUtil.info("Adding product to cart");
    productPage.addToCart();
    // Add assertion for cart update or alert as needed
  }
}
