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

    int[] goalKickTeam = new int[2];
    int[] goalKickTeamId = new int[2];

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

        cornerKickTeamId[teamA] = R.id.team_a_corner_kick_count;
        cornerKickTeamId[teamB] = R.id.team_b_corner_kick_count;

        goalKickTeamId[teamA] = R.id.team_a_goal_kick_count;
        goalKickTeamId[teamB] = R.id.team_b_goal_kick_count;

        throwInTeamId[teamA] = R.id.team_a_throwins_count;
        throwInTeamId[teamB] = R.id.team_b_throwins_count;

        offsideTeamId[teamA] = R.id.team_a_offsides_count;
        offsideTeamId[teamB] = R.id.team_b_offsides_count;

        foulTeamId[teamA] = R.id.team_a_fouls_count;
        foulTeamId[teamB] = R.id.team_b_fouls_count;

        yellowCardTeamId[teamA] = R.id.team_a_yellow_card_count;
        yellowCardTeamId[teamB] = R.id.team_b_yellow_card_count;

        redCardTeamId[teamA] = R.id.team_a_red_card_count;
        redCardTeamId[teamB] = R.id.team_b_red_card_count;

        resetScore(null);
    }

    /**
     * Reset the score for Team A and Team B.
     */
    void resetScore(View v) {
        for(int team = 0;team<=1;team++) {
            cornerKickTeam[team] = 0;
            goalKickTeam[team] = 0;
            throwInTeam[team] = 0;
            offsideTeam[team] = 0;
            scoreTeam[team] = 0;
            foulTeam[team] = 0;
            yellowCardTeam[team] = 0;
            redCardTeam[team] = 0;
            displayScoreForTeam(team);
            displayCornerKickForTeam(team);
            displayGoalKickForTeam(team);
            displayThrowInForTeam(team);
            displayOffSideForTeam(team);
            displayFoulForTeam(team);
            displayYellowCardForTeam(team);
            displayRedCardForTeam(team);
        }
    }

    /**
     * Add Goal and displays the given score for Team A.
     */
    void teamAGoal(View v) {
        scoreTeam[teamA]++;
        displayScoreForTeam(teamA);
    }

    /**
     * Add Corner Kick and displays corner kicks  for Team A.
     */
    void teamACornerKick(View v) {
        cornerKickTeam[teamA]++;
        displayCornerKickForTeam(teamA);
    }

    /**
     * Add Goal Kick and displays goal kicks for Team A.
     */
    void teamAGoalKick(View v) {
        goalKickTeam[teamA]++;
        displayGoalKickForTeam(teamA);
    }

    /**
     * Add Throw-in and displays throwins for Team A.
     */
    void teamAThrowIn(View v) {
        throwInTeam[teamA]++;
        displayThrowInForTeam(teamA);
    }

    /**
     * Add OffSide and displays offsides for Team A.
     */
    void teamAOffSide(View v) {
        offsideTeam[teamA]++;
        displayOffSideForTeam(teamA);
    }

    /**
     * Add Foul and displays fouls for Team A.
     */
    void teamAFoul(View v) {
        foulTeam[teamA]++;
        displayFoulForTeam(teamA);
    }

    /**
     * Add Yellow Card and displays yellow cards for Team A.
     */
    void teamAYellowCard(View v) {
        yellowCardTeam[teamA]++;
        displayYellowCardForTeam(teamA);
    }

    /**
     * Add Red Card and displays red cards for Team A.
     */
    void teamARedCard(View v) {
        redCardTeam[teamA]++;
        displayRedCardForTeam(teamA);
    }

    /**
     * Add Goal and displays the given score for Team A.
     */
    void teamBGoal(View v) {
        scoreTeam[teamB]++;
        displayScoreForTeam(teamB);
    }

    /**
     * Add Corner Kick and displays corner kicks  for Team B.
     */
    void teamBCornerKick(View v) {
        cornerKickTeam[teamB]++;
        displayCornerKickForTeam(teamB);
    }

    /**
     * Add Throw-in and displays throwins for Team B.
     */
    void teamBGoalKick(View v) {
        goalKickTeam[teamB]++;
        displayGoalKickForTeam(teamB);
    }

    /**
     * Add OffSide and displays offsides for Team B.
     */
    void teamBThrowIn(View v) {
        throwInTeam[teamB]++;
        displayThrowInForTeam(teamB);
    }

    /**
     * Add OffSide and displays offsides for Team B.
     */
    void teamBOffSide(View v) {
        offsideTeam[teamB]++;
        displayOffSideForTeam(teamB);
    }

    /**
     * Add Foul and displays fouls for Team B.
     */
    void teamBFoul(View v) {
        foulTeam[teamB]++;
        displayFoulForTeam(teamB);
    }

    /**
     * Add Yellow Card and displays yellow cards for Team B.
     */
    void teamBYellowCard(View v) {
        yellowCardTeam[teamB]++;
        displayYellowCardForTeam(teamB);
    }

    /**
     * Add Red Card and displays red cards for Team B.
     */
    void teamBRedCard(View v) {
        redCardTeam[teamB]++;
        displayRedCardForTeam(teamB);
    }

    /**
     * Displays the given score for Team.
     */
    public void displayScoreForTeam(int team) {
        TextView v = (TextView) findViewById(scoreTeamId[team]);
        v.setText(String.valueOf(scoreTeam[team]));
    }

    public void displayCornerKickForTeam(int team) {
        TextView v = (TextView) findViewById(cornerKickTeamId[team]);
        v.setText(String.valueOf(cornerKickTeam[team]));
    }

    public void displayGoalKickForTeam(int team) {
        TextView v = (TextView) findViewById(goalKickTeamId[team]);
        v.setText(String.valueOf(goalKickTeam[team]));
    }

    public void displayThrowInForTeam(int team) {
        TextView v = (TextView) findViewById(throwInTeamId[team]);
        v.setText(String.valueOf(throwInTeam[team]));
    }

    public void displayOffSideForTeam(int team) {
        TextView v = (TextView) findViewById(offsideTeamId[team]);
        v.setText(String.valueOf(offsideTeam[team]));
    }

    public void displayFoulForTeam(int team) {
        TextView v = (TextView) findViewById(foulTeamId[team]);
        v.setText(String.valueOf(foulTeam[team]));
    }

    public void displayYellowCardForTeam(int team) {
        TextView v = (TextView) findViewById(yellowCardTeamId[team]);
        v.setText(String.valueOf(yellowCardTeam[team]));
    }

    public void displayRedCardForTeam(int team) {
        TextView v = (TextView) findViewById(redCardTeamId[team]);
        v.setText(String.valueOf(redCardTeam[team]));
    }

}
