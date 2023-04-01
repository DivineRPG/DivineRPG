package divinerpg.items.base;

import divinerpg.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.*;
import java.util.*;

public class ItemHealingSword extends ItemModSword {

    private final float healAmount;

    public ItemHealingSword(Tier material, float healAmount) {
        super(material);
        this.healAmount = healAmount;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if (!player.isCreative()) {
                stack.hurtAndBreak(2, player, (p_220044_0_) -> {
                    p_220044_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
            }
            player.heal(healAmount);
            player.playSound(SoundRegistry.HEAL.get(), 1, 1);
        }
        return super.use(world, player, hand);
    }
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
    	if(!(entity instanceof ServerPlayer && ((ServerPlayer) entity).isCreative())) {
    		if(entity instanceof Monster) {
        		entity.hurt(DamageSource.MAGIC, healAmount / 2);
        		if(stack.getDamageValue() < stack.getMaxDamage() && !player.isCreative()) stack.setDamageValue(stack.getDamageValue() + 1);
        		if(!player.isCreative() && player.getHealth() < player.getMaxHealth()) player.heal(healAmount / 3);
        		player.playSound(SoundRegistry.HEAL.get(), 1, 1);
        		player.setItemInHand(hand, stack);
        		return InteractionResult.CONSUME;
        	} if(entity.getHealth() < entity.getMaxHealth()) {
        		if(!player.isCreative()) stack.hurtAndBreak(2, player, (p_220044_0_) -> {
                        p_220044_0_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    });
                entity.heal(healAmount);
        		entity.playSound(SoundRegistry.HEAL.get(), 1, 1);
        		player.setItemInHand(hand, stack);
        		return InteractionResult.CONSUME;
        	}
    	} return InteractionResult.PASS;
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(stack.getItem() == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frossivence")) && entity instanceof Monster){
            stack.setDamageValue(stack.getDamageValue() - player.random.nextInt(3));
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.heals", healAmount / 2));
    }
}