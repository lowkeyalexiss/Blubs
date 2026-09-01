package net.alexis.blubs.common.entity;

import net.alexis.blubs.client.model.BlubEntityModelLayers;
import net.alexis.blubs.client.renderer.BlubEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

import static com.mojang.text2speech.Narrator.LOGGER;

public class BlubsEntityClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlubEntityModelLayers.registerModelLayers();
        EntityRenderers.register(BlubEntityTypes.BLUB, BlubEntityRenderer::new);
        LOGGER.info("This works");
    }
}
