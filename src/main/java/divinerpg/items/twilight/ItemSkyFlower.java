package divinerpg.items.twilight;

import divinerpg.items.base.ItemModFood;
import divinerpg.util.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSkyFlower extends ItemModFood {
    public ItemSkyFlower() {super(FoodList.SKY_FLOWER, true);}
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.sky_flower.breath"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if(entity instanceof Player) {
            Player player = (Player)entity;
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 0, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0, true, false));
        } return super.finishUsingItem(stack, world, entity);
    }
}