import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DseTableScraperTest {

    private WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    @DisplayName("Scrape DSE share-price table: print & save all cells")
    public void scrapeAndSaveDseTable() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebElement table = driver.findElement(
                By.cssSelector("div.table-responsive.inner-scroll table.table-bordered")
        );

        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));

        System.out.println("Output file: " +
                new java.io.File("dse_table_output.txt").getAbsolutePath()
        );

        try (FileWriter writer = new FileWriter("dse_table_output.txt")) {
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    String text = cell.getText().trim();
                    System.out.print(text + " | ");
                    writer.write(text + " | ");
                }
                System.out.println();
                writer.write(System.lineSeparator());
            }
        }
    }


    @AfterAll
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
