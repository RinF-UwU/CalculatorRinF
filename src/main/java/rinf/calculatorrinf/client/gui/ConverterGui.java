package rinf.calculatorrinf.client.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

public class ConverterGui extends LightweightGuiDescription {
    WPlainPanel rootP = new WPlainPanel();
    WPlainPanel panelA = new WPlainPanel();
    WPlainPanel panelB = new WPlainPanel();
    WPlainPanel panelC = new WPlainPanel();
    public ConverterGui() {
        WTabPanel tabs = new WTabPanel();
        setRootPanel(tabs);
        //rootP.add(tabs, 0, 0);
        rootP.setBackgroundPainter(BackgroundPainter.VANILLA);
        panelA.setBackgroundPainter(BackgroundPainter.VANILLA);
        tabs.add(panelA, tab -> tab.icon(new ItemIcon(new ItemStack(Items.APPLE))));
        tabs.add(panelB, tab -> tab.icon(new ItemIcon(new ItemStack(Items.APPLE))));
        tabs.add(panelC, tab -> tab.icon(new ItemIcon(new ItemStack(Items.APPLE))).tooltip(Text.literal("I am a tooltip!")));
        panelA.setSize(125, 125);
        panelB.setSize(125, 125);
        panelC.setSize(125, 125);

        rootP.validate(this);
    }
}
