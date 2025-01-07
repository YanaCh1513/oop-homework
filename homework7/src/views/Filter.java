package views;

import java.time.LocalDateTime;

public class Filter {

    private FilterType type;
    private LocalDateTime value;

    public Filter(FilterType type, LocalDateTime value) {
        this.type = type;
        this.value = value;
    }

    public FilterType getType() {
        return type;
    }

    public LocalDateTime getValue() {
        return value;
    }
}
