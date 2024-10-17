package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.entities.vanilla.EntityGrizzle;
import net.divinerpg.items.base.IDivineMetaItem;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrizzleEgg extends ItemMod implements IDivineMetaItem {

    public ItemGrizzleEgg() {
        super("grizzleEgg", DivineRPGTabs.spawner);
        setMaxStackSize(1);
        setTextureName(Reference.PREFIX + "overworldSpawnEgg");
        setHasSubtypes(true);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            EntityGrizzle e = new EntityGrizzle(world, player, stack.getItemDamage());
            e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
            world.spawnEntityInWorld(e);
            player.triggerAchievement(DivineRPGAchievements.petCollector);
            stack.stackSize--;
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        Item item = stack.getItem();
        String col = stack.getItemDamage() == 1 ? "Brown" : "White";
        list.add("Spawns a pet " + col + " Grizzle");
    }
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + (stack.getItemDamage() == 1 ? "brown" : "white") + "GrizzleEgg";
    }

    @Override
    public void addNames() {
        LangRegistry.instance.localizeName("item", getUnlocalizedName(new ItemStack(this, 1, 0)));
        LangRegistry.instance.localizeName("item", getUnlocalizedName(new ItemStack(this, 1, 1)));
    }
}
