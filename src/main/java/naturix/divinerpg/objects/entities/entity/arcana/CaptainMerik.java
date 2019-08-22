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

import java.util.ArrayList;
import java.util.List;

public class CaptainMerik extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.merik.sword", "message.merik.datticon", "message.merik.hurry",
            "message.merik.battles", "message.merik.phoenix" };

    public CaptainMerik(World world) {
        super(world);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.CAPTAIN_MERIK_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.captain_merik.name") + ": "
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

    public static List<MerchantRecipe> getAllRecipies(){
        List<MerchantRecipe> list = new ArrayList<>();
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 5), new ItemStack(ModItems.stormSword)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 12), new ItemStack(ModItems.enderScepter)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 20), new ItemStack(ModItems.ghostbane)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8), new ItemStack(ModItems.shadowSword)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 4), new ItemStack(ModItems.starlight)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 8), new ItemStack(ModItems.arcaniumSaber)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 20), new ItemStack(ModItems.captainsSparkler)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 12), new ItemStack(ModItems.firefly)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 20), new ItemStack(ModItems.staffStarlight)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 15), new ItemStack(ModItems.meriksMissile)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 30), new ItemStack(ModItems.liviciaSword)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 6), new ItemStack(ModItems.laVekor)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 1), new ItemStack(ModItems.grenade, 10)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}