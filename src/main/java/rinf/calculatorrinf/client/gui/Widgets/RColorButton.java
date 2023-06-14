package rinf.calculatorrinf.client.gui.Widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.PressableWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class RColorButton extends PressableWidget {
    private Color4F color;
    private final OnPress onPress;

    public RColorButton(int x, int y, int width, int height, Text message, Color4F color, OnPress onPress) {
        super(x, y, width, height, message);

        this.color = color;
        this.onPress = onPress;
    }

    @Override
    public void onPress() { this.onPress.onPress(this); }

    @Override
    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        RenderSystem.setShaderTexture(0, WIDGETS_TEXTURE);
        RenderSystem.setShaderColor(this.color.red, this.color.green, this.color.blue, this.color.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        drawNineSlicedTexture(matrices, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 20, 4, 200, 20, 0, this.getTextureY());
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int i = this.active ? 16777215 : 10526880;
        this.drawMessage(matrices, minecraftClient.textRenderer, i | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }

    private int getTextureY() {
        int i = 1;
        if (!this.active) {
            i = 0;
        } else if (this.isSelected()) {
            i = 2;
        }

        return 46 + i * 20;
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        
    }

    @Environment(value= EnvType.CLIENT)
    public interface OnPress {
        void onPress(RColorButton button);
    }
}
