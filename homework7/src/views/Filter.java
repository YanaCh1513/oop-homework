package views;

import java.time.LocalDateTime;

public class Filter {

    private ActionType type;
    private LocalDateTime value;

    public Filter(ActionType type, LocalDateTime value) {
        this.type = type;
        this.value = value;
    }

    public ActionType getType() {
        return type;
    }

    public LocalDateTime getValue() {
        return value;
    }
}
