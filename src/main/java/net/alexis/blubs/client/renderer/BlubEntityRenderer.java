package net.alexis.blubs.client.renderer;

import net.alexis.blubs.Blubs;
import net.alexis.blubs.client.model.BlubEntityModel;
import net.alexis.blubs.client.model.BlubEntityModelLayers;
import net.alexis.blubs.common.entity.BlubEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class BlubEntityRenderer extends MobRenderer<BlubEntity, BlubEntityRenderState, BlubEntityModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Blubs.MOD_ID, "textures/entity/blub.png");

    public BlubEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new BlubEntityModel(context.bakeLayer(BlubEntityModelLayers.BLUB)), 0.375f); // 0.375 shadow radius
    }

    @Override
    public BlubEntityRenderState createRenderState() {
        return new BlubEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(BlubEntityRenderState state) {
        return TEXTURE;
    }
}
