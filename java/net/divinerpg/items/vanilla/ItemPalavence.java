package net.divinerpg.items.vanilla;

import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.material.ToolMaterialMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPalavence extends ItemModSword {

	public ItemPalavence(String name) {
		super(ToolMaterialMod.Palavence, name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		float current = player.getHealth();
        if ((current >= 0.0F) && (current < 20.0F)) {
            player.setHealth(current + 1.0F);
            stack.damageItem(1, player);
            Sounds.getSoundName(Sounds.heal);
        }
		return super.onItemRightClick(stack, world, player);
    }
}
