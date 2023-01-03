package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModDoubleCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockPurpleGlowbone extends BlockModDoubleCrop {
    public BlockPurpleGlowbone() {
        super();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "purple_glowbone_seeds"));
    }
    @Override
    public int getMaxAge() {
        return 1;
    }
    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 3;
    }
}