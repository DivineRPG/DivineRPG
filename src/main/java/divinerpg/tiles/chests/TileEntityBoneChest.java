package divinerpg.tiles.chests;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityBoneChest extends TileEntityModChest {

    public TileEntityBoneChest(BlockPos p_154992_, BlockState p_154993_) {
        super(BlockEntityRegistry.BONE_CHEST.get(), p_154992_, p_154993_);
    }

    @Override
    public String getChestName() {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bone_chest")).getDescriptionId();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }
}
