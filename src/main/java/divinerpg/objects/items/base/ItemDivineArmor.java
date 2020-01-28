package divinerpg.objects.items.base;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import divinerpg.DivineRPG;
import divinerpg.enums.EnumArmor;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModItems;
import divinerpg.utils.ChatFormats;
import divinerpg.utils.TokenHelper;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineArmor extends net.minecraft.item.ItemArmor implements ISpecialArmor {
    protected double damageReduction;
    protected boolean unbreakable;
    protected int fullReduction;
    protected EnumArmor armorMaterial;
    protected Object[] armorInfo;
    protected String name;
    protected StringBuilder infoBuilder;

    public ItemDivineArmor(EnumArmor armorMaterial, EntityEquipmentSlot slot) {
        this(null, armorMaterial, slot);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, EntityEquipmentSlot slot, Object[] info) {
        this(null, armorMaterial, slot, info);
    }

    public ItemDivineArmor(String itemName, EnumArmor armorMaterial, EntityEquipmentSlot slot) {
        this(itemName, armorMaterial, slot, new Object[] { "null", "null" });
    }

    public ItemDivineArmor(String itemName, EnumArmor armorMaterial, EntityEquipmentSlot slot, Object[] info) {
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
        infoBuilder = new StringBuilder();
        for (int i = 0; i < armorInfo.length; i++) {
            String strInfo = armorInfo[i].toString();
            if (strInfo.contains("#")) {
                try {
                    float value = Float.parseFloat(armorInfo[i - 1].toString());
                    strInfo = TokenHelper.replaceToken(strInfo, '#', value);
                } catch (NumberFormatException e) {
                    DivineRPG.logger.error("Attempted to replace a token with an float, but the float was invalid! "
                            + "Make sure the percantage in the index before the String containing the token is an integer!!!");
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    DivineRPG.logger.error(
                            "Attempted to replace a token with the percantage at the index before it, but that index does not exist!! "
                                    + "Make sure you are only trying to replace tokens in values that are not at index 0!!");
                    e2.printStackTrace();
                }
            }
            if (i % 2 == 0 && i != 0) {
                infoBuilder.append('\n');
            }
            if (i == armorInfo.length - 1) {
                infoBuilder.append(strInfo);
            } else if (armorInfo[i].toString().length() > 3) {
                infoBuilder.append(strInfo + ", ");
            }
        }

        this.unbreakable = armorMaterial.isUndamageable();

        this.name = itemName != null ? itemName : getDefaultItemName(this.armorMaterial.getType(), slot);
        setUnlocalizedName(this.name);
        if (armorMaterial.isOverriden()) {
            setRegistryName("minecraft", this.name);
            this.setCreativeTab(CreativeTabs.COMBAT);
        } else {
            setRegistryName(this.name);
            this.setCreativeTab(DivineRPGTabs.armor);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        double roundPH = Math.round(damageReduction * 1000);
        double roundedDamage = roundPH / 10;
        list.add(damageReduction == 0.0 ? TooltipLocalizer.noProtection() :
                TooltipLocalizer.damageReduction(roundedDamage, fullReduction));
        list.add(!unbreakable ? TooltipLocalizer.usesRemaining((item.getMaxDamage() - item.getItemDamage())) :
                TooltipLocalizer.infiniteUses());
        String perks = "";
        for (int i = 0; i < ChatFormats.DIMENSIONS_LIST.length; i++) {
            if (armorInfo[0].equals(ChatFormats.DIMENSIONS_LIST[i])) {
                perks += "In " + armorInfo[0].toString() + ": ";
            }
        }
        perks += infoBuilder.toString();
        for (int c = 0; c < ChatFormats.DIMENSIONS_LIST.length; c++) {
            perks = perks.replace(ChatFormats.DIMENSIONS_LIST[c] + ", ", "");
        }
        String[] perksArray = perks.split("\n");
        if (armorInfo[0] != "null") {
            list.add(TooltipLocalizer.fullsetPerks());
            for (int j = 0; j < perksArray.length; j++) {
                list.add(perksArray[j]);
            }
        }
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