import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testToDo {
    public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver","browserDriver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            String url = "https://todomvc.com/examples/vue/";
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement textBox = driver.findElement(By.className("new-todo"));
            textBox.sendKeys("L1");
            textBox.sendKeys(Keys.ENTER);

            textBox.sendKeys("L2");
            textBox.sendKeys(Keys.ENTER);
            textBox.sendKeys("L3");
            textBox.sendKeys(Keys.ENTER);
            textBox.sendKeys("L4");
            textBox.sendKeys(Keys.ENTER);
            textBox.sendKeys("L5");
            textBox.sendKeys(Keys.ENTER);

            List<WebElement> totalEntries = driver.findElements(By.xpath("//ul[@class='todo-list']"));
            driver.findElement(By.xpath("//ul[@class='todo-list']/li[1]/div/input[@class='toggle']")).click();
            driver.findElement(By.xpath("//ul[@class='todo-list']/li[4]/div/input[@class='toggle']")).click();

            driver.findElement(By.xpath("//ul[@class='filters']/li/a[contains(text(),'Active')]")).click();
            List<WebElement> actList = driver.findElements(By.xpath("//ul[@class='todo-list']"));
            String[] activeList = new String[actList.size()];

                for (WebElement w : actList){
                    for (int i=0;i<activeList.length;i++){
                        activeList[i] = w.getText();
                        System.out.println(activeList[i]);
                }
            }
            String[] totalEnt = new String[totalEntries.size()];
                for(WebElement we : totalEntries) {
                    for (int i = 0; i < totalEntries.size(); i++) {
                        totalEnt[i] = we.getText();
                    }
                }

                driver.findElement(By.xpath("//ul[@class='filters']/li/a[contains(text(),'Completed')]")).click();
                List<WebElement> comList = driver.findElements(By.xpath("//ul[@class='todo-list']"));
                String[] completedList = new String[comList.size()];
            for (WebElement wc:comList) {
                for (int i = 0; i < totalEntries.size(); i++) {
                    completedList[i] = wc.getText();
                }
            }

            int count = 0;

                        for (int i=0;i<activeList.length;i++){
                            for (int j=0;j<completedList.length;j++){
                                if (activeList[i].equals(completedList[j]))
                                    count++;
                            }
                        }
                        if (count>0){
                            System.out.println("Active and Completed links are working as expected");
                        }
                        else
                            System.out.println("All the Functionalities are working as expected");


                    driver.quit();
    }
}
