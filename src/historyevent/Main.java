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
            System.out.println("6. Выход");
            System.out.print("Выберите пункт (1–6): ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: Event.fillEvents(); break;
                case 2: Event.printEvents(); break;
                case 3: Event.listRussian19th(); break;
                case 4: Event.findPeriodWithMaxEvents(); break;
                case 5: Event.sortByYear(); break;
                case 6: System.out.println("Завершение работы.");return;
                default: System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }
}