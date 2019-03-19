package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.objects.entities.entity.InfiniteTrade;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class WorkshopMerchant extends EntityDivineRPGVillager {

    private static final String[] MESSAGE = { "message.merchant.ho", "message.merchant.out", "message.merchant.in", "message.merchant.burr" };

    public WorkshopMerchant(World worldIn) {
        super(worldIn);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WORKSHOP_MERCHANT, this.world, getEntityId(), 0, 0);
            // player.triggerAchievement(DivineRPGAchievements.lilGift);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.divinerpg.workshop_merchant.name") + ": " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaCap, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaTunic, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaPants, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.santaBoots, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.eggNog, 2, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.chocolateLog, 5, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.peppermints, 15, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.fruitCake, 3, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 20), new ItemStack(ModItems.icicleBane, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.greenChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.redChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.blueChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.yellowChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.purpleChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 3), new ItemStack(ModBlocks.presentBox, 1)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.blueCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.greenCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.pinkCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.redCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModBlocks.yellowCandyCane, 4)));
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
