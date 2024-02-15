import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.Distance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    @DisplayName("차 객체를 생성한다.")
    void car() {
        assertThatCode(Car::fromEmpty).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차를 움직이면 거리가 늘어난다.")
    void carMove() {
        Car car = Car.fromEmpty();
        car.move();
        assertThat(car.getDistance()).isEqualTo(Distance.from(1));
    }

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하면 예외를 발생시키지 않는다")
    void validCarName() {
        assertThatCode(() -> Car.fromName("qwey")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("차 이름의 길이가 1 이상 5이하가 아니면 예외를 발생시킨다")
    void invalidCarName() {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.fromName("abcdefg"));
    }

    @Test
    @DisplayName("두 차가 같은 거리인지 확인한다")
    void isSameDistance() {
        Car car = Car.of("포비", 1);
        Car otherCar = Car.of("커비", 1);
        assertThat(car.isSameDistance(otherCar)).isTrue();
    }
}