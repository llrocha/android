package com.example.android.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamA = 0;
    int teamB = 1;

    int[] scoreTeam = new int[2];
    int[] scoreTeamId = new int[2];

    int[] cornerKickTeam = new int[2];
    int[] cornerKickTeamId = new int[2];

    int[] throwInTeam = new int[2];
    int[] throwInTeamId = new int[2];

    int[] offsideTeam = new int[2];
    int[] offsideTeamId = new int[2];

    int[] foulTeam = new int[2];
    int[] foulTeamId = new int[2];

    int[] yellowCardTeam = new int[2];
    int[] yellowCardTeamId = new int[2];

    int[] redCardTeam = new int[2];
    int[] redCardTeamId = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTeamId[teamA] = R.id.team_a_score;
        scoreTeamId[teamB] = R.id.team_b_score;
        resetScore(null);
    }

    /**
     * Reset the score for Team A and Team B.
     */
    void resetScore(View v) {
        scoreTeam[teamA] = 0;
        scoreTeam[teamB] = 0;
        displayForTeam(teamA);
        displayForTeam(teamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeam(int team) {
        TextView scoreView = (TextView) findViewById(scoreTeamId[team]);
        scoreView.setText(String.valueOf(scoreTeam[team]));
    }

}
