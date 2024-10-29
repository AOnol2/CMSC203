import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {
    private Plot plot1, plot2, plot3;

    @BeforeEach
    public void setUp() {
        // Making three different plot instances for testing
        plot1 = new Plot(0, 0, 5, 5);
        plot2 = new Plot(1, 1, 3, 3);
        plot3 = new Plot(6, 6, 2, 2);
    }

    @Test
    public void testDefaultConstructor() {
        Plot defaultPlot = new Plot(); // Using the default plot
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        // Check if custom values are assigned correctly
        assertEquals(0, plot1.getX());
        assertEquals(0, plot1.getY());
        assertEquals(5, plot1.getWidth());
        assertEquals(5, plot1.getDepth());
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2)); // plot2 should overlap with plot1
        assertFalse(plot1.overlaps(plot3)); // plot3 should not overlap with plot1
    }

    @Test
    public void testEncompasses() {
        assertTrue(plot1.encompasses(plot2)); // plot1 should contain plot2
        assertFalse(plot2.encompasses(plot1)); // plot2 should not contain plot1
    }

    @Test
    public void testToString() {
        assertEquals("0,0,5,5", plot1.toString()); // Simple check for format
    }
}