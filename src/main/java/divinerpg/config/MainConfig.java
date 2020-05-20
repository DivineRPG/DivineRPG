package divinerpg.config;

import divinerpg.api.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
@Config(modid = Reference.MODID, name="divinerpg/main")
public class MainConfig {

    @Config.Name("Debug mode")
    @Config.Comment("Prints a bunch of extra, mostly unvetted information. Keep this disabled unless instructed")
    public static boolean debugMode = false;

    @Config.Name("Welcome messages")
    @Config.Comment("Set to false to disable the welcome messages for special players")
    public static boolean welcomeMessages = true;

    @Config.Name("Dimension IDs")
    @Config.Comment("Configure DivineRPG dimension IDs here. Don't change these unless you know what you're doing")
    @Config.RequiresMcRestart
    public static DimensionIDs dimensionIDs = new DimensionIDs();
    public static class DimensionIDs {
        @Config.Name("Eden")
        public int edenDimensionID = 420;
        @Config.Name("Wildwood")
        public int wildwoodDimensionID = 421;
        @Config.Name("Apalachia")
        public int apalachiaDimensionID = 422;
        @Config.Name("Skythern")
        public int skythernDimensionID = 423;
        @Config.Name("Mortum")
        public int mortumDimensionID = 424;
        @Config.Name("Iceika")
        public int iceikaDimensionID = 425;
        @Config.Name("Arcana")
        public int arcanaDimensionID = 426;
        @Config.Name("Vethea")
        public int vetheaDimensionID = 427;
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MODID)) {
            ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
            System.out.println("Sync done");
        }
    }
}
