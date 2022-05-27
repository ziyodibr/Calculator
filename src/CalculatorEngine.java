import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {  // Создаем Класс CalculatorEngine, который наследует от Класса ActionListener.
    // Класс CalculatorEngine должен реализовать метод actionPerformed(ActionEvent e). Иначе не скомпелируется код.

    SimpleCalculator parent;  // Создаем переменную parent Класса Calculator.
    // Которая будет хранить ссылку на экземпляр объекта Calculator(сылаться на окно калькулятора).

    char selectedAction = ' '; // Создаем переменную, которая принимаее значения с нажатой кнопки.
    double currentResult = 0;  //

    CalculatorEngine(SimpleCalculator parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource(); // Получаем Источник текущего события (действия).
        // Приводим Источник текущего события (действия) e.getSource() типа Object к типу JButton.
        // И передаем приведенный к типу JButton Источник события переменной clickedButton JButton.
        // Только после этого можно использовать метод getText().

        String dispFieldText = parent.displayField.getText(); // Получаем текущего Текст из Текстового поля(находящиеся в нем данные).

        double displayVaiue = 0.0;

        if (!"".equals(dispFieldText)) {
            displayVaiue = Double.parseDouble(dispFieldText); // Получить число из дисплея калькулятора, если он не пустой.
            // Восклицательный знак "!"– это оператор отрицания.
        }

        // ВЫПОЛНЕНИЕ ПРОГРАММЫ ДЛЯ РАЗНЫХ КНОПОК.

        Object src = e.getSource();
        // Для каждой кнопки арифметического действия запомнить его: +, -, /, или *, сохранить текущее число
        // в переменной currentResult, и очистить дисплей для ввода нового числа.

        if (src == parent.buttonPlus) { // Тексе программы для чтения Знака Сложения чисел.
            selectedAction = '+';
            currentResult = displayVaiue;
            parent.displayField.setText("");

        } else if (src == parent.buttonMinus) { // Текст программы для чтения Знака Вычитания чисел.
            selectedAction = '-';
            currentResult = displayVaiue;
            parent.displayField.setText("");

        } else if (src == parent.buttonMultiply) { // Текст программы для чтения Знака Умножения чисел.
            selectedAction = '*';
            currentResult = displayVaiue;
            parent.displayField.setText("");

        } else if (src == parent.buttonDivide) { // Текст программы для чтения Знака Деления чисел.
            selectedAction = '/';
            currentResult = displayVaiue;
            parent.displayField.setText("");

        } else if (src == parent.buttonEqual) { // Текст программы для чтения Знака Результата действия с числами.

            // Совершить арифметическое действие, в зависимости
            // от selectedAction, обновить переменную currentResult
            // и показать результат на дисплее.


            if (selectedAction == '+') { // Текст программы для чтения Результата Сложения чисел.
                currentResult += displayVaiue;
                parent.displayField.setText("" + currentResult);

                // Сконвертировать результат в строку, добавляя его к пустой строке и показать его.

            } else if (selectedAction == '-') { // Текст программы для чтения Результата Вычитания чисел.
                currentResult -= displayVaiue;
                parent.displayField.setText("" + currentResult);

            } else if (selectedAction == '*') { // Текст программы для чтения Результата Умножения чисел.
                currentResult *= displayVaiue;
                parent.displayField.setText("" + currentResult);

            } else if (selectedAction == '/') { // Текст программы для чтения Результата Деления чисел.
                currentResult /= displayVaiue;
                parent.displayField.setText("" + currentResult);
            }

        } else {
            String clickedButtonLabel = clickedButton.getText();             // Получить Надпись с Кнопки.
            parent.displayField.setText(dispFieldText + clickedButtonLabel); // Соединить Надпись с Кнопки с Текстом в Текстовом поле.
            // И передать его в Текстовое поле по ссылке через parent.
        }
    }
}