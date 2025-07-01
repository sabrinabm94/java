package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = setDatePatter("dd/MM/yyyy");
        SimpleDateFormat dateAndHourFormat = setDateAndHoursPatter("dd/MM/yyyy HH:mm:ss");

        Print.print("\nDate: " + getFormattedDate(dateFormat));
        Print.print("\nDate and hours: " + getFormattedDateAndMinutes(dateAndHourFormat));
        Print.print("\n" + getYearMouthDayByCalendar());

    }

    public static SimpleDateFormat setDatePatter(String patter) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(patter);

        return dateFormat;

    }

    public static SimpleDateFormat setDateAndHoursPatter(String patter) {
        SimpleDateFormat dateAndHourFormat = new SimpleDateFormat(patter);

        return dateAndHourFormat;
    }

    public static String getFormattedDate(SimpleDateFormat patter) {
        Date dateAndHours = new Date();

        return patter.format(dateAndHours);
    }

    public static String getFormattedDateAndMinutes(SimpleDateFormat patter) {
       /*
        Date date = new Date("11/07/2019");
        Date date = new Date("11/07/2019 13:30:00");
        */

        Date date = new Date();

        return patter.format(date);
    }

    public static String getYearMouthDayByCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = 1 + calendar.get(Calendar.MONTH);

        return "Year: " + year + "; Mouth: " + month + "; Day: " + day + ";";
    }
}
