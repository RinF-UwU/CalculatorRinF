package rinf.calculatorrinf.client.gui.Widgets;

import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import rinf.calculatorrinf.client.CalculatorOperation;

import java.util.List;

public class Calculator {
    private final List<ClickableWidget> widgets = Lists.newArrayList();
    private static final RCalculatorField calculatorField = new RCalculatorField(MinecraftClient.getInstance().textRenderer, 0, 0, 74, 20);
    public Calculator(RBackPanel backPanel) {
        calculatorField.setPosition((backPanel.getX() + 8), (backPanel.getY() + 8));

        RColorButton buttonClear = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 113, 24, 20, Text.of("C"), new Color4F(1.0f,0.6f,0.6f,1), button -> {
            CalculatorOperation.x = 0;
            CalculatorOperation.y = 0;
            CalculatorOperation.result = 0;
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            calculatorField.setText("");
        });
        RColorButton buttonBackspace = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 8, 30, 20, Text.of("←"), new Color4F(1.0f,0.6f,0.6f,1), button -> calculatorField.eraseCharacters(-1));
        RColorButton buttonResult = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 113, 30, 20, Text.of("="), new Color4F(0.6f,0.6f,1.0f,1), button -> {
            if (calculatorField.getText().equals("")) return;
            CalculatorOperation.y = calculatorField.textToDouble();
            CalculatorOperation.calculatorOperation();
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            calculatorField.setText(String.valueOf(CalculatorOperation.result));
            CalculatorOperation.x = CalculatorOperation.result;

            calculatorField.setText(String.valueOf(CalculatorOperation.result));
        });

        RColorButton buttonDivision = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 29, 30, 20, Text.of("÷"), new Color4F(0.6f,0.6f,0.6f,1), button -> this.OpController(CalculatorOperation.OperationType.DIVISION));
        RColorButton buttonMultiply = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 50, 30, 20, Text.of("×"), new Color4F(0.6f,0.6f,0.6f,1), button -> this.OpController(CalculatorOperation.OperationType.MULTIPLY));
        RColorButton buttonMinus = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 71, 30, 20, Text.of("-"), new Color4F(0.6f,0.6f,0.6f,1), button -> this.OpController(CalculatorOperation.OperationType.MINUS));
        RColorButton buttonPlus = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 92, 30, 20, Text.of("+"), new Color4F(0.6f,0.6f,0.6f,1), button -> this.OpController(CalculatorOperation.OperationType.PLUS));

        RColorButton buttonNegate = new RColorButton(backPanel.getX() + 8, backPanel.getY() + 92, 24, 20, Text.of("±"), new Color4F(0.6f,0.6f,0.6f,1), button -> calculatorField.setText(String.valueOf(calculatorField.textToDouble() * -1)));
        RColorButton buttonComma = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 92, 24, 20, Text.of(","), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            if (calculatorField.getText().indexOf('.') != -1) return;
            if (calculatorField.getText().equals("")) {
                calculatorField.write("0.");
            } else calculatorField.write(".");
        });

        RColorButton button0 = new RColorButton(backPanel.getX() + 33, backPanel.getY() + 92, 24, 20, Text.of("0"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("0"));
        RColorButton button1 = new RColorButton(backPanel.getX() + 8, backPanel.getY() + 71, 24, 20, Text.of("1"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("1"));
        RColorButton button2 = new RColorButton(backPanel.getX() + 33, backPanel.getY() + 71, 24, 20, Text.of("2"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("2"));
        RColorButton button3 = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 71, 24, 20, Text.of("3"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("3"));
        RColorButton button4 = new RColorButton(backPanel.getX() + 8, backPanel.getY() + 50, 24, 20, Text.of("4"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("4"));
        RColorButton button5 = new RColorButton(backPanel.getX() + 33, backPanel.getY() + 50, 24, 20, Text.of("5"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("5"));
        RColorButton button6 = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 50, 24, 20, Text.of("6"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("6"));
        RColorButton button7 = new RColorButton(backPanel.getX() + 8, backPanel.getY() + 29, 24, 20, Text.of("7"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("7"));
        RColorButton button8 = new RColorButton(backPanel.getX() + 33, backPanel.getY() + 29, 24, 20, Text.of("8"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("8"));
        RColorButton button9 = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 29, 24, 20, Text.of("9"), new Color4F(1, 1, 1, 1), button -> calculatorField.write("9"));


        this.widgets.add(calculatorField);

        this.widgets.add(buttonClear);
        this.widgets.add(buttonBackspace);
        this.widgets.add(buttonResult);

        this.widgets.add(buttonDivision);
        this.widgets.add(buttonMultiply);
        this.widgets.add(buttonMinus);
        this.widgets.add(buttonPlus);

        this.widgets.add(buttonNegate);
        this.widgets.add(buttonComma);

        this.widgets.add(button0);
        this.widgets.add(button1);
        this.widgets.add(button2);
        this.widgets.add(button3);
        this.widgets.add(button4);
        this.widgets.add(button5);
        this.widgets.add(button6);
        this.widgets.add(button7);
        this.widgets.add(button8);
        this.widgets.add(button9);
    }

    public void OpController(CalculatorOperation.OperationType type) {
        if (CalculatorOperation.operationType == CalculatorOperation.OperationType.NONE) {
            CalculatorOperation.x = calculatorField.textToDouble();
            CalculatorOperation.operationType = type;
            calculatorField.setText("");
        } else {
            CalculatorOperation.y = calculatorField.textToDouble();
            CalculatorOperation.calculatorOperation();
            CalculatorOperation.operationType = type;
            calculatorField.setText("");
            CalculatorOperation.x = CalculatorOperation.result;
            CalculatorOperation.y = 0;
        }
    }

    public List<ClickableWidget> getWidgets() {
        return widgets;
    }
}
