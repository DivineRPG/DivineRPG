package divinerpg.items.vanilla;

import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemSlowingSword extends ItemModSword {
    public int slowSeconds;
    public ItemSlowingSword(Tier tier) {
        super(tier);
        slowSeconds = 3;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity) ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, slowSeconds * 20, 1));
        return super.onLeftClickEntity(stack, player, entity);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.slow(slowSeconds));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}