package Contexts;

import PageObjects.OrderPage;
import PageObjects.DeliveryPage;
import static Contexts.InputCustomer.inputInfo;

public class MakeOrder {
    public static DeliveryPage input_Info(OrderPage page){
        return inputInfo(page);
    }
}
