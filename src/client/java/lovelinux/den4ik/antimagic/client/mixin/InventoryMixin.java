package lovelinux.den4ik.antimagic.client.mixin;


import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import lovelinux.den4ik.antimagic.client.event.KeyInputHandler;

import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public class InventoryMixin {

//    @Shadow @Final private Minecraft minecraft;

    @ModifyReturnValue(
            method = {"getStyledHoverName", "getCustomName"},
            at = @At("RETURN"),
            remap = false
    )
    private Component modifyMessage(Component original) {
        return removeObfuscatedFormatting(original);
    }

    @Unique
    private Component removeObfuscatedFormatting(Component component) {
        if (component == null) return null;

        //mutable buffer
        MutableComponent result = Component.empty();

        result.append(component.getString());

        Style style = component.getStyle();
        if (KeyInputHandler.revealKeyDown() || InventoryScreen.hasAltDown()) {
            result = Component.literal(result.getString().replaceAll("(§[mnkolr])", ""));

        }


        return result;
    }
}
