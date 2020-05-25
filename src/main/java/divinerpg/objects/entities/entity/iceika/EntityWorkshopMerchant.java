package divinerpg.objects.entities.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.ArmorRegistry;
import divinerpg.registry.WeaponRegistry;
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

public class EntityWorkshopMerchant extends EntityDivineVillager {
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
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaHelmet, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaChestplate, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaLeggings, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaBoots, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.eggNog, 2, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.chocolateLog, 5, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.peppermints, 15, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.fruitCake, 3, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 20), new ItemStack(WeaponRegistry.icicleBane, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.greenChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.redChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.blueChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.yellowChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.purpleChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 9), new ItemStack(BlockRegistry.presentBox, 1)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.pinkCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowCandyCane, 4)));
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

