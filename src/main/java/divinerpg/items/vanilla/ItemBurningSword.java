package divinerpg.items.vanilla;

import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemBurningSword extends ItemModSword {
    private final int burnSeconds;
    public ItemBurningSword(Tier tier, int seconds) {
        super(tier, new Properties().fireResistant());
        burnSeconds = seconds;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.setSecondsOnFire(burnSeconds);
        return super.onLeftClickEntity(stack, player, entity);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.burn(burnSeconds));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}