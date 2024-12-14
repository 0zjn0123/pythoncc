package org.autoz.pycomputercraft.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.autoz.pycomputercraft.Pycomputercraft;
import org.jetbrains.annotations.Nullable;


public class ModBlock {
//    public static Block register(Block block, String name, boolean shouldRegisterItem) {
//        // Register the block and its item.
//        Identifier id = Identifier.of(Pycomputercraft.MOD_ID, name);
//
//        if (shouldRegisterItem) {
//            BlockItem blockItem = new BlockItem(block, new Item.Settings());
//            Registry.register(Registries.ITEM, id, blockItem);
//        }
//
//        return Registry.register(Registries.BLOCK, id, block);
//    }
//    public static final Block PY_COMPUTER = register(
//            new Block(AbstractBlock.Settings.create()),
//            "py_computer", true
//    );

    public static final Block PY_COMPUTER = new PyccBlock(Block.Settings.create().strength(4.0f));


    public static void initialize() {
        Registry.register(Registries.BLOCK, Identifier.of(Pycomputercraft.MOD_ID, "py_computer"), PY_COMPUTER);
        Registry.register(Registries.ITEM, Identifier.of(Pycomputercraft.MOD_ID, "py_computer"), new BlockItem(PY_COMPUTER, new Item.Settings()));
    }
}
