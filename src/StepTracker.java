import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        monthToData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (где 0 - январь, 1 - февраль и т.д.): ");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 0 || monthNumber > 11) {
            System.out.println("Введенное значение некорректно. Номер месяца должен быть от 0 до 11 включительно");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно): ");
        int daysNumber = scanner.nextInt();
        if (daysNumber <= 0 || daysNumber > 30) {
            System.out.println("Введенное значение некорректно. Номер дня должен быть от 1 до 30 включительно");
            return;
        }

        System.out.println("Введите количество пройденных шагов: ");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Введенное значение некорректно. Количество шагов должно быть положительным числом");
            return;
        }

        // сохранение данных
        MonthData monthData = monthToData[monthNumber];
        monthData.days[daysNumber - 1] = steps;
    }
    void changeStepGoal() {
        int newGoal;
        System.out.println("Введите новую цель шагов за день: ");
        newGoal = scanner.nextInt();
          if (newGoal <= 0) {
              System.out.println("Введенное значение некорректно. Новая цель шагов должна быть положительным числом");
              return;
          }
        goalByStepsPerDay = newGoal;
        System.out.println("Новая цель шагов за день: " + goalByStepsPerDay);
    }

    void printStatistic() {
        System.out.println("Введите число месяца:");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Введенное значение некорректно. Номер месяца должен быть от 0 до 11 включительно");
            return;
        }
        MonthData monthData = monthToData[month];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("В " + month + " месяце:");
        System.out.println("Количество пройденных шагов по дням: ");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + sumSteps/30);
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия (максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого): " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
