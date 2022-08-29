import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> readSerializedFile(){
        ArrayList<User> users = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            users = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return users;
    }
    static void updateSerializedFile(ArrayList<User> arrayList){
        try
        {
            FileOutputStream fos = new FileOutputStream("users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    static void createUser(String username, String password, ArrayList<User> users) {
        if (users.stream().anyMatch(o -> o.getUsername().equals(username))){
            System.out.print("User with that username already exists! \n$ ");
        }
        users.add(new User(username,password));
        updateSerializedFile(users);
    }
    static void login(String username, String password, ArrayList<User> users){
        if (users.stream().anyMatch(o -> o.getUsername().equals(username) && o.getPassword().equals(o.hashPassword(password)))){
            System.out.print("Logged in! \n$ ");
        }
        else System.out.print("Wrong username or password !\n$ ");
    }

    public static void main(String[] args) {
        ArrayList<User> users = readSerializedFile();

        String help = "Type '1' to create new user\nType '2' to login\nType 'exit' to exit program\n$ ";
        System.out.print(help);
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            {
                System.out.print("$ ");
                String userInput = input.nextLine();

                if (userInput.equals("exit"))
                    break;
                else if (userInput.equals("1")) {
                    System.out.print("New username: ");
                    String username = input.nextLine();
                    System.out.print("$ New password: ");
                    String password = input.nextLine();
                    createUser(username, password, users);
                    System.out.print("$ User created Successfully! \n$ ");
                }
                else if (userInput.equals("2"))
                {
                    System.out.print("username: ");
                    String username = input.nextLine();
                    System.out.print("$ password: ");
                    String password = input.nextLine();
                    login(username, password, users);
                }
                else
                    System.out.print("Wrong command !\n"+help);
            }
        }

    }
}
