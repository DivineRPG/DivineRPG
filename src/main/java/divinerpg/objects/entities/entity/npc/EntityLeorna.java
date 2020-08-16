package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityLeorna extends EntityDivineMerchant {
    public EntityLeorna(World world) {
        super(world);
    }

    protected int getGuiId() {
        return GUIHandler.LEORNA_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.leorna.hitchak",
                "message.leorna.lamona",
                "message.leorna.nature",
                "message.leorna.plants",
                "message.leorna.zelus"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(ItemRegistry.eucalyptusRootSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.marsineSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.firestockSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.pinflySeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(ItemRegistry.aquamarineSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(ItemRegistry.hitchakSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.veiloSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 9), new ItemStack(ItemRegistry.lamonaSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(BlockRegistry.arcaniteDirt, 9)));
        return list;
    }
}