package adapter;

public class RandomGeneratorAdapter extends RandomGenerator implements Generator {

    @Override
    public int next() {
        return getRandomNumber();
    }
}
