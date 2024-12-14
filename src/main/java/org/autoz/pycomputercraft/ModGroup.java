package org.autoz.pycomputercraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.autoz.pycomputercraft.block.ModBlock;

public class ModGroup {
    public static final ItemGroup TUTORIAL_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Pycomputercraft.MOD_ID, "pycc_group"),
        ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.pycomputercraft"))
            .icon(() -> new ItemStack(ModBlock.PY_COMPUTER))
            .entries((displayContext, entries) -> {
                entries.add(ModBlock.PY_COMPUTER);

            }).build());
    public static void initialize() {}
}
