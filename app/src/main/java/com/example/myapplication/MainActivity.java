package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private EditText input;
    private Button button;
    private TextView output;
    private int listSize;

    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();

    private long timeOne, timeTwo, timeThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);
        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                listSize = Integer.parseInt(input.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(MainActivity.this, "Введите размер списка", Toast.LENGTH_SHORT).show();
                return; // выход из метода, если возникла ошибка
            }

            // Заполнение списков арифметической прогрессией
            timeOne = SystemClock.uptimeMillis();
            arrayList = addArithmeticProgressionList(new ArrayList<>());
            timeTwo = SystemClock.uptimeMillis();
            linkedList = addArithmeticProgressionList(new LinkedList<>());

            output.setText("время заполнения Arraylist: " + (timeTwo - timeOne) + "мс"
                    + "\nвремя заполнения LinkedList: " + (timeThree - timeTwo) + "мс");


            timeOne = SystemClock.uptimeMillis();
            arrayList.add(1,10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(1,10);
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nвремя добавление элементов:\nв начало arraylist" + (timeTwo - timeOne) + "мс"
            + "\nв начало linkedlist" + (timeThree - timeTwo) + "мс");



            timeOne = SystemClock.uptimeMillis();
            arrayList.add(listSize/2,10);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.add(listSize/2,10);
            timeThree = SystemClock.uptimeMillis();
            output.append("\nв середину arraylist" + (timeTwo - timeOne) + "мс"
            + "\nв середнину linkedlist" + (timeThree - timeTwo) + "мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.set(1,1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(1,1000);
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nвремя замены элементов:\nв начале arraylist" + (timeTwo - timeOne) + "мс"
            + "\nв начале linkedlist" + (timeThree - timeTwo)+ "мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize/2,1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize/2,1000);
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nв середине arraylist" + (timeTwo - timeOne) + "мс"
                    + "\nв середине linkedlist" + (timeThree - timeTwo)+ "мс");

            timeOne = SystemClock.uptimeMillis();
            arrayList.set(listSize,1000);
            timeTwo = SystemClock.uptimeMillis();
            linkedList.set(listSize,1000);
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nв конце arraylist" + (timeTwo - timeOne) + "мс"
                    + "\nв конце linkedlist" + (timeThree - timeTwo)+ "мс");

            timeOne = SystemClock.uptimeMillis();
            if (arrayList.size() > 1) {
                arrayList.remove(0); // удаляем элемент из начала списка
            }
            timeTwo = SystemClock.uptimeMillis();
            if (linkedList.size() > 1) {
                linkedList.remove(0);
            }
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nвремя удаления элементов:\nв начале arraylist" + (timeTwo - timeOne) + "мс"
                    + "\nв начале linkedlist" + (timeThree - timeTwo) + "мс");

// Удаление элемента из середины списка
            timeOne = SystemClock.uptimeMillis();
            if (arrayList.size() > 0) {
                arrayList.remove(arrayList.size() / 2);
            }
            timeTwo = SystemClock.uptimeMillis();
            if (linkedList.size() > 0) {
                linkedList.remove(linkedList.size() / 2);
            }
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nвремя удаления элементов:\nв середине arraylist" + (timeTwo - timeOne) + "мс"
                    + "\nв середине linkedlist" + (timeThree - timeTwo) + "мс");

// Удаление элемента из конца списка
            timeOne = SystemClock.uptimeMillis();
            if (arrayList.size() > 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            timeTwo = SystemClock.uptimeMillis();
            if (linkedList.size() > 0) {
                linkedList.remove(linkedList.size() - 1);
            }
            timeThree = SystemClock.uptimeMillis();
            output.append("\n\nвремя удаления элементов:\nв конце arraylist" + (timeTwo - timeOne) + "мс"
                    + "\nв конце linkedlist" + (timeThree - timeTwo) + "мс");
        }
    };

    private List<Integer> addArithmeticProgressionList(List<Integer> list) {
        for (int i = 0; i < listSize; i++) {
            list.add(i * 10);
        }
        return list;
    }
}