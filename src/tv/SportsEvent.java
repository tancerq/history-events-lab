package tv;

import java.time.Duration;
import java.time.LocalDateTime;

/** Спортивное событие: можно записать, рейтинга нет (IRated не реализует). */
public final class SportsEvent extends ProgramItem implements IRecordable {
    private final String teams;
    private final String sportType;
    private String recordedPath;

    public SportsEvent(String title, LocalDateTime startTime, Duration duration, String channel,
                       String teams, String sportType) {
        super(title, startTime, duration, channel);
        this.teams = teams;
        this.sportType = sportType;
    }

    @Override
    public void record(String filePath) {
        recordedPath = filePath;
        System.out.println("Событие \"" + getTitle() + "\" записано в " + filePath);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("  Спорт: " + sportType + ", команды: " + teams
                + (recordedPath != null ? ", записано: " + recordedPath : ""));
    }
}
