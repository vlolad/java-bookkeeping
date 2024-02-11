package ru.test.bookkeeping.model;

public enum Status {
    AVAILABLE("Доступна"),
    UNAVAILABLE("Недоступна");

     private final String title;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Status(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        switch (ordinal()) {
            case 0 -> {
                return ANSI_GREEN + title + ANSI_RESET;
            }
            case 1 -> {
                return ANSI_RED + title + ANSI_RESET;
            }
            default -> {
                return title;
            }
        }
    }
}
