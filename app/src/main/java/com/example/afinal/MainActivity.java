package com.example.afinal;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView eventRecyclerView;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        // Настройка кнопок категорий
//        Button buttonToday = findViewById(R.id.buttonToday);
//        Button buttonTomorrow = findViewById(R.id.buttonTomorrow);
//        Button buttonThisWeekend = findViewById(R.id.buttonThisWeekend);
//        Button buttonNearYou = findViewById(R.id.buttonNearYou);
//
//        buttonToday.setOnClickListener(v -> filterEvents("Сегодня"));
//        buttonTomorrow.setOnClickListener(v -> filterEvents("Завтра"));
//        buttonThisWeekend.setOnClickListener(v -> filterEvents("На выходных"));
//        buttonNearYou.setOnClickListener(v -> filterEvents("Рядом с тобой"));
//
//        // Настройка RecyclerView
//        eventRecyclerView = findViewById(R.id.eventRecyclerView);
//        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        eventAdapter = new EventAdapter(getEvents()); // Замени на данные из Firestore
//        eventRecyclerView.setAdapter(eventAdapter);
//
//        // Настройка нижней навигации
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    // Обработка нажатия на "Главная"
//                    return true;
//                case R.id.navigation_groups:
//                    // Обработка нажатия на "Группы"
//                    return true;
//                case R.id.navigation_watch:
//                    // Обработка нажатия на "Смотреть"
//                    return true;
//                case R.id.navigation_profile:
//                    // Обработка нажатия на "Профиль"
//                    return true;
//            }
//            return false;
//        });
//    }
//
//    private void filterEvents(String filter) {
//        // Фильтрация событий по выбранной категории
//        // Пример: Запрос к Firestore
//    }
//
//    private List<Event> getEvents() {
//        // Initialize the list with ArrayList
//        List<Event> events = new ArrayList<>();
//        events.add(new Event("Маркетинговые тренды 2023", "Пн, 17:00 PST", "The Vault"));
//        events.add(new Event("Финансирование стартапов в 2023", "Чт, 17:00 PST", "The Vault"));
//        events.add(new Event("Как собрать удаленную команду", "Ср, 17:00 PST", "The Vault"));
//        return events;
    }
}