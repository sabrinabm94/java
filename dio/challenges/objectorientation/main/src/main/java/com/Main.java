package com;

import java.util.List;

import com.interfaces.UserRecord;

public class Main {
    public static void main(String[] args) {
        List<UserRecord> users = List.of(new UserRecord("Daniela", 21), new UserRecord("Daniel", 25),
                new UserRecord("Danilo", 42));

        printStringValue(users);
    }

    private static void printStringValue(List<UserRecord> users) {
        users.forEach(user -> System.out.println("O nome do usuário é " + user.name()));
    }
}
