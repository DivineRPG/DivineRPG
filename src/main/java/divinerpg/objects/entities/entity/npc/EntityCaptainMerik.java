package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityCaptainMerik extends EntityDivineMerchant {
    public EntityCaptainMerik(World world) {
        super(world);
    }

    protected int getGuiId() {
        return GUIHandler.CAPTAIN_MERIK_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.merik.battles",
                "message.merik.datticon",
                "message.merik.hurry",
                "message.merik.phoenix",
                "message.merik.sword"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(WeaponRegistry.stormSword)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(WeaponRegistry.enderScepter)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.ghostbane)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(WeaponRegistry.shadowSaber)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(WeaponRegistry.starlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(WeaponRegistry.arcaniumSaber)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(WeaponRegistry.captainsSparkler)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(WeaponRegistry.firefly)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 20), new ItemStack(WeaponRegistry.staffOfStarlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 15), new ItemStack(WeaponRegistry.meriksMissile)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 30), new ItemStack(WeaponRegistry.liviciaSword)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(WeaponRegistry.laVekor)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(WeaponRegistry.grenade, 10)));
        return list;
    }
}