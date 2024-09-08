package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.quiz.Score;
import java.util.List;

public class ScoreAdapter extends BaseAdapter {
    private Context context;
    private List<Score> scores;

    public ScoreAdapter(Context context, List<Score> scores) {
        this.context = context;
        this.scores = scores;
    }

    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int position) {
        return scores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_score, parent, false);
        }

        Score score = scores.get(position);

        TextView textViewRank = convertView.findViewById(R.id.textViewRank);
        TextView textViewPlayerName = convertView.findViewById(R.id.textViewPlayerName);
        TextView textViewScore = convertView.findViewById(R.id.textViewScore);

        textViewRank.setText(String.valueOf(position + 1));
        textViewPlayerName.setText(score.getPlayerName());
        textViewScore.setText(String.valueOf(score.getScore()));

        return convertView;
    }
}
