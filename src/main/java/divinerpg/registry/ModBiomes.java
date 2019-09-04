package divinerpg.registry;

import java.util.ArrayList;

import divinerpg.Reference;
import divinerpg.dimensions.apalachia.BiomeApalachia;
import divinerpg.dimensions.arcana.BiomeArcana;
import divinerpg.dimensions.eden.BiomeEden;
import divinerpg.dimensions.iceika.BiomeIceika;
import divinerpg.dimensions.mortum.BiomeMortum;
import divinerpg.dimensions.skythern.BiomeSkythern;
import divinerpg.dimensions.wildwood.BiomeWildWood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBiomes {
    public static final Biome Eden = new BiomeEden();
    public static final Biome WildWood = new BiomeWildWood();
    public static final Biome Apalachia = new BiomeApalachia();
    public static final Biome Skythern = new BiomeSkythern();
    public static final Biome Mortum = new BiomeMortum();
    public static final Biome Iceika = new BiomeIceika();
    public static final Biome Arcana = new BiomeArcana();

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.registerAll(
                Eden,
                WildWood,
                Apalachia,
                Skythern,
                Mortum,
                Iceika,
                Arcana
        );

        addBiomeTypes();
    }

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(Eden, Type.MAGICAL);
        BiomeDictionary.addTypes(WildWood, Type.MAGICAL);
        BiomeDictionary.addTypes(Apalachia, Type.MAGICAL);
        BiomeDictionary.addTypes(Skythern, Type.MAGICAL);
        BiomeDictionary.addTypes(Mortum, Type.MAGICAL);
        BiomeDictionary.addTypes(Iceika, Type.MAGICAL, Type.SNOWY);
        BiomeDictionary.addTypes(Arcana, Type.MAGICAL);
    }
}