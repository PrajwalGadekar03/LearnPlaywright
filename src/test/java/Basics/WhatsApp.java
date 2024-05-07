package Basics;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class WhatsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println(width +":"+ height);
		
		Playwright playw = Playwright.create();
		Browser brow = playw.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext context = brow.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = context.newPage();
		
		page.navigate("https://www.whatsapp.com/");
//		page.pause();
		
	    page.getByTestId("whatsapp_www_header").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("WhatsApp Web")).click();
	    page.navigate("https://web.whatsapp.com/");
	    page.waitForTimeout(35_000);
	    page.getByRole(AriaRole.PARAGRAPH).click();
	    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search input textbox")).fill("8975370911");
	    page.getByText("#प्रज्वल_गाडेकर_").click();
	      
	    for(int i=1;i<=10;i++) {
	    	  
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type a message")).getByRole(AriaRole.PARAGRAPH).click();
		    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Type a message")).fill("PlayWright");
		    page.getByLabel("Send").click();
	    	  
	    }
				

	}

}
