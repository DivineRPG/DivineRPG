package divinerpg.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.EntityRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.CriterionValidator;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Optional;

public class LookAtEyeTrigger extends SimpleCriterionTrigger<LookAtEyeTrigger.TriggerInstance> {

    @Override
    public Codec<LookAtEyeTrigger.TriggerInstance> codec() {
        return LookAtEyeTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player, Entity entity) {
        if (isEyeEntity(entity)) { // Checks if the entity is "The Eye"
            LootContext context = EntityPredicate.createContext(player, entity);
            this.trigger(player, instance -> instance.matches(context));
        }
    }

    private boolean isEyeEntity(Entity entity) {
        return entity.getType().equals(EntityRegistry.THE_EYE.get()); // Assuming EntityRegistry.THE_EYE represents the entity type
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player, Optional<ContextAwarePredicate> eyeEntity)
            implements SimpleCriterionTrigger.SimpleInstance {

        public static final Codec<LookAtEyeTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                instance -> instance.group(
                        ContextAwarePredicate.CODEC.optionalFieldOf("player").forGetter(LookAtEyeTrigger.TriggerInstance::player),
                        ContextAwarePredicate.CODEC.optionalFieldOf("entity").forGetter(LookAtEyeTrigger.TriggerInstance::eyeEntity)
                ).apply(instance, LookAtEyeTrigger.TriggerInstance::new)
        );

        public static Criterion<LookAtEyeTrigger.TriggerInstance> playerLookedAtEye() {
            return CriteriaTriggers.register(
                    "looked_at_eye", new LookAtEyeTrigger()
            ).createCriterion(new LookAtEyeTrigger.TriggerInstance(
                    Optional.empty(),
                    Optional.of(createContextAwarePredicateForEntity(EntityPredicate.Builder.entity().of(EntityRegistry.THE_EYE.get()).build()))
            ));
        }

        public boolean matches(LootContext context) {
            return this.eyeEntity.isPresent() && this.eyeEntity.get().matches(context);
        }

        @Override
        public void validate(CriterionValidator validator) {
            SimpleCriterionTrigger.SimpleInstance.super.validate(validator);
            validator.validateEntity(this.eyeEntity, ".entity");
        }

        private static ContextAwarePredicate createContextAwarePredicateForEntity(EntityPredicate entityPredicate) {
            LootItemCondition condition = LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, entityPredicate).build();
            return ContextAwarePredicate.create(new LootItemCondition[] {condition});
        }
    }
}
