package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;
import net.minecraft.world.spawner.*;

import java.util.*;

public class BlockFrostedAllure extends BlockMod {
    public BlockFrostedAllure(String name) {
        super(name, 0.8F);
        isRandomlyTicking(defaultBlockState());
    }

    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        WorldEntitySpawner.spawnMobsForChunkGeneration(worldIn, worldIn.getBiome(pos), pos.getX() + 8, pos.getZ() + 8, random);
        this.tick(state, worldIn, pos, random);
    }

    @Override
    public void appendHoverText(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.frosted_allure"));
    }
}
