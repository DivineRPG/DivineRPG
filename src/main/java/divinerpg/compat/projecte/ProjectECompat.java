package divinerpg.compat.projecte;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import divinerpg.DivineRPG;
import moze_intel.projecte.api.mapper.*;
import moze_intel.projecte.api.mapper.collector.IMappingCollector;
import moze_intel.projecte.api.nss.*;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.*;

@EMCMapper
public class ProjectECompat
        implements IEMCMapper<NormalizedSimpleStack, Long>
{

    private static final Map<NormalizedSimpleStack, Long> CUSTOM_EMC_VALUES = new HashMap<>();

    public static void init() {
        //Resources
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cyclops_eye_shards")), 1)), 46L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "crab_claw")), 1)), 150L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquatic_pellets")), 1)), 800L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shark_fin")), 1)), 1020L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "whale_fin")), 1)), 1280L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "liopleurodon_teeth")), 1)), 2242L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "liopleurodon_skull")), 1)), 4942L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "realmite_ingot")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_ingot")), 1)), 8064L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_ingot")), 1)), 9216L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "healing_stone")), 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ice_shards")), 1)), 910L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_shards")), 1)), 910L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_shards")), 1)), 910L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_shards")), 1)), 910L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_shards")), 1)), 1420L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_shards")), 1)), 1820L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_shards")), 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_ingot")), 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bloodgem")), 1)), 8256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "purple_blaze")), 1)), 1536L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "fury_fire")), 1)), 6144L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "soulfire_stone")), 1)), 8092L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "anthracite")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "olivine")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "oxdrite_ingot")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "seng_fur")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sabear_fur")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sabear_tooth")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "watching_eye")), 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "color_template")), 1)), 20121L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquatic_coating_template")), 1)), 12192L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquamarine")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "firestock")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "lamona")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "marsine")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "veilo")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eucalyptus_root_seeds")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dungeon_tokens")), 1)), 17109L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "collector_fragments")), 1)), 1820L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium")), 1)), 17109L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_key")), 1)), 49140L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_key")), 1)), 49140L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sludge_key")), 1)), 49140L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_key")), 1)), 49140L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_soul")), 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_soul")), 1)), 1536L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_soul")), 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_soul")), 1)), 4072L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_soul")), 1)), 6096L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_heart")), 1)), 4096L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_heart")), 1)), 6144L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_heart")), 1)), 8192L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_heart")), 1)), 16288L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_heart")), 1)), 24384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dirty_pearls")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "clean_pearls")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "polished_pearls")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shiny_pearls")), 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rock_chunks")), 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "acid")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cannon_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "claw_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "backsword_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bow_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "disk_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dissipator_template")), 1)), 640L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "hammer_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "staff_template")), 1)), 384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_template")), 1)), 640L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_template")), 1)), 1280L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_template")), 1)), 2560L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_template")), 1)), 2560L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_template")), 1)), 5120L);

        //Food & Drinks
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "white_mushroom")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "peppermints")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cauldron_flesh")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "raw_seng_meat")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "raw_wolpertinger_meat")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snow_cones")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "chocolate_log")), 1)), 122L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "fruit_cake")), 1)), 182L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "egg_nog")), 1)), 800L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "weak_arcana_potion")), 1)), 5460L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "strong_arcana_potion")), 1)), 8190L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "hitchak")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pinfly")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "raw_empowered_meat")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "forbidden_fruit")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "magic_meat")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pink_glowbone")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "purple_glowbone")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "enriched_magic_meat")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sky_flower")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_carrot")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_sweets")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_sours")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_cake")), 1)), 160L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_pie")), 1)), 130L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_melon")), 1)), 96L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "honeysuckle")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "honeychunk")), 1)), 1L);

        //Equipment & Stuff
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frossivence")), 1)), 24023L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_sword")), 1)), 4868L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "fury_maul")), 1)), 171753L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bane")), 1)), 10240L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glacier_sword")), 1)), 53006L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frostking_sword")), 1)), 24077L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "enderice")), 1)), 202080L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icine_sword")), 1)), 94212L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_maul")), 1)), 134232L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake_shuriken")), 1)), 192L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bow")), 1)), 58025L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowstorm_bow")), 1)), 44676L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sound_of_carols")), 1)), 21519L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frostclaw_cannon")), 1)), 13651L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "fractite_cannon")), 1)), 99840L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_blaster")), 1)), 307962L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "generals_staff")), 1)), 307962L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "meteor_mash")), 1)), 290853L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "starlight")), 1)), 68436L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "staff_of_starlight")), 1)), 342180L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ghostbane")), 1)), 342180L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "captains_sparkler")), 1)), 342180L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "firefly")), 1)), 205308L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "meriks_missile")), 1)), 256635L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "grenade")), 1)), 1710L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "la_vekor")), 1)), 102654L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "storm_sword")), 1)), 85545L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_blade")), 1)), 513270L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_saber")), 1)), 136872L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_saber")), 1)), 136872L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "livicia_sword")), 1)), 513111L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_helmet")), 1)), 102654L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_chestplate")), 1)), 171090L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_leggings")), 1)), 171090L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_boots")), 1)), 102654L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_helmet")), 1)), 102654L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_chestplate")), 1)), 171090L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_leggings")), 1)), 171090L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_boots")), 1)), 102654L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "angelic_chestplate")), 1)), 381784L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wizards_book")), 1)), 34218L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_helmet")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_chestplate")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_leggings")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_boots")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_helmet")), 1)), 2800L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_chestplate")), 1)), 4160L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_leggings")), 1)), 4160L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_boots")), 1)), 2800L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_helmet")), 1)), 2464L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_chestplate")), 1)), 4208L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_leggings")), 1)), 4208L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_boots")), 1)), 2464L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "scythe")), 1)), 7696L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "smoldering_tar_bucket")), 1)), 832L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gem_fin_bucket")), 1)), 832L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cauldron_fish_bucket")), 1)), 832L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "miners_amulet")), 1)), 3840L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "band_of_heiva_hunting")), 1)), 25600L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_flint")), 1)), 10240L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moon_clock")), 1)), 40960L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "teaker_arrow")), 1)), 8L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "darven_arrow")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pardimal_arrow")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_arrow")), 1)), 48L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ever_arrow")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_axe")), 1)), 1278L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_pickaxe")), 1)), 1278L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_shovel")), 1)), 1278L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "karos_rockmaul")), 1)), 51200L);

        //Dirt, Grass, Sand, etc.
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_dirt")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_dirt")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_grass")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "flame_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "evergrass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "scorched_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "gelidite")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_gravel")), 1)), 4L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_sludge_breakable")), 1)), 49L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hive_wall")), 1)), 1L);

        //Stone & Bricks
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "asphalt")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "milk_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cobbled_frozen_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "snow_bricks")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icy_stone")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icy_bricks")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "chiseled_icy_bricks")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "thermal_vent")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icy_stone")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cobaltite")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_stone_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_stone_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_bricks_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_bricks_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_tile_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_metal_breakable")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_power_breakable")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_moss_stone")), 1)), 9L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_stone")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "luna_stone")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "luna_bricks")), 1)), 64L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "red_dream_bricks")), 1)), 8L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dark_dream_bricks")), 1)), 8L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "light_dream_bricks")), 1)), 8L);

        //Plants & Fungi
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_grass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_moss")), 1)), 12L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_bush")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_head")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_brush")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcana_bush")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_moss")), 1)), 12L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_head")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "weedwood_vine")), 1)), 8L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blossomed_weedwood_vine")), 1)), 8L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_brush")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_vine")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_fern")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_tallgrass")), 1)), 16L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "truffle")), 1)), 144L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_tallgrass")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_brush")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_brush")), 1)), 32L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dreamglow")), 1)), 16L);

        //Misc Blocks
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cold_hellfire_sponge")), 1)), 122488L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone_furnace")), 1)), 128L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_chest")), 1)), 1024L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "present_box")), 1)), 2048L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "steel_door")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "red_candy_cane")), 1)), 126L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_candy_cane")), 1)), 126L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "green_candy_cane")), 1)), 126L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_candy_cane")), 1)), 126L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "pink_candy_cane")), 1)), 126L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "red_fairy_lights")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_fairy_lights")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "green_fairy_lights")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fairy_lights")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "purple_fairy_lights")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_glass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "workshop_lamp")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_tubes")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_ladder")), 1)), 14L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dungeon_lamp_breakable")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "demon_furnace")), 1)), 153981L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "greenlight_furnace")), 1)), 51327L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_furnace")), 1)), 34218L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_furnace")), 1)), 85545L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "oceanfire_furnace")), 1)), 68436L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "whitefire_furnace")), 1)), 119763L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "star_bridge")), 1)), 8554L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "slime_light")), 1)), 1920L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "elevantium")), 1)), 5703L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "acceleron")), 1)), 17109L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "barred_door")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "smooth_glass")), 1)), 1L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "hive_egg")), 1)), 16384L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "firelight")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "fire_crystal")), 1)), 512L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_lamp")), 1)), 1792L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "cell_lamp")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "village_lamp")), 1)), 256L);
        register(NSSItem.createItem(new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "metal_caging")), 1)), 64L);
    }
    public static void register(@Nonnull NormalizedSimpleStack stack, long emcValue) {
        CUSTOM_EMC_VALUES.put(stack, emcValue);
    }
    @Override
    public String getName() {
        return "DivineRPGMapper";
    }

    @Override
    public String getDescription() {
        return "Adds EMC to DivineRPG";
    }

    @Override
    public void addMappings(IMappingCollector<NormalizedSimpleStack, Long> iMappingCollector, CommentedFileConfig commentedFileConfig, ReloadableServerResources reloadableServerResources, RegistryAccess registryAccess, ResourceManager resourceManager) {
        for (Map.Entry<NormalizedSimpleStack, Long> entry : CUSTOM_EMC_VALUES.entrySet()) {
            NormalizedSimpleStack normStack = entry.getKey();
            long value = entry.getValue();
            iMappingCollector.setValueBefore(normStack, value);
        }
    }
}
