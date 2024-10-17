package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModPickaxe extends ItemPickaxe {

    protected String name;

    public ItemModPickaxe(ToolMaterial tool, String name) {
        super(tool);
        this.name = name;
        setCreativeTab(DivineRPGTabs.tools);
        setTextureName(Reference.PREFIX + name);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        infoList.add(TooltipLocalizer.efficiency(toolMaterial.getEfficiencyOnProperMaterial()));
        if(item.getMaxDamage() != -1) infoList.add(TooltipLocalizer.usesRemaining(item.getMaxDamage() - item.getItemDamage()));
        else infoList.add(TooltipLocalizer.infiniteUses());
    }

}
