package ru.netology.repository;
public class NotFoundException extends RuntimeException{
    NotFoundException(String msg) {
        super(msg);
    }
}
