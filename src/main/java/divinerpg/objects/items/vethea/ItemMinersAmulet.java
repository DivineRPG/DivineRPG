package divinerpg.objects.items.vethea;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface="baubles.api.IBauble",modid="baubles")
public class ItemMinersAmulet extends ItemMod implements IBauble {
    public ItemMinersAmulet(String name) {
        super(name, DivineRPGTabs.VETHEA);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase player) {
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 40, 1, false, false));
    }
    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity player, int itemSlot, boolean isSelected)
    {
        ((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.HASTE, 40, 1, false, false));
    }
}
