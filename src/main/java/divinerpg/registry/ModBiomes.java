package divinerpg.registry;

import divinerpg.api.Reference;
import divinerpg.dimensions.apalachia.BiomeApalachia;
import divinerpg.dimensions.arcana.BiomeArcana;
import divinerpg.dimensions.eden.BiomeEden;
import divinerpg.dimensions.iceika.BiomeIceika;
import divinerpg.dimensions.mortum.BiomeMortum;
import divinerpg.dimensions.skythern.BiomeSkythern;
import divinerpg.dimensions.vethea.BiomeVethea;
import divinerpg.dimensions.wildwood.BiomeWildWood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBiomes {

    @ObjectHolder("divinerpg:eden")
    public static final Biome biomeEden = new BiomeEden();
    @ObjectHolder("divinerpg:wildwood")
    public static final Biome biomeWildwood = new BiomeWildWood();
    @ObjectHolder("divinerpg:apalachia")
    public static final Biome biomeApalachia = new BiomeApalachia();
    @ObjectHolder("divinerpg:skythern")
    public static final Biome biomeSkythern = new BiomeSkythern();
    @ObjectHolder("divinerpg:mortum")
    public static final Biome biomeMortum = new BiomeMortum();
    @ObjectHolder("divinerpg:iceika")
    public static final Biome biomeIceika = new BiomeIceika();
    @ObjectHolder("divinerpg:arcana")
    public static final Biome biomeArcana = new BiomeArcana();
    @ObjectHolder("divinerpg:vethea")
    public static final Biome biomeVethea = new BiomeVethea();

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.registerAll(
                biomeEden,
                biomeWildwood,
                biomeApalachia,
                biomeSkythern,
                biomeMortum,
                biomeIceika,
                biomeArcana,
                biomeVethea
        );

        addBiomeTypes();
    }

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(biomeEden, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeWildwood, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeApalachia, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeSkythern, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeMortum, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeIceika, Type.MAGICAL, Type.SNOWY);
        BiomeDictionary.addTypes(biomeArcana, Type.MAGICAL);
        BiomeDictionary.addTypes(biomeVethea, Type.MAGICAL, Type.SPOOKY);
    }
}