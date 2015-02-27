package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAnchor extends ItemProjectileShooter {
	
	public ItemAnchor(String name, String projectileTex, float damage) {
		super(name, damage, Sounds.blitz.getPrefixedName(), projectileTex, -1, 0);
	}

	@Override
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", 8, 0));
        return multimap;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(damage + " Ranged Damage");
		list.add("8 Melee Damage");
		list.add(this.ammo == null ? "Infinite Ammo" : "Ammo: " + StatCollector.translateToLocal(this.ammo.getUnlocalizedName() + ".name"));
		list.add(this.uses == -1 ? "Infinite Uses" : stack.getMaxDurability() - stack.getMetadata() + " Uses Remaining");
	}
}
