package divinerpg.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.render.RenderHat;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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

    public static List<String> DEV_LIST = new ArrayList<String>();
    public static Map<AbstractClientPlayer, RenderHat.Type> REGISTRY = new LinkedHashMap<>();
    private static List<String> PATRON_LIST = new ArrayList<String>();
    public static Map<String, ResourceLocation> capeMap = new HashMap<>();

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

    private static String convertCapeString(String capeName) {
        StringBuilder underscoreCase = new StringBuilder();
        for (int i = 0; i < capeName.length(); ++i) {
            char c = capeName.charAt(i);
            if (!Character.isLowerCase(c)) {
                underscoreCase.append("_");
                c = Character.toLowerCase(c);
            }
            underscoreCase.append(c);
        }
        return underscoreCase.toString();
    }

    public static boolean doesPlayerHaveBlueHat(AbstractClientPlayer player) {
        for (int i = 0; i < PATRON_LIST.size(); ++i) {
            String uuid = player.getUniqueID().toString() + "_BHAT";
            if (!uuid.equals(PATRON_LIST.get(i))) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static boolean doesPlayerHaveRedHat(AbstractClientPlayer player) {
        for (int i = 0; i < PATRON_LIST.size(); ++i) {
            String uuid = player.getUniqueID().toString() + "_RHAT";
            if (!uuid.equals(PATRON_LIST.get(i))) {
                continue;
            }
            return true;
        }
        return false;
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

    static List<String> getPatronList() {
        try {
            List<String> entries = new ArrayList<String>();
            HttpURLConnection con;
            con = (HttpURLConnection) new URL(
                    "https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/dev.txt").openConnection();
            con.setConnectTimeout(1000);
            InputStream in2 = con.getInputStream();
            entries = IOUtils.readLines(in2);
            if (!entries.isEmpty()) {
                con.disconnect();
                return entries;
            }
        } catch (IOException e) {
        }
        return null;
    }

    public static RenderHat.Type getWingType(AbstractClientPlayer player) {
        if (player != null) {
            if (REGISTRY.containsKey(player)) {
                return REGISTRY.get(player);
            }
        }
        return null;
    }

    public static boolean isBlockInList(Block block1, Block... blocks) {
        for (Block b : blocks) {
            if (block1 == b) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContributor(AbstractClientPlayer player) {
        return player != null && REGISTRY.containsKey(player);
    }

    @SuppressWarnings("unlikely-arg-type")
    public static boolean isDeveloperName(ITextComponent iTextComponent) {
        for (int i = 0; i < DEV_LIST.size(); i++) {
            if (iTextComponent.equals(DEV_LIST.toArray())) {
                return true;
            }
        }
        return false;
    }

    public static void postFMLEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    public static void postForgeEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    public static void registerProjectile(Class entityClass, String entityName) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, Reference.MODID + "." + entityName),
                entityClass, Reference.MODID + entityName + "Projectile", projectileID, DivineRPG.instance, 250, 5,
                true);
        projectileID++;
    }

    public static void setupCapes() {
        try {
            Utils.updateCapeList();
        } catch (Exception e) {
            FMLLog.severe("Error while setting up DivineRPG dev hats");
            e.printStackTrace();
        }

    }

    public static void updateCapeList() {
        int timeout = 10000;
        URL capeListUrl;

        try {
            capeListUrl = new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/dev.txt");
        } catch (IOException e) {
            FMLLog.severe("Error getting capes list URL");
            if (Config.debug) {
                e.printStackTrace();
            }
            return;
        }

        URLConnection connection;

        try {
            connection = capeListUrl.openConnection();
        } catch (IOException e) {
            if (Config.debug) {
                e.printStackTrace();
            }
            return;
        }

        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        InputStream stream;

        try {
            stream = connection.getInputStream();
        } catch (IOException e) {
            if (Config.debug) {
                e.printStackTrace();
            }
            return;
        }

        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains(":")) {
                    int splitLocation = line.indexOf(":");
                    String username = line.substring(0, splitLocation);
                    Utils.capeMap.put(username, new ResourceLocation(Reference.MODID, "textures/models/devhats/"
                            + convertCapeString(line.substring(splitLocation + 1)) + ".png"));
                }
            }
        } catch (IOException e) {
            if (Config.debug) {
                e.printStackTrace();
            }
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                if (Config.debug) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static DamageSource causeArcanaDamage(Entity projectile, Entity shooter) {
        return new EntityDamageSourceIndirect("arrow", projectile, shooter).setMagicDamage();
    }

    public static ToolMaterial addHammerMaterial(float damage) {
        return EnumHelper.addToolMaterial("sword", 0, -1, 0, damage - 4, 22);
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
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();
        for (int i = x - 4; i <= x + 4; ++i) {
            for (int j = y; j <= y + 1; ++j) {
                for (int k = z - 4; k <= z + 4; ++k) {
                    if (w.getBlockState(new BlockPos(i, j, k)) == ModBlocks.tar) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void addDevsToList() {
        DEV_LIST.add("RadioactiveStud");
        DEV_LIST.add("Eternaldoom1");
        DEV_LIST.add("BossLetsPlays");
        DEV_LIST.add("Xolova");
        DEV_LIST.add("sheenrox82");
        DEV_LIST.add("The_SlayerMC");
        DEV_LIST.add("insanity414all");
        DEV_LIST.add("deathman12e3");
        DEV_LIST.add("Fire_Sight");
        DEV_LIST.add("krwminer");
        DEV_LIST.add("NicosaurusRex99");
        DEV_LIST.add("LiteWolf101");
        DEV_LIST.add("Dash");
    }
}