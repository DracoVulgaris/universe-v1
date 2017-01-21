package com.universe;

import com.universe.elements.FoodTest;
import com.universe.elements.OxygenTest;
import com.universe.elements.WaterTest;
import com.universe.environment.LocationTest;
import com.universe.environment.SectorTest;
import com.universe.environment.UniverseTest;
import com.universe.utilities.RandomiserTest;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UniverseTest.class,
        FoodTest.class,
        OxygenTest.class,
        WaterTest.class,
        LocationTest.class,
        SectorTest.class,
        RandomiserTest.class
})
public class TestSuite {
    //nothing
}
