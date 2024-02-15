package view;

import domain.CarStatusResponse;
import dto.WinnersResponse;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void showResult(WinnersResponse rawWinners) { //TODO: formatter로 넣든지, dto 쓸것!
        List<String> winners = rawWinners.getNames();
        String result = String.join(",", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }

//    public void showStatus(Cars cars) {
//        for (Car car : cars.getCars()) {
//            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
//        }
//        System.out.println();
//    }

    public void showStatusMessage() {
        System.out.println("실행 결과");
    }

    public void showStatus(List<List<CarStatusResponse>> result) {
        for (List<CarStatusResponse> turnResult : result) {
            for (CarStatusResponse carStatusResponse : turnResult) {
                System.out.println(carStatusResponse.getName() + " : " + "-".repeat(carStatusResponse.getDistance()));
            }
            System.out.println();
        }
    }
}
