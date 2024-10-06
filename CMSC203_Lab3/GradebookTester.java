import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GradebookTester {
    // Declare two GradeBook instances to use in testing
    private GradeBook gradebook1;
    private GradeBook gradebook2;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // This runs once before all tests, can be used to set up class-level resources
       
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        // This runs once after all tests have completed
       
    }

    @BeforeEach
    void setUp() throws Exception {
        // This runs before each test, initializing the GradeBook instances
        gradebook1 = new GradeBook(5);  // GradeBook with capacity of 5 scores
        gradebook2 = new GradeBook(5);

        // Adding some test scores to gradebook1
        gradebook1.addScore(85.0);
        gradebook1.addScore(90.0);

        // Adding some test scores to gradebook2
        gradebook2.addScore(75.0);
        gradebook2.addScore(60.0);
        gradebook2.addScore(88.0);
    }

    @AfterEach
    void tearDown() throws Exception {
        // This runs after each test, cleaning up the objects
        gradebook1 = null;
        gradebook2 = null;
    }

    @Test
    void testAddScore() {
        // Testing addScore and toString methods
        assertEquals("85.0 90.0", gradebook1.toString());
        assertEquals("75.0 60.0 88.0", gradebook2.toString());

        // Verifying the size after adding scores
        assertEquals(2, gradebook1.getScoreSize());
        assertEquals(3, gradebook2.getScoreSize());
    }

    @Test
    void testSum() {
        // Testing sum() method
        assertEquals(175.0, gradebook1.sum(), 0.0001);
        assertEquals(223.0, gradebook2.sum(), 0.0001);
    }

    @Test
    void testMinimum() {
        // Testing minimum() method
        assertEquals(85.0, gradebook1.minimum(), 0.001);
        assertEquals(60.0, gradebook2.minimum(), 0.001);
    }

    @Test
    void testFinalScore() {
        // Testing finalScore() method (sum minus the lowest score)
        assertEquals(90.0, gradebook1.finalScore(), 0.001);
        assertEquals(163.0, gradebook2.finalScore(), 0.001);
    }

}