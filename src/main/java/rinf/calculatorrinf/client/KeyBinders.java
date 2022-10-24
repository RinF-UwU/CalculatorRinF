package rinf.calculatorrinf.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBinders {
    public static KeyBinding kb_openCM;
    //public static KeyBinding kb_opencCovM;

    public static void keyBinders() {
        kb_openCM = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.calculator-rinf.opencm",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                "category.rinf-mods.general"
        ));
        /*kb_opencCovM = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.calculator-rinf.openconvm",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_J,
                "category.calculator-rinf.general"
        ));*/
    }
}
