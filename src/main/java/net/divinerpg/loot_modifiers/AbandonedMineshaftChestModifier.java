package net.divinerpg.loot_modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.divinerpg.registries.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class AbandonedMineshaftChestModifier extends LootModifier {
    public static final MapCodec<AbandonedMineshaftChestModifier> CODEC = RecordCodecBuilder.mapCodec(
            (RecordCodecBuilder.Instance<AbandonedMineshaftChestModifier> instance) ->
                    codecStart(instance).apply(instance, AbandonedMineshaftChestModifier::new)
    );

    public AbandonedMineshaftChestModifier(LootItemCondition[] conditionsIn, int priority) {
        super(conditionsIn, priority);
    }

    @NotNull
    @Override protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= .5) {
            ItemStack toAdd = new ItemStack(ItemRegistry.realmite_pickaxe.get(), 1);
            generatedLoot.add(toAdd);
        } if(context.getRandom().nextFloat() <= .3) {
            ItemStack toAdd = new ItemStack(ItemRegistry.skeleton_torch.get(), 4 + context.getRandom().nextInt(4));
            generatedLoot.add(toAdd);
        } return generatedLoot;
    }
    @Override public MapCodec<? extends IGlobalLootModifier> codec() {return CODEC;}
}