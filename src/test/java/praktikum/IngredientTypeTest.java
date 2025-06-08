package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String name;

    @Parameterized.Parameters(name = "Проверка типа: {0}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

    public IngredientTypeTest(String name) {
        this.name = name;
    }

    @Test
    public void ingredientTypeTest()
    {
        MatcherAssert.assertThat("Не найден тип " + name, IngredientType.valueOf(name).toString(), is(name));
    }
}
