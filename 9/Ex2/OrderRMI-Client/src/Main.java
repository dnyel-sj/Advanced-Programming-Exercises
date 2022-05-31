import myRemote.Order;
import myRemote.OrderService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            OrderService orderService = (OrderService) Naming.lookup("//localhost/ORDERService");
            System.out.print("enter your name: ");
            String customerName = input.nextLine();
            System.out.println("1:Fried chicken 30000 toman");
            System.out.println("2:Pizza 50000 toman");
            System.out.println("3:Sausage 20000 toman");
            System.out.println("4:Special potatoes 25000 toman");
            System.out.print("enter your choice of food: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Please pay 30000 toman and enter the payment tracking code: ");
                    long paymentTrackingCode = Long.parseLong(input.nextLine());
                    orderService.save(new Order().setCustomerName(customerName).setFoodName("fried chicken").setPrice(30000).setPaymentTrackingCode(paymentTrackingCode));
                    System.out.println("Order successfully registered");
                    break;
                case 2:
                    System.out.print("Please pay 50000 toman and enter the payment tracking code: ");
                    long paymentTrackingCode1 = Long.parseLong(input.nextLine());
                    orderService.save(new Order().setCustomerName(customerName).setFoodName("pizza").setPrice(50000).setPaymentTrackingCode(paymentTrackingCode1));
                    System.out.println("Order successfully registered");
                    break;
                case 3:
                    System.out.print("Please pay 20000 toman and enter the payment tracking code: ");
                    long paymentTrackingCode2 = Long.parseLong(input.nextLine());
                    orderService.save(new Order().setCustomerName(customerName).setFoodName("sausage").setPrice(20000).setPaymentTrackingCode(paymentTrackingCode2));
                    System.out.println("Order successfully registered");
                    break;
                case 4:
                    System.out.print("Please pay 25000 toman and enter the payment tracking code: ");
                    long paymentTrackingCode3 = Long.parseLong(input.nextLine());
                    orderService.save(new Order().setCustomerName(customerName).setFoodName("special potatoes").setPrice(25000).setPaymentTrackingCode(paymentTrackingCode3));
                    System.out.println("Order successfully registered");
                    break;
                default:
                    System.out.println("invalid choice number");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

