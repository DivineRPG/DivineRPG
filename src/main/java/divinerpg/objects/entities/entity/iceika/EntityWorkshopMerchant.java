package divinerpg.objects.entities.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ModArmor;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModWeapons;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityWorkshopMerchant extends EntityDivineRPGVillager {
    public EntityWorkshopMerchant(World worldIn) {
        super(worldIn, "message.merchant.ho",
                "message.merchant.out",
                "message.merchant.in",
                "message.merchant.burr");
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WORKSHOP_MERCHANT_GUI_ID, this.world, getEntityId(), 0, 0);
            CriteriaTriggers.VILLAGER_TRADE.trigger((EntityPlayerMP) player, this, ItemStack.EMPTY);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static List<MerchantRecipe> getAllRecipies(){
        List<MerchantRecipe> list = new ArrayList<>();
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModArmor.santaHelmet, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModArmor.santaChestplate, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModArmor.santaLeggings, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModArmor.santaBoots, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModItems.eggNog, 2, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModItems.chocolateLog, 5, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModItems.peppermints, 15, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModItems.fruitCake, 3, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 20), new ItemStack(ModWeapons.icicleBane, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3),
                new ItemStack(ModBlocks.greenChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3),
                new ItemStack(ModBlocks.redChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3),
                new ItemStack(ModBlocks.blueChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3),
                new ItemStack(ModBlocks.yellowChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3),
                new ItemStack(ModBlocks.purpleChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 9), new ItemStack(ModBlocks.presentBox, 1)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModBlocks.blueCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModBlocks.greenCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModBlocks.pinkCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModBlocks.redCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.iceStone, 3), new ItemStack(ModBlocks.yellowCandyCane, 4)));
        return list;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }
}

