package test;

import controller.RentingBikeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author san.dl170111
 */
class RentingBikeControllerTest {
    private RentingBikeController rentingBikeController;

    @BeforeEach
    void setUp() {
        rentingBikeController = new RentingBikeController();
    }

    @ParameterizedTest
    @CsvSource({
            "599,0",
            "899,10000",
            "1000,16000",
            "86400,298000"
    })
    public void getTotal(int t, int actual) {
        int res = rentingBikeController.getTotal(t);
        assertEquals(actual, res);
    }
}