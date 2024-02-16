package domain;

public class RandomMovementGenerator implements MovementGenerator {
    public static final int MOVABLE_CRITERION = 4;
    private final NumberGenerator randomNumberGenerator;

    public RandomMovementGenerator(NumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public Movement generate() {
        if (isMovable(randomNumberGenerator)) {
            return Movement.MOVE;
        }
        return Movement.STAY;
    }

    public boolean isMovable(NumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generate() >= MOVABLE_CRITERION;
    }
}
