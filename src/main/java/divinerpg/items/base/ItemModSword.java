package divinerpg.items.base;

import divinerpg.capability.ArcanaProvider;
import divinerpg.enums.ToolStats;
import divinerpg.registries.EnchantmentRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.*;

public class ItemModSword extends SwordItem {
    public int arcanaConsumedUse;
    public int arcanaConsumedAttack;
    public int cooldown;
    public ToolStats sword;
    //Have rarity
    public ItemModSword(Rarity rarity, Tier tier) {
        super(tier, 1, tier.getSpeed(), new Properties().rarity(rarity));
        sword = (ToolStats)tier;
    }
    //No rarity
    public ItemModSword(Tier tier) {
        super(tier, 1, tier.getSpeed(), new Properties());
        sword = (ToolStats)tier;
    }
    //Fire-resistant swords
    public ItemModSword(Tier tier, Properties properties) {
        super(tier, 1, tier.getSpeed(), properties);
        sword = (ToolStats)tier;
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
    	return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
    		if(arcanaConsumedAttack != 0 && arcana.getAmount(player.level().isClientSide()) >= arcanaConsumedAttack && entity instanceof LivingEntity) {
    			arcana.modifyAmount(player, -arcanaConsumedAttack);
    			return preArcanicAttack(stack, player, entity);
    		} return false;
    	}).orElse(false);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    	if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, sword.effectSec * 20, sword.effectPower));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) target.addEffect(new MobEffectInstance(MobEffects.POISON, sword.effectSec * 20, sword.effectPower));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) target.setSecondsOnFire(sword.effectSec);
    	postArcanicAttack(stack, (Player) attacker, target);
    	return false;
    }
    protected boolean preArcanicAttack(ItemStack stack, Player player, Entity entity) {
    	return false;
    }
    protected void postArcanicAttack(ItemStack stack, Player player, Entity entity) {
    	
    }
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand){
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcanaConsumedUse != 0 && arcana.getAmount(level.isClientSide()) >= arcanaConsumedUse) {
                arcana.modifyAmount(player, -arcanaConsumedUse);
                player.getCooldowns().addCooldown(this, cooldown);
                player.awardStat(Stats.ITEM_USED.get(this));
                return arcanicUse(level, player, hand);
            } return super.use(level, player, hand);
        }).orElse(super.use(level, player, hand));
    }
    @Override public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME && enchantment == Enchantments.FIRE_ASPECT ||
           sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW && enchantment == EnchantmentRegistry.BRAIN_FREEZE.get()) return false;
        else return enchantment.category.canEnchant(stack.getItem());
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.ARCANA_DAMAGE) tooltip.add(LocalizeUtils.weakenedWithoutArcana());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.FLAME) tooltip.add(LocalizeUtils.burn(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.LIGHTNING) tooltip.add(LocalizeUtils.lightningShots());
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.POISON) tooltip.add(LocalizeUtils.poison(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SLOW) tooltip.add(LocalizeUtils.slow(sword.effectSec));
        if(sword.getSwordSpecial() == ToolStats.SwordSpecial.SPEED) tooltip.add(LocalizeUtils.i18n("shadow_saber"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}