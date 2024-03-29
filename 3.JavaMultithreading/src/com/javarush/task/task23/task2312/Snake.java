package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {

    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
}


//Надо:
//        а) Передать в конструктор координаты головы змеи (x и y).
//        б) создать в нем первый "кусочек змеи" (голову) и добавить его в коллекцию sections (ArrayList).
//        в) isAlive выставить в true.
//        г) не забудь в конструкторе инициализировать переменную sections. В null не много-то и добавишь!
//        д) создать и реализовать метод int getX(). Метод должен вернуть координату Х головы змеи.
//        е) создать и реализовать метод int getY(). Метод должен вернуть координату Y головы змеи.
//        ж) еще добавить классу метод move()- он нам пригодится попозже.
//        з) созданный конструктор должен быть публичным.