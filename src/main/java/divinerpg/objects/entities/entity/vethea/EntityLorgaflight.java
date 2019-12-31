package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EntityLorgaflight extends VetheaMob {

    private int spawnTick;
    private boolean canSpawnMinions;

    public EntityLorgaflight(World worldIn) {
        this(worldIn, false); //lorgaflights sterile for now
    }

    private EntityLorgaflight(World worldIn, boolean canSpawnMinions) {
        super(worldIn);
        this.setSize(1F, 2.4f);
        this.canSpawnMinions = canSpawnMinions;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        List<EntityLorgaflight> nearby = this.world.getEntitiesWithinAABB(EntityLorgaflight.class, this.getEntityBoundingBox().expand(10, 10, 10));
        if(!this.canSpawnMinions) {
            return;
        }
        else {
            if (!this.world.isRemote && this.spawnTick == 0 && nearby.size() < 12) {
                this.spawnTick = 260;
                EntityLorgaflight var2 = new EntityLorgaflight(this.world, false);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);
            }
            else if (this.spawnTick > 0) {
                this.spawnTick--;
            }
        }
    }
    
    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_LORGAFLIGHT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LORGAFLIGHT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.LORGAFLIGHT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.LORGAFLIGHT_HURT;
    }

}
