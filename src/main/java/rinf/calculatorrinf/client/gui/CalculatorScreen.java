package rinf.calculatorrinf.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import rinf.calculatorrinf.client.CalculatorOperation;
import rinf.calculatorrinf.client.gui.Widgets.Color4F;
import rinf.calculatorrinf.client.gui.Widgets.RBackPanel;
import rinf.calculatorrinf.client.gui.Widgets.RCalculatorField;
import rinf.calculatorrinf.client.gui.Widgets.RColorButton;

import java.util.List;

public class CalculatorScreen extends Screen {
    private RBackPanel backPanel;
    private RCalculatorField calculatorField;
    public CalculatorScreen() {
        super(Text.of(""));
    }

    @Override
    protected void init() {
        super.init();

        backPanel = new RBackPanel(122, 141);
        this.calculatorField = new RCalculatorField(this.textRenderer, this.backPanel.getX() + 8, this.backPanel.getY() + 8, 74, 20);

        RColorButton buttonClear = new RColorButton(this.backPanel.getX() + 58, this.backPanel.getY() + 113, 25, 20, Text.of("C"), new Color4F(1.0f,0.6f,0.6f,1), button -> {
            CalculatorOperation.x = 0;
            CalculatorOperation.y = 0;
            CalculatorOperation.result = 0;
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            this.calculatorField.setText("");
        });
        RColorButton buttonBackspace = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 8, 30, 20, Text.of("←"), new Color4F(1.0f,0.6f,0.6f,1), button -> {
            this.calculatorField.eraseCharacters(-1);
        });
        RColorButton buttonResult = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 113, 30, 20, Text.of("="), new Color4F(0.6f,0.6f,1.0f,1), button -> {
            if (calculatorField.getText().equals("")) return;
            CalculatorOperation.y = this.calculatorField.textToDouble();
            CalculatorOperation.calculatorOperation();
            CalculatorOperation.operationType = CalculatorOperation.OperationType.NONE;
            this.calculatorField.setText(String.valueOf(CalculatorOperation.result));
            CalculatorOperation.x = CalculatorOperation.result;

            calculatorField.setText(String.valueOf(CalculatorOperation.result));
        });

        RColorButton buttonDivision = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 29, 30, 20, Text.of("÷"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.DIVISION);

        });
        RColorButton buttonMultiply = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 50, 30, 20, Text.of("×"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.MULTIPLY);

        });
        RColorButton buttonMinus = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 71, 30, 20, Text.of("-"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.MINUS);

        });
        RColorButton buttonPlus = new RColorButton(this.backPanel.getX() + 83, this.backPanel.getY() + 92, 30, 20, Text.of("+"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.OpController(CalculatorOperation.OperationType.PLUS);
        });

        RColorButton buttonNegate = new RColorButton(this.backPanel.getX() + 8, this.backPanel.getY() + 92, 25, 20, Text.of("±"), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            this.calculatorField.setText(String.valueOf(calculatorField.textToDouble() * -1));
        });
        RColorButton buttonComma = new RColorButton(this.backPanel.getX() + 58, this.backPanel.getY() + 92, 25, 20, Text.of(","), new Color4F(0.6f,0.6f,0.6f,1), button -> {
            if (this.calculatorField.getText().indexOf('.') != -1) return;
            if (this.calculatorField.getText().equals("")) {
                this.calculatorField.write("0.");
            } else this.calculatorField.write(".");
        });

        ButtonWidget button0 = new ButtonWidget(this.backPanel.getX() + 33, this.backPanel.getY() + 92, 25, 20, Text.of("0"), button -> this.calculatorField.write("0"));
        ButtonWidget button1 = new ButtonWidget(this.backPanel.getX() + 8, this.backPanel.getY() + 71, 25, 20, Text.of("1"), button -> this.calculatorField.write("1"));
        ButtonWidget button2 = new ButtonWidget(this.backPanel.getX() + 33, this.backPanel.getY() + 71, 25, 20, Text.of("2"), button -> this.calculatorField.write("2"));
        ButtonWidget button3 = new ButtonWidget(this.backPanel.getX() + 58, this.backPanel.getY() + 71, 25, 20, Text.of("3"), button -> this.calculatorField.write("3"));
        ButtonWidget button4 = new ButtonWidget(this.backPanel.getX() + 8, this.backPanel.getY() + 50, 25, 20, Text.of("4"), button -> this.calculatorField.write("4"));
        ButtonWidget button5 = new ButtonWidget(this.backPanel.getX() + 33, this.backPanel.getY() + 50, 25, 20, Text.of("5"), button -> this.calculatorField.write("5"));
        ButtonWidget button6 = new ButtonWidget(this.backPanel.getX() + 58, this.backPanel.getY() + 50, 25, 20, Text.of("6"), button -> this.calculatorField.write("6"));
        ButtonWidget button7 = new ButtonWidget(this.backPanel.getX() + 8, this.backPanel.getY() + 29, 25, 20, Text.of("7"), button -> this.calculatorField.write("7"));
        ButtonWidget button8 = new ButtonWidget(this.backPanel.getX() + 33, this.backPanel.getY() + 29, 25, 20, Text.of("8"), button -> this.calculatorField.write("8"));
        ButtonWidget button9 = new ButtonWidget(this.backPanel.getX() + 58, this.backPanel.getY() + 29, 25, 20, Text.of("9"), button -> this.calculatorField.write("9"));

        this.addDrawableChild(this.calculatorField);

        this.addDrawableChild(buttonClear);
        this.addDrawableChild(buttonBackspace);
        this.addDrawableChild(buttonResult);

        this.addDrawableChild(buttonDivision);
        this.addDrawableChild(buttonMultiply);
        this.addDrawableChild(buttonMinus);
        this.addDrawableChild(buttonPlus);

        this.addDrawableChild(buttonNegate);
        this.addDrawableChild(buttonComma);

        this.addDrawableChild(button0);
        this.addDrawableChild(button0);

        this.addDrawableChild(button0);
        this.addDrawableChild(button1);
        this.addDrawableChild(button2);
        this.addDrawableChild(button3);
        this.addDrawableChild(button4);
        this.addDrawableChild(button5);
        this.addDrawableChild(button6);
        this.addDrawableChild(button7);
        this.addDrawableChild(button8);
        this.addDrawableChild(button9);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.backPanel.render(matrices, mouseX, mouseY, delta);
        super.render(matrices, mouseX, mouseY, delta);
    }

    public void OpController(CalculatorOperation.OperationType type) {
        if (CalculatorOperation.operationType == CalculatorOperation.OperationType.NONE) {
            CalculatorOperation.x = this.calculatorField.textToDouble();
            CalculatorOperation.operationType = type;
            this.calculatorField.setText("");
        } else {
            CalculatorOperation.y = this.calculatorField.textToDouble();
            CalculatorOperation.calculatorOperation();
            CalculatorOperation.operationType = type;
            this.calculatorField.setText("");
            CalculatorOperation.x = CalculatorOperation.result;
            CalculatorOperation.y = 0;
        }
    }
}
