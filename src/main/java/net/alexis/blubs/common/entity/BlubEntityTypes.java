package net.alexis.blubs.common.entity;


import net.alexis.blubs.Blubs;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class BlubEntityTypes {
    public static final EntityType<BlubEntity> BLUB = register(
            "blub",
            EntityType.Builder.<BlubEntity>of(BlubEntity::new, MobCategory.AMBIENT)
                    .sized(0.75f, 1.75f)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Blubs.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerBlubsEntityTypes() {
        Blubs.LOGGER.info("Registering EntityTypes for " + Blubs.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(BLUB, BlubEntity.createCubeAttributes());
    }
}
