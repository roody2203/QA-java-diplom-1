package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

public class BunTest {

    @Test
    public void bunTest() {
        Bun bun = new Bun("Bun", 100);
        assertNotNull("Ошибка при создании объекта Bun", bun);
    }

    @Test
    public void getNameTest() {
        String name = "Bun";

        Bun bun = new Bun(name , 100);

        MatcherAssert.assertThat("Метод getName должен вернуть " + name, bun.getName(), is(name));
    }

    @Test
    public void getPriceTest() {
        float price = 100;

        Bun bun = new Bun("name" , price);

        MatcherAssert.assertThat("Метод getName должен вернуть " + price, bun.getPrice(), is(price));
    }
}
