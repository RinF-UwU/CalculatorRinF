package rinf.calculatorrinf.client.gui.Widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.List;

public class RBackPanel extends DrawableHelper implements Drawable, Element {
    public static final Identifier R_PANEL_TEXTURE = new Identifier("calculator-rinf", "gui/panel.png");
    private final boolean center;
    private int x;
    private int y;
    private int width;
    private int height;

    public RBackPanel(int x, int y, int width, int height) {
        this.center = false;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public RBackPanel(int width, int height) {
        this.center = true;
        this.x = (MinecraftClient.getInstance().getWindow().getScaledWidth() / 2) - (width / 2);
        this.y = (MinecraftClient.getInstance().getWindow().getScaledHeight() / 2) - (height / 2);
        this.width = width;
        this.height = height;
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        Screen screen = MinecraftClient.getInstance().currentScreen;
        RenderSystem.setShaderTexture(0, R_PANEL_TEXTURE);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.drawTexture(matrices, this.x, this.y, 0, 0, this.width / 2, this.height / 2);
        this.drawTexture(matrices, this.x + this.width / 2, this.y + this.height / 2, 256 - this.width / 2, 256 - this.height / 2, this.width / 2, this.height / 2);
        this.drawTexture(matrices, this.x, this.y + this.height / 2, 0, 256 - this.height / 2, this.width / 2, this.height / 2);
        this.drawTexture(matrices, this.x + this.width / 2, this.y, 256 - this.width / 2, 0, this.width / 2, this.height / 2);
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }

    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }
}
