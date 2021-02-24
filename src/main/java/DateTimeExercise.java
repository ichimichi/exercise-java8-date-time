import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class DateTimeExercise {
    private static ArrayList<Tablet> tabletArrayList = new ArrayList<>();

    public static void main(String[] args) {
        getExpiringTablets(3).forEach(System.out::println);
        getExpiringTabletsSorted(3).forEach(t -> System.out.println(t.getName() + " " + t.getExpiryDate()));
        getTabletExpiryPeriod().forEach((key, value) -> System.out.println(key + " " + value));
        getSameYearExpiry().forEach((key, value)-> System.out.println(key+" "+value));
    }

    static {
        tabletArrayList.add(new Tablet("Galaxy 10", "Samsung",
                LocalDate.parse("2021-02-22"), LocalDate.parse("2022-02-22")));
        tabletArrayList.add(new Tablet("Galaxy 9", "Samsung",
                LocalDate.parse("2020-02-22"), LocalDate.parse("2021-06-25")));
        tabletArrayList.add(new Tablet("Galaxy 8", "Samsung",
                LocalDate.parse("2019-02-22"), LocalDate.parse("2020-03-16")));
        tabletArrayList.add(new Tablet("Ipad 10", "Apple",
                LocalDate.parse("2021-02-22"), LocalDate.parse("2022-04-22")));
        tabletArrayList.add(new Tablet("Ipad 9", "Apple",
                LocalDate.parse("2019-02-22"), LocalDate.parse("2020-02-14")));
    }

    public static List<String> getExpiringTablets(int months) {
        List<String> expiringTabletsList = new ArrayList<>();
        LocalDate expireDate = LocalDate.now().minusDays(months * 30L);
        for (Tablet t : tabletArrayList) {
            if (t.getExpiryDate().isBefore(expireDate)) {
                expiringTabletsList.add(t.getName());
            }
        }
        return expiringTabletsList;
    }

    public static List<Tablet> getExpiringTabletsSorted(int months) {
        List<Tablet> expiringTabletsList = new ArrayList<>();
        LocalDate expireDate = LocalDate.now().minusDays(months * 30L);
        for (Tablet t : tabletArrayList) {
            if (t.getExpiryDate().isBefore(expireDate)) {
                expiringTabletsList.add(t);
            }
        }

        Comparator<Tablet> dateComparator = (Tablet t1, Tablet t2) -> (int) t1.getExpiryDate().compareTo(t2.getExpiryDate());
        Collections.sort(expiringTabletsList, dateComparator);
        return expiringTabletsList;
    }

    public static Map<String, String> getTabletExpiryPeriod() {
        LinkedHashMap<String, String> tabletPeriodMap = new LinkedHashMap<>();
        for (Tablet t : tabletArrayList) {
            tabletPeriodMap.put(t.getName(), Period.between(t.getManufactureDate(), t.getExpiryDate()).toString());
        }
        return tabletPeriodMap;
    }

    public static Map<String, List<String>> getSameYearExpiry() {
        HashMap<String, List<String>> tabletMap = new HashMap<>();
        for (Tablet t : tabletArrayList) {
            if(!tabletMap.containsKey(t.getManufacturer())) {
                tabletMap.put(t.getManufacturer(), new ArrayList<>());
            }
            tabletMap.get(t.getManufacturer()).add(t.getName());
        }
        return tabletMap;
    }


}
