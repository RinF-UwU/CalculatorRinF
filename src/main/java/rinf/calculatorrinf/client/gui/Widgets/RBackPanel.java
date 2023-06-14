package rinf.calculatorrinf.client.gui.Widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.widget.AbstractTextWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RBackPanel extends ButtonWidget implements Drawable, Element {
    public static final Identifier R_PANEL_TEXTURE = new Identifier("calculator-rinf", "gui/panel.png");
    public static final Identifier R_WIDGETS_TEXTURE = new Identifier("calculator-rinf", "gui/widgets.png");
    private int x;
    private int y;
    private int width;
    private int height;

    public RBackPanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public RBackPanel(int width, int height) {;
        this.x = (MinecraftClient.getInstance().getWindow().getScaledWidth() / 2) - (width / 2);
        this.y = (MinecraftClient.getInstance().getWindow().getScaledHeight() / 2) - (height / 2);
        this.width = width;
        this.height = height;
    }
    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        RenderSystem.setShaderTexture(0, R_WIDGETS_TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        drawNineSlicedTexture(MinecraftClient.DEFAULT_FONT_ID, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 10, 10, 100, 100, 0, 0);
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }

    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    @Override
    public void setFocused(boolean focused) {

    }

    @Override
    public boolean isFocused() {
        return false;
    }
}
