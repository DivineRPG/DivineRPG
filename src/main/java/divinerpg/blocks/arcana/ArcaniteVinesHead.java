package divinerpg.blocks.arcana;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class ArcaniteVinesHead extends WeepingVinesBlock {
    public ArcaniteVinesHead(Properties properties) {
        super(properties);
    }
    @Override protected Block getBodyBlock() {
        return BlockRegistry.arcaniteVinesBody.get();
    }
}