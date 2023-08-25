

public class Checker {
    public boolean isDayOfWeek(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public boolean allVowels(String string) {
        return string.matches("(a|e|i|o|u)*");
    }
    
    public boolean timeOfDay(String string) {
        if (!string.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            return false;
        }
        String parts[] = string.split(":");
        if (Integer.valueOf(parts[0]) > 23 || Integer.valueOf(parts[1]) > 59 || Integer.valueOf(parts[2]) > 59) {
            return false;
        }
        return true;
    }
}
