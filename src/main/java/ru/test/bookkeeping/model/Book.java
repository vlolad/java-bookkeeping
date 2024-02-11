package ru.test.bookkeeping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private Integer id;
    private String name;
    private String author;
    private Status status;


    public void changeStatus() {
        switch (status) {
            case AVAILABLE -> this.status = Status.UNAVAILABLE;
            case UNAVAILABLE -> this.status = Status.AVAILABLE;
            default -> System.out.println("Unsupported status");
        }
    }

    @Override
    public String toString() {
        return id + ". \"" + name + "\" - " +
                author + " - " +
                status;
    }
}
