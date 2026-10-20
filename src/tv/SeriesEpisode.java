package tv;

import java.time.Duration;
import java.time.LocalDateTime;

public final class SeriesEpisode extends ProgramItem implements IRated, IRecordable {
    private final String seriesName;
    private final int season;
    private final int episodeNumber;
    private double rating;
    private String recordedPath;

    public SeriesEpisode(String title, LocalDateTime startTime, Duration duration, String channel,
                         String seriesName, int season, int episodeNumber) {
        super(title, startTime, duration, channel);
        this.seriesName = seriesName;
        this.season = season;
        this.episodeNumber = episodeNumber;
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
        System.out.println("Эпизод \"" + getTitle() + "\" записан в " + filePath);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("  Сериал: " + seriesName + ", сезон " + season + ", серия " + episodeNumber
                + ", рейтинг: " + rating + (recordedPath != null ? ", записан: " + recordedPath : ""));
    }
}
