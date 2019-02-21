package naturix.divinerpg.objects.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class JackOMan extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.jackoman.boo", "message.jackoman.lost", "message.jackoman.hurah",
            "message.jackoman.seen" };
    private static final String PROFESSION_NAME = DivineRPG.modId + ".jackoman";
    private static VillagerRegistry.VillagerProfession jackomanProfession;
    private static VillagerRegistry.VillagerCareer jackomanCareer;

    public static void registerVillager() {
        jackomanProfession = new VillagerRegistry.VillagerProfession(PROFESSION_NAME, "", "");
        IForgeRegistry<VillagerRegistry.VillagerProfession> villagerProfessions = ForgeRegistries.VILLAGER_PROFESSIONS;
        villagerProfessions.register(jackomanProfession);
        jackomanCareer = new VillagerRegistry.VillagerCareer(jackomanProfession, PROFESSION_NAME);
    }

    public JackOMan(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2f);
        this.setHealth(this.getMaxHealth());
    }

    @Override
    public void setProfession(net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession prof) {
        super.setProfession(jackomanProfession);
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
                new ItemStack(ModItems.skelemanChestplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 60), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanLeggings, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Items.BONE, 40), new ItemStack(Items.SPIDER_EYE, 60),
                new ItemStack(ModItems.skelemanBoots, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackomanHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackomanChestplate)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackomanLeggings)));
        list.add(new MerchantRecipe(new ItemStack(Blocks.PUMPKIN, 50), new ItemStack(Items.ENDER_EYE, 10),
                new ItemStack(ModItems.jackomanBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 3, 1), new ItemStack(ModItems.witherreaperHelmet)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 5, 1), new ItemStack(ModItems.witherreaperChestplate)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 4, 1), new ItemStack(ModItems.witherreaperLeggings)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 2, 1), new ItemStack(ModItems.witherreaperBoots)));
        list.add(new MerchantRecipe(new ItemStack(Items.SKULL, 6, 1), new ItemStack(Items.ENDER_EYE, 60),
                new ItemStack(ModItems.scythe)));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.JACKOMAN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.JACKOMAN;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.JACKOMAN;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
