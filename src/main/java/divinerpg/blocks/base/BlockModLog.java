package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockModLog extends RotatedPillarBlock {

    public BlockModLog(MapColor color, SoundType sound) {
        super(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).mapColor(color).sound(sound));
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_log"))) {
            if (!world.isClientSide) {
                EntityRegistry.ENT.get().spawn((ServerLevel) world, stack, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            }
        }
        super.playerDestroy(world, player, pos, state, blockEntity, stack);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 5;
    }
}
