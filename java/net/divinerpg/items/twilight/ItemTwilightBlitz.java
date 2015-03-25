package net.divinerpg.items.twilight;

import java.util.List;

import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTwilightBlitz extends ItemProjectileShooter {
	
	public ItemTwilightBlitz(String name, String projectileTex, Item ammo, float damage) {
		super(name, damage, Sounds.blitz.getPrefixedName(), ammo, projectileTex, -1, 0);
	}

	@Override
	public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", this.damage, 0));
        return multimap;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedAndMelee(damage));
		list.add(TooltipLocalizer.ammo(this.ammo));
		list.add(this.uses == -1 ? TooltipLocalizer.infiniteUses() : TooltipLocalizer.usesRemaining(stack.getMaxDurability() - stack.getMetadata()));
	}
}
