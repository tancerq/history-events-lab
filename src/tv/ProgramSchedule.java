package tv;

import java.util.Arrays;
import java.util.Comparator;

/** Менеджер расписания. Вместо List — массив + счётчик элементов. */
public final class ProgramSchedule {
    private ProgramItem[] items = new ProgramItem[10];
    private int size;

    public void addProgram(ProgramItem item) {
        if (item == null) throw new IllegalArgumentException("item == null");
        if (size == items.length) items = Arrays.copyOf(items, size * 2);
        items[size++] = item;
    }

    public void removeProgram(String title) {
        for (int i = 0; i < size; i++) {
            if (items[i].getTitle().equals(title)) {
                System.arraycopy(items, i + 1, items, i, size - i - 1);
                items[--size] = null;
                return;
            }
        }
    }

    public void showAll() {
        for (int i = 0; i < size; i++) items[i].showInfo();
    }

    public void showByChannel(String channel) {
        for (int i = 0; i < size; i++) {
            if (items[i].getChannel().equals(channel)) items[i].showInfo();
        }
    }

    public void sortByStartTime() {
        Arrays.sort(items, 0, size, Comparator.comparing(ProgramItem::getStartTime));
    }

    /** Среднее по передачам с рейтингом (IRated); SportsEvent не учитывается. */
    public double getAverageRating() {
        double sum = 0;
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] instanceof IRated) {
                sum += ((IRated) items[i]).getRating();
                n++;
            }
        }
        return n == 0 ? 0 : sum / n;
    }
}
