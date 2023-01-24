public class Converter {


    int convertToKm(int steps) {
    int convertSm = steps * 75;
    return convertSm / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        int convertKk = steps * 50;
        return convertKk / 1000;

    }
}

