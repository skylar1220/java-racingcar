package controller;

import domain.Cars;
import domain.Count;
import domain.GameResult;
import domain.MovementGenerator;
import domain.NumberGenerator;
import domain.RacingGame;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import domain.Winners;
import dto.CarNameRequest;
import dto.WinnersResponse;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        Count count = Count.from(retryUntilNoException(inputView::readCount));

        RacingGame racingGame = RacingGame.of(count, cars, createRandomMovementGenerator());

        outputView.showStatusMessage();
        play(racingGame);

        Winners winners = Winners.from(cars);
        outputView.showResult(new WinnersResponse(winners));
    }

    private static MovementGenerator createRandomMovementGenerator() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MovementGenerator movementGenerator = new RandomMovementGenerator(numberGenerator);
        return movementGenerator;
    }

    private Cars getCars() {
        CarNameRequest carsNameRequest = retryUntilNoException(inputView::readCars);
        return retryUntilNoException(carsNameRequest::toCars);
    }

    public void play(RacingGame racingGame) {
        GameResult result = racingGame.getGameResult();
        outputView.showStatus(result);
    }

    private <T> T retryUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryUntilNoException(supplier);
        }
    }
}
