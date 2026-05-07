package org.example;
import java.io.*;
import java.util.*;

public class UsersApp {
    public static void main(String[] args) {
        ArrayList<User>users= new ArrayList<>();
        try {
            File file = new File("Users.txt");
            Scanner scanner = new Scanner(file);

            //יצירת קובץ פלט
            PrintWriter writer = new PrintWriter("myOutput.txt");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\\s+");

                if (parts.length != 2) continue;

                try {
                    User user = new User(parts[0], parts[1]);
                    users.add(user);
                } catch (Exception e) {
                    //write the error message
                    System.out.println(line + " -> " + e.getMessage());
                }
            }

            scanner.close();

            // מיון
            Collections.sort(users, (u1, u2) ->
                    u1.getName().compareTo(u2.getName())
            );

            for (User u : users) {
                writer.print(u.getName() + " " + u.getPassword());
                writer.print("\n");
            }


            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}//enduserapp
