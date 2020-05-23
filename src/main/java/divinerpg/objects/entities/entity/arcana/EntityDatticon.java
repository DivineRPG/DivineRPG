package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityDatticon extends EntityDivineRPGVillager {
    public EntityDatticon(World world) {
        super(world, "message.datticon.merik",
                "message.datticon.furnace",
                "message.datticon.science",
                "message.datticon.plugged",
                "message.datticon.redstone");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.DATTICON_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static MerchantRecipeList getAllRecipies() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8), new ItemStack(BlockRegistry.starBridge, 16)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(BlockRegistry.arcaniteTubes, 16)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(BlockRegistry.moltenFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(BlockRegistry.greenlightFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4), new ItemStack(BlockRegistry.oceanfireFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5), new ItemStack(BlockRegistry.moonlightFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(BlockRegistry.whitefireFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 9), new ItemStack(BlockRegistry.demonFurnace)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(BlockRegistry.elevantium, 9)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(BlockRegistry.acceleron, 3)));

        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}