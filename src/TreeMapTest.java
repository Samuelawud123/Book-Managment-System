import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Test class for TreeMap.
 * This class tests the various functionalities of the TreeMap class, including insertion,
 * size calculation, key existence check, and key array extraction.
 */
public class TreeMapTest {

    private TreeMap<Integer, String> treeMap;

    /**
     * Sets up a new TreeMap instance before each test method is run.
     */
    @Before
    public void setUp() {
        treeMap = new TreeMap<>();
    }

    /**
     * Tests the size() method of the TreeMap.
     * Ensures that the size is correctly updated when new key-value pairs are added.
     */
    @Test
    public void testSize() {
        assertEquals(0, treeMap.size());
        treeMap.put(2767052, "Suzanne Collins");
        treeMap.put(41865, "Stephenie Meyer");
        assertEquals(2, treeMap.size());
        treeMap.put(2657, "Harper Lee");
        assertEquals(3, treeMap.size());
    }

    /**
     * Tests the clear() method of the TreeMap.
     * Ensures that the TreeMap is correctly cleared of all entries.
     */
    @Test
    public void testClear() {
        treeMap.put(2767052, "Suzanne Collins");
        treeMap.put(41865, "Stephenie Meyer");
        treeMap.clear();
        assertEquals(0, treeMap.size());
        assertNull(treeMap.get(1));
        assertNull(treeMap.get(2));
    }

    /**
     * Tests the get() method of the TreeMap.
     * Checks that the correct value is returned for existing keys and null for non-existing keys.
     */
    @Test
    public void testGet() {
        treeMap.put(2767052, "Suzanne Collins");
        treeMap.put(41865, "Stephenie Meyer");
        assertEquals("Suzanne Collins", treeMap.get(2767052));
        assertEquals("Stephenie Meyer", treeMap.get(41865));
        assertNull(treeMap.get(3));
    }

    /**
     * Tests the put() method of the TreeMap.
     * Verifies that new entries can be added and existing entries can be updated.
     */
    @Test
    public void testPut() {
        treeMap.put(2767052, "Suzanne Collins");
        assertEquals("Suzanne Collins", treeMap.get(2767052));
        treeMap.put(2767052, "New Suzanne Collins");
        assertEquals("New Suzanne Collins", treeMap.get(2767052));
    }

    /**
     * Tests the containsKey() method of the TreeMap.
     * Checks that the method correctly identifies the presence or absence of keys.
     */
    @Test
    public void testContainsKey() {
        treeMap.put(2767052, "Suzanne Collins");
        assertTrue(treeMap.containsKey(2767052));
        assertFalse(treeMap.containsKey(41865));
    }

    /**
     * Tests the toKeyArray() method of the TreeMap.
     * Verifies that the method correctly returns an array of all keys in sorted order.
     */
    @Test
    public void testToKeyArray() {
        treeMap.put(2767052, "Suzanne Collins");
        treeMap.put(41865, "Stephenie Meyer");
        treeMap.put(2657, "Harper Lee");

        Integer[] array = new Integer[treeMap.size()];
        Integer[] expected = {2657, 41865, 2767052};
        Arrays.sort(expected);
        Integer[] actual = treeMap.toKeyArray(array);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
