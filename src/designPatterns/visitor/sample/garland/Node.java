package designPatterns.visitor.sample.garland;

import designPatterns.visitor.sample.element.Changeable;

// тут инкапсулирована логика двусвязного списка
// класс абстрактный и намекает на то,
// что все наследники будут Changeable
public abstract class Node implements Changeable {

    public Node prev;
    public Node next;

    // для добавления ноды в конец
    public <T extends Node> T add(T node) {
        next = node;
        node.prev = this;
        return node;
    }
}