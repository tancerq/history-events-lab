package historyevent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventService {
    // Массив перенесен сюда
    private static Event[] events;

    // Статический блок инициализации тоже здесь
    static {
        events = new Event[] {
                new Event("Отечественная война", 1812, "Россия", "Война с Наполеоном"),
                new Event("Восстание декабристов", 1825, "Россия", "Восстание на Сенатской площади"),
                new Event("Отмена крепостного права", 1861, "Россия", "Реформа Александра II"),
                new Event("Русско-турецкая война", 1877, "Россия", "Война за освобождение Болгарии"),
                new Event("Французская революция", 1789, "Франция", "Великая французская революция"),
                new Event("Битва при Ватерлоо", 1815, "Великобритания", "Поражение Наполеона"),
                new Event("Первая мировая война", 1914, "Россия", "Начало Первой мировой войны"),
                new Event("Революция 1905 года", 1905, "Россия", "Первая русская революция"),
                new Event("Октябрьская революция", 1917, "Россия", "Октябрьский переворот")
        };
    }

    // Приватный метод для чтения одного события
    private static Event readEvent(Scanner sc) {
        String name;
        while (true) {
            System.out.print("Название события: ");
            name = sc.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Ошибка: название не может быть пустым. Повторите ввод.");
            } else break;
        }

        int year;
        while (true) {
            System.out.print("Год: ");
            try {
                year = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: год должен быть числом. Повторите ввод.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            if (year < 0) {
                System.out.println("Ошибка: год не может быть отрицательным. Повторите ввод.");
            } else if (year > 2026) {
                System.out.println("Ошибка: год не может быть больше 2026. Повторите ввод.");
            } else break;
        }

        String country;
        while (true) {
            System.out.print("Страна: ");
            country = sc.nextLine();
            if (country == null || country.trim().isEmpty()) {
                System.out.println("Ошибка: страна не может быть пустой. Повторите ввод.");
            } else if (!country.matches("[A-Za-zА-Яа-яЁё\\s]+")) {
                System.out.println("Ошибка: название страны должно содержать только буквы. Повторите ввод.");
            } else break;
        }

        System.out.print("Описание (необязательно): ");
        String description = sc.nextLine();

        return new Event(name, year, country, description);
    }

    // Все статические методы перенесены сюда
    public static void fillEvents() {
        Scanner sc = new Scanner(System.in, "UTF-8");

        int n;
        while (true) {
            System.out.print("Введите количество новых событий: ");
            try {
                n = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: нужно ввести число. Повторите ввод.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            if (n <= 0) {
                System.out.println("Ошибка: количество должно быть положительным. Повторите ввод.");
            } else break;
        }

        Event[] oldEvents = events;
        int oldSize = (oldEvents == null) ? 0 : oldEvents.length;
        Event[] newEvents = new Event[n];

        System.out.println("Введите информацию о новых событиях:");
        for (int i = 0; i < n; i++) {
            System.out.println("Новое событие " + (i + 1) + ":");
            newEvents[i] = readEvent(sc);
        }

        Event[] combined = new Event[oldSize + n];
        if (oldEvents != null) {
            System.arraycopy(oldEvents, 0, combined, 0, oldSize);
        }
        System.arraycopy(newEvents, 0, combined, oldSize, n);
        events = combined;
        System.out.println("Массив успешно дополнен.");
    }

    public static void printEvents() {
        System.out.println("\n=== Список всех событий ===");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    public static void listRussian19th() {
        System.out.println("\n=== События русской истории 19 века (1801–1900) ===");
        boolean found = false;
        for (Event e : events) {
            if (e.getCountry().equalsIgnoreCase("Россия") && e.getYear() >= 1801 && e.getYear() <= 1900) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Нет таких событий.");
    }

    public static void findPeriodWithMaxEvents() {
        if (events.length == 0) {
            System.out.println("Массив пуст.");
            return;
        }
        int minYear = events[0].getYear();
        int maxYear = events[0].getYear();
        for (Event e : events) {
            if (e.getYear() < minYear) minYear = e.getYear();
            if (e.getYear() > maxYear) maxYear = e.getYear();
        }
        int startDecade = (minYear / 10) * 10;
        int endDecade = (maxYear / 10) * 10;
        int decadeCount = (endDecade - startDecade) / 10 + 1;
        int[] counts = new int[decadeCount];
        for (Event e : events) {
            int decade = (e.getYear() / 10) * 10;
            int index = (decade - startDecade) / 10;
            counts[index]++;
        }
        int maxCount = 0, maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        int decadeStart = startDecade + maxIndex * 10;
        int decadeEnd = decadeStart + 9;
        System.out.println("\n=== Период с максимальным числом событий ===");
        System.out.println("Десятилетие: " + decadeStart + "–" + decadeEnd + ", событий: " + maxCount);
        System.out.println("События в этом периоде:");
        for (Event e : events) {
            int d = (e.getYear() / 10) * 10;
            if (d == decadeStart) {
                System.out.println(e);
            }
        }
    }

    public static void sortByYear() {
        for (int i = 0; i < events.length - 1; i++) {
            for (int j = 0; j < events.length - 1 - i; j++) {
                if (events[j].getYear() > events[j + 1].getYear()) {
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }
        System.out.println("\n=== События, упорядоченные по возрастанию дат ===");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    // НОВЫЙ ФУНКЦИОНАЛ (по заданию лабы)
    public static int count() {
        return events.length;
    }
}