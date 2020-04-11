package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemModSword;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import java.util.List;

public class ItemPoisonousSword extends ItemModSword {
    private float poisonSeconds;

    public ItemPoisonousSword(ToolMaterial mat, String name, float seconds) {
        super(mat, name);
        this.poisonSeconds = seconds;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof EntityLivingBase)
            ((EntityLivingBase) entity)
                    .addPotionEffect(new PotionEffect(MobEffects.POISON, (int) (poisonSeconds * 20), 1));
        return false;
    }

    @Override
    protected void addAdditionalInformation(List list) {
        list.add(LocalizeUtils.poison(this.poisonSeconds));
    }
}
