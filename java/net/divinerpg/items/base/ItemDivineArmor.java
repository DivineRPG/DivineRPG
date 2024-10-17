package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.TokenHelper;
import net.divinerpg.utils.TooltipLocalizer;
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
    
    public ItemDivineArmor(EnumArmor armorMaterial, int type, boolean vethean) {
        this(armorMaterial, type, armorMaterial.getType(), vethean);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, Object[] info) {
        this(armorMaterial, type, armorMaterial.getType(), info);
    }
    
    public ItemDivineArmor(EnumArmor armorMaterial, int type, Object[] info, boolean vethean, String helmType) {
        this(armorMaterial, type, armorMaterial.getType(), info, vethean, helmType);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR) {
        this(armorMaterial, type, dR, armorMaterial.getType(), new Object[] { "null", "null" }, false, null);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, Object[] info) {
        this(armorMaterial, type, dR, armorMaterial.getType(), info, false, null);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, String name) {
        this(armorMaterial, type, dR, name, new Object[] { "null", "null" }, false, null);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, new Object[] { "null", "null" }, false, null);
    }
    
    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name, boolean vethean) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, new Object[] { "null", "null" }, vethean, null);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name, Object[] info) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, info, false, null);
    }
    
    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name, Object[] info, boolean vethean) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, info, vethean, null);
    }
    
    public ItemDivineArmor(EnumArmor armorMaterial, int type, String name, Object[] info, boolean vethean, String helmType) {
        this(armorMaterial, type, armorMaterial.getDamageReduction(), name, info, vethean, helmType);
    }

    public ItemDivineArmor(EnumArmor armorMaterial, int type, int dR, String name, Object[] info, boolean vethean, String helmType) {
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
        for (int i = 0; i < armorInfo.length; i++) {
            String strInfo = armorInfo[i].toString();
            if (strInfo.contains("#")) {
                try {
                	float value = Float.parseFloat(armorInfo[i - 1].toString());
                	strInfo = TokenHelper.replaceToken(strInfo, '#', value);
                } catch (NumberFormatException e) {
                    LogHelper.error("Attempted to replace a token with an float, but the float was invalid! "
                            + "Make sure the value in the index before the String containing the token is an integer!!!");
                    e.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    LogHelper.error("Attempted to replace a token with the value at the index before it, but that index does not exist!! "
                            + "Make sure you are only trying to replace tokens in values that are not at index 0!!");
                    e2.printStackTrace();
                }
            }
            if(i % 2 == 0 && i != 0) infoBuilder.append('\n');
            if (i == armorInfo.length - 1) infoBuilder.append(strInfo);
            else if (armorInfo[i].toString().length() > 3) infoBuilder.append(strInfo + ", ");
        }

        this.unbreakable = armorMaterial.isUndamageable();
        if(vethean)setCreativeTab(DivineRPGTabs.vethea);
        else setCreativeTab(DivineRPGTabs.armor);
        setArmorType(name, armorType, vethean, helmType);
        setUnlocalizedName(this.name);
        setTextureName(Reference.PREFIX + this.name);
        GameRegistry.registerItem(this, this.name);
        LangRegistry.addItem(this);
    }

    protected void setArmorType(String material, int armorType, boolean vethean, String helmType) {
        if(armorMaterial.isClothing()) {
            this.name = armorType == HEAD ? material + "Cap" : armorType == BODY ? material + "Tunic" : armorType == LEGS ? material + "Pants" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
        } else if(!vethean) {
    		this.name = armorType == HEAD ? material + "Helmet" : armorType == BODY ? material + "Chestplate" : armorType == LEGS ? material + "Leggings" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
    	} else {
    		this.name = armorType == HEAD ? material + helmType : armorType == BODY ? material + "Chestplate" : armorType == LEGS ? material + "Leggings" : armorType == BOOTS ? material + "Boots" : material + "Unknown";
    	}
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
        list.add(damageReduction == 0.0 ? TooltipLocalizer.noProtection() : TooltipLocalizer.damageReduction(roundedDamage, fullReduction));
        list.add(!unbreakable ? TooltipLocalizer.usesRemaining((item.getMaxDamage() - item.getItemDamage())) : TooltipLocalizer.infiniteUses());
        String perks = "";
        for (int i = 0; i < ChatFormats.DIMENSIONS_LIST.length; i++)
            if (armorInfo[0].equals(ChatFormats.DIMENSIONS_LIST[i])) perks += "In " + armorInfo[0].toString() + ": ";
        perks += infoBuilder.toString();
        for(int c = 0; c < ChatFormats.DIMENSIONS_LIST.length; c++) {
        	perks = perks.replace(ChatFormats.DIMENSIONS_LIST[c]+", ", "");
        }
        String[] perksArray = perks.split("\n");
        if (armorInfo[0] != "null"){
            list.add(TooltipLocalizer.fullsetPerks());
            for(int j = 0; j < perksArray.length; j++){
            	list.add(perksArray[j]);
            }
        }
    }

    @Override
    public boolean isDamageable() {
        return !unbreakable;
    }

    @Override
    public void damageArmor(EntityLivingBase livingBase, ItemStack stack, DamageSource source, int par4, int par5) {
        if (!unbreakable) stack.damageItem(1, livingBase);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack stack, int bars) {
        return (int) Math.round((damageReduction * 100) / 4);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase livingBase, ItemStack stack, DamageSource source, double par4, int par5) {
        if(source.isUnblockable()) return new ISpecialArmor.ArmorProperties(0, 0, 50000);
        return new ISpecialArmor.ArmorProperties(0, damageReduction, 50000);
    }

}
