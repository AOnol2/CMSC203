import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany mgmtCompany;
    private Property property1, property2, property3;

    @BeforeEach
    public void setUp() {
        // Setting up a management company and a few properties
        mgmtCompany = new ManagementCompany("TestCompany", "123456789", 10.0);
        property1 = new Property("Property1", "City1", 1000, "Owner1", 1, 1, 2, 2);
        property2 = new Property("Property2", "City2", 1500, "Owner2", 3, 3, 2, 2);
        property3 = new Property("Property3", "City3", 2000, "Owner3", 6, 6, 2, 2);
    }

    @Test
    public void testAddProperty() {
        // Testing if properties are added at the correct indexes
        assertEquals(0, mgmtCompany.addProperty(property1));
        assertEquals(1, mgmtCompany.addProperty(property2));
        assertEquals(2, mgmtCompany.addProperty(property3));
    }

    @Test
    public void testGetTotalRent() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        mgmtCompany.addProperty(property3);
        assertEquals(4500, mgmtCompany.getTotalRent()); // Sum of rents should match
    }

    @Test
    public void testGetHighestRentProperty() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        mgmtCompany.addProperty(property3);
        assertEquals(property3, mgmtCompany.getHighestRentProperty()); // Highest rent is property3
    }

    @Test
    public void testIsPropertiesFull() {
        // Filling the property list to max capacity
        for (int i = 0; i < 5; i++) {
            mgmtCompany.addProperty(new Property("Property" + i, "City", 1000 * i, "Owner", i, i, 1, 1));
        }
        assertTrue(mgmtCompany.isPropertiesFull()); // Should return true when full
    }

    @Test
    public void testToString() {
        mgmtCompany.addProperty(property1);
        mgmtCompany.addProperty(property2);
        String result = mgmtCompany.toString();
        // Just check if our properties appear in the string
        assertTrue(result.contains("Property1"));
        assertTrue(result.contains("Property2"));
    }
}