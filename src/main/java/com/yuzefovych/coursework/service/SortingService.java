package com.yuzefovych.coursework.service;

import com.yuzefovych.coursework.model.Wagon;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SortingService {

    public Map<String, List<Wagon>> sortWagonsByRoute(List<Wagon> incomingTrain) {
        // Створюємо карту для 5 напрямків
        Map<String, List<Wagon>> result = new LinkedHashMap<>();

        result.put("Львів (Пасажирський)", new ArrayList<>());
        result.put("Київ (Вантажний)", new ArrayList<>());
        result.put("Одеса (Цистерна)", new ArrayList<>());
        result.put("Харків (Контейнерний)", new ArrayList<>());
        result.put("Дніпро (Технічний)", new ArrayList<>());

        // Розподіляємо вагони за типом
        for (Wagon wagon : incomingTrain) {
            switch (wagon.getType()) {
                case 1 -> result.get("Львів (Пасажирський)").add(wagon);
                case 2 -> result.get("Київ (Вантажний)").add(wagon);
                case 3 -> result.get("Одеса (Цистерна)").add(wagon);
                case 4 -> result.get("Харків (Контейнерний)").add(wagon);
                case 5 -> result.get("Дніпро (Технічний)").add(wagon);
                default -> System.out.println("Вагон " + wagon.getNumber() + " має невідомий тип");
            }
        }
        return result;
    }
}