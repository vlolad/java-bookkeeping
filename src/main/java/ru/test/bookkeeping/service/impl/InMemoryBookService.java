package ru.test.bookkeeping.service.impl;

import ru.test.bookkeeping.model.Book;
import ru.test.bookkeeping.model.Status;
import ru.test.bookkeeping.service.BookService;
import ru.test.bookkeeping.service.SimpleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InMemoryBookService extends SimpleService implements BookService {

    private final Map<Integer, Book> repo;
    private final Scanner scanner;

    public InMemoryBookService(Scanner scanner) {
        this.repo = new HashMap<>();
        this.scanner = scanner;
    }

    @Override
    public void addBook() {
        System.out.print("Введите название книги: ");
        String name = scanner.nextLine().trim();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine().trim();

        Book book = Book.builder()
                .id(generateId())
                .name(name)
                .author(author)
                .status(Status.AVAILABLE)
                .build();

        repo.put(book.getId(), book);
        System.out.println("Книга успешно добавлена.\n");
    }

    @Override
    public void showBooks() {
        System.out.println("Список книг:");
        repo.values().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void findBook() {
        System.out.print("Введите название книги для поиска: ");
        String name = scanner.nextLine().trim();

        List<Book> result = repo.values().stream().filter(b -> b.getName().contains(name)).toList();

        if (result.isEmpty()) {
            System.out.println("Книга не найдена.\n");
            return;
        }

        System.out.println("Результаты поиска:");
        result.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void deleteBook() {
        System.out.print("Введите номер книги для удаления: ");
        String number = scanner.nextLine().trim();
        int id;
        //Проверка, что вводимый ID корректен
        try {
            id = Integer.parseInt(number);
            if (id <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод ID книги.\n");
            return;
        }

        if (repo.containsKey(id)) {
            Book book = repo.remove(id);
            System.out.println("Книга \"" + book.getName() + "\" успешно удалена.\n");
        } else {
            System.out.println("Книга с данным ID не найдена.\n");
        }
    }
}
