package com.qa.springproj.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;

import com.qa.springproj.seleniumtests.IndexPage;

public class IndexTest {

	private WebDriver driver;

	@BeforeEach
	public void setup() {

		/*
		 * ChromeOptions options = new ChromeOptions(); options.setHeadless(true);
		 */
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	@Test
	public void checkFooter() throws InterruptedException {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		assertTrue(indexPage.checkFooter().contains("2021 © George Project Week 8"));
		
		Thread.sleep(1000);
	}

	@Test
	public void checkTitle() throws InterruptedException {
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		assertTrue(indexPage.checkTitle().contains("To Do list"));
		
		Thread.sleep(1000);
	}

	@Test
	public void testCreate() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		String name = "run a test";

		int priority = 1;

		String create = "To do created";

		this.driver.get(indexPage.url);

		indexPage.enterNewToDo(name, priority);

		Thread.sleep(4000);

		assertThat(indexPage.getCreateMsg().getText()).contains(create);

	}

	@Test
	public void testRead() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		String readTest = "Run a test";

		indexPage.readBtn();

		Thread.sleep(4000);

		assertThat(indexPage.readAll().getText()).contains(readTest);

	}

	@Test
	public void testUpdate() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		this.driver.get(indexPage.url);

		String update = "To Do Updated";

		indexPage.insertIdUpdate("94");

		indexPage.insertNameInputUpdate("Service the guitar");

		indexPage.insertPriorityInputUpdate(3);

		indexPage.updateBtn();

		Thread.sleep(4000);

		assertThat(indexPage.getUpdateMsg().getText()).contains(update);
	}

	@Test
	public void testDelete() throws InterruptedException {
		
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		
		this.driver.get(indexPage.url);

		indexPage.insertIdDelete("97");

		indexPage.deleteBtn();

		Thread.sleep(4000);

		assertThat(indexPage.getDeleteMsg().getText().contains("Delete To Do"));
	}

	@AfterEach
	public void teardown() {
		
		this.driver.quit();
	}

}