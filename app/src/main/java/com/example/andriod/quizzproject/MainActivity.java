package com.example.andriod.quizzproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the submit button is press
    // Here I found the Id of all my inputs of checkboxes, radio buttons and EditText used for evaluation
    // I also called other methods that handle the evaluation and pass their return value to a varaible
    public void submitResult(View view) {
        int scoreCheck = 0; // variable to hold the evaluated score from checkboxes
        int scoreCheck2 = 0; // variable to hold the evaluated score from radio buttons
        int scoreCheck3 = 0;    // variable to hold the evaluated score from editaTextViews

        // finding id of Checkbox with correct answer inputs from question 1  and passing them to a boolean variable
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.oneA);
        boolean answer11 = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.oneD);
        boolean answer12 = checkBox2.isChecked();

        // finding id of Checkbox with wrong answer inputs from question 1  and passing them to a boolean variable
        CheckBox checkBox_1 = (CheckBox) findViewById(R.id.oneB);
        boolean badanswer11 = checkBox_1.isChecked();

        CheckBox checkBox_2 = (CheckBox) findViewById(R.id.oneC);
        boolean badanswer12 = checkBox_2.isChecked();

        // finding id of Checkbox with correct answer inputs from question 2  and passing them to a boolean variable
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.twoB);
        boolean answer21 = checkBox3.isChecked();

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.twoD);
        boolean answer22 = checkBox4.isChecked();

        // finding id of Checkbox with wrong answer inputs from question 2  and passing them to a boolean variable
        CheckBox checkBox_3 = (CheckBox) findViewById(R.id.twoA);
        boolean badanswer21 = checkBox_3.isChecked();

        CheckBox checkBox_4 = (CheckBox) findViewById(R.id.twoC);
        boolean badanswer22 = checkBox_4.isChecked();

        // finding id of Checkbox with correct answer inputs from question 3  and passing them to a boolean variable
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.threeA);
        boolean answer31 = checkBox5.isChecked();
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.threeB);
        boolean answer32 = checkBox6.isChecked();
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.threeC);
        boolean answer33 = checkBox7.isChecked();

        // finding id of Checkbox with wrong answer inputs from question 3  and passing them to a boolean variable
        CheckBox checkBox_5 = (CheckBox) findViewById(R.id.threeD);
        boolean badanswer31 = checkBox_5.isChecked();

        // finding id of Checkbox with correct answer inputs from question 4  and passing them to a boolean variable
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.fourB);
        boolean answer41 = checkBox8.isChecked();
        CheckBox checkBox9 = (CheckBox) findViewById(R.id.fourC);
        boolean answer42 = checkBox9.isChecked();
        CheckBox checkBox10 = (CheckBox) findViewById(R.id.fourD);
        boolean answer43 = checkBox10.isChecked();

        // finding id of Checkbox with wrong answer inputs from question 4  and passing them to a boolean variable
        CheckBox checkBox_6 = (CheckBox) findViewById(R.id.fourA);
        boolean badanswer41 = checkBox_6.isChecked();

        // Passing input from question 8 to a string variable
        EditText edit_text1 = (EditText) findViewById(R.id.text_answer_1);
        String text_answer_1 = edit_text1.getText().toString().toLowerCase();

        // Passing input from question 9 to a string variable
        EditText edit_text2 = (EditText) findViewById(R.id.text_answer_2);
        String text_answer_2 = edit_text2.getText().toString().toLowerCase();

        // Passing input from question 10 to a string variable
        EditText edit_text3 = (EditText) findViewById(R.id.text_answer_3);
        String text_answer_3 = edit_text3.getText().toString().toLowerCase();

        // finding the Radio group for  question 5
        RadioGroup radio_group1 = (RadioGroup) findViewById(R.id.radioGroup1);

        // finding the radio button with the right answer for question 5
        RadioButton radio_test1 = (RadioButton) findViewById(R.id.fiveC);

        // finding the Radio group for  question 6
        RadioGroup radio_group2 = (RadioGroup) findViewById(R.id.radioGroup2);

        // finding the radio button with the right answer for question 6
        RadioButton radio_test2 = (RadioButton) findViewById(R.id.sixB);

        // finding the Radio group for  question 7
        RadioGroup radio_group3 = (RadioGroup) findViewById(R.id.radioGroup3);

        // finding the radio button with the right answer for question 7
        RadioButton radio_test3 = (RadioButton) findViewById(R.id.sevenD);

        // Passing the Strings from question 8, 9 and 10 to be evaluted in
        // scoresForTextBox method that stores the corresponding points gotten in scoreCheck3
        scoreCheck3 = scoresForTextBox(text_answer_1, text_answer_2, text_answer_3);

        // Passing the checkboxes from question 1, 2, 3 and 4 to be evaluted in
        // scoresForCheckBoxes method that stores the corresponding points gotten in scoreCheck
        scoreCheck = scoresForCheckBoxes(answer11, answer12, answer21, answer22, answer31, answer32, answer33, answer41, answer42, answer43,
                badanswer11, badanswer12, badanswer21, badanswer22, badanswer31, badanswer41);

        // Passing the checkboxes from question 5, 6 and 7 to be evaluted in
        // scoresForCheckBoxes method that stores the corresponding points gotten in scoreCheck2
        scoreCheck2 = calcRadioButton(radio_group1, radio_test1,radio_group2, radio_test2,radio_group3, radio_test3);

        // All eveluated scores are added up and displayed by scoreCalculation
        scoreCalculate(scoreCheck,scoreCheck2,scoreCheck3);



    }

    // Evaluating all the checkboxes for question 1, 2, 3 and 4
    public int scoresForCheckBoxes(boolean answer11, boolean answer12, boolean answer21, boolean answer22, boolean answer31, boolean answer32, boolean answer33,
                                   boolean answer41, boolean answer42, boolean answer43, boolean badanswer11, boolean badanswer12, boolean badanswer21, boolean badanswer22,
                                   boolean badanswer31, boolean badanswer41) {

        int scoresFromCheckBoxes = 0;

        // Evaluation for question 1
        if (answer11) {
            if (answer12) {
                if (badanswer11 == false) {
                    if (badanswer12 == false) {
                        scoresFromCheckBoxes++;
                    }
                }
            }
        }

        // Evaluation for question 2
        if (answer21) {
            if (answer22) {
                if (badanswer21 == false) {
                    if (badanswer22 == false) {
                        scoresFromCheckBoxes++;
                    }
                }
            }
        }

        // Evaluation for question 3
        if (answer31) {
            if (answer32) {
                if (answer33) {
                    if (badanswer31 == false) {
                        scoresFromCheckBoxes++;
                    }
                }
            }
        }

        // Evaluation for question 4
        if (answer41) {
            if (answer42) {
                if (answer43) {
                    if (badanswer41 == false) {
                        scoresFromCheckBoxes++;
                    }
                }
            }
        }

        return scoresFromCheckBoxes;
    }



    // Evaluating the radio buttons for question 5, 6 andf 74
     public int calcRadioButton (RadioGroup RG1, RadioButton RB1 ,RadioGroup RG2, RadioButton RB2,RadioGroup RG3, RadioButton RB3){
        int point = 0;
        // Checking if radio group is not checked for question 5
         if (RG1.getCheckedRadioButtonId() == -1)
         {
             // no radio buttons are checked
         }
         else
         {
             if(RB1.isChecked())//add point if radiobutton is checked
             {
                 point++ ;
             }

         }

         // Checking if radio group is not checked for question 6
         if (RG2.getCheckedRadioButtonId() == -1)
         {
             // no radio buttons are checked
         }
         else
         {
             if(RB2.isChecked())//add point if radiobutton is checked
             {
                 point++ ;
             }

         }

         // Checking if radio group is not checked for question 7
         if (RG3.getCheckedRadioButtonId() == -1)
         {
             // no radio buttons are checked
         }
         else
         {
             if(RB3.isChecked())//add point if radiobutton is checked
             {
                 point++ ;
             }

         }
         return point;
     }



    public int scoresForTextBox(String text_answer_1, String text_answer_2, String text_answer_3 ){

        int points = 0;
        boolean correct = text_answer_1.equals("animals"); // compare if The inputted text is same as the answeradd point if it is
        if (correct){
            points++ ;
        }
        boolean correct2 = text_answer_2.equals("cold"); // compare if The inputted text is same as the answeradd point if it is
        if (correct2){
            points++ ;
        }
        boolean correct3 = text_answer_3.equals("blood"); // compare if The inputted text is same as the answeradd point if it is
        if (correct3){
            points++ ;
        }
        return points;
    }

    // Adding all evaluated points together and displaying a toast message
    public void scoreCalculate(int checkBoxcoreCheck ,int radioButtonCheck, int editTextField) {
        int total_score = checkBoxcoreCheck + radioButtonCheck + editTextField ;
        int percentage = total_score * 10;
        Toast.makeText(this, "You got " + total_score + " questions correct \n\t\t\t\t\t You scored " + percentage +"% ", Toast.LENGTH_SHORT).show();
    }

// Reset quiz by clearing previouse input
    public void resetQuiz (View view){
        /*
        find checked checkboxes and uncheck them
         */
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.oneA);
        if (checkBox1.isChecked()){
            checkBox1.toggle();
        }

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.oneD);
        if (checkBox2.isChecked()){
            checkBox2.toggle();
        }

        // Checkbox for wrong inputs for question1
        CheckBox checkBox_1 = (CheckBox) findViewById(R.id.oneB);
        if (checkBox_1.isChecked()){
            checkBox_1.toggle();
        }

        CheckBox checkBox_2 = (CheckBox) findViewById(R.id.oneC);
        if (checkBox_2.isChecked()){
            checkBox_2.toggle();
        }

        // Checkbox answer inputs from question 2
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.twoB);
        if (checkBox3.isChecked()){
            checkBox3.toggle();
        }

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.twoD);
        if (checkBox4.isChecked()){
            checkBox4.toggle();
        }

        // Checkbox for wrong inputs for question 2
        CheckBox checkBox_3 = (CheckBox) findViewById(R.id.twoA);
        if (checkBox_3.isChecked()){
            checkBox_3.toggle();
        }

        CheckBox checkBox_4 = (CheckBox) findViewById(R.id.twoC);
        if (checkBox_4.isChecked()){
            checkBox_4.toggle();
        }

        // Checkbox answer inputs from question 3
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.threeA);
        if (checkBox5.isChecked()){
            checkBox5.toggle();
        }

        CheckBox checkBox6 = (CheckBox) findViewById(R.id.threeB);
        if (checkBox6.isChecked()){
            checkBox6.toggle();
        }

        CheckBox checkBox7 = (CheckBox) findViewById(R.id.threeC);
        if (checkBox7.isChecked()){
            checkBox7.toggle();
        }

        // Checkbox for wrong inputs for question 3
        CheckBox checkBox_5 = (CheckBox) findViewById(R.id.threeD);
        if (checkBox_5.isChecked()){
            checkBox_5.toggle();
        }

        // Checkbox answer inputs from question 4
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.fourB);
        if (checkBox8.isChecked()){
            checkBox8.toggle();
        }

        CheckBox checkBox9 = (CheckBox) findViewById(R.id.fourC);
        if (checkBox9.isChecked()){
            checkBox9.toggle();
        }

        CheckBox checkBox10 = (CheckBox) findViewById(R.id.fourD);
        if (checkBox10.isChecked()){
            checkBox10.toggle();
        }

        // Checkbox for wrong inputs for question 4
        CheckBox checkBox_6 = (CheckBox) findViewById(R.id.fourA);
        if (checkBox_6.isChecked()){
            checkBox_6.toggle();
        }

        //Clear text input area by setting it to an empty string for question 8 , 9 and 10
        EditText edit_text1 = (EditText) findViewById(R.id.text_answer_1);
        edit_text1.setText("");

        EditText edit_text2 = (EditText) findViewById(R.id.text_answer_2);
        edit_text2.setText("");

        EditText edit_text3 = (EditText) findViewById(R.id.text_answer_3);
        edit_text3.setText("");

        // Clear checks for all radio groups in question 8, 9, 10
        RadioGroup radio_group1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radio_group1.clearCheck();


        RadioGroup radio_group2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radio_group2.clearCheck();


        RadioGroup radio_group3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radio_group3.clearCheck();

    }
}
