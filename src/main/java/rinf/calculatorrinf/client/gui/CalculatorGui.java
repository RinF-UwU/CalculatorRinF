package rinf.calculatorrinf.client.gui;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import rinf.calculatorrinf.client.CalculatorOperation;

public class CalculatorGui extends LightweightGuiDescription {
    public static WButton cButton0 = new WButton(Text.literal("0"));
    public static WButton cButton1 = new WButton(Text.literal("1"));
    public static WButton cButton2 = new WButton(Text.literal("2"));
    public static WButton cButton3 = new WButton(Text.literal("3"));
    public static WButton cButton4 = new WButton(Text.literal("4"));
    public static WButton cButton5 = new WButton(Text.literal("5"));
    public static WButton cButton6 = new WButton(Text.literal("6"));
    public static WButton cButton7 = new WButton(Text.literal("7"));
    public static WButton cButton8 = new WButton(Text.literal("8"));
    public static WButton cButton9 = new WButton(Text.literal("9"));
    public static WTextField cTextC = new WTextField();
    public static WButton cButtonOpPlus = new WButton(Text.literal("+"));
    public static WButton cButtonOpMinus = new WButton(Text.literal("-"));
    public static WButton cButtonOpMulti = new WButton(Text.literal("*"));
    public static WButton cButtonOpDivision = new WButton(Text.literal("/"));
    public static WButton cButtonPositiveAndNegative = new WButton(Text.literal("+/-"));
    public static WButton cButtonComma = new WButton(Text.literal(","));
    public static WButton cButtonEquals = new WButton(Text.literal("="));
    public static WButton cButtonErase = new WButton(Text.literal("<<"));
    public static WButton cButtonClear = new WButton(Text.literal("C"));
    public CalculatorGui() {
        WPlainPanel rootP = new WPlainPanel();
        setRootPanel(rootP);
        rootP.setInsets(Insets.ROOT_PANEL);

        rootP.add(cTextC, 0, 0, 73, 20);

        rootP.add(cButton0, 25, 84, 25, 25);
        rootP.add(cButton1, 0, 63, 25, 25);
        rootP.add(cButton2, 25, 63, 25, 25);
        rootP.add(cButton3, 50, 63, 25, 25);
        rootP.add(cButton4, 0, 42, 25, 25);
        rootP.add(cButton5, 25, 42, 25, 25);
        rootP.add(cButton6, 50, 42, 25, 25);
        rootP.add(cButton7, 0, 21, 25, 25);
        rootP.add(cButton8, 25, 21, 25, 25);
        rootP.add(cButton9, 50, 21, 25, 25);
        rootP.add(cButtonOpPlus, 75, 84, 30, 25);
        rootP.add(cButtonOpMinus, 75, 63, 30, 25);
        rootP.add(cButtonOpMulti, 75, 42, 30, 25);
        rootP.add(cButtonOpDivision, 75, 21, 30, 25);
        rootP.add(cButtonPositiveAndNegative, 0, 84, 25, 25);
        rootP.add(cButtonComma, 50, 84, 25, 25);
        rootP.add(cButtonEquals, 75, 105, 30, 25);
        rootP.add(cButtonErase, 75, 0, 30, 25);
        rootP.add(cButtonClear, 50, 105, 25, 25);

        CalculatorGuiLogics();

        rootP.validate(this);
    }
    public void CalculatorGuiLogics() {
        cButton0.setOnClick(() -> CharController('0'));
        cButton1.setOnClick(() -> CharController('1'));
        cButton2.setOnClick(() -> CharController('2'));
        cButton3.setOnClick(() -> CharController('3'));
        cButton4.setOnClick(() -> CharController('4'));
        cButton5.setOnClick(() -> CharController('5'));
        cButton6.setOnClick(() -> CharController('6'));
        cButton7.setOnClick(() -> CharController('7'));
        cButton8.setOnClick(() -> CharController('8'));
        cButton9.setOnClick(() -> CharController('9'));

        cButtonOpPlus.setOnClick(() -> OpController((byte) 1));
        cButtonOpMinus.setOnClick(() -> OpController((byte) 2));
        cButtonOpMulti.setOnClick(() -> OpController((byte) 3));
        cButtonOpDivision.setOnClick(() -> OpController((byte) 4));

        cButtonComma.setOnClick(() -> CharController('.'));

        cButtonPositiveAndNegative.setOnClick(() -> {
            if (cTextC.getText().equals(".") || cTextC.getText().equals("-")) return;
            if (cTextC.getText().indexOf('.') + 1 == cTextC.getText().length()) CharController('0');
            cTextC.setText(String.valueOf(Float.parseFloat(cTextC.getText()) * -1));
        });

        cButtonClear.setOnClick(() -> {
            CalculatorOperation.x = 0;
            CalculatorOperation.y = 0;
            CalculatorOperation.result = 0;
            CalculatorOperation.nOp = 0;
            cTextC.setText("");
        });

        cButtonEquals.setOnClick(() -> {
           if (CalculatorOperation.nOp != 0 && !cTextC.getText().equals("") && !cTextC.getText().equals("-") && !cTextC.getText().equals(".")) {
               CalculatorOperation.y = Float.parseFloat(cTextC.getText());
               CalculatorOperation.calculatorOperation();
               CalculatorOperation.nOp = 0;
               cTextC.setText(String.valueOf(CalculatorOperation.result));
               CalculatorOperation.x = CalculatorOperation.result;
           }
        });

        cButtonErase.setOnClick(() -> {
            if (cTextC.getText().equals("Infinity") || cTextC.getText().equals("NaN")) cTextC.setText("");
            if (!cTextC.getText().equals("")) cTextC.setText(cTextC.getText().substring(0, cTextC.getText().length() - 1));
        });
    }
    public void CharController(char ch) {
        if (cTextC.getText().equals("Infinity") || cTextC.getText().equals("NaN")) cTextC.setText("");
        if (Character.isDigit(ch)) {
            cTextC.setText(cTextC.getText() + ch);
        } else if (ch == '.') {
            if (!cTextC.getText().contains(".")) {
                if (cTextC.getText().equals("")) cTextC.setText("0");
                cTextC.setText(cTextC.getText() + '.');
            }
        }
    }
    public void OpController(byte b) {
        if (cTextC.getText().equals(".") || cTextC.getText().equals("-")) return;
        if (cTextC.getText().indexOf('.') + 1 == cTextC.getText().length()) CharController('0');
        if (CalculatorOperation.nOp == 0) {
            CalculatorOperation.x = Float.parseFloat(cTextC.getText());
                CalculatorOperation.nOp = b;
                cTextC.setText("");
            } else {
            CalculatorOperation.y = Float.parseFloat(cTextC.getText());
                CalculatorOperation.calculatorOperation();
                CalculatorOperation.nOp = b;
                cTextC.setText("");
                CalculatorOperation.x = CalculatorOperation.result;
                CalculatorOperation.y = 0;
            }
    }
}
