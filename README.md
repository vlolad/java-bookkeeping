# Book keeping

Приложение для учета книг в библиотеке

## Фукнционал
1. Создание книг
2. Хранение книг в памяти приложения
3. Поиск книг по названию
4. Отображение всего списка книг
5. Удаление книг по ID

## Структура

**Основной класс:** `App` <br>
- Реализует пользовательский интерфейс и взаимодействие с сервисами

**Основной сервис:** `InMemoryBookService` <br>
- Реализует основной функционал приложения <br>
- Наследуется от `SimpleService`, в котором прописана логика генерации ID <br>
- Реализует интерфейс `BookService`

**Основной объект:** `Book` <br>
- Хранит основные сведения о книге
- Позволяет менять статус книги через внутренний метод `changeStatus()` (не реализовано в настоящий момент)
- Статусы представляют собой отдельный Enum-класс
