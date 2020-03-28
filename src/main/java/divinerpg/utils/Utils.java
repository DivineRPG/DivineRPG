package divinerpg.utils;

import divinerpg.registry.ModBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Utils {
    public static int mobID = 500, projectileID = 0, entityListID = 2500;

    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource spikeSource = new DamageSource("spike");
    public static DamageSource arcanaSource = new DamageSource("arcana");

    private static String str;

    private static Object args;
    public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73",
            DARK_RED = "\u00a74";
    public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78",
            BLUE = "\u00a79";
    public static String GREEN = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d",
            YELLOW = "\u00a7e";
    public static String WHITE = "\u00a7f";

    private static List<UUID> DEV_LIST = new ArrayList<UUID>() {{
        add(UUID.fromString("607043b2-830e-4d7c-a600-871754c01827")); //RadioactiveStud
        add(UUID.fromString("a75f7026-aebd-4777-9cbb-de40516dca84")); //Eternaldoom1
        add(UUID.fromString("989677b3-7af4-4b9a-9672-07b367677ecb")); //BossLetsPlays
        add(UUID.fromString("010318ef-28fc-4c7c-8940-2f0d62eabfa6")); //Xolova
        add(UUID.fromString("6e65f2ca-fd15-47c5-ab91-13dd2731d73f")); //sheenrox82
        add(UUID.fromString("b9ee091b-c611-41ff-a52b-4020027e5cb6")); //The_SlayerMC
        add(UUID.fromString("3a037d9d-0744-4452-aa80-f3c9ab17a1d2")); //insanity414all
        add(UUID.fromString("de247846-69fb-4880-907b-a5e1f58267f3")); //deathman12e3
        add(UUID.fromString("1586e8bd-e266-49d0-aa2a-f6aab3a8e90d")); //Fire_Sight
        add(UUID.fromString("c657219e-36ba-495c-aff4-dad3c248f76c")); //Krwminer
        add(UUID.fromString("17356bc2-89ad-484e-9f2a-8fdbdcf1f3cd")); //NicosaurusRex99
        add(UUID.fromString("1e2326e7-a592-4e11-9b4c-d0c930deeca3")); //Wufflez
        add(UUID.fromString("e11679a6-2269-46aa-a6fd-4e2aec9f3b96")); //Dash
    }};

    private static List<UUID> TESTER_LIST = new ArrayList<UUID>() {{
        add(UUID.fromString("509f6794-ad97-4270-9627-ae85b03a0534")); //alexandru
        add(UUID.fromString("2903ef30-1a71-40ff-87aa-dceee2b6f6d9")); //FireBitMC
        add(UUID.fromString("ae8d12d9-391f-4b0c-9627-662b3e91b3c9")); //Locomen_
        add(UUID.fromString("52b7a6ca-ec5f-406a-90cb-012dbb8dbc0d")); //69EHOTUK96
        add(UUID.fromString("f4bcf30e-cc3a-48bc-82dc-d75798f1f844")); //rpgmaster99
        add(UUID.fromString("74e117c8-7f46-4f39-a174-c86bafb6ad50")); //KIRYLL_Wexd1105
        add(UUID.fromString("0d731c4e-7d1a-4072-8ef3-54cc6a524e47")); //PinkGoose_
        add(UUID.fromString("f4bcf30e-cc3a-48bc-82dc-d75798f1f844")); //Cpfuzzyz
        add(UUID.fromString("6280b6f6-eafe-4a38-9296-a05cace12c15")); //sikerow
        add(UUID.fromString("5f7b78f0-e8e0-4ae3-a55c-2e8ddab3c51e")); //EliteXander2017
        add(UUID.fromString("52dc9328-c685-4868-bc71-0f17b66c3ae0")); //Arob105
        add(UUID.fromString("ac5a82b0-6ace-4649-ac54-ac66597127fc")); //Dinozver
        add(UUID.fromString("4cf228db-7980-4543-ab01-4138ed5824c7")); //Lukifuge
        add(UUID.fromString("c3c9543a-70a1-4b24-9c3c-7f6569b90437")); //TellNoLies
        add(UUID.fromString("404b95bb-9fc1-4653-98b2-6be5ef77ede8")); //PeggyPenguin
        add(UUID.fromString("48448fdb-18d4-4359-af91-eb529486f18c")); //Chelovechecheggg
        add(UUID.fromString("940b96bb-1b57-40d1-9cbf-51e261e3b31d")); //SystemDysphoria
        add(UUID.fromString("d6f20cb4-6a17-4ffc-b928-dc05c6d5c809")); //a09hopper
        add(UUID.fromString("af0adaea-4a23-4b18-9237-fc7661e854a5")); //PeopleMcNugget
        add(UUID.fromString("0c23ad99-41b5-420a-8503-9868cf174183")); //whitebeartigtig
        add(UUID.fromString("417f6730-13ec-4ad0-83cf-abd6ef1ef9a9")); //MaxTalks
        add(UUID.fromString("ebbfcae9-9181-46f7-9b0b-840b75b4919c")); //masterbobli
        add(UUID.fromString("0c23ad99-41b5-420a-8503-9868cf174183")); //whitebear___
        add(UUID.fromString("492875d9-06f7-4c3b-85f1-9e3a63f71128")); //FLAVSY9000
        add(UUID.fromString("a9d16dd7-d917-48ac-9888-095eb30ab3af")); //Techno3712
    }};

    // Whats a pity, It's empty
    private static List<UUID> PATRON_LIST = new ArrayList<UUID>() {{

    }};

    public static boolean isDeveloperName(UUID name) {
        return DEV_LIST.contains(name);
    }

    public static boolean isTesterName(UUID name) {
        return TESTER_LIST.contains(name);
    }

    public static boolean isPatreon(UUID name) {
        return PATRON_LIST.contains(name);
    }

    /**
     * Loads possible information from web if we really need it
     *
     * @return
     */
    public static void loadHatInformation(String filePath) {
        CompletableFuture<String> fileDownload = CompletableFuture.supplyAsync(() -> {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL(filePath).openConnection();
                con.setConnectTimeout(1000);
                InputStream in2 = con.getInputStream();
                List<String> strings = IOUtils.readLines(in2, Charset.defaultCharset());

                return String.join("\n", strings);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });

        fileDownload.thenApply(text -> {
            // parse your result
            return true;
        });
    }

    public static ITextComponent getChatComponent(String str) {
        TextComponentString ret = new TextComponentString(str);
        return ret;
    }

    public static ITextComponent getChatComponent(String str, String args) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static DamageSource causeArcanaDamage(Entity projectile, Entity shooter) {
        return new EntityDamageSourceIndirect("arrow", projectile, shooter).setMagicDamage();
    }

    public static boolean bordersTar(World world, int x, int y, int z) {
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == ModBlocks.tar) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean bordersTar(World w, BlockPos pos) {
        return bordersTar(w, pos.getX(), pos.getY(), pos.getZ());
    }

    public static ITextComponent addChatMessage(ITextComponent displayName) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static TextComponentString addChatMessage(String str, Object... args) {
        TextComponentString ret = new TextComponentString(args + str);
        ret.getStyle().setColor(TextFormatting.WHITE);
        return ret;
    }

    public static ToolMaterial addHammerMaterial(float damage) {
        return EnumHelper.addToolMaterial("sword", 0, -1, 0, damage - 4, 22);
    }
}