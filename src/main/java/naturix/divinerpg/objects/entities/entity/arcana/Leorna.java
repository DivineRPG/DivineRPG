package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class Leorna extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.leorna.plants", "message.leorna.nature", "message.leorna.lamona",
            "message.leorna.hitchak", "message.leorna.zelus" };

    public Leorna(World world) {
        super(world);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.LEORNA_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.leorna.name") + ": "
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
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1), new ItemStack(ModSeeds.eucalyptusSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModSeeds.marsineSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModSeeds.firestockSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModSeeds.pinflySeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4), new ItemStack(ModSeeds.aquamarineSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5), new ItemStack(ModSeeds.hitchakSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModSeeds.veiloSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 9), new ItemStack(ModSeeds.lamonaSeeds)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModBlocks.arcanaDirt, 9)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}