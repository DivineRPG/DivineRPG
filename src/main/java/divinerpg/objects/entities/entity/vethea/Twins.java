package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Twins extends VetheaMob implements IRangedAttackMob {

    public static final int SLOW = 0, FAST = 1;
    public static int ability;
    private int abilityCoolDown;
    private int rangedAttackCounter;

    public Twins(World worldIn) {
		super(worldIn);
		this.setSize(1.1F, 2f);
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 1, 15, 60, 15));
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
        switch(ability) {
            case FAST:
                EntityArrow var2 = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, entity, 1.6f, 12);
                var2.setDamage(2);
                this.world.spawnEntity(var2);
                break;
            case SLOW:
                this.rangedAttackCounter++;
                if ((this.rangedAttackCounter & 4) == 0) {
                    EntityArrow arrow = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, entity, 1.6f, 12);
                    arrow.setDamage(4);
                    this.world.spawnEntity(arrow);
                    break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void setSwingingArms(boolean b) {
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_TWINS;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DUO_HURT;
    }
}
