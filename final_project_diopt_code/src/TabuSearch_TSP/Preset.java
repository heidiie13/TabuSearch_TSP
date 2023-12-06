package TabuSearch_TSP;

import TabuSearch_TSP.data.ImportData;

import TabuSearch_TSP.objects.TabuSearch;

import java.util.Random;

public class Preset {
    static Random random = new Random();
    public static long seed = random.nextLong();

    public static void setSeed(long number) {
        seed = number;
    }
    public static void printSeed() {
        System.out.println("Seed: " + seed);
    }
    /**
     * Gets a default TabuSearch instance with preset configurations.
     *
     * @return A TabuSearch instance with default configurations.
     */
    public static TabuSearch getDefaultTabu() {

        TabuSearch tabuSearch = new TabuSearch();
        tabuSearch.setCities(ImportData.getCities());
        tabuSearch.setMaxTabuTenure(ImportData.getCities().length / 3);
        tabuSearch.setInitialTabuSize(ImportData.getCities().length / 10);
        tabuSearch.setIncreaseTabuSizeInterval(30);

        // auto change max iterations for tabu_search
        if (ImportData.getCities().length <= 180) {
            tabuSearch.setMaxIterations(500);
        } else if (ImportData.getCities().length > 180 && ImportData.getCities().length <= 400) {
            tabuSearch.setMaxIterations(700);
        } else {
            tabuSearch.setMaxIterations(1000);
        }
        return tabuSearch;
    }
}
