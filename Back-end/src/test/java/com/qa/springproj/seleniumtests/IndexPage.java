package com.qa.springproj.seleniumtests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

	public final String url = "http://127.0.0.1:5500/HTML/index.html";

	@FindBy(id = "post1")
	public WebElement name;

	@FindBy(id = "post2")
	public WebElement priority;

	@FindBy(xpath = "/html/body/h1")
	private WebElement title;

	@FindBy(xpath = "/html/body/footer/p")
	private WebElement footer;

	@FindBy(xpath = "/html/body/div[1]/button")
	public WebElement readBtn;

	@FindBy(xpath = "/html/body/div[2]/button")
	public WebElement createBtn;

	@FindBy(xpath = "/html/body/div[3]/button")
	public WebElement updateBtn;

	@FindBy(xpath = "/html/body/div[4]/button")
	public WebElement deleteBtn;

	@FindBy(xpath = "/html/body/div[1]/table")
	public WebElement readAll;

	@FindBy(xpath = "/html/body/div[3]/input[1]")
	private WebElement updateIdInput;

	@FindBy(xpath = "/html/body/div[4]/input")
	private WebElement deleteIdInput;

	@FindBy(xpath = "/html/body/div[3]/input[2]")
	private WebElement updateNameInput;

	@FindBy(xpath = "/html/body/div[3]/input[3]")
	private WebElement updatePriorityInput;

	@FindBy(xpath = "/html/body/div[2]/p[2]")
	private WebElement createMsg;

	@FindBy(xpath = "/html/body/div[3]/p[2]")
	private WebElement updateMsg;

	@FindBy(xpath = "/html/body/div[4]/button")
	private WebElement deleteMsg;

	public void enterNewToDo(String todoName, int todoPriority) {
		name.sendKeys(todoName);
		priority.sendKeys(String.valueOf(todoPriority));
		createBtn.click();

	}

	public String checkFooter() {
		return footer.getText();
	}

	public String checkTitle() {
		return title.getText();
	}

	public void readBtn() {

		readBtn.click();
	}

	public void updateBtn() {

		updateBtn.click();
	}

	public void deleteBtn() {

		deleteBtn.click();
	}

	public String readAllTest() {
		return readAll.getText();
	}

	public WebElement readAll() {
		return readAll;
	}

	public void insertIdUpdate(String id) {
		updateIdInput.sendKeys(id);
	}

	public void insertIdDelete(String id) {
		deleteIdInput.sendKeys(id);
	}

	public void insertNameInputUpdate(String name) {
		updateNameInput.sendKeys(name);
	}

	public void insertPriorityInputUpdate(int priority) {
		updatePriorityInput.sendKeys(String.valueOf(priority));
	}

	public WebElement getCreateMsg() {
		return createMsg;
	}

	public WebElement getUpdateMsg() {
		return updateMsg;
	}

	public WebElement getDeleteMsg() {
		return deleteMsg;
	}
}
