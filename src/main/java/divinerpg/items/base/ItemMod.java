package divinerpg.items.base;

import divinerpg.capability.ArcanaProvider;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMod extends Item {
    public int arcanaConsumedUse, cooldown;
    public ItemMod() {super(new Properties());}
    public ItemMod(Properties properties) {super(properties);}
    public ItemMod setArcanaUseConsumption(int amount) {
    	arcanaConsumedUse = amount;
    	return this;
    }
    public ItemMod setArcanaUseCooldown(int amount) {
    	cooldown = amount;
    	return this;
    }
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand) {
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
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(getDescriptionId().contains("torridite")) tooltip.add(LocalizeUtils.i18n("torridite"));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
}