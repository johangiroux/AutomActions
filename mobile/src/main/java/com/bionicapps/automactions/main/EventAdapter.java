package com.bionicapps.automactions.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bionicapps.automactions.R;
import com.bionicapps.automactions.model.Event;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johan on 3/20/16.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> events;
    private EventAdapterInterface eventAdapterInterface;

    public EventAdapter(EventAdapterInterface eventAdapterInterface) {
        this.eventAdapterInterface = eventAdapterInterface;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = getItem(position);
        holder.eventName.setText(event.getName());
    }

    public Event getItem(int position) {
        if (events == null) return null;
        return events.get(position);
    }

    @Override
    public int getItemCount() {
        if (events == null) return 0;
        return events.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        @Bind(R.id.even_name)
        TextView eventName;
        @Bind(R.id.action_name)
        TextView actionName;
        @Bind(R.id.action_app)
        TextView actionApp;
        @Bind(R.id.geofence_action)
        TextView geofenceAction;
        @Bind(R.id.geofence_location)
        TextView geofenceLocation;

        public EventViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (eventAdapterInterface != null) {
                Event event = getItem(getAdapterPosition());
                eventAdapterInterface.onItemClick(event);
            }
        }
    }

    public interface EventAdapterInterface {
        void onItemClick(Event event);
    }
}
