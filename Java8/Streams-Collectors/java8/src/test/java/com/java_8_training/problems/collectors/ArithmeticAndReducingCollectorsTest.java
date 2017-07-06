
package com.java_8_training.problems.collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static junit.framework.Assert.assertEquals;

@Ignore
public class ArithmeticAndReducingCollectorsTest {

    // See: Dish.menu.stream()

    @Test
    public void leastCaloricDishMEAT() {
        //TODO #C5
        Dish leastCaloricMEAT = new Dish();


        Optional<Dish> collect = Dish.menu.stream().filter((Dish x) -> x.getType() == Dish.Type.MEAT).
                collect(minBy(comparingInt(Dish::getCalories)));

        leastCaloricMEAT= collect.get();

        assertEquals("chicken", leastCaloricMEAT.getName());
    }

    @Test
    public void statisticsForVegetarianDishes() {
        //TODO #C5
        IntSummaryStatistics vegetarianStats = new IntSummaryStatistics();

        vegetarianStats = Dish.menu.stream().filter(Dish::isVegetarian).collect(summarizingInt(Dish::getCalories));

        assertEquals(4, vegetarianStats.getCount());
        assertEquals(1550, vegetarianStats.getSum());
        assertEquals(120, vegetarianStats.getMin());
        assertEquals(387.5, vegetarianStats.getAverage());
        assertEquals(550, vegetarianStats.getMax());

    }
}
