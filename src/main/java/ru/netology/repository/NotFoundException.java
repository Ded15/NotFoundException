package ru.netology.repository;

public class NotFoundException extends RuntimeException {

    public  NotFoundException (String massage) {
        super(massage);
    }
}
