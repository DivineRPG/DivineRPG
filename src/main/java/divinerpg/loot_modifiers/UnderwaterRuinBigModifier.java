package divinerpg.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.ItemRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.*;
import org.jetbrains.annotations.NotNull;

public class UnderwaterRuinBigModifier extends LootModifier {
    public static final MapCodec<UnderwaterRuinBigModifier> CODEC = RecordCodecBuilder.mapCodec(builder -> codecStart(builder).apply(builder, UnderwaterRuinBigModifier::new));
	protected UnderwaterRuinBigModifier(LootItemCondition[] conditionsIn) {super(conditionsIn);}
	@Override @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= .4) generatedLoot.add(new ItemStack(ItemRegistry.aquatic_coating_template.get(), 1));
        return generatedLoot;
    }
    @Override public MapCodec<? extends IGlobalLootModifier> codec() {return CODEC;}
}