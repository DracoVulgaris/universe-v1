package com.universe.utilities;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import static com.universe.utilities.DateUtilities.getFormattedCurrentDateTime;

/**
 * Test {@link DateUtilities}
 *
 * @since 22/01/2017.
 */
public class DateUtilitiesTest {

    @Test
    public void getFormattedCurrentDateTimeNotNull() throws Exception {
        String date = getFormattedCurrentDateTime();
        assertNotNull(date);
    }

    @Test
    public void getFormattedCurrentDateTimePatternCorrect() {
        String date = getFormattedCurrentDateTime();
        System.out.println(date);
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(date);
        assertTrue(matcher.matches());
    }

}