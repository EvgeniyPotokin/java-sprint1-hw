class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        int printDay;
        for (int i = 0; i < 30; i++) {
            printDay = i + 1;
            System.out.println(printDay + " -й день: " + days[i]);
            // Вывод элементов массива в необходимом формате
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
           sumSteps = sumSteps + days[i];// подсчёт суммы элементов массива days[]
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
         if (maxSteps < days[i])  {
             maxSteps = days[i]; // поиск максимального элемента
         }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] >= goalByStepsPerDay) {
                bestSession = bestSession + 1;
            }
            else if (days[i] < goalByStepsPerDay) {
                bestSession = 0;
            }
            if (bestSession > countBest) {
                countBest = bestSession;
            }
                  }
        return countBest;
    }
}
