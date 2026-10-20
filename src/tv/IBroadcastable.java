package tv;

import java.time.Duration;

/** Возможность "показа" передачи. */
public interface IBroadcastable {
    void broadcast();
    Duration getDuration();
}
