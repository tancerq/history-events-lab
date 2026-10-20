package tv;

/** Передача, имеющая рейтинг. */
public interface IRated {
    double getRating();
    void updateRating(double newRating);
}
