package Basics;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class userLogIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext context =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1009));
		Page page = context.newPage();
		
		page.navigate("https://ecommerce-playground.lambdatest.io/");
//		page.pause();
		page.locator("(//a[@data-toggle='dropdown'])[3]").hover();
		page.click("//span[contains(.,' Login')]");
		
		assertThat(page).hasTitle("Account Login");
//		page.pause();
		
		page.getByPlaceholder("E-Mail Address").click();
	    page.getByPlaceholder("E-Mail Address").fill("prajwalgadekar03@gmail.com");
	    page.getByPlaceholder("Password").click();
	    page.getByPlaceholder("Password").fill("Pass#123");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	 

	}

}
