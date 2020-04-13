package divinerpg.objects.entities.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
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

public class EntityWorkshopTinkerer extends EntityDivineRPGVillager {
    public EntityWorkshopTinkerer(World worldIn) {
        super(worldIn, "message.merchant.ho",
                "message.merchant.out",
                "message.merchant.in",
                "message.merchant.burr");
        this.setSize(1.0F, 2.0F);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.WORKSHOP_TINKERER_GUI_ID, this.world, getEntityId(), 0, 0);
            CriteriaTriggers.VILLAGER_TRADE.trigger((EntityPlayerMP) player, this, ItemStack.EMPTY);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static List<MerchantRecipe> getAllRecipies(){
        ArrayList<MerchantRecipe> list = new ArrayList<>();
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new ItemStack(ModWeapons.shuriken, 16, 0),
                new ItemStack(ModWeapons.snowflakeShuriken, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new ItemStack(ModWeapons.serenadeStriker, 1, 0),
                new ItemStack(ModWeapons.serenadeOfIce, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 7), new ItemStack(ModWeapons.slimeSword, 1, 0),
                new ItemStack(ModWeapons.glacierSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModWeapons.shadowBow, 1, 0),
                new ItemStack(ModWeapons.icicleBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new ItemStack(ModWeapons.massivence, 1, 0),
                new ItemStack(ModWeapons.frossivence, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModWeapons.crabclawCannon, 1, 0),
                new ItemStack(ModWeapons.frostclawCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new ItemStack(ModWeapons.frostCannon, 1, 0),
                new ItemStack(ModWeapons.fractiteCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModWeapons.frostSword, 1, 0),
                new ItemStack(ModWeapons.frostkingSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 18), new ItemStack(ModWeapons.soundOfMusic, 1, 0),
                new ItemStack(ModWeapons.soundOfCarols, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 25), new ItemStack(ModWeapons.enderSword, 1, 0),
                new ItemStack(ModWeapons.enderice, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 30), new ItemStack(ModWeapons.bluefireBow, 1, 0),
                new ItemStack(ModWeapons.snowstormBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 45), new ItemStack(ModWeapons.bedrockMaul, 1, 0),
                new ItemStack(ModWeapons.frozenMaul, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 40), new ItemStack(ModWeapons.divineSword, 1, 0),
                new ItemStack(ModWeapons.icineSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new ItemStack(ModWeapons.sandslash, 1, 0),
                new ItemStack(ModWeapons.snowslash, 1, 0)));
        return list;
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
