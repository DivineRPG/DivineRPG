package naturix.divinerpg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import naturix.divinerpg.entities.assets.render.RenderHat;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Utils {
	public static int      mobID                  = 500, projectileID = 0, entityListID = 2500;

    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource spikeSource = new DamageSource("spike");
    public static void postForgeEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }

    public static void postFMLEvent(Object o) {
        FMLCommonHandler.instance().bus().register(o);
    }
		private static String str;
		private static Object args;
		public static ITextComponent getChatComponent(String str) {
	        TextComponentString ret = new TextComponentString(str);
	        return ret;
	    }
		public static TextComponentString addChatMessage(String str, Object... args) {
	        TextComponentString ret = new TextComponentString(args + str);
	        ret.getStyle().setColor(TextFormatting.WHITE);
	        return ret; 
	    }
		public static ITextComponent getChatComponent(String str, String args) {
			TextComponentString ret = new TextComponentString(args + str);
	        ret.getStyle().setColor(TextFormatting.WHITE);
	        return ret;
		}
		public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73", DARK_RED = "\u00a74";
	    public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78", BLUE = "\u00a79";
	    public static String GREEN       = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d", YELLOW = "\u00a7e";
	    public static String WHITE       = "\u00a7f";

	    public static final String[] devs = { "RadioactiveStud", "Eternaldoom1", "BossLetsPlays", "Xolova", "sheenrox82", "The_SlayerMC", "insanity414all", "deathman12e3", "Fire_Sight", "krwminer", "NicosaurusRex99", "LiteWolf101" };

	    @SuppressWarnings("unlikely-arg-type")
		public static boolean isDeveloperName(ITextComponent iTextComponent) {
			for(int i = 0; i < devs.length; i++){
				if(iTextComponent.equals(devs[i]))return true;
			}
			return false;
		}

		public static Map<AbstractClientPlayer, RenderHat.Type> REGISTRY = new LinkedHashMap<>();
	    public static boolean isContributor(AbstractClientPlayer player) {
			return player != null && REGISTRY.containsKey(player);
		}
		public static ITextComponent addChatMessage(ITextComponent displayName) {
			TextComponentString ret = new TextComponentString(args + str);
	        ret.getStyle().setColor(TextFormatting.WHITE);
	        return ret; 
		}

		public static RenderHat.Type getWingType(AbstractClientPlayer player) {
			if (player != null) {
				if (REGISTRY.containsKey(player)) {
					return REGISTRY.get(player);
				}
			}
			return null;
		}
		private static List<String> PATRON_LIST = new ArrayList<String>();
		
		static List<String> getPatronList() {
			try {
				List<String> entries = new ArrayList<String>();
				HttpURLConnection con;
				con = (HttpURLConnection) new URL("https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/dev.txt").openConnection();
				con.setConnectTimeout(1000);
				InputStream in2 = con.getInputStream();
				entries = IOUtils.readLines(in2);
				if (!entries.isEmpty()) {
					con.disconnect();
					return entries;
				}
			}
			catch (IOException e) {
			}
			return null;
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
	    }
