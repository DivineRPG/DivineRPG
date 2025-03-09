package divinerpg.items.base;

import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.List;

public class ItemMaul extends ItemModSword {
    public ItemMaul(Tier tier, Properties properties) {
        super(tier, properties);
        cooldown = 10;
    }
    public ItemMaul(Tier tier) {
        super(tier);
        cooldown = 10;
    }
    @Override public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        if(itemStack.isDamageableItem()) {
            int i = itemStack.getDamageValue() + 1;
            if(i == itemStack.getMaxDamage()) return ItemStack.EMPTY;
            itemStack.setDamageValue(i);
        } return itemStack.copy();
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        double range = player.entityInteractionRange();
        Vec3 eyepos = player.getEyePosition(), viewVector = player.getViewVector(1F);
        EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, eyepos, eyepos.add(viewVector.scale(range)), player.getBoundingBox().expandTowards(viewVector.scale(range)).inflate(1D), e -> e instanceof ItemEntity, range * range);
        if(entityhitresult != null) {
            ItemEntity i = (ItemEntity) entityhitresult.getEntity();
            ItemStack targetItem = i.getItem();
            if(targetItem.is(ItemRegistry.shadow_stone) && i.getBlockStateOn().is(TagRegistry.BEDROCK_GRINDING_BASE)) i.setItem(ItemRegistry.bedrock_chunk.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.arlemite_ingot)) i.setItem(ItemRegistry.arlemite_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.rupee_ingot)) i.setItem(ItemRegistry.rupee_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.shadow_bar)) i.setItem(ItemRegistry.shadow_coins.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.eden_fragments)) i.setItem(ItemRegistry.eden_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.wildwood_fragments)) i.setItem(ItemRegistry.wildwood_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.apalachia_fragments)) i.setItem(ItemRegistry.apalachia_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.skythern_fragments)) i.setItem(ItemRegistry.skythern_dust.toStack(targetItem.getCount()));
            else if(targetItem.is(ItemRegistry.mortum_fragments)) i.setItem(ItemRegistry.mortum_dust.toStack(targetItem.getCount()));
            if(!i.getItem().is(targetItem.getItem())) {
                ItemStack stack = player.getItemInHand(hand);
                if(player instanceof ServerPlayer s) stack.hurtAndBreak(targetItem.getCount(), s.serverLevel(), s, (it) -> s.serverLevel().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1F, 1F));
                player.playSound(SoundEvents.ANVIL_LAND, .7F, 1.5F);
                player.getCooldowns().addCooldown(this, cooldown);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.success(stack);
            }
        } return super.use(level, player, hand);
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("maul_use"));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}