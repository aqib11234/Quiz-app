package com.example.quiz;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
public class ResultActivity extends AppCompatActivity {
    private TextView textViewScore;
    private TextView textViewLeaderboard;
    private DatabaseHelper databaseHelper;
    private ListView listViewLeaderboard;
    private ScoreAdapter scoreAdapter;
    private List<Score> leaderboard;
    private int selectedPosition;
    private Button buttonQuit;
    private Button buttonPlayAgain;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");

        buttonQuit=findViewById(R.id.buttonQuit);
        buttonPlayAgain=findViewById(R.id.buttonPlayAgain);
        textViewScore = findViewById(R.id.textViewScore);
        listViewLeaderboard = findViewById(R.id.listViewLeaderboard);

        int score = getIntent().getIntExtra("score", 0);
        String playerName = getIntent().getStringExtra("playerName");

        databaseHelper = new DatabaseHelper(this);
        databaseHelper.saveResult(playerName, score);

        String resultText = "Congratulations, " + playerName + "!\nYour score: " + score;
        textViewScore.setText(resultText);

        leaderboard = databaseHelper.getLeaderboard();

        scoreAdapter = new ScoreAdapter(this, leaderboard);
        listViewLeaderboard.setAdapter(scoreAdapter);
        registerForContextMenu(listViewLeaderboard);

        listViewLeaderboard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                openContextMenu(view);
            }
        });


        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuestionsActivity.class);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
                finish();
            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Close the app
            }
        });


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_leaderboard, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_delete_score) {
            Score selectedScore = leaderboard.get(selectedPosition);
            databaseHelper.deleteScore(selectedScore.getId());
            leaderboard.remove(selectedPosition);
            scoreAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }}