package divinerpg.items.base;

import divinerpg.enums.BulletType;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModThrowable extends ItemModRanged {
    public ItemModThrowable(BulletType bulletType) {super(Rarity.COMMON, bulletType, 0);}
    public ItemModThrowable(Rarity rarity, BulletType bulletType) {super(rarity, bulletType, 0);}
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!player.isCreative()) stack.shrink(1);
        return super.use(level, player, hand);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        if(this == ItemRegistry.vile_storm.get()) {tooltip.add(LocalizeUtils.poison(2));}
        if(this == ItemRegistry.snowflake_shuriken.get()) {tooltip.add(LocalizeUtils.slow(2));}
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}