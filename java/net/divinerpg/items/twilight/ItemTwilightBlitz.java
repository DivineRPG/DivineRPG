package net.divinerpg.items.twilight;

import net.divinerpg.items.vanilla.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;

import com.google.common.collect.Multimap;

public class ItemTwilightBlitz extends ItemProjectileShooter {
	
	public ItemTwilightBlitz(String name, String projectileTex, Item ammo, float damage) {
		super(name, damage, Sounds.blitz.getPrefixedName(), ammo, projectileTex, -1, 0);
	}

	@Override
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.damage, 0));
        return multimap;
    }
}
