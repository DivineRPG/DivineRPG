package divinerpg.objects.items.vethea;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class ItemMinersAmulet extends ItemMod implements IBauble {
    public ItemMinersAmulet(String name) {
        super(name, DivineRPGTabs.VETHEA);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE,40,1,true,true));
    }
}
