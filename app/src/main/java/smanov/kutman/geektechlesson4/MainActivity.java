package smanov.kutman.geektechlesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView multiTV;
    private List<String> operations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiTV = findViewById(R.id.multi_tv);

        ac();
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ac:
                ac();
                break;
            case R.id.dart:
                setText(".");
                break;
            case R.id.nul:
                setText("0");
                break;
            case R.id.one:
                setText("1");
                break;

            case R.id.two:
                setText("2");
                break;

            case R.id.three:
                setText("3");
                break;

            case R.id.four:
                setText("4");
                break;

            case R.id.five:
                setText("5");
                break;

            case R.id.six:
                setText("6");
                break;

            case R.id.seven:
                setText("7");
                break;

            case R.id.eight:
                setText("8");
                break;

            case R.id.nine:
                setText("9");
                break;

            case R.id.plus:
                multiTV.append("+");
                operations.add("+");
                break;

            case R.id.minus:
                multiTV.append("-");
                operations.add("-");
                break;

            case R.id.umnoj:
                multiTV.append("*");
                operations.add("*");
                break;

            case R.id.del:
                multiTV.append("/");
                operations.add("/");
                break;

            case R.id.equals:
                equals();
                break;
        }

    }

    public void setText(String text){
        if(multiTV.getText().toString().equals("0.0")){
            multiTV.setText(text);
        }else {
            multiTV.append(text);
        }
    }

    private void equals(){
        try{
            String values = multiTV.getText().toString();
            String regex = "\\+|\\-|\\*|\\/";
            String[] stringValues = values.split(regex);
            double[] intValues = new double[100];
            double result = 0;

            for (int i = 0; i < stringValues.length; i++) {
                intValues[i] = Double.parseDouble(stringValues[i]);
            }

            for (int i = 0; i < intValues.length; i++) {
                if(result == 0){
                    result = intValues[i];
                }else {
                    if(i <= operations.size()){
                        if(operations.get(i-1).equals("+")){
                            result += intValues[i];
                        }else if(operations.get(i-1).equals("-")){
                            result -= intValues[i];
                        }else if(operations.get(i-1).equals("*")){
                            result *= intValues[i];
                        }else if(operations.get(i-1).equals("/")){
                            result /= intValues[i];
                        }
                    }
                }
            }

            multiTV.setText(String.valueOf(result));

            operations.clear();
        }catch (Throwable err){
            Toast.makeText(this, err.getMessage(), Toast.LENGTH_SHORT).show();
            ac();
        }

    }

    private void ac(){
        double clearDouble = 0;
        multiTV.setText(String.valueOf(clearDouble));
        operations.clear();
    }
}