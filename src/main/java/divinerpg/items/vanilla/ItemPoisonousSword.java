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

public class ItemPoisonousSword extends ItemModSword {
    private final int poisonSeconds;
    public ItemPoisonousSword(Tier tier, int seconds) {
        super(tier);
        poisonSeconds = seconds;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity) ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.POISON, poisonSeconds * 20, 1));
        return super.onLeftClickEntity(stack, player, entity);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.poison(poisonSeconds));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}