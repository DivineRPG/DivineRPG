package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;

import java.util.*;

public class BlockFrostedAllure extends BlockMod {
    public BlockFrostedAllure(String name) {
        super(name, 0.8F);
        ticksRandomly(this.getDefaultState());
    }

    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        WorldEntitySpawner.performWorldGenSpawning(worldIn, worldIn.getBiome(pos), pos.getX() + 8, pos.getZ() + 8, random);
        this.tick(state, worldIn, pos, random);
    }

    @Override
    public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.frosted_allure"));
    }
}
