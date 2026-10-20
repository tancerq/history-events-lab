package tv;

import java.time.Duration;
import java.time.LocalDateTime;

/** Абстрактная телепередача. Напрямую создать объект нельзя. */
public abstract class ProgramItem implements IBroadcastable {
    private final String title;
    private final LocalDateTime startTime;
    private final Duration duration;
    private final String channel;

    protected ProgramItem(String title, LocalDateTime startTime, Duration duration, String channel) {
        this.title = title;
        this.startTime = startTime;
        this.duration = duration;
        this.channel = channel;
    }

    public String getTitle() { return title; }
    public LocalDateTime getStartTime() { return startTime; }
    public String getChannel() { return channel; }

    @Override
    public Duration getDuration() { return duration; }

    @Override
    public void broadcast() {
        System.out.println("В эфире [" + channel + "]: " + title);
    }

    /** Общая информация; потомки дополняют её своими полями. */
    public void showInfo() {
        System.out.println(title + " | канал: " + channel + " | начало: " + startTime
                + " | длительность: " + duration.toMinutes() + " мин");
    }
}
