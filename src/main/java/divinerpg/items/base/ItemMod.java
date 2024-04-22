package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
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
    private static final Item.Properties props = new Item.Properties();
    public int arcanaConsumedAttack;
    public int arcanaConsumedUse;
    public int cooldown;
    private boolean hasGlint;
    public ItemMod() {super(props);}
    public ItemMod(Properties properties) {super(properties);}
    public ItemMod(Rarity rarity) {super(props.rarity(rarity));}
    public ItemMod(boolean hasGlint) {
        super(props);
        this.hasGlint = hasGlint;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedAttack) arcana.consume(player, arcanaConsumedAttack);
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
        if(getDescriptionId().contains("torridite")) tooltip.add(Component.translatable(DivineRPG.MODID + ".torridite").withStyle(ChatFormatting.GRAY));
        if(arcanaConsumedAttack > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedAttack));
        if(arcanaConsumedUse > 0) tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
    }
    @Override public boolean isEnchantable(ItemStack stack) {return hasGlint || super.isEnchantable(stack);}
}