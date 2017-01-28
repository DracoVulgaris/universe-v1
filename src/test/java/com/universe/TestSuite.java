package com.universe;

import com.universe.pollution.CarbonDioxideTest;
import com.universe.pollution.ExcrementTest;
import com.universe.resources.FoodTest;
import com.universe.resources.OxygenTest;
import com.universe.resources.WaterTest;
import com.universe.environment.LocationTest;
import com.universe.environment.SectorTest;
import com.universe.environment.UniverseTest;
import com.universe.utilities.LocationHelperTest;
import com.universe.utilities.PropertiesManagerTest;
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
        RandomiserTest.class,
        PropertiesManagerTest.class,
        LocationHelperTest.class,
        ExcrementTest.class,
        CarbonDioxideTest.class
})
public class TestSuite {
    //nothing
}
