package divinerpg.utils.log;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Logging {
	private static Logging instance = null;

	public static long prevTicks = -1;
	public static boolean debugMode = false;

	public static boolean doLogging = false;

	public static void broadcast(String message) {
		FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList()
		        .sendMessage(new TextComponentString(message), false);
	}

	public static void broadcast(TextComponentBase base) {
		FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().sendMessage(base, false);
	}

	private static Logging getInstance() {
		if (instance == null) {
			instance = new Logging();
		}
		return instance;
	}

	public static Logger getLogger() {
		return getInstance().logger;
	}

	public static void log(String message) {
		getInstance().logger.log(Level.INFO, message);
	}

	public static void log(World world, TileEntity te, String message) {
		if (doLogging) {
			long ticks = world.getTotalWorldTime();
			if (ticks != prevTicks) {
				prevTicks = ticks;
				getInstance().logger.log(Level.INFO, "=== Time " + ticks + " ===");
			}
			String id = te.getPos().getX() + "," + te.getPos().getY() + "," + te.getPos().getZ() + ": ";
			getInstance().logger.log(Level.INFO, id + message);
		}
	}

	public static void logDebug(String message) {
		if (debugMode) {
			getInstance().logger.log(Level.INFO, message);
		}
	}

	public static void logError(String msg) {
		getLogger().log(Level.ERROR, msg);
	}

	public static void logError(String msg, Throwable e) {
		getLogger().error(msg, e);
	}

	public static void message(@Nonnull EntityPlayer player, String message) {
		player.sendStatusMessage(new TextComponentString(message), false);
	}

	public static void message(@Nonnull EntityPlayer player, TextComponentBase base) {
		player.sendStatusMessage(base, false);
	}

	public static void warn(@Nonnull EntityPlayer player, String message) {
		player.sendStatusMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.RED)),
		        false);

	}

	private Logger logger;

	private Logging() {
		logger = LogManager.getLogger();
		instance = this;
	}
}