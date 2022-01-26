package dev.lee.util;

/* This TempDB class is to represent a persistent store for our application's data.
    It has static arrays that hold info on each of the entities/models that our application needs.
    This will be replaced with our actual DB once we begin incorporating it into our code.
 */

import dev.lee.models.User;
import java.util.List;
import java.util.ArrayList;

public class TempDB {
    public static int userIndex = 0;
    public static List<User> users = new ArrayList<>();
}