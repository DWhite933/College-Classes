package calandarlocale;

import java.text.*;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;



public class CalendarPane extends BorderPane{
    // header label
    private Label headerLabel = new Label();
    
    // Maximum number of labels to display day names and days
    private Label[] dayLabels = new Label[49];
    
    
    private Calendar calendar;
    private int month; // specified month
    private int year; // specified year
    private Locale locale = Locale.US;
    
    public CalendarPane() {
        // labels for displaying days
        for (int i = 0; i < 49; i++) {
            dayLabels[i] = new Label();
            dayLabels[i].setTextAlignment(TextAlignment.RIGHT);
        }
        
        showDayNames(); //Display day names for the locale
        
        GridPane dayPane = new GridPane();
        dayPane.setAlignment(Pos.CENTER);
        
        dayPane.setHgap(10);
        dayPane.setVgap(10);
        for (int i = 0; i < 49; i++) {
            dayPane.add(dayLabels[i], i%7, i/7);
        }
        
        // place header and clendar body in the pane
        this.setTop(headerLabel);
        BorderPane.setAlignment(headerLabel, Pos.CENTER);
        this.setCenter(dayPane);
        
        // set current month and year
        calendar = new GregorianCalendar();
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        updateCalendar();
        
        // show calendar
        showHeader();
        showDays();
    }

    private void showDayNames() {
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String dayNames[] = dfs.getWeekdays();
        
        for (int i = 0; i < 7; i++) {
            dayLabels[i].setText(dayNames[i+1]);
        }
    }
    
    private void showHeader(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", locale);
        String header = sdf.format(calendar.getTime());
        headerLabel.setText(header);
    }

    private void showDays() {
        // get day of the first day in a month
        int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        
        // fill calendar with days before this month
        Calendar calendarClone = (Calendar) calendar.clone();
        calendarClone.add(Calendar.DATE, -1); // becomes preceding month
        int daysInPrecedingMonth = calendarClone.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for (int i = 0; i < startingDayOfMonth; i++) {
            dayLabels[i + 7].setTextFill(Color.LIGHTGRAY);
            dayLabels[i+7].setText(daysInPrecedingMonth - startingDayOfMonth + 2 + i + "");
        }
        
        // displays days of this month
        int daysInCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInCurrentMonth; i++) {
            dayLabels[i - 2 + startingDayOfMonth + 7].setTextFill(Color.BLACK);
            dayLabels[i - 2 + startingDayOfMonth + 7].setText(i + "");
        }
        
        // fill calendar with days after this month
        int j = 1;
        for (int i = daysInCurrentMonth - 1 + startingDayOfMonth + 7; i < 49; i++) {
            dayLabels[i].setTextFill(Color.LIGHTGRAY);
            dayLabels[i].setText(j++ + "");
        }
    }
    
    /**
     * set the calendar to the first day
     * of the specified month and year
     */
    private void updateCalendar() {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, 1);
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int newMonth){
        month = newMonth;
        updateCalendar();
        showHeader();
        showDays();
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int newYear){
        year = newYear;
        updateCalendar();
        showHeader();
        showDays();
    }
    
    public void setLocale(Locale locale){
        this.locale = locale;
        updateCalendar();
        showDayNames();
        showHeader();
        showDays();
    }
}
