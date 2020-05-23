package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityLeorna extends EntityDivineRPGVillager {
    public EntityLeorna(World world) {
        super(world, "message.leorna.plants",
                "message.leorna.nature",
                "message.leorna.lamona",
                "message.leorna.hitchak",
                "message.leorna.zelus");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.LEORNA_GUI_ID, this.world, getEntityId(), 0, 0);
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

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}