package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemHordeHorn extends ItemBossSpawner {

    public ItemHordeHorn() {
        super("message.ayeraco_horde", Level.END);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = super.useOn(context);
        BlockPos pos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        Direction facing = context.getClickedFace();
        Level world = context.getLevel();
        Player player = context.getPlayer();
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            if (!world.isClientSide) {
                player.displayClientMessage(Component.translatable("message.spawner.peaceful"), true);
            }
            return InteractionResult.FAIL;
        }
        pos = pos.offset(facing.getStepX(), facing.getStepY() + 1, facing.getStepZ());
        if (world.getBlockState(pos) == Blocks.AIR.defaultBlockState()) {
            if (world.dimension().equals(Level.END)) {
                world.playSound(null, pos, SoundRegistry.AYERACO_SPAWN.get(), SoundSource.MASTER, 20.0F, 1.0F);
                world.setBlock(pos.below(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_spawn")).defaultBlockState(), 0);
                if (!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
            }
        }
        return result;
    }
}