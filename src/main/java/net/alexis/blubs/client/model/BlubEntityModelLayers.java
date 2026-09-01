package net.alexis.blubs.client.model;

import net.alexis.blubs.Blubs;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class BlubEntityModelLayers {
    public static final ModelLayerLocation BLUB = createMain("blub");

    private static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Blubs.MOD_ID, name), "main");
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(BlubEntityModelLayers.BLUB, BlubEntityModel::getTexturedModelData);
    }
}