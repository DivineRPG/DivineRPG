package net.divinerpg.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.divinerpg.registries.BlockRegistry;
import net.divinerpg.registries.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class JungleTempleChestModifier extends LootModifier {
    public static final MapCodec<JungleTempleChestModifier> CODEC = RecordCodecBuilder.mapCodec(
            (RecordCodecBuilder.Instance<JungleTempleChestModifier> instance) ->
                    codecStart(instance).apply(instance, JungleTempleChestModifier::new)
    );

    public JungleTempleChestModifier(LootItemCondition[] conditionsIn, int priority) {
        super(conditionsIn, priority);
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= 0.3F) {
            ItemStack toAdd = new ItemStack(ItemRegistry.jungle_shards.get(), 1 + context.getRandom().nextInt(3));
            generatedLoot.add(toAdd);
        }

        if(context.getRandom().nextFloat() <= 0.5F) {
            ItemStack toAdd = new ItemStack(BlockRegistry.jungleSpiderPumpkin.asItem(), 1 + context.getRandom().nextInt(1));
            generatedLoot.add(toAdd);
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}