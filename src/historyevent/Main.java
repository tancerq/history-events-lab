package historyevent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Меню =====");
            System.out.println("1. Дополнить массив событий");
            System.out.println("2. Распечатать все события");
            System.out.println("3. Список событий русской истории 19 века");
            System.out.println("4. Период с максимальным количеством событий");
            System.out.println("5. Упорядочить события по возрастанию дат");
            System.out.println("6. Показать количество событий"); // Добавили вызов нового метода
            System.out.println("7. Выход");
            System.out.print("Выберите пункт (1-7): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: EventService.fillEvents(); break;
                case 2: EventService.printEvents(); break;
                case 3: EventService.listRussian19th(); break;
                case 4: EventService.findPeriodWithMaxEvents(); break;
                case 5: EventService.sortByYear(); break;
                case 6: System.out.println("Всего событий в массиве: " + EventService.count()); break; // Используем count()
                case 7:
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }
}