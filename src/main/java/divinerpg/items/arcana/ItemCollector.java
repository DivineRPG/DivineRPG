package divinerpg.items.arcana;

import divinerpg.items.base.ItemModFuel;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ItemCollector extends ItemModFuel {
    public ItemCollector() {super(100);}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(hand);
        if(block == BlockRegistry.dramixAltar.get()) {
            if(!level.isClientSide) EntityRegistry.DUNGEON_CONSTRUCTOR.get().spawn((ServerLevel) level, stack, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) stack.shrink(1);
            player.getCooldowns().addCooldown(this, 20);
            return InteractionResult.SUCCESS;
        }return InteractionResult.PASS;
    }
}