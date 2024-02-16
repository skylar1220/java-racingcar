package dto;

import domain.Cars;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarsReponse {
    private final List<CarReponse> carsReponses;

    public CarsReponse(List<CarReponse> carsReponses) {
        this.carsReponses = carsReponses;
    }

    public static CarsReponse from(Cars cars) {
        return new CarsReponse(convertToCarResponses(cars));
    }

    private static List<CarReponse> convertToCarResponses(Cars cars) { // TODO: 메서드명 개선하기
        return cars.getCars().stream()
                .map(CarReponse::of)
                .collect(Collectors.toList());
    }

    public List<CarReponse> getCarsReponses() {
        return carsReponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarsReponse that = (CarsReponse) o;
        return Objects.equals(carsReponses, that.carsReponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsReponses);
    }
}
