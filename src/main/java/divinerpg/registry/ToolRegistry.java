package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.objects.items.base.ItemModAxe;
import divinerpg.objects.items.base.ItemModHoe;
import divinerpg.objects.items.base.ItemModPickaxe;
import divinerpg.objects.items.base.ItemModShovel;
import divinerpg.objects.items.vanilla.ItemShickaxe;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created to ensure that tools are registered after items, due to ToolMaterials requiring item instances.
 * Any tools must go here.
 */
@Mod.EventBusSubscriber
@ObjectHolder("divinerpg")
public class ToolRegistry {

    @ObjectHolder("arlemite_shovel")
    public static final Item arlemiteShovel = null;
    @ObjectHolder("arlemite_pickaxe")
    public static final Item arlemitePickaxe = null;
    @ObjectHolder("arlemite_axe")
    public static final Item arlemiteAxe = null;
    @ObjectHolder("arlemite_hoe")
    public static final Item arlemiteHoe = null;
    @ObjectHolder("arlemite_shickaxe")
    public static final Item arlemiteShickaxe = null;

    @ObjectHolder("bedrock_shovel")
    public static final Item bedrockShovel = null;
    @ObjectHolder("bedrock_pickaxe")
    public static final Item bedrockPickaxe = null;
    @ObjectHolder("bedrock_axe")
    public static final Item bedrockAxe = null;

    @ObjectHolder("corrupted_shovel")
    public static final Item corruptedShovel = null;
    @ObjectHolder("corrupted_pickaxe")
    public static final Item corruptedPickaxe = null;
    @ObjectHolder("corrupted_axe")
    public static final Item corruptedAxe = null;

    @ObjectHolder("divine_shovel")
    public static final Item divineShovel = null;
    @ObjectHolder("divine_pickaxe")
    public static final Item divinePickaxe = null;
    @ObjectHolder("divine_axe")
    public static final Item divineAxe = null;
    @ObjectHolder("divine_shickaxe")
    public static final Item divineShickaxe = null;

    @ObjectHolder("realmite_shovel")
    public static final Item realmiteShovel = null;
    @ObjectHolder("realmite_pickaxe")
    public static final Item realmitePickaxe = null;
    @ObjectHolder("realmite_axe")
    public static final Item realmiteAxe = null;
    @ObjectHolder("realmite_hoe")
    public static final Item realmiteHoe = null;

    @ObjectHolder("rupee_shovel")
    public static final Item rupeeShovel = null;
    @ObjectHolder("rupee_pickaxe")
    public static final Item rupeePickaxe = null;
    @ObjectHolder("rupee_axe")
    public static final Item rupeeAxe = null;
    @ObjectHolder("rupee_hoe")
    public static final Item rupeeHoe = null;
    @ObjectHolder("rupee_shickaxe")
    public static final Item rupeeShickaxe = null;

    // Twilight tools
    @ObjectHolder("eden_shovel")
    public static final Item edenShovel = null;
    @ObjectHolder("eden_pickaxe")
    public static final Item edenPickaxe = null;
    @ObjectHolder("eden_axe")
    public static final Item edenAxe = null;

    @ObjectHolder("wildwood_shovel")
    public static final Item wildwoodShovel = null;
    @ObjectHolder("wildwood_pickaxe")
    public static final Item wildwoodPickaxe = null;
    @ObjectHolder("wildwood_axe")
    public static final Item wildwoodAxe = null;

    @ObjectHolder("apalachia_shovel")
    public static final Item apalachiaShovel = null;
    @ObjectHolder("apalachia_pickaxe")
    public static final Item apalachiaPickaxe = null;
    @ObjectHolder("apalachia_axe")
    public static final Item apalachiaAxe = null;

    @ObjectHolder("skythern_shovel")
    public static final Item skythernShovel = null;
    @ObjectHolder("skythern_pickaxe")
    public static final Item skythernPickaxe = null;
    @ObjectHolder("skythern_axe")
    public static final Item skythernAxe = null;

    @ObjectHolder("mortum_shovel")
    public static final Item mortumShovel = null;
    @ObjectHolder("mortum_pickaxe")
    public static final Item mortumPickaxe = null;
    @ObjectHolder("mortum_axe")
    public static final Item mortumAxe = null;

    // Vethea tools
    @ObjectHolder("dream_shovel")
    public static final Item dreamShovel = null;
    @ObjectHolder("dream_pickaxe")
    public static final Item dreamPickaxe = null;
    @ObjectHolder("dream_axe")
    public static final Item dreamAxe = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        DivineRPG.logger.info("Registering DivineRPG tools");

        IForgeRegistry<Item> registry = event.getRegistry();

        // Vanilla dimension tools
        register(registry, new ItemModShovel(MaterialRegistry.ARLEMITE_SHOVEL, "arlemite_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.ARLEMITE_PICKAXE, "arlemite_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.ARLEMITE_AXE, "arlemite_axe"));
        register(registry, new ItemModHoe(MaterialRegistry.ARLEMITE_PICKAXE, "arlemite_hoe"));
        register(registry, new ItemShickaxe(MaterialRegistry.ARLEMITE_SHICKAXE, "arlemite_shickaxe"));

        register(registry, new ItemModShovel(MaterialRegistry.BEDROCK_SHOVEL, "bedrock_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.BEDROCK_PICKAXE, "bedrock_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.BEDROCK_AXE, "bedrock_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.CORRUPTED_SHOVEL, "corrupted_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.CORRUPTED_PICKAXE, "corrupted_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.CORRUPTED_AXE, "corrupted_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.DIVINE_SHOVEL, "divine_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.DIVINE_PICKAXE, "divine_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.DIVINE_AXE, "divine_axe"));
        register(registry, new ItemShickaxe(MaterialRegistry.DIVINE_SHICKAXE, "divine_shickaxe"));

        register(registry, new ItemModShovel(MaterialRegistry.REALMITE_SHOVEL, "realmite_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.REALMITE_PICKAXE, "realmite_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.REALMITE_AXE, "realmite_axe"));
        register(registry, new ItemModHoe(MaterialRegistry.REALMITE_PICKAXE, "realmite_hoe"));

        register(registry, new ItemModShovel(MaterialRegistry.RUPEE_SHOVEL, "rupee_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.RUPEE_PICKAXE, "rupee_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.RUPEE_AXE, "rupee_axe"));
        register(registry, new ItemModHoe(MaterialRegistry.RUPEE_PICKAXE, "rupee_hoe"));
        register(registry, new ItemShickaxe(MaterialRegistry.RUPEE_SHICKAXE, "rupee_shickaxe"));

        // Twilight tools
        register(registry, new ItemModShovel(MaterialRegistry.EDEN_SHOVEL, "eden_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.EDEN_PICKAXE, "eden_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.EDEN_AXE, "eden_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.WILDWOOD_SHOVEL, "wildwood_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.WILDWOOD_PICKAXE, "wildwood_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.WILDWOOD_AXE, "wildwood_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.APALACHIA_SHOVEL, "apalachia_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.APALACHIA_PICKAXE, "apalachia_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.APALACHIA_AXE, "apalachia_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.SKYTHERN_SHOVEL, "skythern_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.SKYTHERN_PICKAXE, "skythern_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.SKYTHERN_AXE, "skythern_axe"));

        register(registry, new ItemModShovel(MaterialRegistry.MORTUM_SHOVEL, "mortum_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.MORTUM_PICKAXE, "mortum_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.MORTUM_AXE, "mortum_axe"));

        // Vethea tools
        register(registry, new ItemModShovel(MaterialRegistry.DREAM_SHOVEL, "dream_shovel"));
        register(registry, new ItemModPickaxe(MaterialRegistry.DREAM_PICKAXE, "dream_pickaxe"));
        register(registry, new ItemModAxe(MaterialRegistry.DREAM_AXE, "dream_axe"));
    }

    private static void register(IForgeRegistry<Item> registry, Item item) {
        registry.register(item);
        ItemRegistry.itemMap.put(item.getRegistryName().getResourcePath(), item);
    }
}
