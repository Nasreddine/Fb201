package RecyclerView;

import android.view.View;
import android.widget.TextView;
import com.example.fb201.R;
import androidx.recyclerview.widget.RecyclerView;

public class Trip_View_Holder extends RecyclerView.ViewHolder {

    private TextView start, end, time_start, time_end, price;

    Trip_View_Holder(View itemView){
        super(itemView);
        start = itemView.findViewById(R.id.departure);
        end = itemView.findViewById(R.id.arrival);
        time_start = itemView.findViewById(R.id.time_departure);
        time_end = itemView.findViewById(R.id.time_arrival);
        price = itemView.findViewById(R.id.price);
    }

    void display(Trip tr){
        start.setText(tr.getStart());
        end.setText(tr.getEnd());
        time_start.setText(tr.getTime_start());
        time_end.setText(tr.getTime_end());
        price.setText(tr.getPrice()+" $");
    }
}
