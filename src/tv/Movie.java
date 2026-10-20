package tv;

import java.time.Duration;
import java.time.LocalDateTime;

public final class Movie extends ProgramItem implements IRated, IRecordable {
    private final String director;
    private final String genre;
    private final int year;
    private double rating;
    private String recordedPath;

    public Movie(String title, LocalDateTime startTime, Duration duration, String channel,
                 String director, String genre, int year) {
        super(title, startTime, duration, channel);
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

    @Override public double getRating() { return rating; }

    @Override
    public void updateRating(double newRating) {
        if (newRating < 0 || newRating > 10) throw new IllegalArgumentException("Рейтинг 0..10");
        rating = newRating;
    }

    @Override
    public void record(String filePath) {
        recordedPath = filePath;
        System.out.println("Фильм \"" + getTitle() + "\" записан в " + filePath);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("  Фильм. Режиссёр: " + director + ", жанр: " + genre + ", год: " + year
                + ", рейтинг: " + rating + (recordedPath != null ? ", записан: " + recordedPath : ""));
    }
}
