package divinerpg.items.vanilla;

import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.*;

public class ItemHordeHorn extends ItemBossSpawner {

    public ItemHordeHorn(String name) {
        super(name, "message.ayeraco_horde", World.END);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        ActionResultType result = super.useOn(context);
        BlockPos pos = context.getClickedPos();
        Hand hand = context.getHand();
        Direction facing = context.getClickedFace();
        World world = context.getLevel();
        PlayerEntity player = context.getPlayer();
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            if (!world.isClientSide){
                player.sendMessage(new TranslationTextComponent("message.spawner.peaceful"), player.getUUID());
            }
            return ActionResultType.FAIL;
        }
        pos = pos.offset(facing.getStepX(), facing.getStepY() + 1, facing.getStepZ());
        if (world.getBlockState(pos) == Blocks.AIR.defaultBlockState()) {
            if (world.dimension().equals(World.END)) {
                world.playSound(null, pos, SoundRegistry.AYERACO_SPAWN, SoundCategory.MASTER, 20.0F, 1.0F);
                world.setBlock(pos.below(), BlockRegistry.ayeracoSpawn.defaultBlockState(), 0);
                if (!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
            }
        }
        return result;
    }
}