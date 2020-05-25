package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWarGeneral extends EntityDivineVillager {

    public EntityWarGeneral(World world) {
        super(world, "message.general.weapons",
                "message.general.merik",
                "message.general.blade");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WAR_GENERAL_GUI_ID, this.world, getEntityId(), 0, 0);
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

    public static MerchantRecipeList getAllRecipies(){
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(ItemRegistry.divineAccumulator)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 17), new ItemStack(WeaponRegistry.meteorMash)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.arcaniteBlaster)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 30), new ItemStack(WeaponRegistry.arcaniteBlade)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 18), new ItemStack(WeaponRegistry.generalsStaff)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.arcaniumReflector)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 7), new ItemStack(ItemRegistry.arcaniumAttractor)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}