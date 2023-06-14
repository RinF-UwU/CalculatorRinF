package rinf.calculatorrinf.client.gui.Widgets;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class RCalculatorField extends TextFieldWidget {
    public RCalculatorField(TextRenderer textRenderer, int x, int y, int width, int height) {
        super(textRenderer, x, y, width, height, Text.of(""));
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        if (!(chr >= '0' && chr <= '9')) {
            if (chr == '.' || chr == ',') {
                chr = '.';
                if (this.getText().indexOf('.') != -1) return false;
                if (this.getText().equals("")) {
                    this.write("0");
                } else return false;
            } else return false;
        }
        return super.charTyped(chr, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (Screen.isPaste(keyCode)) {
            return false;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void eraseWords(int wordOffset) {
        super.eraseWords(wordOffset);
        if (!this.getText().equals("")) {
            if (this.getText().toCharArray()[0] == '.') {
                this.setText("0" + this.getText());
            }
        }
    }

    @Override
    public void eraseCharacters(int characterOffset) {
        super.eraseCharacters(characterOffset);
        if (!this.getText().equals("")) {
            if (this.getText().toCharArray()[0] == '.') {
                this.setText("0" + this.getText());
            }
        }
    }

    public double textToDouble() {
        var str = this.getText();
        if (str.toCharArray()[str.length() - 1] == '.' || str.indexOf('-') > 0 || str.equals("-")) {
            str += "0";
        }
        return Double.parseDouble(str);
    }
}
