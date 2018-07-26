package naturix.divinerpg.utils;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class Utils {
	public static int MINS2TICKS(int mins) {
		return mins * 1200;
		}

		public static int SECS2TICKS(int secs) {
		return secs * 20;
		}
		public static ITextComponent getChatComponent(String str) {
	        TextComponentString ret = new TextComponentString(str);
	        return ret;
	    }
}
