package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.TokenHelper;
import net.divinerpg.utils.material.EnumArmor;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemDivineArmor extends ItemArmor implements ISpecialArmor {

    public static final int HEAD = 0, BODY = 1, LEGS = 2, BOOTS = 3;

    protected double damageReduction;
    protected boolean unbreakable;
    protected String textureName = Reference.PREFIX + "textures/armor/";
    protected int fullReduction;
    protected EnumArmor armorMaterial;
    protected Object[] armorInfo;
    protected String name;
    protected StringBuilder infoBuilder;

    public ItemDivineArmor(EnumArmor armorMaterial, int type) {
        this(armorMaterial, type, armorMaterial.getType());
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, Object[] info) {
        this(armorMaterial, type, armorMaterial.getType(), info);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR) {
        this(armorMaterial, type, dR, armorMaterial.getType(), new Object[] { "null", "null" });
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, Object[] info) {
        this(armorMaterial, type, dR, armorMaterial.getType(), info);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, String name) {
        this(armorMaterial, type, dR, name, new Object[] { "null", "null" });
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, new Object[] { "null", "null" });
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name, Object[] info) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, info);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, String name, Object[] info) {
        super(armorMaterial.getArmorMaterial(), type, type);
        this.armorMaterial = armorMaterial;
        this.textureName += armorMaterial.getType();
        this.fullReduction = dR;
        this.armorInfo = info;

        if (armorType == 0) damageReduction = ((((double) fullReduction) / 24) * 5) / 100;
        else if (armorType == 1) damageReduction = ((((double) fullReduction) / 24) * 8) / 100;
        else if (armorType == 2) damageReduction = ((((double) fullReduction) / 24) * 7) / 100;
        else if (armorType == 3) damageReduction = ((((double) fullReduction) / 24) * 4) / 100;
        infoBuilder = new StringBuilder();
        for (int i = 1; i < armorInfo.length; i++) {
            String strInfo = armorInfo[i].toString();
            if (strInfo.contains("#")) {
                try {
                    int value = Integer.parseInt(armorInfo[i - 1].toString());
                    strInfo = TokenHelper.replaceToken(strInfo, '#', value);
                } catch (NumberFormatException e) {
                    LogHelper.error("Attempted to replace a token with an integer, but the integer was invalid! "
                            + "Make sure the value in the index before the String containing the token is an integer!!!");
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    LogHelper.error("Attempted to replace a token with the value at the index before it, but that index does not exist!! "
                            + "Make sure you are only trying to replace tokens in values that are not at index 0!!");
                    e2.printStackTrace();
                }
            }
            if(i % 3 == 0) infoBuilder.append('\n');
            if (i == armorInfo.length - 1) infoBuilder.append(strInfo);
            else if (armorInfo[i].toString().length() > 2) infoBuilder.append(strInfo + ',');
        }

        this.unbreakable = armorMaterial.isUndamageable();
        setCreativeTab(DivineRPGTabs.armor);
        setArmorType(name, armorType);
        setUnlocalizedName(this.name);
        setTextureName(Reference.PREFIX + this.name);
        GameRegistry.registerItem(this, this.name);
        LangRegistry.addItem(this);
    }

    protected void setArmorType(String material, int armorType) {
        this.name = armorType == HEAD ? material + "Helmet" : armorType == BODY ? material + "Body" : armorType == LEGS ? material + "Legs" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
        this.textureName = (armorType == 0 || armorType == 1 || armorType == 3) ? textureName + "_1.png" : textureName + "_2.png";
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return textureName;
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean par4) {
        double roundPH = Math.round(damageReduction * 1000);
        double roundedDamage = roundPH / 10;
        list.add(damageReduction == 0.0 ? ("No Protection") : "Damage Reduction: " + roundedDamage + "% (" + fullReduction + "% full)");
        list.add(!unbreakable ? (item.getMaxDamage() - item.getItemDamage() + " Uses Remaining") : "Unlimited Uses");
        String perks = "";
        for (int i = 0; i < ChatFormats.DIMENSIONS_LIST.length; i++)
            if (armorInfo[0].equals(ChatFormats.DIMENSIONS_LIST[i])) perks += "In " + armorInfo[0].toString() + ": ";
        perks += infoBuilder.toString();
        if (armorInfo[0] != "null"){
            list.add(ChatFormats.AQUA + "Fullset Perks: " + ChatFormats.RESET);
            list.add(perks);
        }
        list.add(ChatFormats.DIVINERPG);
    }

    @Override
    public boolean isDamageable() {
        return !unbreakable;
    }

    @Override
    public void damageArmor(EntityLivingBase livingBase, ItemStack stack, DamageSource dmgSrc, int par4, int par5) {
        if (!unbreakable) stack.damageItem(1, livingBase);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack stack, int bars) {
        return (int) Math.round((damageReduction * 100) / 4);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase livingBase, ItemStack stack, DamageSource dmgSrc, double par4, int par5) {
        return new ISpecialArmor.ArmorProperties(0, damageReduction, 50000);
    }

}
