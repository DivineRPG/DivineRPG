package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.vethea.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.particles.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityHiveQueen extends EntityDivineBoss {

    private int spawnTick;
    private int deathTicks;

    public EntityHiveQueen(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        addAttackingAI();
        spawnTick=80;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hiveQueenHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.hiveQueenDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.hiveQueenSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.hiveQueenFollowRange);
    }
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getHealth() > 0) {
            if (this.spawnTick % 40 == 0 && !this.level.isClientSide && this.level.getNearestPlayer(this, 20) != null) {
                if (this.random.nextBoolean()) {
                    EntityHoverStinger var2 = new EntityHoverStinger(EntityRegistry.HOVER_STINGER, level);
                    var2.moveTo(this.getX(), this.getY(), this.getZ(), this.random.nextFloat() * 360.0F, 0.0F);
                    this.level.addFreshEntity(var2);
                    this.level.addParticle(RedstoneParticleData.REDSTONE, var2.xo, var2.yo, var2.zo, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1);
                } else {
                    EntityHiveSoldier var2 = new EntityHiveSoldier(EntityRegistry.HIVE_SOLDIER, this.level);
                    var2.moveTo(this.xo, this.yo, this.zo, this.random.nextFloat() * 360.0F, 0.0F);
                    this.level.addFreshEntity(var2);
                    this.level.addParticle(RedstoneParticleData.REDSTONE, var2.xo, var2.yo, var2.zo, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1, random.nextGaussian() * 2 - 1);
                }
                spawnTick = 80;
            }

            this.spawnTick--;
        }
    }
}
