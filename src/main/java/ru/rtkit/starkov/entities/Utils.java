package ru.rtkit.starkov.entities;

import static ru.rtkit.starkov.Interface.*;

public class Utils {
    public static int[] coordinatesLineParsing(String coordinatesLine) {

        String[] strArray = coordinatesLine.split(";");
        int[] coordinates = new int[strArray.length * 2];

        int index = 0;
        for (String s : strArray) {

            String[] nums = s.split(",");
            try {
                coordinates[index++] = Integer.parseInt(nums[0]) - 1;
                coordinates[index++] = Integer.parseInt(nums[1]) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные координаты! Введите их заново:");
                coordinatesLineParsing(scanner.nextLine());
            }
        }
        return coordinates;
    }
}
