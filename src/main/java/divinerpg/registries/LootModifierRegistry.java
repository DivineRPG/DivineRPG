package divinerpg.registries;

import com.mojang.serialization.MapCodec;
import divinerpg.loot_modifiers.*;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LootModifierRegistry {

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AbandonedMineshaftChestModifier>> ABANDONED_MINESHAFT_MODIFIER = DivineRegistries.LOOT_MODIFIERS.register("abandoned_mineshaft_modifier", () -> AbandonedMineshaftChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<JungleTempleChestModifier>> JUNGLE_TEMPLE_MODIFIER = DivineRegistries.LOOT_MODIFIERS.register("jungle_temple_modifier", () -> JungleTempleChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<SpawnBonusChestModifier>> SPAWN_BONUS_MODIFIER = DivineRegistries.LOOT_MODIFIERS.register("spawn_bonus_modifier", () -> SpawnBonusChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<UnderwaterRuinBigModifier>> UNDERWATER_RUIN_BIG_MODIFIER = DivineRegistries.LOOT_MODIFIERS.register("underwater_ruin_big_modifier", () -> UnderwaterRuinBigModifier.CODEC);
    public static void load() {}
}
