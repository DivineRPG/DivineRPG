package naturix.divinerpg.objects.entities.entity.iceika;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.EntityDivineRPGVillager;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class WorkshopTinkerer extends EntityDivineRPGVillager {
    private static final String[] MESSAGE = { "message.merchant.ho", "message.merchant.out", "message.merchant.in",
            "message.merchant.burr" };
    private static final String PROFESSION_NAME = DivineRPG.modId + ".workshop_tinkerer";
    private static VillagerRegistry.VillagerProfession workshoptinkererProfession;
    private static VillagerRegistry.VillagerCareer workshoptinkererCareer;

    public static void registerVillager() {
        workshoptinkererProfession = new VillagerRegistry.VillagerProfession(PROFESSION_NAME, "", "");
        IForgeRegistry<VillagerRegistry.VillagerProfession> villagerProfessions = ForgeRegistries.VILLAGER_PROFESSIONS;
        villagerProfessions.register(workshoptinkererProfession);
        workshoptinkererCareer = new VillagerRegistry.VillagerCareer(workshoptinkererProfession, PROFESSION_NAME);
    }

    public WorkshopTinkerer(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.0F);
    }

    @Override
    public void setProfession(net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession prof) {
        super.setProfession(workshoptinkererProfession);
    }

    @Override
    public void extraInteract(EntityPlayer player) {
        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("entity.divinerpg.workshop_tinkerer.name")
                + ": " + MessageLocalizer.normal(MESSAGE[rand.nextInt(4)])));
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.world.isRemote) {
            // player.triggerAchievement(DivineRPGAchievements.lilGift);
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void addRecipies(MerchantRecipeList list) {
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 1), new
        // ItemStack(VanillaItemsWeapons.shuriken, 16, 0), new
        // ItemStack(ModItems.snowflakeShuriken, 16, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 4), new
        // ItemStack(VanillaItemsWeapons.serenadeStriker, 1, 0), new
        // ItemStack(ModItems.serenadeOfIce, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 7), new
        // ItemStack(VanillaItemsWeapons.slimeSword, 1, 0), new
        // ItemStack(ModItems.glacierSword, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new
        // ItemStack(VanillaItemsWeapons.shadowBow, 1, 0),new
        // ItemStack(ModItems.icicleBow, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 6), new
        // ItemStack(VanillaItemsWeapons.massivence, 1, 0),new
        // ItemStack(ModItems.frossivence, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new
        // ItemStack(VanillaItemsWeapons.crabclawCannon, 1, 0),new
        // ItemStack(ModItems.frostclawCannon, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 12), new
        // ItemStack(VanillaItemsWeapons.frostCannon, 1, 0),new
        // ItemStack(ModItems.fractiteCannon, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new
        // ItemStack(VanillaItemsWeapons.frostSword, 1, 0), new
        // ItemStack(ModItems.frostkingSword, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 18), new
        // ItemStack(IceikaItems.soundOfMusic, 1, 0), new
        // ItemStack(ModItems.soundOfCarols, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 25), new
        // ItemStack(VanillaItemsWeapons.enderSword, 1, 0), new
        // ItemStack(ModItems.enderice, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 30), new
        // ItemStack(VanillaItemsWeapons.bluefireBow, 1, 0), new
        // ItemStack(ModItems.snowstormBow, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 45), new
        // ItemStack(VanillaItemsWeapons.bedrockMaul, 1, 0), new
        // ItemStack(ModItems.frozenMaul, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 40), new
        // ItemStack(VanillaItemsWeapons.divineSword, 1, 0), new
        // ItemStack(ModItems.icineSword, 1, 0)));
        // list.add(new InfiniteTrade(new ItemStack(ModItems.snowflake, 15), new
        // ItemStack(VanillaItemsWeapons.sandslash, 1, 0), new
        // ItemStack(ModItems.snowSlash, 1, 0)));
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
