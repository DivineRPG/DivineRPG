package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.objects.entities.entity.InfiniteTrade;
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

public class WorkshopTinkerer extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.merchant.ho", "message.merchant.out", "message.merchant.in",
            "message.merchant.burr" };

    public WorkshopTinkerer(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.0F);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WORKSHOP_TINKERER, this.world, getEntityId(), 0, 0);
            // player.triggerAchievement(DivineRPGAchievements.lilGift);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.divinerpg.workshop_tinkerer.name")
                + ": " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModItems.shuriken, 16, 0),
                new ItemStack(ModItems.shurikenSnow, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModItems.serenadeStrike, 1, 0),
                new ItemStack(ModItems.serenadeIce, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 7), new ItemStack(ModItems.slimeSword, 1, 0),
                new ItemStack(ModItems.glacierSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.shadowBow, 1, 0),
                new ItemStack(ModItems.icicleBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModItems.massivence, 1, 0),
                new ItemStack(ModItems.frossivence, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.cannonCrab, 1, 0),
                new ItemStack(ModItems.cannonFrost, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModItems.cannonFrost, 1, 0),
                new ItemStack(ModItems.cannonFractite, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModItems.frostSword, 1, 0),
                new ItemStack(ModItems.frostkingSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 18), new ItemStack(ModItems.soundMusic, 1, 0),
                new ItemStack(ModItems.soundCarol, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 25), new ItemStack(ModItems.enderSword, 1, 0),
                new ItemStack(ModItems.iceEnder, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 30), new ItemStack(ModItems.bluefireBow, 1, 0),
                new ItemStack(ModItems.snowBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 45), new ItemStack(ModItems.bedrockMaul, 1, 0),
                new ItemStack(ModItems.maulFrozen, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 40), new ItemStack(ModItems.divineSword, 1, 0),
                new ItemStack(ModItems.icineSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModItems.sandslash, 1, 0),
                new ItemStack(ModItems.snowslash, 1, 0)));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
}
