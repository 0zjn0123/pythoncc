package org.autoz.pycomputercraft.screen;

import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

class PyccBlockScreenHandler extends ScreenHandler {
    private final TextFieldWidget inputField;

    public PyccBlockScreenHandler(int syncId, PlayerInventory playerInventory, TextFieldWidget inputField) {
        super(ModScreenHandlers.PYCC_SCREEN_HANDLER, syncId);

        this.inputField = inputField;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}