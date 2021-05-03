import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {


    @Test
    void TEST1() {
        Main.runRacingcarGame();
    }

    @Test
    @DisplayName("사용자 input data 검증")
    void TEST2() {
        String cars = "apple, bag, cccc, dog, egg, four, ghost, zzzzzzzzz";
        InputStream in = new ByteArrayInputStream(cars.getBytes());
        System.setIn(in);

        RacingcarGame racingcarGame = new RacingcarGame();
        racingcarGame.readCarNames();

        Set<Car> myCars = racingcarGame.getCars();
        assertThat(myCars.size()).isEqualTo(7);
    }
}
