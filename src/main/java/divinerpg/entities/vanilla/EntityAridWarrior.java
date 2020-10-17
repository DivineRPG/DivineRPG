package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAridWarrior extends EntityDivineMob implements IRangedAttackMob {

    public EntityAridWarrior(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().func_233815_a_(Attributes.field_233818_a_, 40.0D).func_233815_a_(Attributes.field_233823_f_, 8);
    }
    @Override
    protected void registerGoals() {
        addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.field_233821_d_).getBaseValue(), 1, (float)getAttribute(Attributes.field_233819_b_).getBaseValue()));
    }
    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Custom arrow
        this.world.addEntity(new ArrowEntity(world, this));
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARID_WARRIOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ARID_WARRIOR;
    }

}
