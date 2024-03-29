package com.example.project_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SummaryActivity extends AppCompatActivity {

    // Correct answers
    String correctAnswer1;
    String correctAnswer2;
    String correctAnswer3;
    String correctAnswer4;
    String correctAnswer5;
    String correctAnswer6;
    String correctAnswer8text1;
    String correctAnswer8text2;
    String correctAnswer8text3;
    String correctAnswer8text4;
    String correctAnswer8text5;
    String correctAnswer7checkbox1;
    String correctAnswer7checkbox2;
    String correctAnswer7checkbox3;
    String correctAnswer7checkbox4;
    String correctAnswer7checkbox5;

    boolean userQuestion7checkbox1, userQuestion7checkbox2, userQuestion7checkbox3, userQuestion7checkbox4, userQuestion7checkbox5;
    String userQuestion8text1, userQuestion8text2, userQuestion8text3, userQuestion8text4, userQuestion8text5;

    final int pointsPerHit = 60;
    int numberOfHits = 0;
    int pointsEarned = 0;
    int finalHits, finalPoints;
    String textHit;
    String feelingNotSeen;
    String feelingCrazy;
    String feelingBad;
    String feelingCool;
    String feelingOhhh;
    String feelingPerfect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        correctAnswer1 = getString(R.string.correct_answer_1);
        correctAnswer2 = getString(R.string.correct_answer_2);
        correctAnswer3 = getString(R.string.correct_answer_3);
        correctAnswer4 = getString(R.string.correct_answer_4);
        correctAnswer5 = getString(R.string.correct_answer_5);
        correctAnswer6 = getString(R.string.correct_answer_6);
        correctAnswer8text1 = getString(R.string.correct_answer_8_1);
        correctAnswer8text2 = getString(R.string.correct_answer_8_2);
        correctAnswer8text3 = getString(R.string.correct_answer_8_3);
        correctAnswer8text4 = getString(R.string.correct_answer_8_4);
        correctAnswer8text5 = getString(R.string.correct_answer_8_5);
        correctAnswer7checkbox1 = getString(R.string.yes);
        correctAnswer7checkbox2 = getString(R.string.yes);
        correctAnswer7checkbox3 = getString(R.string.no);
        correctAnswer7checkbox4 = getString(R.string.yes);
        correctAnswer7checkbox5 = getString(R.string.no);

        textHit = getString(R.string.you_got_a_hit);
        feelingNotSeen = getString(R.string.result_feedback_1);
        feelingCrazy = getString(R.string.result_feedback_2);
        feelingBad = getString(R.string.result_feedback_3);
        feelingCool = getString(R.string.result_feedback_4);
        feelingOhhh = getString(R.string.result_feedback_5);
        feelingPerfect = getString(R.string.result_feedback_6);

        // Grab data from QuestionActivity by Intent
        Bundle userData = getIntent().getExtras();
      //  String name = userData.getString("name");
     //   String email = userData.getString("email");
      //  int age = userData.getInt("age");
     //   boolean sendMeACopy = userData.getBoolean("sendMeACopy");
     //   boolean sendMeFuture = userData.getBoolean("sendMeFuture");
     //   String isAthleteActive = userData.getString("isAthleteActive");
        String userAnswer1 = userData.getString("userAnswer1");
        String userAnswer2 = userData.getString("userAnswer2");
        String userAnswer3 = userData.getString("userAnswer3");
        String userAnswer4 = userData.getString("userAnswer4");
        String userAnswer5 = userData.getString("userAnswer5");
        String userAnswer6 = userData.getString("userAnswer6");

        boolean userQuestion7checkbox1 = userData.getBoolean("question7checkbox1");
        boolean userQuestion7checkbox2 = userData.getBoolean("question7checkbox2");
        boolean userQuestion7checkbox3 = userData.getBoolean("question7checkbox3");
        boolean userQuestion7checkbox4 = userData.getBoolean("question7checkbox4");
        boolean userQuestion7checkbox5 = userData.getBoolean("question7checkbox5");

        userQuestion8text1 = userData.getString("question8text1");
        userQuestion8text2 = userData.getString("question8text2");
        userQuestion8text3 = userData.getString("question8text3");
        userQuestion8text4 = userData.getString("question8text4");
        userQuestion8text5 = userData.getString("question8text5");

        String commentText = userData.getString("commentText");

        generateSummary(numberOfHits,
                            pointsEarned,
                            correctAnswer1,
                            correctAnswer2,
                            correctAnswer3,
                            correctAnswer4,
                            correctAnswer5,
                            correctAnswer6,
                            userAnswer1,
                            userAnswer2,
                            userAnswer3,
                            userAnswer4,
                            userAnswer5,
                            userAnswer6,
                            userQuestion7checkbox1,
                            userQuestion7checkbox2,
                            userQuestion7checkbox3,
                            userQuestion7checkbox4,
                            userQuestion7checkbox5,
                            userQuestion8text1,
                            userQuestion8text2,
                            userQuestion8text3,
                            userQuestion8text4,
                            userQuestion8text5);

    }

    /**
     * The method gets all user answer and compare with the correct ones. If they match add 1 to number of hits and multiply by points per hit (60) giving the pointsEarned as a result.
     *
     * @param numberOfHits is the number of right answers that user hit
     * @param pointsEarned is the number of hits multiplied by the number of points per hit 60
     * @param correctAnswer1 is the correct answer to be compared with the user answer of the question 1
     * @param correctAnswer2 is the correct answer to be compared with the user answer of the question 2
     * @param correctAnswer3 is the correct answer to be compared with the user answer of the question 3
     * @param correctAnswer4 is the correct answer to be compared with the user answer of the question 4
     * @param correctAnswer5 is the correct answer to be compared with the user answer of the question 5
     * @param correctAnswer6 is the correct answer to be compared with the user answer of the question 6
     * @param userAnswer1 is the user answer select in question 1
     * @param userAnswer2 is the user answer select in question 2
     * @param userAnswer3 is the user answer select in question 3
     * @param userAnswer4 is the user answer select in question 4
     * @param userAnswer5 is the user answer select in question 5
     * @param userAnswer6 is the user answer select in question 6
     */
    public void generateSummary(int numberOfHits,
                                    int pointsEarned,
                                    String correctAnswer1,
                                    String correctAnswer2,
                                    String correctAnswer3,
                                    String correctAnswer4,
                                    String correctAnswer5,
                                    String correctAnswer6,
                                    String userAnswer1,
                                    String userAnswer2,
                                    String userAnswer3,
                                    String userAnswer4,
                                    String userAnswer5,
                                    String userAnswer6,
                                    boolean userQuestion7checkbox1,
                                    boolean userQuestion7checkbox2,
                                    boolean userQuestion7checkbox3,
                                    boolean userQuestion7checkbox4,
                                    boolean userQuestion7checkbox5,
                                    String userQuestion8text1,
                                    String userQuestion8text2,
                                    String userQuestion8text3,
                                    String userQuestion8text4,
                                    String userQuestion8text5){

        // Send user answer and correct answer to question 1 card at the summary
        TextView userAnswerTextView1 = findViewById(R.id.user_answer_1);
            userAnswerTextView1.setText(userAnswer1);
        TextView correctAnswerTextView1 = findViewById(R.id.correct_answer_1);
            correctAnswerTextView1.setText(correctAnswer1);
        // Send user answer and correct answer to question 2 card at the summary
        TextView userAnswerTextView2 = findViewById(R.id.user_answer_2);
            userAnswerTextView2.setText(userAnswer2);
        TextView correctAnswerTextView2 = findViewById(R.id.correct_answer_2);
            correctAnswerTextView2.setText(correctAnswer2);
        // Send user answer and correct answer to question 3 card at the summary
        TextView userAnswerTextView3 = findViewById(R.id.user_answer_3);
            userAnswerTextView3.setText(userAnswer3);
        TextView correctAnswerTextView3 = findViewById(R.id.correct_answer_3);
            correctAnswerTextView3.setText(correctAnswer3);
        // Send user answer and correct answer to question 4 card at the summary
        TextView userAnswerTextView4 = findViewById(R.id.user_answer_4);
            userAnswerTextView4.setText(userAnswer4);
        TextView correctAnswerTextView4 = findViewById(R.id.correct_answer_4);
            correctAnswerTextView4.setText(correctAnswer4);
        // Send user answer and correct answer to question 5 card at the summary
        TextView userAnswerTextView5 = findViewById(R.id.user_answer_5);
            userAnswerTextView5.setText(userAnswer5);
        TextView correctAnswerTextView5 = findViewById(R.id.correct_answer_5);
            correctAnswerTextView5.setText(correctAnswer5);
        // Send user answer and correct answer to question 6 card at the summary
        TextView userAnswerTextView6 = findViewById(R.id.user_answer_6);
            userAnswerTextView6.setText(userAnswer6);
        TextView correctAnswerTextView6 = findViewById(R.id.correct_answer_6);
            correctAnswerTextView6.setText(correctAnswer6);

        // QUESTION 7
        if(userQuestion7checkbox1){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img71 = findViewById(R.id.img_question_7_user_option_1);
            img71.setImageResource(R.drawable.question_hit);
        }
        if(userQuestion7checkbox2){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img72 = findViewById(R.id.img_question_7_user_option_2);
            img72.setImageResource(R.drawable.question_hit);
        }
        if(!userQuestion7checkbox3){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img73 = findViewById(R.id.img_question_7_user_option_3);
            img73.setImageResource(R.drawable.question_missed);
        }
        if(userQuestion7checkbox4){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img74 = findViewById(R.id.img_question_7_user_option_4);
            img74.setImageResource(R.drawable.question_hit);
        }
        if(!userQuestion7checkbox5){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img75 = findViewById(R.id.img_question_7_user_option_5);
            img75.setImageResource(R.drawable.question_missed);
        }

        // QUESTION 8
        // Update the correct answers on summary
        TextView correctAnswerTextView81 = findViewById(R.id.question_8_correct_option_1);
            correctAnswerTextView81.setText(correctAnswer8text1);
        TextView correctAnswerTextView82 = findViewById(R.id.question_8_correct_option_2);
            correctAnswerTextView82.setText(correctAnswer8text2);
        TextView correctAnswerTextView83 = findViewById(R.id.question_8_correct_option_3);
            correctAnswerTextView83.setText(correctAnswer8text3);
        TextView correctAnswerTextView84 = findViewById(R.id.question_8_correct_option_4);
            correctAnswerTextView84.setText(correctAnswer8text4);
        TextView correctAnswerTextView85 = findViewById(R.id.question_8_correct_option_5);
            correctAnswerTextView85.setText(correctAnswer8text5);

        if(userQuestion8text1.equals(correctAnswer8text1)){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img81 = findViewById(R.id.img_question_8_correct_option_1);
            img81.setImageResource(R.drawable.question_hit);
        }
        if(userQuestion8text2.equals(correctAnswer8text2)){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img82 = findViewById(R.id.img_question_8_correct_option_2);
            img82.setImageResource(R.drawable.question_hit);
        }
        if(userQuestion8text3.equals(correctAnswer8text3)){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img83 = findViewById(R.id.img_question_8_correct_option_3);
            img83.setImageResource(R.drawable.question_hit);
        }
        if(userQuestion8text4.equals(correctAnswer8text4)){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img84 = findViewById(R.id.img_question_8_correct_option_4);
            img84.setImageResource(R.drawable.question_hit);
        }
        if(userQuestion8text5.equals(correctAnswer8text5)){
            numberOfHits++;
            pointsEarned = pointsEarned + 12;
            ImageView img85 = findViewById(R.id.img_question_8_correct_option_5);
            img85.setImageResource(R.drawable.question_hit);
        }

        // Check if use answers are correct or not, updates the number of hits and points earned
        if(userAnswer1.equals(correctAnswer1)){
            numberOfHits++;
            pointsEarned += 60;

            ImageView img1 = findViewById(R.id.img_answer_1);
            img1.setImageResource(R.drawable.question_hit);

            TextView textAnswerTextView1 = findViewById(R.id.summary_bottom_layout_text_1);
            textAnswerTextView1.setText(textHit);
            textAnswerTextView1.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));
        }
        if(userAnswer2.equals(correctAnswer2)){
            numberOfHits++;
            pointsEarned += pointsPerHit;

            ImageView img2 = findViewById(R.id.img_answer_2);
            img2.setImageResource(R.drawable.question_hit);

            TextView textAnswerTextView2 = findViewById(R.id.summary_bottom_layout_text_2);
            textAnswerTextView2.setText(textHit);
            textAnswerTextView2.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));
        }
        if(userAnswer3.equals(correctAnswer3)){
            numberOfHits++;
            pointsEarned += pointsPerHit;

            ImageView img3 = findViewById(R.id.img_answer_3);
            img3.setImageResource(R.drawable.question_hit);

            TextView textAnswerTextView3 = findViewById(R.id.summary_bottom_layout_text_3);
            textAnswerTextView3.setText(textHit);
            textAnswerTextView3.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));
        }
        if(userAnswer4.equals(correctAnswer4)){
            numberOfHits++;
            pointsEarned += pointsPerHit;

            ImageView img4 = findViewById(R.id.img_answer_4);
            img4.setImageResource(R.drawable.question_hit);

            TextView textAnswerTextView4 = findViewById(R.id.summary_bottom_layout_text_4);
            textAnswerTextView4.setText(textHit);
            textAnswerTextView4.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));
        }
        if(userAnswer5.equals(correctAnswer5)){
            numberOfHits++;
            pointsEarned += pointsPerHit;

            ImageView img5 = findViewById(R.id.img_answer_5);
            img5.setImageResource(R.drawable.question_hit);

            TextView textAnswerTextView5 = findViewById(R.id.summary_bottom_layout_text_5);
            textAnswerTextView5.setText(textHit);
            textAnswerTextView5.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));
        }
        if(userAnswer6.equals(correctAnswer6)){
            numberOfHits++;
            pointsEarned += pointsPerHit;

            TextView textAnswerTextView6 = findViewById(R.id.summary_bottom_layout_text_6);
            textAnswerTextView6.setText(textHit);
            textAnswerTextView6.setTextColor(ContextCompat.getColor(this, R.color.correctAnswer));

            ImageView img6 = findViewById(R.id.img_answer_6);
            img6.setImageResource(R.drawable.question_hit);
        }

        // update the points earned on the summary and show it as a toast message
        TextView hitsTextView = findViewById(R.id.number_of_hit_questions);
        hitsTextView.setText(String.valueOf(numberOfHits));
        finalHits = numberOfHits;

        // update the number of hits  on the summary and show it as a toast message
        TextView pointsTextView = findViewById(R.id.points_earned);
        pointsTextView.setText(String.valueOf(pointsEarned));
        finalPoints = pointsEarned;

        // Update the summary header with text and image according to amount of questions hit
        if(numberOfHits < 3) {
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_not_seen);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingNotSeen);
        }else if(numberOfHits <= 6){
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_crazy);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingCrazy);
        }else if(numberOfHits <= 10){
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_bad);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingBad);
        }else if(numberOfHits <= 12){
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_cool);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingCool);
        }else if(numberOfHits <= 15){
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_ohhhhh);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingOhhh);
        }else{
            ImageView imgFeeling = findViewById(R.id.img_feeling);
                imgFeeling.setImageResource(R.drawable.feeling_perfect);
            TextView textFelling = findViewById(R.id.text_feeling);
                textFelling.setText(feelingPerfect);
        }
    }

    public void sendQuizByEmail(View view){

        String sendMeACopy;
        String sendMeFuture;

        Bundle userData = getIntent().getExtras();
        String name = userData.getString("name");
        String email = userData.getString("email");
        int age = userData.getInt("age");
        boolean receiveCopy = userData.getBoolean("sendMeACopy");
            if(receiveCopy){
                    sendMeACopy = getString(R.string.yes);
                }else{
                    sendMeACopy = getString(R.string.no);
            }
        boolean sendFuture = userData.getBoolean("sendMeFuture");
            if(sendFuture){
                sendMeFuture = getString(R.string.yes);
            }else{
                sendMeFuture = getString(R.string.no);
            }
        String isAthleteActive = userData.getString("isAthleteActive");
        String userAnswer1 = userData.getString("userAnswer1");
        String userAnswer2 = userData.getString("userAnswer2");
        String userAnswer3 = userData.getString("userAnswer3");
        String userAnswer4 = userData.getString("userAnswer4");
        String userAnswer5 = userData.getString("userAnswer5");
        String userAnswer6 = userData.getString("userAnswer6");
        String commentText = userData.getString("commentText");

        TextView pointsTextView = findViewById(R.id.points_earned);
        int pointsEarned = Integer.parseInt(pointsTextView.getText().toString());

        TextView numberOfHitsTextView = findViewById(R.id.number_of_hit_questions);
        int numberOfHits = Integer.parseInt(numberOfHitsTextView.getText().toString());

        String userSummary = addDataToEmailSummary(name,
                                            email,
                                            age,
                                            numberOfHits,
                                            pointsEarned,
                                            correctAnswer1,
                                            correctAnswer2,
                                            correctAnswer3,
                                            correctAnswer4,
                                            correctAnswer5,
                                            correctAnswer6,
                                            userAnswer1,
                                            userAnswer2,
                                            userAnswer3,
                                            userAnswer4,
                                            userAnswer5,
                                            userAnswer6,
                                            userQuestion7checkbox1,
                                            userQuestion7checkbox2,
                                            userQuestion7checkbox3,
                                            userQuestion7checkbox4,
                                            userQuestion7checkbox5,
                                            userQuestion8text1,
                                            userQuestion8text2,
                                            userQuestion8text3,
                                            userQuestion8text4,
                                            userQuestion8text5,
                                            commentText,
                                            sendMeACopy,
                                            sendMeFuture,
                                            isAthleteActive);

        // sending summary to the email body
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        // only email apps should handle this
        intent.setData(Uri.parse("mailto:" + email));
        // sending the subject os the email + name
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.quiz_summary_email_subject) + name);
        // Add data to userSummary object.
        intent.putExtra(Intent.EXTRA_TEXT, userSummary);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     *
     * @param name
     * @param email
     * @param age
     * @param numberOfHits
     * @param pointsEarned
     * @param userAnswer1
     * @param userAnswer2
     * @param userAnswer3
     * @param userAnswer4
     * @param userAnswer5
     * @param userAnswer6
     * @param correctAnswer1
     * @param correctAnswer2
     * @param correctAnswer3
     * @param correctAnswer4
     * @param correctAnswer5
     * @param correctAnswer6
     * @param commentText
     * @param sendMeACopy
     * @param sendMeFuture
     * @param isAthleteActive
     * @return
     */
    private String addDataToEmailSummary(String name,
                                         String email,
                                         int age,
                                         int numberOfHits,
                                         int pointsEarned,
                                         String userAnswer1,
                                         String userAnswer2,
                                         String userAnswer3,
                                         String userAnswer4,
                                         String userAnswer5,
                                         String userAnswer6,
                                         String correctAnswer1,
                                         String correctAnswer2,
                                         String correctAnswer3,
                                         String correctAnswer4,
                                         String correctAnswer5,
                                         String correctAnswer6,
                                         boolean userQuestion7checkbox1,
                                         boolean userQuestion7checkbox2,
                                         boolean userQuestion7checkbox3,
                                         boolean userQuestion7checkbox4,
                                         boolean userQuestion7checkbox5,
                                         String userQuestion8text1,
                                         String userQuestion8text2,
                                         String userQuestion8text3,
                                         String userQuestion8text4,
                                         String userQuestion8text5,
                                         String commentText,
                                         String sendMeACopy,
                                         String sendMeFuture,
                                         String isAthleteActive){

        String userSummaryData = getString(R.string.my_quiz_athletics_result);

        // User data
        userSummaryData += "\n\n " + getString(R.string.name) + name;
        userSummaryData += "\n " + getString(R.string.email) + email;
        userSummaryData += "\n " + getString(R.string.age) + age;

        // Points
        userSummaryData += "\n\n " + getString(R.string.number_of_hits) + numberOfHits;
        userSummaryData += "\n " + getString(R.string.points_earned) + pointsEarned;

        // Questions and answers
        userSummaryData += "\n\n " + getString(R.string.question_1_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer1;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer1;

        userSummaryData += "\n\n " + getString(R.string.question_2_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer2;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer2;

        userSummaryData += "\n\n " + getString(R.string.question_3_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer3;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer3;

        userSummaryData += "\n\n " + getString(R.string.question_4_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer4;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer4;

        userSummaryData += "\n\n " + getString(R.string.question_5_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer5;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer5;

        userSummaryData += "\n\n " + getString(R.string.question_6_body);
        userSummaryData += "\n " + getString(R.string.your_answer);
        userSummaryData += "\n " + userAnswer6;
        userSummaryData += "\n " + getString(R.string.correct_answer);
        userSummaryData += "\n " + correctAnswer6;

        String userAnswer71, userAnswer72, userAnswer73, userAnswer74, userAnswer75;
        if(userQuestion7checkbox1){
            userAnswer71 = getString(R.string.yes);
        }else{
            userAnswer71 = getString(R.string.yes);
        }
        if(userQuestion7checkbox2){
            userAnswer72 = getString(R.string.yes);
        }else{
            userAnswer72 = getString(R.string.yes);
        }
        if(userQuestion7checkbox3){
            userAnswer73 = getString(R.string.yes);
        }else{
            userAnswer73 = getString(R.string.yes);
        }
        if(userQuestion7checkbox4){
            userAnswer74 = getString(R.string.yes);
        }else{
            userAnswer74 = getString(R.string.yes);
        }
        if(userQuestion7checkbox5){
            userAnswer75 = getString(R.string.yes);
        }else{
            userAnswer75 = getString(R.string.yes);
        }
        userSummaryData += "\n\n " + getString(R.string.question_7_body);
        userSummaryData += "\n\n " + getString(R.string.question_7_answer_1);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userAnswer71;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer7checkbox1;
        userSummaryData += "\n\n " + getString(R.string.question_7_answer_2);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userAnswer72;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer7checkbox2;
        userSummaryData += "\n\n " + getString(R.string.question_7_answer_3);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userAnswer73;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer7checkbox3;
        userSummaryData += "\n\n " + getString(R.string.question_7_answer_4);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userAnswer74;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer7checkbox4;
        userSummaryData += "\n\n " + getString(R.string.question_7_answer_5);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userAnswer75;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer7checkbox5;

        userSummaryData += "\n\n " + getString(R.string.question_8_body);
        userSummaryData += "\n\n " + getString(R.string.question_8_answer_1_title);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userQuestion8text1;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer8text1;
        userSummaryData += "\n\n " + getString(R.string.question_8_answer_2_title);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userQuestion8text2;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer8text2;
        userSummaryData += "\n\n " + getString(R.string.question_8_answer_3_title);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userQuestion8text3;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer8text3;
        userSummaryData += "\n\n " + getString(R.string.question_8_answer_4_title);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userQuestion8text4;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer8text4;
        userSummaryData += "\n\n " + getString(R.string.question_8_answer_5_title);
        userSummaryData += "\n " + getString(R.string.your_answer) + " " + userQuestion8text5;
        userSummaryData += "\n " + getString(R.string.correct_answer) + " " + correctAnswer8text5;

        userSummaryData += "\n\n " + getString(R.string.i_wish_a_copy);
        userSummaryData += "\n " + sendMeACopy;

        userSummaryData += "\n\n " + getString(R.string.wish_more_future_quiz);
        userSummaryData += "\n " + sendMeFuture;

        userSummaryData += "\n\n " + getString(R.string.am_i_active_athlete);
        userSummaryData += "\n " + isAthleteActive;

        userSummaryData += "\n\n " + getString(R.string.your_feedback);
        userSummaryData += "\n " + commentText;

        return userSummaryData;
    }

    /**
     * Shows the number of hits, points earned and feedback in a toast message when button SHow Results is clicked
      * @param view
     */
    public void showResults(View view){

        Toast.makeText(this, getString(R.string.you_made) + finalHits + getString(R.string.correct_hits), Toast.LENGTH_LONG).show();
        Toast.makeText(this, getString(R.string.earned) + finalPoints + getString(R.string.points), Toast.LENGTH_LONG).show();

        if(finalHits < 3) {
            Toast.makeText(this, R.string.not_see_this, Toast.LENGTH_LONG).show();
        }else if(finalHits <= 6){
            Toast.makeText(this, R.string.bad_result, Toast.LENGTH_LONG).show();
        }else if(finalHits <= 10){
            Toast.makeText(this, R.string.not_so_bad, Toast.LENGTH_LONG).show();
        }else if(finalHits <= 12){
            Toast.makeText(this, R.string.great_result, Toast.LENGTH_LONG).show();
        }else if(finalHits <= 15){
            Toast.makeText(this, R.string.awesome, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, R.string.perfect_result, Toast.LENGTH_LONG).show();
        }

        View showSummaryTitle = findViewById(R.id.summary_title);
        showSummaryTitle.setVisibility(View.VISIBLE);

        View showSummaryHeader = findViewById(R.id.summary_header);
        showSummaryHeader.setVisibility(View.VISIBLE);

        final View btnSummaryCards;
        btnSummaryCards = findViewById(R.id.btn_show_summary_cards);
        btnSummaryCards.postDelayed(new Runnable() {
            public void run() {
                btnSummaryCards.setVisibility(View.VISIBLE);
            }
        }, 200);

    }

    /**
     * Show all the cards of the summary
     * @param view
     */
    public void showSummaryCards(View view){
        View cardSummaryQuestion1 = findViewById(R.id.card_summary_question_1);
            cardSummaryQuestion1.setVisibility(View.VISIBLE);

        View cardSummaryQuestion2 = findViewById(R.id.card_summary_question_2);
            cardSummaryQuestion2.setVisibility(View.VISIBLE);

        View cardSummaryQuestion3 = findViewById(R.id.card_summary_question_3);
            cardSummaryQuestion3.setVisibility(View.VISIBLE);

        View cardSummaryQuestion4 = findViewById(R.id.card_summary_question_4);
            cardSummaryQuestion4.setVisibility(View.VISIBLE);

        View cardSummaryQuestion5 = findViewById(R.id.card_summary_question_5);
            cardSummaryQuestion5.setVisibility(View.VISIBLE);

        View cardSummaryQuestion6 = findViewById(R.id.card_summary_question_6);
            cardSummaryQuestion6.setVisibility(View.VISIBLE);

        View cardSummaryQuestion7 = findViewById(R.id.card_summary_question_7);
        cardSummaryQuestion7.setVisibility(View.VISIBLE);

        View cardSummaryQuestion8 = findViewById(R.id.card_summary_question_8);
        cardSummaryQuestion8.setVisibility(View.VISIBLE);

        View btnShowSummaryCards = findViewById(R.id.btn_show_summary_cards);
        btnShowSummaryCards.setVisibility(View.VISIBLE);

        View btnSendByEmail = findViewById(R.id.btn_send_by_email);
        btnSendByEmail.setVisibility(View.VISIBLE);

    }

}


