package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

public class IngredientTest {

    @Test
    public void ingredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ingredient", 100);

        assertNotNull("Ошибка при создании объекта Ingredient", ingredient);
    }

    @Test
    public void getPriceTest() {
        float price = 100;

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ingredient", price);

        MatcherAssert.assertThat("Метод getPrice должен вернуть " + price, ingredient.getPrice(), is(price));
    }

    @Test
    public void getNameTest() {
        String name = "ingredient";

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 100);

        MatcherAssert.assertThat("Метод getName должен вернуть " + name, ingredient.getName(), is(name));
    }

    @Test
    public void getTypeTest() {
        IngredientType type = IngredientType.FILLING;

        Ingredient ingredient = new Ingredient(type, "name", 100);

        MatcherAssert.assertThat("Метод getType должен вернуть " + type, ingredient.getType(), is(type));
    }
}
