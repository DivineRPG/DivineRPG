package net.divinerpg.data;

import net.divinerpg.loot_modifiers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        add("abandoned_mineshaft_chest", new AbandonedMineshaftChestModifier(new LootItemCondition[]{new LootTableIdCondition.Builder(Identifier.parse("chests/abandoned_mineshaft")).build()}, 1));
        add("jungle_temple_chest", new AbandonedMineshaftChestModifier(new LootItemCondition[]{new LootTableIdCondition.Builder(Identifier.parse("chests/jungle_temple")).build()}, 1));
        add("spawn_bonus_chest", new SpawnBonusChestModifier(new LootItemCondition[]{LootTableIdCondition.builder(Identifier.parse("chests/spawn_bonus")).build()}, 1));
        add("underwater_ruin_big", new UnderwaterRuinBigModifier(new LootItemCondition[]{LootTableIdCondition.builder(Identifier.parse("chests/underwater_ruin_big")).build()}, 1));
    }
}