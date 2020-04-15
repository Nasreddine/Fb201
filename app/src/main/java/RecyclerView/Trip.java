package RecyclerView;

public class Trip {

    private String start, end, time_start, time_end;
    private double price;

    public Trip(String start, String end, String time_start, String time_end, double price) {
        this.start = start;
        this.end = end;
        this.time_start = time_start;
        this.time_end = time_end;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }
}

