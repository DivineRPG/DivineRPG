package net.divinerpg.items.vanilla;

import net.divinerpg.libs.Sounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import com.google.common.collect.Multimap;

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
}
