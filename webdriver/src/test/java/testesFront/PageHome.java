package testesFront;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageHome {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getenv("Driver"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.className("gLFyf")).sendKeys("Senai");
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
	}

	@Test
	public void realizarPesquisa() {

		// Busca
		driver.findElement(By.className("LC20lb")).click();
		driver.findElement(By.id("idControle_0")).click();
		driver.findElement(By.id("ctl00_Header1_MenuSuperior1_rptMenuLateral_ctl00_rptMenu_ctl05_lnkMenu")).click();
		driver.findElement(By.id("oqEstabuscando")).click();
		driver.findElement(By.id("oqEstabuscando")).sendKeys("técnico");
		driver.findElement(By.className("btnBuscaJavaScript")).click();
		driver.findElement(By.id("oqEstabuscando")).click();
		driver.findElement(By.id("oqEstabuscando")).sendKeys("técnico");
		driver.findElement(By.className("btnBuscaJavaScript")).click();

		// Clicka no link da pesquisa
		driver.findElement(By.id("ctl00_cp_lv_ctrl7_lnkTitu")).click();
		driver.findElement(By.id("OWA2319fb38-838f-9a9a-72ae-67843c8f418f")).click();
	}

	public void fecharNavegador(WebDriver driver) {
		driver.quit();
	}

	public void navegarParaNovaAba() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.findElement(By.id("lnkCaseBtn")).click();
		driver.switchTo().window(tabs.get(3));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void fechar() throws Exception {
		  driver.quit();
	}
}
