package net.divinerpg.items.vanilla;

import net.divinerpg.items.base.ItemFastFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSkyFlower extends ItemFastFood {

    public ItemSkyFlower() {
        super(1, 1, false, "skyFlower");
        setAlwaysEdible();
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player) {
        super.onItemUseFinish(stack, world, player);
        player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 600, 0, true));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 0, true));
        return stack;
    }

}
