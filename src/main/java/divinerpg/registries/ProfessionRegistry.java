package divinerpg.registries;

import divinerpg.DivineRPG;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProfessionRegistry {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, DivineRPG.MODID);
    //ARCANA
    public static final DeferredHolder<VillagerProfession, VillagerProfession> CAPTAIN_MERIK = register("captain_merik", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> DATTICON = register("datticon", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> KAZARI = register("kazari", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> LEORNA = register("leorna", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> LORD_VATTICUS = register("lord_vatticus", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> WAR_GENERAL = register("war_general", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> ZELUS = register("zelus", PoiType.NONE, null);
    //ICEIKA
    public static final DeferredHolder<VillagerProfession, VillagerProfession> WORKSHOP_MERCHANT = register("workshop_merchant", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> WORKSHOP_TINKERER = register("workshop_tinkerer", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> GROGLIN = register("groglin", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> GRUZZORLUG = register("gruzzorlug", PoiType.NONE, null);
    //OVERWORLD
    public static final DeferredHolder<VillagerProfession, VillagerProfession> DIAMOND_DAVE = register("diamond_dave", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> JACK_O_MAN = register("jack_o_man", PoiType.NONE, null);
    public static final DeferredHolder<VillagerProfession, VillagerProfession> LIVESTOCK_MERCHANT = register("livestock_merchant", PoiType.NONE, null);
    //VETHEA
    public static final DeferredHolder<VillagerProfession, VillagerProfession> THE_HUNGER = register("the_hunger", PoiType.NONE, null);

    private static DeferredHolder<VillagerProfession, VillagerProfession> register(String name, Predicate<Holder<PoiType>> job, @Nullable SoundEvent sound) {
        return register(name, job, PoiType.NONE, ImmutableSet::of, ImmutableSet::of, sound);
    }

    private static DeferredHolder<VillagerProfession, VillagerProfession> register(String name, Predicate<Holder<PoiType>> job, Predicate<Holder<PoiType>> job2, Supplier<ImmutableSet<Item>> focusItem, Supplier<ImmutableSet<Block>> blockPoi, @Nullable SoundEvent sound) {
        return PROFESSIONS.register(name, () -> new VillagerProfession(name, job, job2, focusItem.get(), blockPoi.get(), sound));
    }

}
