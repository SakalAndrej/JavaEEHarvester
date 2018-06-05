package filter;

import javax.ejb.Singleton;
import java.time.LocalDateTime;

@Singleton
public class Status {

    private static boolean isHarvesting = false;

    private static int productsToHarvest;

    private static LocalDateTime lastHarvest;

    private static String logs;

    private static int duration;

    private static int productsHarvested = 1;

    private static LocalDateTime startedHarvest;

    //region Getter & Setter


    public static void setDuration(int duration) {
        Status.duration = duration;
    }

    public static int getDuration() {
        return duration;
    }

    public static int getTimePerProduct() {
        return (duration/productsHarvested);
    }

    public static String getLogs() {
        return logs;
    }

    public static void setLogs(String logs) {
        Status.logs = logs;
    }

    public static void appendLogs(String s) {
        logs += "/n"+s;
    }

    public static double getEstimatedTime() {
        return productsHarvested*getTimePerProduct();
    }

    public static boolean isIsHarvesting() {
        return isHarvesting;
    }

    public static void setIsHarvesting(boolean isHarvesting) {
        Status.isHarvesting = isHarvesting;
    }

    public static LocalDateTime getLastHarvest() {
        return lastHarvest;
    }

    public static void setLastHarvest(LocalDateTime lastHarvest) {
        Status.lastHarvest = lastHarvest;
    }

    public static int getProductsToHarvest() {
        return productsToHarvest;
    }

    public static void setProductsToHarvest(int productsToHarvest) {
        Status.productsToHarvest = productsToHarvest;
    }

    public static void setProductsHarvested(int productsHarvested) {
        Status.productsHarvested = productsHarvested;
    }

    public static int getProductsHarvested() {
        return productsHarvested;
    }

    public static void setStartedHarvest(LocalDateTime startedHarvest) {
        Status.startedHarvest = startedHarvest;
    }

    public static LocalDateTime getStartedHarvest() {
        return startedHarvest;
    }

    //endregion
}
