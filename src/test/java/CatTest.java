package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CatTest {

    @Mock
    private Predator predatorMock;

    private Cat cat;

    private String expectedSound;

    public CatTest(String expectedSound) {
        this.expectedSound = expectedSound;
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(predatorMock);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Мяу"},
                {"Meow"},
                {"ЧЫГЧЕРЫГ"}
        });
    }

    @Test
    public void testGetSound() {
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(predatorMock, times(1)).eatMeat();
    }

}

