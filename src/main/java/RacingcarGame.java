import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RacingcarGame {

    private Set<Car> cars;
    private final int carNameLength = 5;
    private final String carNameDeleimeter = ",";

    public RacingcarGame() {
        this.cars = new HashSet<Car>();
    }

    public void startGame() {
        readCarNames();
    }

    public void readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), carNameDeleimeter);

            while(stringTokenizer.hasMoreTokens()) {
                String car = stringTokenizer.nextToken().trim();

                if(validateCarName(car)) {
                    System.out.println(car);
                    Car myCar = new Car(car);
                    cars.add(myCar);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateCarName(String car) {
        return car.length() <= carNameLength;
    }

    public Set<Car> getCars() {
        return cars;
    }
}
