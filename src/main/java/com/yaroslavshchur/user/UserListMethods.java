package main.java.com.yaroslavshchur.user;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserListMethods {
   private final static String firstCity = "Dnipro";
    private final static String secondCity = "Lviv";
    private final static String thirdCity = "Kyiv";
    private final static int count = 3;
    private final static int midAge = 40;
    private final static int highAge = 50;

    public void userListMethods {
        List<User> list = new ArrayList<>();
        list.add(new User("Vasia", 16, "Dnipro"));
        list.add(new User("Petya", 23, "Dnipro"));
        list.add(new User("Elena", 42, "Lutsk"));
        list.add(new User("Elena", 92, "Chernihiv"));
        list.add(new User("Sergiy", 5, "Kyiv"));
        list.add(new User("Marina", 32, "Kyiv"));
        list.add(new User("Ivan Ivanovich", 69, "Lviv"));
        System.out.println("This is a list of User older than " + midAge);
        printUserOlderAge(list);

        System.out.println("This is a list of User from " + firstCity + " older than " + highAge);
        printUserYoungerAgeFromCity(list, firstCity);

        System.out.println("This is the average age of User from " + secondCity);
        printUserAverageAgeFromCity(list, secondCity);

        System.out.println("This is a list of User not from Kyiv " + thirdCity);
        printUserNotFromCity(list, thirdCity);
    }

    public static void printUserOlderAge(List<User> users) {
        System.out.println("User older than " + midAge);
        users.stream()
                .filter(user -> user.getAge() > midAge)
                .forEach(System.out::println);

    }

    public static void printUserYoungerAgeFromCity(List<User> users, String firstCity) {
        System.out.println("Users younger tnan " + highAge + " from " + firstCity);
        users.stream()
                .filter(user -> user.getAge() < highAge)
                .filter(user -> user.getCity().equals(firstCity))
                .forEach(System.out::println);
    }

    public static void printUserAverageAgeFromCity(List<User> users, String secondCity) {
        System.out.println("Average age of Users from " + secondCity + " :");
        System.out.println(
                users.stream()
                        .filter(user -> user.getCity().equals(secondCity)
                        .mapToInt(User::getAge)
                        .average()
                        .getAsDouble());
    }

    public static void printUserNotFromCity(List<User> users, String thirdCity) {
        System.out.println("Number of users not from " + thirdCity);
        System.out.println(
                users.stream()
                        .filter(user -> !user.getCity().equals(city3))
                        .count());
    }

    public static void printSortedByAge(List<User> users, int count) {

        System.out.println(count + " smallest user is: ");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .limit(count)
                .forEach(System.out::println);

    }
}
