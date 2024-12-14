package org.autoz.pycomputercraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.autoz.pycomputercraft.block.ModBlock;
import org.autoz.pycomputercraft.block.ModBlocks;
import org.python.util.PythonInterpreter;

public class Pycomputercraft implements ModInitializer {
    public static final String MOD_ID = "pycomputercraft";
    @Override
    public void onInitialize() {

        Commands.init();
        ModBlock.initialize();
        ModGroup.initialize();

    }
}
