package rinf.calculatorrinf.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import rinf.calculatorrinf.client.gui.CalculatorScreen;

@Environment(EnvType.CLIENT)
public class CalculatorRinfClient implements ClientModInitializer {
    public static boolean isShowCalculator = false;
    @Override
    public void onInitializeClient() {
        KeyBinders.keyBinders();
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KeyBinders.kb_openCM.wasPressed()) MinecraftClient.getInstance().setScreen(new CalculatorScreen());
        });
    }
}
