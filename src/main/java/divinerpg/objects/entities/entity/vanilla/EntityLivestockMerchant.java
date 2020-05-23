package divinerpg.objects.entities.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityLivestockMerchant extends EntityDivineRPGVillager {

    public EntityLivestockMerchant(World worldIn) {
        super(worldIn, "message.livestock.travel",
                "message.livestock.sell",
                "message.livestock.hi",
                "message.livestock.snapper");
        this.setSize(0.8F, 2f);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.LIVESTOCK_MERCHANT_GUI_ID, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.addAll(getAllRecipies());
    }

    public static MerchantRecipeList getAllRecipies() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(Blocks.LOG, 32, 0), new ItemStack(ItemRegistry.shadowCoins, 4),
                new ItemStack(ItemRegistry.ehuEgg, 2)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.LOG, 64, 0), new ItemStack(ItemRegistry.shadowCoins, 7),
                new ItemStack(ItemRegistry.huskEgg, 2)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.STONE, 64), new ItemStack(ItemRegistry.shadowCoins, 3),
                new ItemStack(ItemRegistry.stoneGolemEgg, 1)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.NETHER_BRICK, 32), new ItemStack(ItemRegistry.shadowCoins, 5),
                new ItemStack(ItemRegistry.smelterEgg, 1)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.jungleStone, 2), new ItemStack(ItemRegistry.shadowCoins, 4),
                new ItemStack(ItemRegistry.snapperEgg, 3)));
        list.add(new MerchantRecipe(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8),
                new ItemStack(ItemRegistry.whiteGrizzleEgg, 2)));
        list.add(new MerchantRecipe(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadowCoins, 8),
                new ItemStack(ItemRegistry.brownGrizzleEgg, 2)));
        return list;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
