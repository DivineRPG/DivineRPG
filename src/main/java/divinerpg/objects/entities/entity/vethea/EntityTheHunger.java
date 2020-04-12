package divinerpg.objects.entities.entity.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityTheHunger extends EntityDivineRPGVillager {
    public EntityTheHunger(World worldIn) {
        super(worldIn, "message.hunger.hungry",
                "message.hunger.closer",
                "message.hunger.fatten",
                "message.hunger.dinner");
        this.setSize(0.8F, 2f);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.THE_HUNGER_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }


    @Override
    public void addRecipies(MerchantRecipeList recipes) {
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(ModItems.dreamCarrot, 2, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.dreamMelon, 4, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(ModItems.dreamPie, 5, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 10, 0), new ItemStack(ModItems.dreamCake, 8, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(ModItems.barredDoor, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.diskTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.cannonTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.backswordTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.hammerTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.bowTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.staffTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 3, 0), new ItemStack(ModItems.clawTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 5, 0), new ItemStack(ModItems.degradedTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(ModBlocks.lightDreamBricks, 16, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(ModBlocks.darkDreamBricks, 16, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(ModBlocks.redDreamBricks, 16, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 2, 0), new ItemStack(ModBlocks.dreamDirt, 64, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 1, 0), new ItemStack(ModBlocks.smoothGlass, 16, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 4, 0), new ItemStack(ModBlocks.firelight, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 4, 0), new ItemStack(Blocks.CHEST, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.dirtyPearls, 2, 0), new ItemStack(ModItems.teakerArrow, 32, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 1, 0), new ItemStack(ModItems.dreamSweets, 4, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 5, 0), new ItemStack(ModItems.finishedTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 2, 0), new ItemStack(ModItems.darvenArrow, 32, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 4, 0), new ItemStack(ModItems.pardimalArrow, 32, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 6, 0), new ItemStack(ModItems.karosArrow, 32, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 10, 0), new ItemStack(ModItems.dreamShovel, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 10, 0), new ItemStack(ModItems.dreamPickaxe, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 10, 0), new ItemStack(ModItems.dreamAxe, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.cleanPearls, 15, 0), new ItemStack(ModItems.minersAmulet, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.polishedPearls, 20, 0), new ItemStack(ModItems.dreamFlint, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.polishedPearls, 5, 0), new ItemStack(ModItems.glisteningTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.polishedPearls, 5, 0), new ItemStack(ModItems.demonizedTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.shinyPearls, 40, 0), new ItemStack(ModItems.moonClock, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.shinyPearls, 25, 0), new ItemStack(ModItems.bandOfHeivaHunting, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.shinyPearls, 1, 0), new ItemStack(ModItems.dreamSours, 4, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.shinyPearls, 5, 0), new ItemStack(ModItems.tormentedTemplate, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(ModItems.rockChunks, 25, 0), new ItemStack(ModItems.karosRockmaul, 1, 0)));
    }
}
