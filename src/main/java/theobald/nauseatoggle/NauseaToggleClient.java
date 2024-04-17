package theobald.nauseatoggle;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class NauseaToggleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (NauseaToggle.toggleEffectKey.wasPressed()) {
                NauseaToggle.toggleEffect(client);
            }
        });
    }
}