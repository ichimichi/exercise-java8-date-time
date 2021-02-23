import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BankDepositExercise {

    public static void main(String[] args) {
        System.out.println(getMaturityDate("22-02-2021", Period.of(1,1,0)));
        System.out.println(getInvestmentPeriod("22-02-2021", "22-03-2022"));

    }

    public static LocalDate stringToDate(String date){
        try{
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeParseException e){
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
    }

    public static String getMaturityDate(String investmentDate, Period duration){
        LocalDate investmentLocalDate = stringToDate(investmentDate);
        LocalDate maturityDate = investmentLocalDate.plus(duration);
        return maturityDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    public static String getInvestmentPeriod(String investmentDate, String maturityDate){
        LocalDate investmentLocalDate = stringToDate(investmentDate);
        LocalDate maturityLocalDate = stringToDate(maturityDate);
        Period investmentPeriod = Period.between(investmentLocalDate, maturityLocalDate);
        return investmentPeriod.getYears()+" years, "+investmentPeriod.getMonths()+ " months";
    }
}
