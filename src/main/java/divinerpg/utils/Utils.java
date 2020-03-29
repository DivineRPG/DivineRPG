package divinerpg.utils;

import divinerpg.registry.ModBlocks;
import divinerpg.utils.Utils.DLThread;
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

    private static List<UUID> DEV_LIST = new ArrayList<UUID>();
    private static List<UUID> TESTER_LIST = new ArrayList<UUID>();
    private static List<UUID> PATRON_LIST = new ArrayList<UUID>();
    private static List<UUID> ARTIST_LIST = new ArrayList<UUID>();

	private static DLThread thread;
    public static boolean isDeveloperName(UUID name) {
    	thread = new DLThread();
		thread.setDaemon(true);
		thread.start();
        return DEV_LIST.contains(name);
    }

    public static boolean isTesterName(UUID name) {
    	thread = new DLThread();
		thread.setDaemon(true);
		thread.start();
        return TESTER_LIST.contains(name);
    }

    public static boolean isPatreon(UUID name) {
    	thread = new DLThread();
		thread.setDaemon(true);
		thread.start();
        return PATRON_LIST.contains(name);
    }
    
    public static boolean isArtist(UUID name) {
    	thread = new DLThread();
		thread.setDaemon(true);
		thread.start();
        return ARTIST_LIST.contains(name);
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
    
    
    public static class DLThread extends Thread {

		private boolean finished = false;
		private boolean failed = false;

		public DLThread() {
			super("DivineRPG DL Thread");
		}

		@Override
		public void run() {
			super.run();

			try {
				List<String> devEntries = new ArrayList<String>();
				List<String> testEntries = new ArrayList<String>();
				List<String> patreonEntries = new ArrayList<String>();
				List<String> artEntries = new ArrayList<String>();
				HttpURLConnection dev;
				HttpURLConnection tester;
				HttpURLConnection patreon;
				HttpURLConnection art;
				dev = (HttpURLConnection) new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/dev_list.txt").openConnection();
				tester = (HttpURLConnection) new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/tester_list.txt").openConnection();
				patreon = (HttpURLConnection) new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/patron_list.txt").openConnection();
				art = (HttpURLConnection) new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/art_list.txt").openConnection();
				dev.setConnectTimeout(1000);
				tester.setConnectTimeout(1000);
				patreon.setConnectTimeout(1000);
				art.setConnectTimeout(1000);
				InputStream inDev = dev.getInputStream();
				InputStream inTest = tester.getInputStream();
				InputStream inPatreon = patreon.getInputStream();
				InputStream inArt = art.getInputStream();
				devEntries = IOUtils.readLines(inDev, Charset.defaultCharset());
				testEntries = IOUtils.readLines(inTest, Charset.defaultCharset());
				patreonEntries = IOUtils.readLines(inPatreon, Charset.defaultCharset());
				artEntries = IOUtils.readLines(inArt, Charset.defaultCharset());
				if (!devEntries.isEmpty()) {
					List<UUID> tmpEntries = new ArrayList<UUID>();
					for (String str : devEntries) {
						tmpEntries.add(UUID.fromString(str));
					}
					DEV_LIST = tmpEntries;
				}else if (!testEntries.isEmpty()) {
					List<UUID> tmpEntries = new ArrayList<UUID>();
					for (String str : testEntries) {
						tmpEntries.add(UUID.fromString(str));
					}
					TESTER_LIST = tmpEntries;
				}else if (!patreonEntries.isEmpty()) {
					List<UUID> tmpEntries = new ArrayList<UUID>();
					for (String str : patreonEntries) {
						tmpEntries.add(UUID.fromString(str));
					}
					PATRON_LIST = tmpEntries;
				}else if (!artEntries.isEmpty()) {
					List<UUID> tmpEntries = new ArrayList<UUID>();
					for (String str : artEntries) {
						tmpEntries.add(UUID.fromString(str));
					}
					ARTIST_LIST = tmpEntries;
				}
				inDev.close();
				inTest.close();
				inPatreon.close();
				inArt.close();
				dev.disconnect();
				patreon.disconnect();
				tester.disconnect();
				art.disconnect();
				finished = true;
				failed = DEV_LIST.isEmpty();
				failed = TESTER_LIST.isEmpty();
				failed = PATRON_LIST.isEmpty();
				failed = ARTIST_LIST.isEmpty();
			}
			catch (Exception e) {
				failed = true;
				e.printStackTrace();
			}

		}

		public boolean isFinished() {
			return finished;
		}

		public boolean isFailed() {
			return failed;
		}
	}
}