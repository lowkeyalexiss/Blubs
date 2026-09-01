package net.alexis.blubs.client.model;

import net.alexis.blubs.Blubs;
import net.alexis.blubs.client.renderer.BlubEntityRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BlubEntityModel extends EntityModel<BlubEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Blubs.id("blub"), "main");

    private final ModelPart head;
    private final ModelPart rightEar;
    private final ModelPart leftEar;
    private final ModelPart frontLeftLeg;
    private final ModelPart backLeftLeg;
    private final ModelPart frontRightLeg;
    private final ModelPart backRightLeg;

    public BlubEntityModel(ModelPart root) {
        super(root);
        this.head = root.getChild("head");
        this.rightEar = root.getChild("rightEar");
        this.leftEar = root.getChild("leftEar");
        this.frontLeftLeg = root.getChild("frontLeftLeg");
        this.backLeftLeg = root.getChild("backLeftLeg");
        this.frontRightLeg = root.getChild("frontRightLeg");
        this.backRightLeg = root.getChild("backRightLeg");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-8.0F, -8.0F, -1.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 22.0F, -4.0F));

        partdefinition.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(0, 20)
                .addBox(-8.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, -2.0F));

        partdefinition.addOrReplaceChild("leftEar", CubeListBuilder.create().texOffs(8, 20)
                .addBox(-8.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 12.0F, -2.0F));

        // Front Left Leg
        partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(24, 24)
                .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 24.0F, -4.0F));

        // Back Left Leg
        partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(16, 24)
                .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 24.0F, 4.0F));

        // Front Right Leg
        partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(24, 20)
                .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 24.0F, -4.0F));

        // Back Right Leg
        partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(16, 20)
                .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 24.0F, 4.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(BlubEntityRenderState state) {
        super.setupAnim(state);

        this.frontLeftLeg.xRot = state.xRot * Mth.RAD_TO_DEG;
        //this.frontLeftLeg.yRot = state.yRot * Mth.RAD_TO_DEG;
        this.frontRightLeg.xRot = state.xRot * Mth.RAD_TO_DEG;
        //this.frontRightLeg.yRot = state.yRot * Mth.RAD_TO_DEG;

        float limbSwingAmplitude = state.walkAnimationSpeed;
        float limbSwingAnimationProgress = state.walkAnimationPos;

        this.frontLeftLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.6662F) * 1.4F * limbSwingAmplitude;
        this.backLeftLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.6662F + Mth.PI) * 1.4F * limbSwingAmplitude;
        this.frontRightLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.6662F + Mth.PI) * 1.4F * limbSwingAmplitude;
        this.backRightLeg.xRot = Mth.cos(limbSwingAnimationProgress * 0.6662F) * 1.4F * limbSwingAmplitude;

        float earFlop = Mth.cos(limbSwingAnimationProgress * 0.6662F) * 0.2F * limbSwingAmplitude;
        this.leftEar.xRot = earFlop;
        this.rightEar.xRot = -earFlop;
    }
}