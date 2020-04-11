package divinerpg.objects.items.base;

import divinerpg.utils.LocalizeKeys;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import java.util.List;

public class ItemSlowingSword extends ItemModSword {

    public ItemSlowingSword(ToolMaterial toolMaterial, String name) {
        super(toolMaterial, name);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityLivingBase)
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 50, 1));
        return false;
    }

    @Override
    public void addAdditionalInformation(List l) {
        l.add(LocalizeKeys.slow(2.5));
    }
}
