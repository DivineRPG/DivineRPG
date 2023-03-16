package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingStone extends ItemMod {
    private final float healAmount;

    public ItemHealingStone(float healAmount) {
        super();
        this.healAmount = healAmount;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (healAmount != 0 && player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if(!player.isCreative()) stack.shrink(1);
            player.heal(healAmount);
            return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
        } else {
            return super.use(world, player, hand);
        }
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
    	if(!(entity instanceof ServerPlayer && ((ServerPlayer) entity).isCreative())) {
    		if(entity instanceof Monster) {
        		entity.hurt(entity.damageSources().magic(), healAmount / 2);
                if(!player.isCreative()) {
                	stack.shrink(1);
                	if(player.getHealth() < player.getMaxHealth()) player.heal(healAmount / 2);
                }
        		player.setItemInHand(hand, stack);
        		return InteractionResult.CONSUME;
        	} if(entity.getHealth() < entity.getMaxHealth()) {
                if(!player.isCreative()) stack.shrink(1);
                entity.heal(healAmount);
        		entity.playSound(SoundRegistry.HEAL.get(), 1, 1);
        		player.setItemInHand(hand, stack);
        		return InteractionResult.CONSUME;
        	}
    	} return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.heals", healAmount / 2));
    }
}