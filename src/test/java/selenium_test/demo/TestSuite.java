package selenium_test.demo;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AllArgsConstructor
public class TestSuite {
    GooglePage googlePage;
    AmazonPage amazonPage;

    @Test
    void googleSearch() {
        googlePage.load();
        googlePage.search("bugs bunny");
        Assertions.assertEquals("bugs bunny - Google Search", googlePage.getTitle());
    }

    @Test
    void shouldGetALotOfResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bunny");
        Assertions.assertTrue(amazonPage.getResultCount() >= 100_000);
    }

    @Test
    void shouldGetFewerResults() throws Exception {
        amazonPage.load();
        amazonPage.search("bugs bunny dvd");
        Assertions.assertTrue(amazonPage.getResultCount() < 100_000);
    }
}
