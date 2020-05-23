package divinerpg.objects.entities.entity.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityCaptainMerik extends EntityDivineRPGVillager {
    public EntityCaptainMerik(World world) {
        super(world, "message.merik.sword", "message.merik.datticon", "message.merik.hurry",
                "message.merik.battles", "message.merik.phoenix");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.CAPTAIN_MERIK_GUI_ID, this.world, getEntityId(), 0, 0);
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

    public static List<MerchantRecipe> getAllRecipies() {
        List<MerchantRecipe> list = new ArrayList<>();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 5), new ItemStack(WeaponRegistry.stormSword)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(WeaponRegistry.enderScepter)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(ItemRegistry.ghostbane)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(WeaponRegistry.shadowSaber)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 4), new ItemStack(WeaponRegistry.starlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 8), new ItemStack(WeaponRegistry.arcaniumSaber)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 20), new ItemStack(WeaponRegistry.captainsSparkler)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 12), new ItemStack(WeaponRegistry.firefly)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 20), new ItemStack(WeaponRegistry.staffOfStarlight)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 15), new ItemStack(WeaponRegistry.meriksMissile)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dungeonTokens, 30), new ItemStack(WeaponRegistry.liviciaSword)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 6), new ItemStack(WeaponRegistry.laVekor)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 1), new ItemStack(WeaponRegistry.grenade, 10)));
        return list;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}