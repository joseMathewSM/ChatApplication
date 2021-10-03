package com.jose.exercise2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Exercise2ApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private LoginPage loginPage;
	private SignupPage signupPage;
	private ChatPage chatPage;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){driver.quit();}


	@Test
	public void testSignUp() {
		driver.get("http://localhost:" + port + "/signup");
		signupPage = new SignupPage(driver);
		signupPage.signupUser("jose", "mathew", "jmpunk","test");
		signupPage.validateSuccessfullSignup();
		driver.get("http://localhost:" + port + "/login");
		loginPage = new LoginPage(driver);
		loginPage.loginUser("jmpunk", "test");
		chatPage = new ChatPage(driver);
		chatPage.publishMsg("fuckU", "Say");
		chatPage.validateMsg("fuckU");

	}

	@Test
	public void testLogin() {
		driver.get("http://localhost:" + port + "/login");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void testChat() {
		driver.get("http://localhost:" + port + "/chat");
		loginPage = new LoginPage(driver);
	}

}
