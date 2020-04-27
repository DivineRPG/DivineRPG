package divinerpg.objects.items.base;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import divinerpg.enums.ArmorInfo;
import divinerpg.enums.EnumArmor;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineArmor extends ItemArmor implements ISpecialArmor {
    protected double damageReduction;
    protected boolean unbreakable;
    protected int fullReduction;
    protected EnumArmor armorMaterial;
    protected String name;

    protected ArmorInfo armorInfo;

    public ItemDivineArmor(EnumArmor armorMaterial, EntityEquipmentSlot slot) {
        this(null, armorMaterial, slot);
    }

    public ItemDivineArmor(String itemName, EnumArmor armorMaterial, EntityEquipmentSlot slot) {
        this(itemName, armorMaterial, slot, new ArmorInfo());
    }

    public ItemDivineArmor(EnumArmor armorMaterial, EntityEquipmentSlot slot, ArmorInfo info) {
        this(null, armorMaterial, slot, info);
    }


    public ItemDivineArmor(String itemName, EnumArmor armorMaterial, EntityEquipmentSlot slot, ArmorInfo info) {
        super(armorMaterial.getArmorMaterial(), 0, slot);
        this.armorMaterial = armorMaterial;
        this.fullReduction = armorMaterial.getDamageReduction();
        this.armorInfo = info;

        if (slot == EntityEquipmentSlot.HEAD) {
            damageReduction = ((((double) fullReduction) / 24) * 5) / 100;
        } else if (slot == EntityEquipmentSlot.CHEST) {
            damageReduction = ((((double) fullReduction) / 24) * 8) / 100;
        } else if (slot == EntityEquipmentSlot.LEGS) {
            damageReduction = ((((double) fullReduction) / 24) * 7) / 100;
        } else if (slot == EntityEquipmentSlot.FEET) {
            damageReduction = ((((double) fullReduction) / 24) * 4) / 100;
        }

        this.unbreakable = armorMaterial.isUndamageable();

        this.name = itemName != null ? itemName : getDefaultItemName(this.armorMaterial.getType(), slot);
        setUnlocalizedName(this.name);
        setRegistryName(this.name);
        this.setCreativeTab(DivineRPGTabs.armor);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.addAll(armorInfo.toString(item, worldIn, fullReduction, damageReduction));
    }

    @Override
    public void damageArmor(EntityLivingBase livingBase, ItemStack stack, DamageSource source, int par4, int par5) {
        if (!unbreakable) {
            stack.damageItem(1, livingBase);
        }
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack stack, int bars) {
        return (int) Math.round((damageReduction * 100) / 4);
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        return HashMultimap.create();
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase livingBase, ItemStack stack, DamageSource source, double par4,
                                         int par5) {
        if (source.isUnblockable()) {
            return new ISpecialArmor.ArmorProperties(0, 0, 50000);
        }
        return new ISpecialArmor.ArmorProperties(0, damageReduction, 50000);
    }

    @Override
    public boolean isDamageable() {
        return !unbreakable;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return this.getItemStackLimit(stack) == 1
                && (stack.getMaxDamage() < 0 || this.getItemStackLimit(stack) == 1);
    }

    protected String getDefaultItemName(String material, EntityEquipmentSlot slot) {
        if (slot == EntityEquipmentSlot.FEET) {
            return material + "_boots";
        } else if (slot == EntityEquipmentSlot.LEGS) {
            return material + "_leggings";
        } else if (slot == EntityEquipmentSlot.CHEST) {
            return material + "_chestplate";
        } else if (slot == EntityEquipmentSlot.HEAD) {
            return material + "_helmet";
        } else {
            return material + "_unknown";
        }
    }
}