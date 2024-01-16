package divinerpg.loot_modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class UnderwaterRuinBigModifier extends LootModifier {
	public static final Supplier<Codec<UnderwaterRuinBigModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, UnderwaterRuinBigModifier::new)));
	protected UnderwaterRuinBigModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }
	@Override @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= .4F) generatedLoot.add(new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "aquatic_coating_template")), 1));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}