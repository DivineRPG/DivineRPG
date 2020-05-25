package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityZelus extends EntityDivineVillager {
    public EntityZelus(World world) {
        super(world, "message.zelus.fine",
                "message.zelus.minions",
                "message.zelus.flower",
                "message.zelus.plants");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.ZELUS_GUI_ID, this.world, getEntityId(), 0, 0);
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
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.fyracryxEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.seimerEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.paratikuEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 5),
                new ItemStack(ItemRegistry.golemOfRejuvenationEgg)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}