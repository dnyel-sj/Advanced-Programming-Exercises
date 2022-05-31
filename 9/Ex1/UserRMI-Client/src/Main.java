import myRemote.User;
import myRemote.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            UserService userService = (UserService) Naming.lookup("//localhost/USERService");
            List<User> userList = userService.report();
            System.out.println("1:Create an account");
            System.out.println("2:Update information");
            System.out.print("enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());
            switch(choice) {
                case 1:
                    System.out.print("enter name: ");
                    String name = input.nextLine();
                    System.out.print("enter username: ");
                    String username = input.nextLine();
                    System.out.print("enter password: ");
                    String password = input.nextLine();
                    System.out.print("enter email: ");
                    String email = input.nextLine();
                    userService.save(new User().setName(name).setUsername(username).setPassword(password).setEmail(email));
                    System.out.println("Create account successfully");
                    break;
                case 2:
                    boolean check = false;
                    System.out.print("enter the current name: ");
                    String name1 = input.nextLine();
                    System.out.print("enter the new username: ");
                    String username1 = input.nextLine();
                    System.out.print("enter the new password: ");
                    String  password1 = input.nextLine();
                    for(User user : userList) {
                        if(name1 != null && name1.equals(user.getName())) {
                            check = true;
                            userService.edit(new User().setName(name1).setUsername(username1).setPassword(password1));
                            System.out.println("Update information successfully");
                            break;
                        }
                    }
                    if(!check)
                        System.out.println("invalid name");
                    break;
                default:
                    System.out.println("invalid choice number");
            }

        } catch (RemoteException e) {
            e.printStackTrace ();
        } catch (NotBoundException e) {
            e.printStackTrace ();
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
