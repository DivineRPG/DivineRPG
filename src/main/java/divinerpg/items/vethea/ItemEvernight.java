package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemEvernight extends ItemStaff {
    public ItemEvernight() {
        super(BulletType.EVERNIGHT_SHOT);
        arcanaConsumedUse = 80;
    }
    @Override protected void doPreUsageEffects(Level world, Player player) {player.hurt(DamageSources.source(world, DamageSources.ARCANA), 20);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaDam((int)bulletType.getDamage()));
        tooltip.add(LocalizeUtils.i18n(ChatFormatting.RED, "tooltip.staff.evernight.damage"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}