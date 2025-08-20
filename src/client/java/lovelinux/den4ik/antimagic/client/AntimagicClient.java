package lovelinux.den4ik.antimagic.client;

import lovelinux.den4ik.antimagic.client.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntimagicClient implements ClientModInitializer {

    public static final String MOD_ID = "antimagic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
        LOGGER.info("Antimagic mod initialized!");
    }
}
