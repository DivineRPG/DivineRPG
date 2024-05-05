package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
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

public class ItemWizardsBook extends ItemMod {
    public ItemWizardsBook() {super(new Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(hand);
        if(block == BlockRegistry.parasectaAltar.get()) {
            if(!level.isClientSide) EntityRegistry.PARASECTA.get().spawn((ServerLevel)level, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) stack.shrink(1);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResult.SUCCESS;
        } if(block == BlockRegistry.dramixAltar.get()) {
            if(!level.isClientSide) EntityRegistry.DRAMIX.get().spawn((ServerLevel)level, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) stack.shrink(1);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResult.SUCCESS;
        } return InteractionResult.FAIL;
    }
}