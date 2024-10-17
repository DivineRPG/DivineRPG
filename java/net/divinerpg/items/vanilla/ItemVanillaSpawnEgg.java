package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.vanilla.EntityEhu;
import net.divinerpg.entities.vanilla.EntityHusk;
import net.divinerpg.entities.vanilla.EntitySmelter;
import net.divinerpg.entities.vanilla.EntitySnapper;
import net.divinerpg.entities.vanilla.EntityStoneGolem;
import net.divinerpg.items.base.IDivineMetaItem;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVanillaSpawnEgg extends ItemMod implements IDivineMetaItem {

    private Class[] mobs = { EntityEhu.class, EntityHusk.class, EntityStoneGolem.class, EntitySmelter.class, EntitySnapper.class };

    public ItemVanillaSpawnEgg() {
        super("overworldPetSpawner", DivineRPGTabs.spawner);
        setMaxStackSize(1);
        setTextureName(Reference.PREFIX + "overworldSpawnEgg");
        setHasSubtypes(true);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            try {
                Entity e = (Entity) mobs[stack.getItemDamage()].getConstructor(World.class, EntityPlayer.class).newInstance(world, player);
                e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntityInWorld(e);
                player.triggerAchievement(DivineRPGAchievements.petCollector);
                stack.stackSize--;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String str = (String) EntityList.classToStringMapping.get(mobs[stack.getItemDamage()]);
        return "item." + str.substring(4) + "Egg";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < mobs.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        Item item = stack.getItem();
        list.add("Spawns a pet " + ((String)EntityList.classToStringMapping.get(mobs[stack.getItemDamage()])).substring(4));
    }

    @Override
    public void addNames() {
        for (int i = 0; i < mobs.length; i++) {
            LangRegistry.instance.localizeName("item", this.getUnlocalizedName(new ItemStack(this, 1, i)));
        }
    }
}
