package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockModLog extends RotatedPillarBlock {

    public BlockModLog(MaterialColor color) {
        super(BlockBehaviour.Properties.of(Material.WOOD, color).strength(2.0F).sound(SoundType.WOOD));
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity tileEntity, ItemStack stack) {
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamwood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firewood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hyrewood_log")) || this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mintwood_log"))) {
            if (world.isClientSide) {
                EntityRegistry.ENT.get().spawn((ServerLevel) world, stack, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            }
        }
        super.playerDestroy(world, player, pos, state, tileEntity, stack);
    }
}