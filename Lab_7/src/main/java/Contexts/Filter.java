package Contexts;
import PageObjects.*;

public class Filter {
    public static SortOutPage setPrice(SortOutPage page, Integer minPrice, Integer maxPrice){
        page.inputMinPrice(minPrice).inputMaxPrice(maxPrice)
                .submitprice();
        return page;
    }

    public static GoodsPage setCountry(SortOutPage page, String country){
        return page.selectCountry(country);
    }
}
