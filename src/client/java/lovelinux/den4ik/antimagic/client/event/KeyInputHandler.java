package lovelinux.den4ik.antimagic.client.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.mixin.client.gametest.input.InputUtilMixin;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.InputType;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_ANTIMAGIC = "key.category.antimagic";
    public static final String KEY_REVEAL_TEXT = "key.antimagic.reveal_text";
    public static KeyMapping revealKey;

    public static boolean revealKeyDown() {
        if (revealKey.isDown())
            return true;
        return false;
    }
    public static void register()
    {
        revealKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(KEY_REVEAL_TEXT, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, KEY_CATEGORY_ANTIMAGIC));
    }

}
