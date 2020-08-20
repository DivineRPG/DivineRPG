package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ArmorRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineMerchant {

    public EntityWarGeneral(World world) {
        super(world);
    }

    protected int getGuiId() {
        return GUIHandler.WAR_GENERAL_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.general.blade",
                "message.general.merik",
                "message.general.weapons"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();

        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 17), new ItemStack(WeaponRegistry.meteorMash)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(WeaponRegistry.starlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 20), new ItemStack(WeaponRegistry.staffOfStarlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.arcaniteBlaster)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 30), new ItemStack(WeaponRegistry.arcaniteBlade)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.generalsStaff)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosHelmet)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosChestplate)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosLeggings)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosBoots)));
        return list;
    }
}