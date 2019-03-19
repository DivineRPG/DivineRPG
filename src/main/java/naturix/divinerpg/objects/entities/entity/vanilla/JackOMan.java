package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.GUIHandler;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class JackOMan extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.jackoman.boo", "message.jackoman.lost", "message.jackoman.hurah",
            "message.jackoman.seen" };

    public JackOMan(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2f);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            player.openGui(DivineRPG.instance, GUIHandler.JACK_O_MAN, this.world, getEntityId(), 0, 0);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.divinerpg.jackoman.name") + ": "
                + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanHelmet, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanBody, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanLegs, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 40), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanBoots, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackOManHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackOManBody)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackOManLegs)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackOManBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 3, 1), new ItemStack(ModItems.witherReaperHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 5, 1), new ItemStack(ModItems.witherReaperBody)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 4, 1), new ItemStack(ModItems.witherReaperLegs)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 2, 1), new ItemStack(ModItems.witherReaperBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 6, 1), new ItemStack(Items.ENDER_EYE, 60),
                new ItemStack(ModItems.scythe)));
    }

    public boolean isValidLightLevel() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32)) {
            return false;
        } else {
            int i = this.world.getLightFromNeighbors(blockpos);

            if (this.world.isThundering()) {
                int j = this.world.getSkylightSubtracted();
                this.world.setSkylightSubtracted(10);
                i = this.world.getLightFromNeighbors(blockpos);
                this.world.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canDespawn() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return DRPGSoundHandler.JACKOMAN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return DRPGSoundHandler.JACKOMAN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return DRPGSoundHandler.JACKOMAN;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.isValidLightLevel() && super.getCanSpawnHere();
    }
}
