import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class RacingcarGame {

    private Set<Car> cars;
    private Set<Car> winnderCars;
    private int gameMatchNumber;
    private int longestDistance = 0;

    public RacingcarGame() {
        this.cars = new HashSet<>();
        this.winnderCars = new HashSet<>();
    }

    public void startGame() {
        if (readCarNames() == 0) {
            System.out.println("자동차 이름은 최대 5자까지 가능합니다. 5자까지 가능한 이름을 최소 1개 이상 넣어주세요.");
        }

        readGameMatchNumber();
        startCars();
    }

    private void startCars() {
        System.out.println("\n실행 결과");
        int matchNum = gameMatchNumber;
        while (matchNum-- > 0) {
            moveCars();
        }

        String resultStr = showWinner();
        System.out.println(resultStr);
    }

    private String showWinner() {
        for (Car car : cars) {
            calcWinnerCar(car);
        }
        StringBuilder result = new StringBuilder();
        for(Car car : winnderCars) {
            result.append(car.getName()).append(", ");
        }
        String resultStr = result.substring(0, result.length()-2);
        resultStr += "가 최종 우승했습니다.";
        return resultStr;
    }

    private void calcWinnerCar(Car car) {
        if(car.getDistance() == longestDistance) {
            winnderCars.add(car);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int carDistance = car.move();
            car.showCarDistance();
            checkDistance(carDistance);
        }
        System.out.println();
    }

    private void checkDistance(int carDistance) {
        if (longestDistance < carDistance) {
            longestDistance = carDistance;
        }
    }

    public int readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), ",");
            while (stringTokenizer.hasMoreTokens()) {
                addCar(stringTokenizer.nextToken().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars.size();
    }

    private void addCar(String car) {
        final int carNameLength = 5;
        if (car.length() <= carNameLength) {
            System.out.println(car);
            Car myCar = new Car(car);
            cars.add(myCar);
        }
    }

    public void readGameMatchNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        gameMatchNumber = scanner.nextInt();
    }

    public Set<Car> getCars() {
        return cars;
    }

    public int getGameMatchNumber() {
        return gameMatchNumber;
    }
}
