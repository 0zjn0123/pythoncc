package org.autoz.pycomputercraft;

import net.fabricmc.api.ModInitializer;
import org.autoz.pycomputercraft.block.ModBlock;

public class Pycomputercraft implements ModInitializer {
    public static final String MOD_ID = "pycomputercraft";
    @Override
    public void onInitialize() {

        Commands.init();
        ModBlock.initialize();
        ModGroup.initialize();

    }
}
