package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class Datticon extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.datticon.merik", "message.datticon.furnace",
            "message.datticon.science", "message.datticon.plugged", "message.datticon.redstone" };

    public Datticon(World world) {
        super(world);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.DATTICON_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.datticon.name") + ": "
                + MessageLocalizer.normal(MESSAGE[rand.nextInt(MESSAGE.length)])));
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static MerchantRecipeList getAllRecipies(){
        MerchantRecipeList list = new MerchantRecipeList();
        //FIXME
        //list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1), new ItemStack(ModItems.arcaniumBucket)));
        //list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5), new ItemStack(ModBlocks.arcaniteRails, 8)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8), new ItemStack(ModBlocks.starBridge, 16)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModBlocks.arcaniteTubes, 16)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModBlocks.moltenFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModBlocks.greenlightFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4), new ItemStack(ModBlocks.oceanfireFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5), new ItemStack(ModBlocks.moonlightFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModBlocks.whitefireFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 9), new ItemStack(ModBlocks.demonFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModBlocks.elevantium, 9)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModBlocks.acceleron, 3)));

        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}