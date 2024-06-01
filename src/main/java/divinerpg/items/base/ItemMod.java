package divinerpg.items.base;

import divinerpg.capability.ArcanaProvider;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemMod extends Item {
    public int arcanaConsumedAttack;
    public int arcanaConsumedUse;
    public int cooldown;
    public int effectSec;
    public float healAmount;
    public ItemMod() {super(new Properties());}
    public ItemMod(Properties properties) {super(properties);}
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedAttack && arcanaConsumedAttack != 0) arcana.consume(player, arcanaConsumedAttack);
        }); return super.onLeftClickEntity(stack, player, entity);
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse && arcanaConsumedUse != 0) {
                arcana.consume(player, arcanaConsumedUse);
                player.getCooldowns().addCooldown(this, cooldown);
                player.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResultHolder.success(player.getItemInHand(hand));
            } return super.use(level, player, hand);
        }).orElse(InteractionResultHolder.pass(player.getItemInHand(hand)));
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(getDescriptionId().contains("torridite")) tooltip.add(LocalizeUtils.i18n("tooltip.divinerpg.torridite"));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
}