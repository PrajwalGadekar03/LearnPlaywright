package Basics;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class userRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://ecommerce-playground.lambdatest.io/");
//		page.pause();
		page.locator("(//a[@data-toggle='dropdown'])[3]").hover();
		page.click("//span[contains(.,' Register')]");
		
		assertThat(page).hasTitle("Register Account");
		page.getByPlaceholder("First Name").fill("Prajwal");
//		page.pause();
		
		page.getByPlaceholder("Last Name").fill("Gadekar");
	      page.getByPlaceholder("E-Mail").fill("prajwalgadekar03@gmail.com");
	      page.getByPlaceholder("Telephone").fill("8975370911");
	      page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("Pass#123");
	      page.getByPlaceholder("Password Confirm").fill("Pass#123");
	      page.getByText("Yes").click();
	      page.getByText("I have read and agree to the").click();
//	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
		
		
		
		

	}

}
