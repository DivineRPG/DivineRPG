package divinerpg.items.arcana;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Collector extends Item {
    public Collector(Properties p) {super(p);}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(context.getHand());
        if(block == BlockRegistry.dramixAltar.get()) {
            if(!level.isClientSide()) EntityRegistry.DUNGEON_CONSTRUCTOR.get().spawn((ServerLevel) level, stack, player, pos, EntitySpawnReason.MOB_SUMMONED, true, false);
            stack.consume(1, player);
            player.getCooldowns().addCooldown(stack, 20);
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}