package divinerpg.objects.items.arcana;

import com.google.common.collect.Multimap;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.capabilities.item.DivineItemStackCapability;
import divinerpg.capabilities.item.DivineItemStackCapabilityProvider;
import divinerpg.objects.items.base.ItemModSword;
import divinerpg.utils.LocalizeUtils;
import divinerpg.registry.MaterialRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ItemArcaniteBlade extends ItemModSword {

    private static final int ARCANA_CONSUMED = 30;
    private static final float WEAKENED_DAMAGE_VALUE = 6.0F;

    public ItemArcaniteBlade() {
        super(MaterialRegistry.ARCANITE_BLADE, "arcanite_blade");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        IArcana arcana = DivineAPI.getArcana(player);
        if (!player.world.isRemote && arcana.getArcana() >= ARCANA_CONSUMED) {
            arcana.consume(player, ARCANA_CONSUMED);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (world.getTotalWorldTime() % 10 == 0 && entity instanceof EntityLivingBase) {
            DivineItemStackCapability cap = stack.getCapability(DivineItemStackCapabilityProvider.DIVINE_ITEM_STACK_CAPABILITY, null);
            if (cap != null) {
                if(entity instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer)entity;
                    IArcana arcana = DivineAPI.getArcana(player);

                    float damageValue;
                    if(arcana.getArcana() < ARCANA_CONSUMED) {
                        damageValue = WEAKENED_DAMAGE_VALUE;
                    }
                    else {
                        damageValue = MaterialRegistry.ARCANITE_BLADE.getAttackDamage() + 4.0F;
                    }

                    player.getAttributeMap().removeAttributeModifiers(getAttributeModifiers(EntityEquipmentSlot.MAINHAND, stack));
                    cap.setValue(damageValue);
                    player.getAttributeMap().applyAttributeModifiers(getAttributeModifiers(EntityEquipmentSlot.MAINHAND, stack));
                }
                else {
                    EntityLivingBase entityLivingBase = (EntityLivingBase)entity;

                    entityLivingBase.getAttributeMap().removeAttributeModifiers(getAttributeModifiers(EntityEquipmentSlot.MAINHAND, stack));
                    cap.setValue(WEAKENED_DAMAGE_VALUE);
                    entityLivingBase.getAttributeMap().applyAttributeModifiers(getAttributeModifiers(EntityEquipmentSlot.MAINHAND, stack));
                }
            }
        }
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> attributeMap = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.MAINHAND) {
            DivineItemStackCapability capability = stack.getCapability(DivineItemStackCapabilityProvider.DIVINE_ITEM_STACK_CAPABILITY, null);
            if(capability != null) {
                Collection<AttributeModifier> modifiers = attributeMap.get(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
                Optional<AttributeModifier> mod = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(ATTACK_DAMAGE_MODIFIER)).findFirst();

                if(mod.isPresent()) {
                    modifiers.remove(mod.get());
                    attributeMap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", capability.getValue(), 0));
                }

            }
        }

        return attributeMap;
    }


    @Override
    public void addAdditionalInformation(List list) {
        list.add(LocalizeUtils.arcanaConsumed(ARCANA_CONSUMED));
        list.add("Damage heavily reduced if the required arcana is not present");
    }
}