package views;

public enum ActionType {
    ADD_NEW,
    FILTER_BY_DAY,
    FILTER_BY_WEEK,
    SAVE,
    LOAD;

    public static String getDescription(ActionType x) {
        switch (x) {
            case ADD_NEW:
                return "Добавить запись";
            case FILTER_BY_DAY:
                return "Фильтр по дате";
            case FILTER_BY_WEEK:
                return "Фильтр по недели";
            case SAVE:
                return "Сохранить";
            case LOAD:
                return "Загрузить";
        }
        return null;
    }

    public static ActionType parce(int x) {
        switch (x) {
            case 1:
                return ADD_NEW;
            case 2:
                return FILTER_BY_DAY;
            case 3:
                return FILTER_BY_WEEK;
            case 4:
                return SAVE;
            case 5:
                return LOAD;
        }
        return null;
    }
}
