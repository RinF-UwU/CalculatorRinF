package rinf.calculatorrinf.client.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import rinf.calculatorrinf.client.gui.Widgets.*;

public class CalculatorScreen extends Screen {
    private RBackPanel backPanel;
    public CalculatorScreen() {
        super(Text.of(""));
    }

    @Override
    protected void init() {
        super.init();

        backPanel = new RBackPanel(122, 141);

        for (ClickableWidget widget : new Calculator(backPanel).getWidgets()) {
            this.addDrawableChild(widget);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        this.backPanel.render(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
    }
}
