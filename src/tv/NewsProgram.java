package tv;

import java.time.Duration;
import java.time.LocalDateTime;

public final class NewsProgram extends ProgramItem implements IRated {
    private final String anchor;
    private final String topic;
    private double rating;

    public NewsProgram(String title, LocalDateTime startTime, Duration duration, String channel,
                       String anchor, String topic) {
        super(title, startTime, duration, channel);
        this.anchor = anchor;
        this.topic = topic;
    }

    @Override public double getRating() { return rating; }

    @Override
    public void updateRating(double newRating) {
        if (newRating < 0 || newRating > 10) throw new IllegalArgumentException("Рейтинг 0..10");
        rating = newRating;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("  Новости. Ведущий: " + anchor + ", тема: " + topic + ", рейтинг: " + rating);
    }
}
