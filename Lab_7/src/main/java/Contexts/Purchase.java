package Contexts;

import PageObjects.OrderPage;
import PageObjects.GoodsPage;
public class Purchase {
    public static OrderPage submitPurchase(GoodsPage page){
        return page.submitBuying();
    }
}
