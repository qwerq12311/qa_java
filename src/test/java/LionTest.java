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
public class LionTest {

    @Mock
    private Predator predatorMock;

    private Lion lion;

    private String expectedSex;
    private int expectedKittens;
    private boolean expectedHasMane;
    private List<String> expectedFood;

    public LionTest(String expectedSex, int expectedKittens, boolean expectedHasMane, List<String> expectedFood) {
        this.expectedSex = expectedSex;
        this.expectedKittens = expectedKittens;
        this.expectedHasMane = expectedHasMane;
        this.expectedFood = expectedFood;
    }

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(expectedSex, predatorMock);
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", 1, true, Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Самец", 3, true, Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Самка", 0, false, Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetKittens() {
        int actualKittens = lion.getKittens(expectedKittens);
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testDoesHaveMane() {
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(predatorMock, times(1)).eatMeat();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSexThrowsException() {
        lion = new Lion("InvalidSex", predatorMock);
    }
}
