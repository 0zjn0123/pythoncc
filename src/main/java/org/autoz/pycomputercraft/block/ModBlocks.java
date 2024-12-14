package org.autoz.pycomputercraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.autoz.pycomputercraft.Pycomputercraft;
import org.jetbrains.annotations.Nullable;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(Pycomputercraft.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static final Block PY_COMPUTER = register(
            new Block(Block.Settings.create()){
//                @Override
//                public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
//                    return this.getPlacementState(ctx);
//                }
            },
            "py_computer", true
    );
    public static void initialize() {
    }
}
