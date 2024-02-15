import static org.assertj.core.api.Assertions.*;

import domain.Count;
import domain.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    @DisplayName("레이싱게임 객체를 생성한다")
    void createRacingGame() {
        assertThatCode(RacingGame::fromEmpty).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("횟수가 잘 저장 되는지 확인한다")
    void saveCount() {
        RacingGame racingGame = RacingGame.fromCount(1);
        assertThat(racingGame).extracting("count").isEqualTo(Count.from(1));
    }
}