package tv;

import java.time.Duration;
import java.time.LocalDateTime;

/** Демонстрация работы иерархии (запуск: java tv.Main из папки lab3_var3). */
public class Main {
    public static void main(String[] args) {
        ProgramSchedule schedule = new ProgramSchedule();

        Movie movie = new Movie("Интерстеллар", LocalDateTime.of(2026, 10, 10, 21, 0),
                Duration.ofMinutes(169), "Культура", "К. Нолан", "Фантастика", 2014);
        SeriesEpisode episode = new SeriesEpisode("Зима близко", LocalDateTime.of(2026, 10, 10, 19, 0),
                Duration.ofMinutes(60), "HBO", "Игра престолов", 1, 1);
        NewsProgram news = new NewsProgram("Вести", LocalDateTime.of(2026, 10, 10, 18, 0),
                Duration.ofMinutes(30), "Культура", "И. Иванов", "Политика");
        SportsEvent sport = new SportsEvent("Финал", LocalDateTime.of(2026, 10, 10, 20, 0),
                Duration.ofMinutes(120), "Спорт", "Команда A - Команда B", "Футбол");

        // Добавление передач (полиморфизм: все как ProgramItem)
        schedule.addProgram(movie);
        schedule.addProgram(episode);
        schedule.addProgram(news);
        schedule.addProgram(sport);

        // Оценка и запись
        movie.updateRating(9.0);
        episode.updateRating(8.5);
        news.updateRating(6.0);
        movie.record("movie.mp4");
        episode.record("episode.mp4");

        System.out.println("=== Всё расписание ===");
        schedule.showAll();

        System.out.println("\n=== Канал «Культура» ===");
        schedule.showByChannel("Культура");

        System.out.println("\n=== После сортировки по времени начала ===");
        schedule.sortByStartTime();
        schedule.showAll();

        System.out.println("\nСредний рейтинг: " + schedule.getAverageRating());

        // Показ и длительность через интерфейс
        IBroadcastable b = sport;
        b.broadcast();
        System.out.println("Длительность: " + b.getDuration().toMinutes() + " мин");

        schedule.removeProgram("Вести");
        System.out.println("\n=== После удаления «Вести» ===");
        schedule.showAll();
    }
}
