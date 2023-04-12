package divinerpg.block_entities.block;

import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;

public class InfusionTableBlockEntity extends BlockEntity {

    public InfusionTableBlockEntity(BlockPos p_155077_, BlockState p_155078_) {
        super(BlockEntityRegistry.INFUSION_TABLE.get(), p_155077_, p_155078_);
    }

}