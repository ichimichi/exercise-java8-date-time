import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static void main(String[] args) {
        getBusSchedule("23-07-2021 10:00", Duration.ofHours(2)).forEach(System.out::println);
    }

    public static List<String> getBusSchedule(String start, Duration frequency){
        List<String> busScheduleList = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        LocalDateTime nextDate = LocalDateTime.of(startTime.toLocalDate(), LocalTime.MAX);

        while (startTime.isBefore(nextDate)){
            LocalDateTime endTime = startTime.plusHours(frequency.toHours());
            busScheduleList.add(startTime.format(DateTimeFormatter.ofPattern("HH:mm"))+" - "+endTime.format(DateTimeFormatter.ofPattern("HH:mm")));
            startTime = startTime.plusHours(frequency.toHours());
        }
        return busScheduleList;
    }
}
