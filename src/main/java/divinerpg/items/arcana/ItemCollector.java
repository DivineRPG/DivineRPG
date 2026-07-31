package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static divinerpg.registries.BlockRegistry.dramixAltar;

public class ItemCollector extends ItemMod {

    public ItemCollector(Properties properties) {
        super(properties);
    }

    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(context.getHand());
        //TODO - DUNGEON CONSTRUCTOR
        if(block == dramixAltar.get()) {
//            if(!level.isClientSide()) DUNGEON_CONSTRUCTOR.get().spawn((ServerLevel) level, stack, player, pos, MOB_SUMMONED, true, false);
            stack.consume(1, player);
//            player.getCooldowns().addCooldown(this, 20);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}