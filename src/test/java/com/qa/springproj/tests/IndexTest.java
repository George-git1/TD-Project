package com.qa.springproj.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.springproj.seleniumtests.IndexPage;

public class IndexTest {

	private WebDriver driver;

	@Before
	public void setup() {

		/*
		 * ChromeOptions options = new ChromeOptions(); options.setHeadless(true);
		 */

		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

	}

	@Test
	public void checkFooter() throws InterruptedException {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		assertTrue(indexPage.checkFooter().contains("2021 © George Project Week 8"));
	}

	@Test
	public void checkTitle() throws InterruptedException {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		assertTrue(indexPage.checkTitle().contains("To Do list"));
	}

	@Test
	public void testCreate() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		String name = "run a test";
		int priority = 1;
		String create = "To do created";

		this.driver.get(indexPage.url);

		indexPage.enterNewToDo(name, priority);

		assertThat(indexPage.getCreateMsg().getText()).contains(create);

		Thread.sleep(2000);
	}

	@Test
	public void testRead() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(indexPage.url);

		String readTest = "Run a test";

		indexPage.readBtn();

		assertThat(indexPage.readAll().getText()).contains(readTest);

		Thread.sleep(2000);
	}

	@Test
	public void testUpdate() throws InterruptedException {

		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		this.driver.get(indexPage.url);
		String update = "data updated";

		indexPage.insertIdUpdate("5");
		indexPage.insertNameInputUpdate("Buy a guitar");
		indexPage.insertPriorityInputUpdate(3);

		indexPage.updateBtn();

		assertThat(indexPage.getUpdateMsg().getText()).contains(update);
	}

	@Test
	public void testDelete() throws InterruptedException {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		this.driver.get(indexPage.url);

		indexPage.insertIdDelete("11");

		assertThat(indexPage.getDeleteMsg().getText()).contains("deleted successfully");
	}

	@After
	public void teardown() {
		this.driver.quit();
	}

}