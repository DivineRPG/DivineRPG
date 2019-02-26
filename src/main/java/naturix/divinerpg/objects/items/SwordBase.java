package naturix.divinerpg.objects.items;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SwordBase extends ItemSword implements IHasModel {

	private String name;
	private boolean isClaw;
	private ToolMaterial material;

	public SwordBase(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.CombatTab);
		this.name = name;
		this.material = material;

		ModItems.ITEMS.add(this);
	}

	public SwordBase(ToolMaterial material, String name, boolean isClaw) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.CombatTab);
		this.name = name;
		this.isClaw = isClaw;
		isClaw = true;
		this.isClaw = true;
		this.material = material;

		ModItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(TooltipLocalizer.meleeDam(material.getAttackDamage() + 5));
		if (item.getMaxDamage() != 0) {
			list.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
		} else {
			list.add(TooltipLocalizer.infiniteUses());
		}
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);

		if (slot == EntityEquipmentSlot.MAINHAND) {
			if (this.isClaw == true) {
				replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, 2);
				replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, 0.00003);
			}
		}

		return modifiers;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		if (this.getUnlocalizedName() == "palavence") {
			attacker.heal(1f);
		}
		return true;
	}

	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id,
	        double multiplier) {
		// Get the modifiers for the specified attribute
		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

		// Find the modifier with the specified ID, if any
		final Optional<AttributeModifier> modifierOptional = modifiers.stream()
		        .filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

		if (modifierOptional.isPresent()) { // If it exists,
			final AttributeModifier modifier = modifierOptional.get();
			modifiers.remove(modifier); // Remove it
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier,
			        modifier.getOperation())); // Add the new modifier
		}
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}