package rinf.calculatorrinf.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rinf.calculatorrinf.client.CalculatorRinfClient;
import rinf.calculatorrinf.client.gui.Widgets.Calculator;
import rinf.calculatorrinf.client.gui.Widgets.Color4F;
import rinf.calculatorrinf.client.gui.Widgets.RBackPanel;
import rinf.calculatorrinf.client.gui.Widgets.RColorButton;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {
    private final RColorButton showCalculatorButton = new RColorButton(26, 26, 90, 20, Text.of(""), new Color4F(0.7f,0.7f,1,1), button -> {
        if (CalculatorRinfClient.isShowCalculator) {
            CalculatorRinfClient.isShowCalculator = false;
            button.setMessage(Text.of("Open calculator"));
        } else {
            CalculatorRinfClient.isShowCalculator = true;
            button.setMessage(Text.of("Close calculator"));
        }
    });
    private RBackPanel backPanel;
    private Calculator calculator;
    @Inject(at = @At("TAIL"), method = "init")
    public void init(CallbackInfo callbackInfo) {
        Window window = MinecraftClient.getInstance().getWindow();
        int width = window.getScaledWidth();
        int height = window.getScaledHeight();
        this.showCalculatorButton.setPosition(width - 96, 6);
        this.backPanel = new RBackPanel(width - 122 - 6, height - 141 - 6, 122, 141);
        this.calculator = new Calculator(this.backPanel);

        if (CalculatorRinfClient.isShowCalculator) {
            this.showCalculatorButton.setMessage(Text.of("Close calculator"));
        } else {
            this.showCalculatorButton.setMessage(Text.of("Open calculator"));
        }
    }
    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        showCalculatorButton.render(matrices, mouseX, mouseY, delta);
        if (CalculatorRinfClient.isShowCalculator) {
            backPanel.render(matrices, mouseX, mouseY, delta);
            for (ClickableWidget widget : calculator.getWidgets()) {
                widget.render(matrices, mouseX, mouseY, delta);
            }
        }
    }

    @Inject(at = @At("TAIL"), method = "mouseClicked")
    public void mouseClicked(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir) {
        showCalculatorButton.mouseClicked(mouseX, mouseY, button);
        if (CalculatorRinfClient.isShowCalculator) {
            for (ClickableWidget widget : calculator.getWidgets()) {
                widget.mouseClicked(mouseX, mouseY, button);
            }
        }
    }
}
