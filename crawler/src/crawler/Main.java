package crawler;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {

	public static void main(String[] args) throws InterruptedException{
	    
		//����������
		final String url =
				"http://www.cine21.com/search/?q=%EC%9A%94%EC%A6%98+%EB%AD%90%EC%9D%BD%EC%96%B4";
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//������ ��ư ������
		driver.findElement(By.partialLinkText("�� ���� ���/���� ����")).click();
		
		System.out.println
		("====================To Read List====================");
		
		
		//ù��° ������ å ���� �����ϱ�
		getTitle(driver);
		
		
		//������������ �ִ� å ���� �����ϱ�
        clickNextPage(driver);		
	}
		
		static void getTitle(WebDriver driver) {
			
			List<WebElement> bookInfo = 
					driver.findElements(By.className("tit"));
			for(WebElement bookInfos : bookInfo) {
				String tobeSplit = bookInfos.getText();
				String splited[] = tobeSplit.split("]");
				String finalBname = splited[splited.length-1];
				System.out.println(finalBname);
				System.out.println();
			}
			
		}
		static void clickNextPage(WebDriver driver) {
			for(int i=2;i<=10;i++) {
				String str = String.valueOf(i);
				driver.findElement(By.linkText(str)).click();
				getTitle(driver);
			}
		
		}
}
