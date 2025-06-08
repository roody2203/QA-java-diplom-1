package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class BurgerTest {
    @Test
    public void testSetBuns() {
        Burger burger = new Burger();

        Bun bun = new Bun("Bun", 30);
        burger.setBuns(bun);
        MatcherAssert.assertThat("Поле bun не равно устанавливаемому объекту", burger.bun, is(bun));
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili", 50);
        burger.addIngredient(ingredient);
        MatcherAssert.assertThat("Поле ingredients не равно ожидаемому результату", burger.ingredients, is(List.of(ingredient)));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();

        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "chili", 50);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "fill", 20);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.removeIngredient(0);

        MatcherAssert.assertThat("Поле ingredients не равно ожидаемому результату", burger.ingredients, is(List.of(secondIngredient)));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();

        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "chili", 50);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "fill", 20);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        MatcherAssert.assertThat("Поле ingredients не равно ожидаемому результату", burger.ingredients, is(List.of(secondIngredient, firstIngredient)));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();

        // Создаем Мок класса Bun
        Bun bun = Mockito.mock(Bun.class);
        // Создаем Мок класса Ingredient
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);

        MatcherAssert.assertThat("Итоговая цена не соответствует ожидаемой", burger.getPrice(), is(250F));

        Mockito.verify(bun, Mockito.times(1)).getPrice();
        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void testGetReceipt() {
        Burger burger = Mockito.spy(Burger.class);

        // Создаем Мок класса Bun
        Bun bun = Mockito.mock(Bun.class);
        // Создаем Мок класса Ingredient
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili");
        Mockito.when(burger.getPrice()).thenReturn(250F);

        String expectedReceiptBuilder = String.format("(==== bun ====)%n") +
                String.format("= sauce chili =%n") +
                String.format("(==== bun ====)%n") +
                String.format("%nPrice: 250,000000%n");

        MatcherAssert.assertThat("Возвращенный рецепт не соответствует ожидаемому", burger.getReceipt(), is(expectedReceiptBuilder));

        Mockito.verify(bun, Mockito.times(2)).getName();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
        Mockito.verify(burger, Mockito.times(1)).getPrice();
    }
}
