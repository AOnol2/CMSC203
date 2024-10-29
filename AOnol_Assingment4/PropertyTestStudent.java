import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {
    private Property property;

    @BeforeEach
    public void setUp() {
        // Creating a property to test with specific values
        property = new Property("TestProperty", "TestCity", 1000.0, "TestOwner", 2, 2, 4, 4);
    }

    @Test
    public void testDefaultConstructor() {
        Property defaultProperty = new Property(); // Default property values
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals("", defaultProperty.getOwner());
    }

    @Test
    public void testParameterizedConstructor() {
        // Checking if values are set correctly with the main constructor
        assertEquals("TestProperty", property.getPropertyName());
        assertEquals("TestCity", property.getCity());
        assertEquals(1000.0, property.getRentAmount());
        assertEquals("TestOwner", property.getOwner());
    }

    @Test
    public void testCopyConstructor() {
        Property copiedProperty = new Property(property); // Copy property
        assertEquals(property.getPropertyName(), copiedProperty.getPropertyName());
        assertEquals(property.getCity(), copiedProperty.getCity());
        assertEquals(property.getRentAmount(), copiedProperty.getRentAmount());
        assertEquals(property.getOwner(), copiedProperty.getOwner());
    }

    @Test
    public void testSetters() {
        property.setPropertyName("NewName");
        property.setCity("NewCity");
        property.setRentAmount(2000.0);
        property.setOwner("NewOwner");
        assertEquals("NewName", property.getPropertyName());
        assertEquals("NewCity", property.getCity());
        assertEquals(2000.0, property.getRentAmount());
        assertEquals("NewOwner", property.getOwner());
    }

    @Test
    public void testToString() {
        String result = property.toString();
        // Checking for specific values in toString output
        assertTrue(result.contains("TestProperty"));
        assertTrue(result.contains("TestCity"));
        assertTrue(result.contains("TestOwner"));
        assertTrue(result.contains("1000.0"));
    }
}