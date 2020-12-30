package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        int uppercasecount = 0;
        int numberscount = 0;
        String a = "";
        do {
            System.out.println("password");
            a = scanner.next();
            user.setPassword(a);

            char[] charArray = a.toCharArray();
            for (int i = 0; i < a.length(); i++) {
                if (Character.isUpperCase(charArray[i])) {
                    uppercasecount++;

                }
                if (Character.isDigit(charArray[i])) {
                    numberscount++;
                }
            }
            if (a.length() < 8 || uppercasecount < 2 || numberscount < 3) {
                System.out.println("incorrect password");
            } else {
                user.setPassword(a);
            }
        }while (a.length() < 8 || uppercasecount < 2 || numberscount < 3);


        System.out.println(" username");

        boolean hasdoublication;
        hasdoublication = false;
        String b = "";
        do {
            b = scanner.next();
            char[] charArray = b.toCharArray();
            for (int i = 0; i < b.length()-1; i++) {
                for (int j =i+1; j < b.length(); j++) {
                    if (charArray[i] == charArray[j]) {
                        hasdoublication = true;
                        break;
                    }
                }
            }
            if (b.length() < 10 || hasdoublication == true) {
                System.out.println("wrong username");
            } else {
                user.setUsername(b);
            }
        }while(b.length() < 10 || hasdoublication == true);




        System.out.println("Name");
        String c = scanner.next();
        user.setName(c);

        System.out.println("Surname");
        String d = scanner.next();
        user.setSurname(d);

        System.out.println("Email");
        String e = scanner.next();
        user.setEmail(e);

        String row = user.getName() + " , " + user.getUsername() + " , "+ user.getEmail()+ " , " + user.getPassword()+ " , "+ user.getSurname() +"\n";
        Path path = Paths.get("C:\\Users\\Suren\\Desktop\\codsvard\\Login user\\src\\com\\company\\Data.txt");
        Files.write(path, row.getBytes(), StandardOpenOption.APPEND);

        System.out.println("Success paje");

        System.out.println(" username");
        String inputLog=scanner.next();
        


        System.out.println("password");
        String inputPass=scanner.next();

        String[] strings = Files.readAllLines(Paths
                .get("C:\\Users\\Suren\\Desktop\\codsvard\\Login user\\src\\com\\company\\Data.txt"))
                .toArray(new String[0]);


        for (int i = 1; i < strings.length; i++) {
            String[] s = strings[i].split(",");
            if( inputLog==s[1] && inputPass==s[4]){
                System.out.println( "success login");
            }
            else{
                System.out.println(" invalid input data");
            }
        }

    }

}
