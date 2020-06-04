package divinerpg.objects.entities.entity.boss;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntityLadyLunaSparkler;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityLadyLuna extends EntityDivineBoss {

    public enum ProtectionType {
        ARCANA(0), RANGED(1), MELEE(2);

        private int numVal;

        ProtectionType(int numVal) {
            this.numVal = numVal;
        }

        public int value() {
            return numVal;
        }
    }

    public ProtectionType protectionType;
    private int protectionTimer;

    private List<BlockPos> acidPositions = new ArrayList<BlockPos>();

    public EntityLadyLuna(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3.5f);
        this.setRandomProtectionValues();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_LADY_LUNA;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);


    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.world.isRemote && this.ticksExisted % 5 == 0) {
            for (int x = (int) this.posX - 2; x < (int) this.posX + 2; x++) {
                for (int y = (int) this.getEntityBoundingBox().minY; y < (int) this.getEntityBoundingBox().minY + 4; y++) {
                    for (int z = (int) this.posZ - 2; z < (int) this.posZ + 2; z++) {
                        if (this.world.getBlockState(new BlockPos(x, y, z)).getMaterial() == Material.LEAVES || this.world.getBlockState(new BlockPos(x, y, z)).getMaterial() == Material.WOOD)
                            this.world.setBlockToAir(new BlockPos(x, y, z));
                    }
                }
            }
        }

        BlockPos current = new BlockPos((int)posX - 1, (int)posY, (int)posZ - 1);
        BlockPos below = new BlockPos((int)posX - 1, (int)posY - 1, (int)posZ - 1);
        IBlockState belowState = this.world.getBlockState(below);

        if(this.world.getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.isOpaqueCube() && belowState.isFullCube()) {
                this.world.setBlockState(current, BlockRegistry.lunicAcid.getDefaultState());
                acidPositions.add(current);
            }
        }

        if (!this.world.isRemote && this.getProtectionType() == ProtectionType.ARCANA && this.ticksExisted % 30 == 0) {
            Iterator<BlockPos> iter = this.acidPositions.iterator();
            while (iter.hasNext()) {
                BlockPos pos = iter.next();

                if (this.world.getBlockState(pos).getBlock() != BlockRegistry.lunicAcid) iter.remove();
                else if (this.rand.nextInt(4) == 0) {
                    EntityLadyLunaSparkler e = new EntityLadyLunaSparkler(this.world, this);
                    e.setPosition(pos.getX() + 0.5, pos.getY() + 0, pos.getZ() + 0.5);
                    this.world.spawnEntity(e);
                }
            }
        }

        if (this.getProtectionTimer() <= 0) {
            this.setRandomProtectionValues();
        } else if (this.getProtectionTimer() > 0) {
            this.setProtectionTimer(getProtectionTimer() - 1);
        }
    }

    public void setProtectionType(ProtectionType type) {
        if(type == ProtectionType.ARCANA) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
        }
        else
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
       this.protectionType = type;
    }

    public void setProtectionTimer(int i) {
        this.protectionTimer = i;
    }

    public ProtectionType getProtectionType() {
        return this.protectionType;
    }

    public int getProtectionTimer() {
        return this.protectionTimer;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion()) return false;

        ProtectionType type = this.getProtectionType();
        if (source.isMagicDamage() && type == ProtectionType.ARCANA)
            return false;
        else if ((source.isProjectile() || source.damageType.equals("thrown")) && type == ProtectionType.RANGED)
            return false;
        else if (!source.isProjectile() && !source.isMagicDamage() && type == ProtectionType.MELEE)
            return false;
        return super.attackEntityFrom(source, par2);
    }

    @Override
    public boolean attackEntityAsMob(Entity e) {
        int dam = 20;

        boolean var4 = e.attackEntityFrom(DamageSource.causeMobDamage(this), dam);
        if (var4) {
            this.world.createExplosion(this, e.posX, e.posY, e.posZ, 2, false);
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
            int var5 = EnchantmentHelper.getFireAspectModifier(this);
            if (var5 > 0)
                e.setFire(var5 * 4);
        }
        return var4;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("Immunity", this.getProtectionType().value());
        tag.setInteger("ImmunityCooldown", this.getProtectionTimer());
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.setProtectionType(protectionTypeForInt(tag.getInteger("Immunity")));
        this.setProtectionTimer(tag.getInteger("ImmunityCooldown"));
    }

    private static ProtectionType protectionTypeForInt(int i) {
        switch(i) {
            case 0:
                return ProtectionType.ARCANA;
            case 1:
                return ProtectionType.RANGED;
            case 2:
                return ProtectionType.MELEE;
            default:
                return null;
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    private void setRandomProtectionValues() {
        this.setProtectionType(protectionTypeForInt(this.rand.nextInt(3)));
        this.setProtectionTimer(200 + this.rand.nextInt(200));
    }

}
