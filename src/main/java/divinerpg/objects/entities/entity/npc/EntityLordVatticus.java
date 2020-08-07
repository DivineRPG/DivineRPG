package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.ArmorRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityLordVatticus extends EntityDivineVillager {
    public EntityLordVatticus(World world) {
        super(world);
    }

    protected int getGuiId() {
        return GUIHandler.VATICUS_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.vatticus.discover",
                "message.vatticus.feel",
                "message.vatticus.magic",
                "message.vatticus.noend",
                "message.vatticus.strength"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collectorFragments, 16), new ItemStack(ItemRegistry.chargedCollector)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ArmorRegistry.kormaHelmet)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ArmorRegistry.kormaChestplate)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ArmorRegistry.kormaLeggings)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(ArmorRegistry.kormaBoots)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosHelmet)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosChestplate)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosLeggings)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 10), new ItemStack(ArmorRegistry.vemosBoots)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.staffOfEnrichment)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.wizardsBook)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.weakArcanaPotion, 4)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.strongArcanaPotion, 4)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.orbOfLight)));
        return list;
    }
}