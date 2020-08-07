package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineVillager {

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
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.divineAccumulator)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 17), new ItemStack(WeaponRegistry.meteorMash)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.arcaniteBlaster)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 30), new ItemStack(WeaponRegistry.arcaniteBlade)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.generalsStaff)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.arcaniumReflector)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.arcaniumAttractor)));
        return list;
    }
}