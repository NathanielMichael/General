package net.craftstars.general.util;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Toolbox test cases.
 * 
 * @author Plutonium239
 */
public class ToolboxTest extends TestCase
{
    /**
     * Test capitalizeFirst
     */
    @Test
    public void testCapitalizeFirst()
    {
        String testString = "test";
        testString = Toolbox.capitalizeFirst(testString);
        assertTrue(testString.startsWith("T"));
        
        testString = Toolbox.capitalizeFirst(testString);
        assertTrue(testString.startsWith("T"));
    }
}