package util;

public class StringUtils {
    public static double extractPriceFromString (String stringWithPrice) {
        return Double.parseDouble(stringWithPrice.replaceAll("[^0-9\\.]+",""));
    }
}
