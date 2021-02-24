import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WorkingDaysExercise {
    public static void main(String[] args) {
        getNextMonthsWorkingDays().forEach(System.out::println);
    }

    public static List<String> getNextMonthsWorkingDays(){
        List<String> nextMonthWorkingDays = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate startDateNextMonth = LocalDate.of(today.getYear(), today.plusMonths(1).getMonth(), 1);
        LocalDate lastDateNextMonth = startDateNextMonth.plusMonths(1).minusDays(1);

        int numOfDays = Period.between(startDateNextMonth, lastDateNextMonth).getDays();

        LocalDate currentDate = startDateNextMonth;

        for( int i =0 ; i <=numOfDays; i++){
            if(currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY){
                nextMonthWorkingDays.add(currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
            currentDate = currentDate.plusDays(1);
        }

        return nextMonthWorkingDays;
    }
}
