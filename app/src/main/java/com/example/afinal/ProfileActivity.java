package com.example.afinal; // Замените на ваш пакет

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImageView;
    private EditText nameEditText, bioEditText;
    private Button saveProfileButton;

    private FirebaseFirestore db;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Инициализация элементов интерфейса
        profileImageView = findViewById(R.id.profileImageView);
        nameEditText = findViewById(R.id.nameEditText);
        bioEditText = findViewById(R.id.bioEditText);
        saveProfileButton = findViewById(R.id.saveProfileButton);

        // Инициализация Firebase
        db = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        // Загрузка данных профиля
        if (currentUser != null) {
            loadUserProfile();
        }

        // Обработка нажатия на кнопку "Сохранить"
        saveProfileButton.setOnClickListener(v -> saveProfile());
    }

    private void loadUserProfile() {
        // Загрузка данных из Firestore
        db.collection("users").document(currentUser.getUid())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String name = documentSnapshot.getString("name");
                        String bio = documentSnapshot.getString("bio");
                        String photoUrl = documentSnapshot.getString("photoUrl");

                        // Установка данных в поля
                        nameEditText.setText(name);
                        bioEditText.setText(bio);

                        // Загрузка фото профиля (если есть)
                        if (photoUrl != null) {
                            Glide.with(this).load(photoUrl).into(profileImageView);
                        }
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Ошибка загрузки профиля", Toast.LENGTH_SHORT).show();
                });
    }

    private void saveProfile() {
        // Получение данных из полей
        String name = nameEditText.getText().toString();
        String bio = bioEditText.getText().toString();

        // Обновление данных в Firestore
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", name);
        updates.put("bio", bio);

        db.collection("users").document(currentUser.getUid())
                .update(updates)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Профиль обновлен!", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Ошибка обновления профиля", Toast.LENGTH_SHORT).show();
                });
    }
}