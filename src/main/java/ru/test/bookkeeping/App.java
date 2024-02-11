package ru.test.bookkeeping;

import ru.test.bookkeeping.service.BookService;
import ru.test.bookkeeping.service.impl.InMemoryBookService;

import java.util.Scanner;

public class App {

    Scanner scanner;
    BookService service;

    public App() {
        this.scanner = new Scanner(System.in);
        this.service = new InMemoryBookService(this.scanner);
    }

    public void start() {
        System.out.println("Добро пожаловать в приложение \"Учет книг в библиотеке\"!");
        while (true) {
            printMenu();

            int command;
            System.out.print("Выберите действие (введите номер): ");
            //Проверка валидного ввода команды
            do {
                while (!scanner.hasNextInt()) {
                    System.out.print("Пожалуйста, введите номер команды положительным числом: ");
                    scanner.next();
                }
                command = scanner.nextInt();
            } while (command <= 0);
            scanner.nextLine();

            switch (command) {
                case 1 -> service.addBook();
                case 2 -> service.showBooks();
                case 3 -> service.findBook();
                case 4 -> service.deleteBook();
                case 5 -> {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
                default -> System.out.println("Команда не поддерживается");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                1. Добавить книгу
                2. Просмотреть список книг
                3. Найти книгу по названию
                4. Удалить книгу
                5. Выход""");
    }
}
