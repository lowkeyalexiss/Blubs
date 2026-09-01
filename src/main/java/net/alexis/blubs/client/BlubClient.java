package net.alexis.blubs.client;

import net.fabricmc.api.ClientModInitializer;

import static com.mojang.text2speech.Narrator.LOGGER;

public class BlubClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Client Initalized");
    }
}
