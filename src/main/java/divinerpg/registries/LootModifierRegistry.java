package divinerpg.registries;

import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import divinerpg.loot_modifiers.AbandonedMineshaftChestModifier;
import divinerpg.loot_modifiers.JungleTempleChestModifier;
import divinerpg.loot_modifiers.SpawnBonusChestModifier;
import divinerpg.loot_modifiers.UnderwaterRuinBigModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootModifierRegistry {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DivineRPG.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<SpawnBonusChestModifier>> SPAWN_BONUS_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("spawn_bonus_modifier", () -> SpawnBonusChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AbandonedMineshaftChestModifier>> ABANDONED_MINESHAFT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("abandoned_mineshaft_modifier", () -> AbandonedMineshaftChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<JungleTempleChestModifier>> JUNGLE_TEMPLE_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("jungle_temple_modifier", () -> JungleTempleChestModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<UnderwaterRuinBigModifier>> UNDERWATER_RUIN_BIG_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("underwater_ruin_big_modifier", () -> UnderwaterRuinBigModifier.CODEC);
}