package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ModItems;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineRPGVillager {

    private static final String[] MESSAGE = { "message.general.weapons", "message.general.merik",
            "message.general.blade" };

    public EntityWarGeneral(World world) {
        super(world);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WAR_GENERAL_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(LocalizeUtils.getChatComponent(LocalizeUtils.normal("entity.divinerpg.war_general.name") + ": "
                + LocalizeUtils.normal(MESSAGE[rand.nextInt(MESSAGE.length)])));
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
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 6), new ItemStack(ModItems.divineAccumulator)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.dungeonTokens, 17), new ItemStack(ModItems.meteorMash)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 18), new ItemStack(ModItems.arcaniteBlaster)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 30), new ItemStack(ModItems.arcaniteBlade)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 18), new ItemStack(ModItems.generalsStaff)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModItems.arcaniumReflector)));
        list.add(new MerchantRecipe(new ItemStack(ModItems.arcanium, 7), new ItemStack(ModItems.arcaniumAttractor)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}