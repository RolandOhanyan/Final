package com.example.afinal; // Замени на свой пакет
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
public class EventAdapter /*extends RecyclerView.Adapter<EventAdapter.EventViewHolder> */ {
//    private List<Event> events;
//
//    // Конструктор адаптера
//    public EventAdapter(List<Event> events) {
//        this.events = events;
//    }
//
//    @NonNull
//    @Override
//    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // Создаем View для каждого элемента списка
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_event, parent, false);
//        return new EventViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
//        // Привязываем данные к ViewHolder
//        Event event = events.get(position);
//        holder.textEventTitle.setText(event.getTitle());
//        holder.textEventDateTime.setText(event.getDateTime());
//        holder.textEventLocation.setText(event.getLocation());
//
//        // Обработка нажатия на кнопку "Присоединиться"
//        holder.buttonJoin.setOnClickListener(v -> {
//            // Здесь можно добавить логику для присоединения к событию
//            // Например, открыть экран с деталями события или отправить запрос на сервер
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return events.size();
//    }
//
//    // Внутренний класс ViewHolder
//    static class EventViewHolder extends RecyclerView.ViewHolder {
//        TextView textEventTitle, textEventDateTime, textEventLocation;
//        Button buttonJoin;
//
//        public EventViewHolder(@NonNull View itemView) {
//            super(itemView);
//            // Находим все View в макете item_event.xml
//            textEventTitle = itemView.findViewById(R.id.textEventTitle);
//            textEventDateTime = itemView.findViewById(R.id.textEventDateTime);
//            textEventLocation = itemView.findViewById(R.id.textEventLocation);
//            buttonJoin = itemView.findViewById(R.id.buttonJoin);
//        }
//    }
}