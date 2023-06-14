package rinf.calculatorrinf.client.gui.Widgets;

import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import rinf.calculatorrinf.client.CalculatorOperation;

import java.util.List;

public class Calculator {
    private final List<ClickableWidget> widgets = Lists.newArrayList();
    private static final RCalculatorField calculatorField = new RCalculatorField(MinecraftClient.getInstance().textRenderer, 0, 0, 74, 20);;
    public Calculator(RBackPanel backPanel) {
        calculatorField.x = (backPanel.getX() + 8);
        calculatorField.y = (backPanel.getY() + 8);

        RColorButton buttonClear = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 113, 25, 20, Text.of("C"), new Color4F(1.0f,0.6f,0.6f,1), button -> {
            CalculatorOperation.x = 0;
            CalculatorOperation.y = 0;
            CalculatorOperation.result = 0;
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            calculatorField.setText("");
        });
        RColorButton buttonBackspace = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 8, 30, 20, Text.of("←"), new Color4F(1.0f,0.6f,0.6f,1), button -> {
            calculatorField.eraseCharacters(-1);
        });
        RColorButton buttonResult = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 113, 30, 20, Text.of("="), new Color4F(0.6f,0.6f,1.0f,1), button -> {
            if (calculatorField.getText().equals("")) return;
            CalculatorOperation.y = calculatorField.textToDouble();
            CalculatorOperation.calculatorOperation();
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            calculatorField.setText(String.valueOf(CalculatorOperation.result));
            CalculatorOperation.x = CalculatorOperation.result;

            calculatorField.setText(String.valueOf(CalculatorOperation.result));
        });

        RColorButton buttonDivision = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 29, 30, 20, Text.of("÷"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.DIVISION);

        });
        RColorButton buttonMultiply = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 50, 30, 20, Text.of("×"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.MULTIPLY);

        });
        RColorButton buttonMinus = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 71, 30, 20, Text.of("-"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.MINUS);

        });
        RColorButton buttonPlus = new RColorButton(backPanel.getX() + 83, backPanel.getY() + 92, 30, 20, Text.of("+"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.PLUS);
        });

        RColorButton buttonNegate = new RColorButton(backPanel.getX() + 8, backPanel.getY() + 92, 25, 20, Text.of("±"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            calculatorField.setText(String.valueOf(calculatorField.textToDouble() * -1));
        });
        RColorButton buttonComma = new RColorButton(backPanel.getX() + 58, backPanel.getY() + 92, 25, 20, Text.of(","), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            if (calculatorField.getText().indexOf('.') != -1) return;
            if (calculatorField.getText().equals("")) {
                calculatorField.write("0.");
            } else calculatorField.write(".");
        });

        ButtonWidget button0 = new ButtonWidget(backPanel.getX() + 33, backPanel.getY() + 92, 25, 20, Text.of("0"), button -> calculatorField.write("0"));
        ButtonWidget button1 = new ButtonWidget(backPanel.getX() + 8, backPanel.getY() + 71, 25, 20, Text.of("1"), button -> calculatorField.write("1"));
        ButtonWidget button2 = new ButtonWidget(backPanel.getX() + 33, backPanel.getY() + 71, 25, 20, Text.of("2"), button -> calculatorField.write("2"));
        ButtonWidget button3 = new ButtonWidget(backPanel.getX() + 58, backPanel.getY() + 71, 25, 20, Text.of("3"), button -> calculatorField.write("3"));
        ButtonWidget button4 = new ButtonWidget(backPanel.getX() + 8, backPanel.getY() + 50, 25, 20, Text.of("4"), button -> calculatorField.write("4"));
        ButtonWidget button5 = new ButtonWidget(backPanel.getX() + 33, backPanel.getY() + 50, 25, 20, Text.of("5"), button -> calculatorField.write("5"));
        ButtonWidget button6 = new ButtonWidget(backPanel.getX() + 58, backPanel.getY() + 50, 25, 20, Text.of("6"), button -> calculatorField.write("6"));
        ButtonWidget button7 = new ButtonWidget(backPanel.getX() + 8, backPanel.getY() + 29, 25, 20, Text.of("7"), button -> calculatorField.write("7"));
        ButtonWidget button8 = new ButtonWidget(backPanel.getX() + 33, backPanel.getY() + 29, 25, 20, Text.of("8"), button -> calculatorField.write("8"));
        ButtonWidget button9 = new ButtonWidget(backPanel.getX() + 58, backPanel.getY() + 29, 25, 20, Text.of("9"), button -> calculatorField.write("9"));


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
