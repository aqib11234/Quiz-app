package com.example.quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LeaderboardAdapter extends ArrayAdapter<Score> {
    private Context context;
    private List<Score> leaderboard;

    public LeaderboardAdapter(Context context, List<Score> leaderboard) {
        super(context, 0, leaderboard);
        this.context = context;
        this.leaderboard = leaderboard;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_leaderboard, parent, false);
        }

        Score currentScore = leaderboard.get(position);

        TextView textViewRank = listItemView.findViewById(R.id.textViewRank);
        TextView textViewPlayerName = listItemView.findViewById(R.id.textViewPlayerName);
        TextView textViewScore = listItemView.findViewById(R.id.textViewScore);

        textViewRank.setText(String.valueOf(position + 1));
        textViewPlayerName.setText(currentScore.getPlayerName());
        textViewScore.setText(String.valueOf(currentScore.getScore()));

        listItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteDialog(currentScore);
                return true;
            }
        });

        return listItemView;
    }

    private void showDeleteDialog(Score score) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete User");
        builder.setMessage("Are you sure you want to delete this user from the leaderboard?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                leaderboard.remove(score);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }
}
