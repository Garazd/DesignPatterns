package designPatterns.visitor.sample.garland;

import designPatterns.visitor.sample.element.Changeable;

// тут инкапсулирована логика двусвязного списка
// класс абстрактный и намекает на то,
// что все наследники будут Changeable
public abstract class Node implements Changeable {

    protected Node next;
    protected Node prev;

    // для добавления ноды в конец
    protected <T extends Node> T add(T node) {
        next = node;
        node.prev = this;
        return node;
    }
}