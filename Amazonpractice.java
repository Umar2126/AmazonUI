package com.javabasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazonpractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mobile Programming\\eclipse-workspace\\Umar\\driver\\chromedriver.exe");}
	
		

	private WebDriver driver;		
	public void GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
		}
		
		private String searchTextBoxName = "q";
		private String searchResultsLinks = "//*[@class='LC20lb MBeuO DKV0Md']";
		
		public void gotoPage(String url) {
			driver.get(url);
		}
		
		public void enterSearchText(String searchText) {
			WebElement search = driver.findElement(By.name(searchTextBoxName));
			search.click();
			search.clear();
			search.sendKeys(searchText);
			search.sendKeys(Keys.ENTER);
		}
		
		public void printSearchResults() {
			List<WebElement> results = driver.findElements(By.xpath(searchResultsLinks));
			for(WebElement result: results) {
				System.out.println(result.getText());
			}
		}
		
		public void clickOnLink(String link) {
			driver.findElement(By.xpath("//a[@href='" + link + "']")).click();
		}
		public void AmazonHomePage(WebDriver driver) {
			this.driver = driver;
		}
		
		private String loginButtonId 			= "nav-link-accountList";
		private String loginIdTextboxName		= "email";
		private String continueButtonId			= "continue";
		private String loginPasswordTextboxId	= "ap_password";
		private String signInButtonId			= "signInSubmit";
		
		private String categoryDropDownId 	= "searchDropdownBox";
		private String searchTextBoxId 		= "twotabsearchtextbox";
		private String searchButtonId 		= "nav-search-submit-button";
		
		public void gotoSignInPage() {
			driver.findElement(By.id(loginButtonId)).click();
		}
		
		public void signIn(String id, String password) {
			driver.findElement(By.name(loginIdTextboxName)).sendKeys(id);
			driver.findElement(By.id(continueButtonId)).click();
			driver.findElement(By.id(loginPasswordTextboxId)).sendKeys(password);
			driver.findElement(By.id(signInButtonId)).click();
		}
		
		public void selectCategory(String category) {
			WebElement ele = driver.findElement(By.id(categoryDropDownId));
			Select sel = new Select(ele);
			sel.selectByVisibleText(category);
		}
		
		public void search(String searchText) {
			WebElement ele = driver.findElement(By.id(searchTextBoxId));
			ele.click();
			ele.clear();
			ele.sendKeys(searchText);
			
			driver.findElement(By.id(searchButtonId)).click();
		}
		
	}

		
	
