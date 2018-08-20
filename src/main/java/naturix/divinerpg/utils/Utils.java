package naturix.divinerpg.utils;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.projectile.serenade.EntitySerenadeOfIce;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Utils {
	public static int      mobID                  = 500, projectileID = 0, entityListID = 2500;

    public static DamageSource trapSource = new DamageSource("trap");
    public static DamageSource acidSource = new DamageSource("acid");
    public static DamageSource spikeSource = new DamageSource("spike");
	
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

		public static ITextComponent addChatMessage(ITextComponent displayName) {
			TextComponentString ret = new TextComponentString(args + str);
	        ret.getStyle().setColor(TextFormatting.WHITE);
	        return ret; 
		}
		public static void registerProjectile(Class entityClass, String entityName) {
	        EntityRegistry.registerModEntity(new ModelResourceLocation(DivineRPG.modId + ":serenadeofice"), EntitySerenadeOfIce.class, "serenadeofice", mobID++, DivineRPG.instance, 250, 5, true);
	        projectileID++;
	    }
		
	    }
