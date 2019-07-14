
public class DateTime{

    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    
    //constructors for time and date
    public DateTime(int day, int month, int year, int hour, int min) {
        if ((year > 1939) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32)
                && (hour >= 0) && (hour < 24) && (min >= 0) && (min < 60)) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.hour = hour;
            this.min = min;
        } else {
            System.out.println("Not correct date");
        }
    }
    
    public DateTime(int day, int month, int year) {
        if ((year > 1939) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Not correct date");
        }
    }

    public DateTime(int hour, int min) {
        if ((hour >= 0) && (hour < 24) && (min >= 0) && (min < 60)) {
            this.hour = hour;
            this.min = min;
        } else {
            System.out.println("Not correct time");
        }
    }

    //getters and setters
    public void setYear(int year) {
        if ((year > 1939) && (year < 2099)) {
            this.year = year;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setMonth(int month) {
        if ((month > 0) && (month < 13)) {
            this.month = month;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setDay(int day) {
        if ((day > 0) && (day < 32)) {
            this.day = day;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setHour(int hour) {
        if ((hour >= 0) && (hour < 24)) {
            this.hour = hour;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setMin(int min) {
        if ((min >= 0) && (min < 60)) {
            this.min = min;
        } else {
            System.out.println("Not correct range");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public String getDate() {
        String dateStr = String.format("%02d/%02d/%04d", day, month, year);
        return dateStr;
    }

    public String getTime() {
        String timeStr = String.format("%02d:%02d", hour, min);
        return timeStr;
    }

    public String toString() {
        String dateTimeStr = getDate() + " " + getTime();
        return dateTimeStr;
    }

    //compares the time and date of one vehicle with another which will be sorted chronologically
    int compareTo(DateTime entryDateTime) {
        int returnValue = 0;
        if (this.day > entryDateTime.getDay() || this.month > entryDateTime.getMonth() || this.year > entryDateTime.getYear() 
                || this.hour > entryDateTime.getHour() || this.min > entryDateTime.getMin())
            returnValue = -1;
        else
            returnValue = 1;
        return returnValue;
    }
    
}
