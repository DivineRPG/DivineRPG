package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
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
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 8, 0));
        return multimap;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedDam(damage));
		list.add(TooltipLocalizer.meleeDam(8));
		list.add(TooltipLocalizer.infiniteAmmo());
		list.add(TooltipLocalizer.infiniteUses());
	}
}
