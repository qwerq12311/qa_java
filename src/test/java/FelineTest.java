package com.example;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private Feline feline;

    private String expectedFamily;
    private int expectedKittens;
    private List<String> expectedFood;

    public FelineTest(String expectedFamily, int expectedKittens, List<String> expectedFood) {
        this.expectedFamily = expectedFamily;
        this.expectedKittens = expectedKittens;
        this.expectedFood = expectedFood;
    }

    @Before
    public void setup() {
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Кошачьи", 5, Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Кошачьи", 10, Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Кошачьи", 3, Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFamily() {
        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        int actualKittens = feline.getKittens(expectedKittens);

        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }
}


