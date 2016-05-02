package surf.ru.alex_tyutyarev.rainbowapp.Utils;

import java.util.HashMap;

/**
 * Created by Alexander on 02.05.2016.
 */
public class ColorRecognizer {
    private HashMap<Integer, String> hueNumbers;
    private final int COLOR_DEGREE = 30;

    public ColorRecognizer()
    {
        hueNumbers = new HashMap<>();
        hueNumbers.put(0, "Красный");
        hueNumbers.put(1, "Оранжевый");
        hueNumbers.put(2, "Желтый");
        hueNumbers.put(3, "Лаймовый");
        hueNumbers.put(4, "Зеленый");
        hueNumbers.put(5, "Бирюзовый");
        hueNumbers.put(6, "Циан");
        hueNumbers.put(7, "Кобальтовый");
        hueNumbers.put(8, "Синий");
        hueNumbers.put(9, "Фиолетовый");
        hueNumbers.put(10, "Пурпурный");
        hueNumbers.put(11, "Малиновый");
        hueNumbers.put(12, "Красный");
    }

    public String reсognizeColor(int degree)
    {
        int closestColor = degree % COLOR_DEGREE;


        if (closestColor < COLOR_DEGREE / 6)
            return "Цвет " + hueNumbers.get(degree / COLOR_DEGREE);
        else
        if (closestColor > COLOR_DEGREE / 6 * 5)
            return "Цвет " + hueNumbers.get(degree / COLOR_DEGREE + 1);
        if (closestColor < COLOR_DEGREE / 2)
            return "Цвет " + hueNumbers.get(degree / COLOR_DEGREE)
                    + " с уклоном в " + hueNumbers.get(degree / COLOR_DEGREE + 1);
        else
            return "Цвет " + hueNumbers.get(degree / COLOR_DEGREE + 1)
                    + " с уклоном в " + hueNumbers.get(degree / COLOR_DEGREE);
    }

}
