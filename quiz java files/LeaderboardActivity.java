package com.example.quiz;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {
    private ListView listViewLeaderboard;
    private ScoreAdapter scoreAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        setTitle("Leader Board");

        listViewLeaderboard = findViewById(R.id.listViewLeaderboard);
        databaseHelper = new DatabaseHelper(this);

        List<Score> leaderboard = databaseHelper.getLeaderboard();
        scoreAdapter = new ScoreAdapter(this, leaderboard);
        listViewLeaderboard.setAdapter(scoreAdapter);
    }
}
