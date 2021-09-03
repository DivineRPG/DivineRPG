package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BlockModLog extends RotatedPillarBlock {
    Supplier<Block> strippedLog;

    public BlockModLog(String name, MaterialColor color, Supplier<Block> strippedLog) {
        super(AbstractBlock.Properties.of(Material.WOOD, color).strength(2.0F).sound(SoundType.WOOD));
        setRegistryName(DivineRPG.MODID, name);
        this.strippedLog = strippedLog;
    }

    public BlockModLog(String name, MaterialColor color, Supplier<Block> strippedLog, float hardness) {
        super(AbstractBlock.Properties.of(Material.WOOD, color).strength(2.0F).sound(SoundType.WOOD));
        setRegistryName(DivineRPG.MODID, name);
        this.strippedLog = strippedLog;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if (!world.isClientSide()) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.getItem() instanceof AxeItem) {
                BlockState sourceState = world.getBlockState(pos);
                if (strippedLog == null) {
                    strippedLog = () -> Blocks.OAK_LOG;
                }
                if (!state.getBlock().getRegistryName().getPath().contains("stripped_")) {
                    world.setBlock(pos, strippedLog.get().defaultBlockState(), 3);
                }
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }
}