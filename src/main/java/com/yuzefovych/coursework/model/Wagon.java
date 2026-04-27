package com.yuzefovych.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wagon {
    private String number; // Номер вагона
    private int type;      // 1-Пасажирський, 2-Вантажний, 3-Цистерна, 4-Контейнерний, 5-Технічний
}