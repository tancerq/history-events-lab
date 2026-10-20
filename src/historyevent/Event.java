package historyevent;

import java.util.Scanner;

public class Event {
    private String name;
    private int year;
    private String country;
    private String description;

    // Конструкторы
    public Event(String name, int year, String country, String description) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.description = description;
    }

    public Event() {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.print("Название события: ");
        this.setName(sc.nextLine());
        System.out.print("Год: ");
        this.setYear(sc.nextInt());
        sc.nextLine();
        System.out.print("Страна: ");
        this.setCountry(sc.nextLine());
        System.out.print("Описание (необязательно): ");
        this.setDescription(sc.nextLine());
    }

    @Override
    public String toString() {
        return String.format("Событие: %s, год: %d, страна: %s, описание: %s",
                name, year, country, description);
    }

    // ----- Геттеры и сеттеры -----
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            System.out.println("Ошибка: название не может быть пустым!");
        else this.name = name;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 0)
            System.out.println("Ошибка: год не может быть отрицательным!");
        else if (year > 2026)
            System.out.println("Ошибка: год не может быть больше 2026!");
        else this.year = year;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty())
            System.out.println("Ошибка: страна не может быть пустой!");
        else if (!country.matches("[A-Za-zА-Яа-яЁё\\s]+")) // Убрана опечатка (лишний символ `)
            System.out.println("Ошибка: название страны должно содержать только буквы!");
        else this.country = country;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}