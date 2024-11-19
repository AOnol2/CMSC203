/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #5
 * Description: Utility class for calculating holiday bonuses based on store sales.
 * Due: 11/18/2024
 * Platform/compiler: Eclipse
 * Author: Ata Onol
 */

public class HolidayBonus {

    // Bonus values for specific store performance
    public static final double BONUS_TOP_PERFORMER = 5000.0;
    public static final double BONUS_LOW_PERFORMER = 1000.0;
    public static final double BONUS_FOR_OTHER = 2000.0;

    /**
     * Calculate holiday bonuses for each store based on sales data.
     * Set salesData 2D array of sales data for stores.
     * Return Array of holiday bonuses for each store.
     */
    public static double[] calculateHolidayBonus(double[][] salesData) {
        double[] bonusesByStore = new double[salesData.length];

        for (int categoryIndex = 0; categoryIndex < salesData[0].length; categoryIndex++) {
            int bestStoreIndex = findHighestStore(salesData, categoryIndex);
            int leastStoreIndex = findLowestStore(salesData, categoryIndex);

            for (int storeIndex = 0; storeIndex < salesData.length; storeIndex++) {
                if (storeIndex == bestStoreIndex) {
                    bonusesByStore[storeIndex] += BONUS_TOP_PERFORMER;
                } else if (storeIndex == leastStoreIndex) {
                    bonusesByStore[storeIndex] += BONUS_LOW_PERFORMER;
                } else if (salesData[storeIndex].length > categoryIndex && salesData[storeIndex][categoryIndex] > 0) {
                    bonusesByStore[storeIndex] += BONUS_FOR_OTHER;
                }
            }
        }

        return bonusesByStore;
    }

    /**
     * Calculate the total holiday bonus for all stores combined.
     * Set salesData 2D array of sales data for stores.
     * Return Total holiday bonus amount.
     */
    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double[] bonusesByStore = calculateHolidayBonus(salesData);
        return sumTotalBonuses(bonusesByStore);
    }

    /**
     * Identify the store with the highest sales for a specific category.
     * Set salesData 2D array of sales data
     * Set categoryIndex Index of the sales category
     * Return Index of the store with the highest sales
     */
    public static int findHighestStore(double[][] salesData, int categoryIndex) {
        int highestStoreIndex = -1;
        double maxSales = Double.NEGATIVE_INFINITY;

        for (int storeIndex = 0; storeIndex < salesData.length; storeIndex++) {
            if (categoryIndex < salesData[storeIndex].length && salesData[storeIndex][categoryIndex] > maxSales) {
                maxSales = salesData[storeIndex][categoryIndex];
                highestStoreIndex = storeIndex;
            }
        }

        return highestStoreIndex;
    }

    /**
     * Identify the store with the lowest positive sales for a specific category.
     * Set salesData 2D array of sales data
     * Set categoryIndex Index of the sales category
     * Return Index of the store with the lowest positive sales
     */
    public static int findLowestStore(double[][] salesData, int categoryIndex) {
        int lowestStoreIndex = -1;
        double minPositiveSales = Double.POSITIVE_INFINITY;

        for (int storeIndex = 0; storeIndex < salesData.length; storeIndex++) {
            if (categoryIndex < salesData[storeIndex].length 
                && salesData[storeIndex][categoryIndex] > 0 
                && salesData[storeIndex][categoryIndex] < minPositiveSales) {
                minPositiveSales = salesData[storeIndex][categoryIndex];
                lowestStoreIndex = storeIndex;
            }
        }

        return lowestStoreIndex;
    }

    /**
     * Calculate the total of all bonuses for all stores.
     * Set bonuses Array of bonuses for each store
     * Return Sum of bonuses
     */
    public static double sumTotalBonuses(double[] bonuses) {
        double totalBonus = 0.0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }

    /**
     * Calculate the total of all store bonuses directly (restored for compatibility).
     * Set bonuses Array of bonuses for each store
     * Return Sum of bonuses
     */
    public static double calculateTotalStoreBonus(double[] bonuses) {
        double totalBonus = 0.0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}
