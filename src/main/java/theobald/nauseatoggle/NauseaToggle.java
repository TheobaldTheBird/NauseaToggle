package theobald.nauseatoggle;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NauseaToggle implements ModInitializer {

    public static KeyBinding toggleEffectKey;
    private static boolean effectActive = false;

    public static void toggleEffect(MinecraftClient client) {
        effectActive = !effectActive;
        if (client.player != null) {
            if (effectActive) {
                client.player.sendMessage(Text.of("Nausea effect toggled ON"), true);
                client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, -1, 0, true, false));
            } else {
                client.player.sendMessage(Text.of("Nausea effect toggled OFF"), true);
                client.player.removeStatusEffect(StatusEffects.NAUSEA);
            }
        }
    }

    @Override
    public void onInitialize()
    {
        toggleEffectKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Toggle Nausea",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_N,
                "Nausea"
        ));
    }
}