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
        super(Block.Properties.create(Material.WOOD, color).hardnessAndResistance(3.0F, 5.0F).sound(SoundType.WOOD).setRequiresTool());
        setRegistryName(DivineRPG.MODID, name);
        this.strippedLog = strippedLog;
    }

    public BlockModLog(String name, MaterialColor color, Supplier<Block> strippedLog, float hardness) {
        super(Block.Properties.create(Material.WOOD, color).hardnessAndResistance(hardness, 5.0F).sound(SoundType.WOOD).setRequiresTool());
        setRegistryName(DivineRPG.MODID, name);
        this.strippedLog = strippedLog;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {

        if (!world.isRemote()) {
            ItemStack itemStack = player.getHeldItem(hand);
            if (itemStack.getItem() instanceof AxeItem) {
                BlockState sourceState = world.getBlockState(pos);
                if (strippedLog == null) {
                    strippedLog = () -> Blocks.OAK_LOG;
                }
                if (!state.getBlock().getRegistryName().getPath().contains("stripped_")) {
                    world.setBlockState(pos, strippedLog.get().getDefaultState(), 3);
                    itemStack.damageItem(1, player, (p_220040_1_) -> p_220040_1_.sendBreakAnimation(hand));
                }
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }
}