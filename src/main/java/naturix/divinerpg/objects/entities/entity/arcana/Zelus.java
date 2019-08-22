package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
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

public class Zelus extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.zelus.fine", "message.zelus.minions", "message.zelus.flower",
            "message.zelus.plants" };

    public Zelus(World world) {
        super(world);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.ZELUS_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.zelus.name") + ": "
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
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModItems.fyracryxSpawner)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 2), new ItemStack(ModItems.seimerSpawner)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 3), new ItemStack(ModItems.paratikuSpawner)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5),
                new ItemStack(ModItems.golemOfRejuvenationSpawner)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}