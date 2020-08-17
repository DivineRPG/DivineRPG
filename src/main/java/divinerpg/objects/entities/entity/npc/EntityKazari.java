package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityKazari extends EntityDivineMerchant {
    public EntityKazari(World world) {
        super(world);
    }
    protected int getGuiId() {
        return GUIHandler.KAZARI_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.kazari.1",
                "message.kazari.2",
                "message.kazari.3",
                "message.kazari.4",
                "message.kazari.5",
                "message.kazari.6",
                "message.kazari.7",
                "message.kazari.8"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.ancientKey)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.degradedKey)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.soulKey)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 3), new ItemStack(ItemRegistry.sludgeKey)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientBricksBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientStoneBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.ancientTileBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumMetalBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.arcaniumPowerBreakable, 4)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.degradedBricksBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.dungeonLampBreakable, 4)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulSludgeBreakable, 16)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.collector, 2), new ItemStack(BlockRegistry.soulStoneBreakable, 16)));
        return list;
    }
}