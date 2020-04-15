package RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fb201.R;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Trip_Adapter extends RecyclerView.Adapter<Trip_View_Holder> {

    private List<Trip> list_trips;

    public Trip_Adapter(List<Trip> list_trips)
    {
        this.list_trips = list_trips;
    }

    @NonNull
    @Override                                   //(parent, viewtype)
    public Trip_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new Trip_View_Holder(view); //, trip_listener
    }

    @Override
    public void onBindViewHolder(@NonNull Trip_View_Holder trip_view_holder, int i) {
        trip_view_holder.display(list_trips.get(i));
    }

    @Override
    public int getItemCount() {
        return list_trips.size();
    }

}

