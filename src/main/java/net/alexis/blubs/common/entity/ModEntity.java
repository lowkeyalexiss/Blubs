package net.alexis.blubs.common.entity;

import net.fabricmc.api.ModInitializer;

public class ModEntity implements ModInitializer {
    @Override
    public void onInitialize() {
        BlubEntityTypes.registerBlubsEntityTypes();
        BlubEntityTypes.registerAttributes();
    }
}
