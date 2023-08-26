package divinerpg.entities.boss;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

import static divinerpg.registries.SoundRegistry.*;

public class EntityAyeraco extends EntityDivineBoss {
	public BlockPos beam = BlockPos.ZERO;
	private static final EntityDataAccessor<Byte> VARIANT = SynchedEntityData.defineId(Mob.class, EntityDataSerializers.BYTE);
	private EntityAyeraco[] group = new EntityAyeraco[5];
	private boolean angry, empowered, projectileProtected, magicProtected, canTeleport, canHeal, fast;
	private boolean broadcast = false;
	private CompoundTag tag;
	
	private Vec3 moveTargetPoint = Vec3.ZERO;
	private boolean circling = true;
	private BlockPos anchorPoint = BlockPos.ZERO;
	public EntityAyeraco(EntityType<? extends Monster> type, Level level) {
		this(type, level, BlockPos.ZERO, (byte) 6, null);
	}
	public EntityAyeraco(EntityType<? extends Monster> type, Level level, BlockPos beam, byte variant) {
		this(type, level, beam, variant, null);
	}
	public EntityAyeraco(EntityType<? extends Monster> type, Level worldIn, BlockPos beam, byte variant, EntityAyeraco[] group) {
		super(type, worldIn);
		this.beam = beam;
		entityData.set(VARIANT, variant);
		moveControl = new AyeracoMoveControl(this);
		lookControl = new AyeracoLookControl(this);
		assignGroup(group);
	}
    @Override
    protected BodyRotationControl createBodyControl() {
        return new AyeracoBodyRotationControl(this);
	}
    @Override
    protected void registerGoals() {
    	goalSelector.addGoal(1, new AyeracoAttackStrategyGoal());
    	goalSelector.addGoal(2, new AyeracoSweepAttackGoal());
    	goalSelector.addGoal(3, new AyeracoCircleAroundAnchorGoal());
    	targetSelector.addGoal(1, new AyeracoAttackPlayerTargetGoal());
    }
	public EntityAyeraco assignGroup(EntityAyeraco[] group) {
		this.group = group == null || group.length != 5 ? new EntityAyeraco[1] : group;
		if(this.group.length == 5) updateAbilities();
		return this;
	}
	public void updateAbilities() {
		updateAbilities(angry = getHealth() < getMaxHealth() / 2F);
	}
	public void updateAbilities(boolean angry) {
		if(!level().isClientSide()) {
			switch(entityData.get(VARIANT)) {
			case 0: for(EntityAyeraco entity : group) if(entity != null) entity.empowered = angry; break;
			case 1: for(EntityAyeraco entity : group) if(entity != null) entity.projectileProtected = angry; break;
			case 2: for(EntityAyeraco entity : group) if(entity != null) entity.magicProtected = angry; break;
			case 3: for(EntityAyeraco entity : group) if(entity != null) entity.canTeleport = angry; break;
			case 4: for(EntityAyeraco entity : group) if(entity != null) entity.canHeal = angry; break;
			case 5: for(EntityAyeraco entity : group) if(entity != null) entity.fast = angry; break;
			default: break; };
			if(angry && isAlive()) {
				boolean b = group[0] == null;
				for(byte by = 1; b && by < 5; by++) b = group[by] == null;
				if(b) empowered = projectileProtected = magicProtected = canTeleport = fast = true;
			}
			if(empowered && isAlive()) addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 255, 2, true, false, false));
			else removeEffect(MobEffects.DAMAGE_BOOST);
			if(fast && isAlive()) addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 255, 2, true, false, false));
	    	else removeEffect(MobEffects.MOVEMENT_SPEED);
			if(canTeleport && isAlive()) {
				playSound(SoundRegistry.AYERACO_TELEPORT.get(), 2.0F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
				moveTo(getX() + random.nextInt(5) - 2, getY() + 3 + random.nextInt(15), getZ() + random.nextInt(5) - 2);
			}
		}
	}
	@Override
	public void die(DamageSource source) {
		super.die(source);
		updateAbilities(false);
        if(level().isLoaded(beam)) level().setBlock(beam, Blocks.AIR.defaultBlockState(), 3);
        if(group != null) for(EntityAyeraco ayeraco : group) if(ayeraco != null) ayeraco.removeFromGroup(entityData.get(VARIANT));
	}
	public void removeFromGroup(byte variant) {
		for(int i = 0; i < 5; i++) {
			EntityAyeraco ayeraco = group[i];
			if(ayeraco != null && ayeraco.entityData.get(VARIANT) == variant) group[i] = null;
		}
	}
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if(isInvulnerableTo(source) || (projectileProtected && source.is(DamageTypes.MOB_PROJECTILE)) || (magicProtected && source.is(DamageTypes.MAGIC))) return false;
		updateAbilities();
		return super.hurt(source, amount);
	}
	@Override
	public void heal(float amount) {
        if (isAlive()) {
            super.heal(amount);
            updateAbilities();
        }
    }
	@Override
	public BossBarColor getBarColor() {return byByte(entityData.get(VARIANT));}
	public static BossBarColor byByte(byte i) {
		return switch(i) {
		case 0 -> BossBarColor.BLUE;
		case 1 -> BossBarColor.GREEN;
		case 2 -> BossBarColor.PINK;
		case 3 -> BossBarColor.PURPLE;
		case 4 -> BossBarColor.RED;
		case 5 -> BossBarColor.YELLOW;
		default -> BossBarColor.WHITE;
		};
	}
	public byte getVariant() {
		if(entityData.get(VARIANT) == 6) {
			BlockState block = level().getBlockState(beam);
			if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_blue")))) return 0;
			else if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_green")))) return 1;
			else if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_pink")))) return 2;
			else if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_purple")))) return 3;
			else if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_red")))) return 4;
			else if(block.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_yellow")))) return 5;
		} return entityData.get(VARIANT);
	}
//	@Override
//	public void handleEntityEvent(byte b) {
//		if(b > 60 && b < 68) entityData.set(VARIANT, (byte) (b - 61));
//		else super.handleEntityEvent(b);
//	}
	public EntityAyeraco setVariant(byte variant) {entityData.set(VARIANT, variant); return this;}
	public EntityAyeraco setBeamPos(BlockPos pos) {beam = pos; return this;}
	@Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {return false;}
    @Override
    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {}
    @Override
    protected SoundEvent getAmbientSound() {return AYERACO.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return AYERACO_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return AYERACO_HURT.get();}
    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions dim) {
        return 0.65625F;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
    	super.addAdditionalSaveData(tag);
    	for(int i = 0; i < 5; i++) if(group[i] != null) tag.putUUID("Group" + i, group[i].uuid);
    	tag.putLong("Beam", beam.asLong());
    	tag.putByte("Variant", entityData.get(VARIANT));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
    	super.readAdditionalSaveData(tag);
    	loadExtra(tag);
    	broadcast = true;
    	this.tag = tag;
    }
    private void loadExtra(CompoundTag tag) {
    	EntityAyeraco[] group = new EntityAyeraco[5];
    	for(int i = 0; i < 5; i++) if(tag.contains("Group" + i)) group[i] = find(tag.getUUID("Group" + i));
    	beam = BlockPos.of(tag.getLong("Beam"));
    	byte b = tag.getByte("Variant");
    	entityData.set(VARIANT, b);
//    	level.broadcastEntityEvent(this, (byte) (b + 61));
    	assignGroup(group);
    }
    @Override
    protected void defineSynchedData() {
    	super.defineSynchedData();
    	entityData.define(VARIANT, (byte)6);
    }
    public EntityAyeraco find(UUID id) {
    	if(level() != null && !level().isClientSide && id != null) {
            Entity entity = ((ServerLevel) level()).getEntity(id);
            if(entity instanceof EntityAyeraco) return (EntityAyeraco) entity;
        } return null;
    }
    @Override
    public void tick() {
    	if(angry && canHeal) heal(2.5F);
    	if(broadcast && !level().isClientSide) {
    		loadExtra(tag);
    		broadcast = false;
    	}
    	super.tick();
    }
    
    //Phantom mimicking part
    @Override
    public void travel(Vec3 vec) {
        if(isInWater() || isInLava()) {
           moveRelative(0.02F, vec);
           move(MoverType.SELF, getDeltaMovement());
           setDeltaMovement(getDeltaMovement().scale(0.8D));
        } else {
           BlockPos ground = new BlockPos(blockPosition().below());
           float f = 0.91F;
           if(onGround()) f = level().getBlockState(ground).getFriction(level(), ground, this) * 0.91F;
           float f1 = 0.16277137F / (f * f * f);
           f = 0.91F;
           if(onGround()) f = level().getBlockState(ground).getFriction(level(), ground, this) * 0.91F;
           moveRelative(onGround() ? 0.1F * f1 : 0.02F, vec);
           move(MoverType.SELF, getDeltaMovement());
           setDeltaMovement(getDeltaMovement().scale(f));
        }
        calculateEntityAnimation(false);
	}
    
    class AyeracoBodyRotationControl extends BodyRotationControl {
        public AyeracoBodyRotationControl(Mob mob) {super(mob);}
        @Override
        public void clientTick() {
           EntityAyeraco.this.yHeadRot = EntityAyeraco.this.yBodyRot;
           EntityAyeraco.this.yBodyRot = EntityAyeraco.this.getYRot();
        }
     }
    
    class AyeracoLookControl extends LookControl {
        public AyeracoLookControl(Mob mob) {super(mob);}
        @Override public void tick() {}
     }
    
    class AyeracoMoveControl extends MoveControl {
	    private float speed = 0.2F;
	    public AyeracoMoveControl(Mob mob) {super(mob);}
	    @Override
	    public void tick() {
	       if (EntityAyeraco.this.horizontalCollision) {
	    	   EntityAyeraco.this.setYRot(EntityAyeraco.this.getYRot() + 180.0F);
	          speed = 0.2F;
	       }
	       double d0 = EntityAyeraco.this.moveTargetPoint.x - EntityAyeraco.this.getX();
	       double d1 = EntityAyeraco.this.moveTargetPoint.y - EntityAyeraco.this.getY();
	       double d2 = EntityAyeraco.this.moveTargetPoint.z - EntityAyeraco.this.getZ();
	       double d3 = Math.sqrt(d0 * d0 + d2 * d2);
	       if(Math.abs(d3) > 1.0E-5D) {
	          double d4 = 1.0 - Math.abs(d1 * 0.7) / d3;
	          d0 *= d4;
	          d2 *= d4;
	          d3 = Math.sqrt(d0 * d0 + d2 * d2);
	          double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
	          float f = EntityAyeraco.this.getYRot();
	          float f1 = (float)Mth.atan2(d2, d0);
	          float f2 = Mth.wrapDegrees(EntityAyeraco.this.getYRot() + 90.0F);
	          float f3 = Mth.wrapDegrees(f1 * (180F / (float)Math.PI));
	          EntityAyeraco.this.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
	          EntityAyeraco.this.yBodyRot = EntityAyeraco.this.getYRot();
	          if (Mth.degreesDifferenceAbs(f, EntityAyeraco.this.getYRot()) < 3.0F) speed = Mth.approach(speed, 1.8F, 0.005F * (1.8F / speed));
	          else speed = Mth.approach(this.speed, 0.22F, 0.025F);
	          float f4 = (float)(-(Mth.atan2(-d1, d3) * (double)(180F / (float)Math.PI)));
	          EntityAyeraco.this.setXRot(f4);
	          float f5 = EntityAyeraco.this.getYRot() + 90.0F;
	          double d6 = speed * Mth.cos(f5 * ((float)Math.PI / 180F)) * Math.abs(d0 / d5);
	          double d7 = speed * Mth.sin(f5 * ((float)Math.PI / 180F)) * Math.abs(d2 / d5);
	          double d8 = speed * Mth.sin(f4 * ((float)Math.PI / 180F)) * Math.abs(d1 / d5);
	          Vec3 vec3 = EntityAyeraco.this.getDeltaMovement();
	          EntityAyeraco.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
	       }
	    }
	}
    
    class AyeracoAttackStrategyGoal extends Goal {
      private int nextSweepTick;
      @Override
      public boolean canUse() {
         LivingEntity livingentity = EntityAyeraco.this.getTarget();
         return livingentity != null ? EntityAyeraco.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
      }
      @Override
      public void start() {
         nextSweepTick = adjustedTickDelay(10);
         EntityAyeraco.this.circling = true;
         setAnchorAboveTarget();
      }
      @Override
      public void stop() {
    	  EntityAyeraco.this.anchorPoint = EntityAyeraco.this.level().getHeightmapPos(Types.MOTION_BLOCKING, EntityAyeraco.this.anchorPoint).above(10 + EntityAyeraco.this.random.nextInt(20));
      }
      @Override
      public void tick() {
         if (EntityAyeraco.this.circling) {
            --nextSweepTick;
            if(nextSweepTick <= 0) {
            	EntityAyeraco.this.circling = false;
               setAnchorAboveTarget();
               nextSweepTick = adjustedTickDelay((8 + EntityAyeraco.this.random.nextInt(4)) * 20);
               EntityAyeraco.this.playSound(AYERACO_TELEPORT.get(), 10.0F, 0.95F + EntityAyeraco.this.random.nextFloat() * 0.1F);
            }
         }
      }
      private void setAnchorAboveTarget() {
    	  EntityAyeraco.this.anchorPoint = EntityAyeraco.this.getTarget().blockPosition().above(20 + EntityAyeraco.this.random.nextInt(20));
         if(EntityAyeraco.this.anchorPoint.getY() < EntityAyeraco.this.level().getSeaLevel()) {
        	 EntityAyeraco.this.anchorPoint = new BlockPos(EntityAyeraco.this.anchorPoint.getX(), EntityAyeraco.this.level().getSeaLevel() + 1, EntityAyeraco.this.anchorPoint.getZ());
         }
      }
	}
    
    abstract class AyeracoMoveTargetGoal extends Goal {
      public AyeracoMoveTargetGoal() {
         setFlags(EnumSet.of(Goal.Flag.MOVE));
      }
      protected boolean touchingTarget() {
         return EntityAyeraco.this.moveTargetPoint.distanceToSqr(EntityAyeraco.this.getX(), EntityAyeraco.this.getY(), EntityAyeraco.this.getZ()) < 4.0D;
      }
	}
    
    class AyeracoSweepAttackGoal extends AyeracoMoveTargetGoal {
      @Override
      public boolean canUse() {
         return EntityAyeraco.this.getTarget() != null && !EntityAyeraco.this.circling;
      }
      @Override
      public boolean canContinueToUse() {
         LivingEntity livingentity = EntityAyeraco.this.getTarget();
         if(livingentity == null || !livingentity.isAlive()) return false;
         else {
            if(livingentity instanceof Player) {
               Player player = (Player)livingentity;
               if(player.isSpectator() || player.isCreative()) return false;
            }
            return canUse();
         }
      }
      @Override
      public void start() {}
      @Override
      public void stop() {
    	  EntityAyeraco.this.setTarget(null);
    	  EntityAyeraco.this.circling = true;
      }
      @Override
      public void tick() {
         LivingEntity livingentity = EntityAyeraco.this.getTarget();
         if(livingentity != null) {
        	 EntityAyeraco.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
            if(EntityAyeraco.this.getBoundingBox().inflate(0.2).intersects(livingentity.getBoundingBox())) {
            	EntityAyeraco.this.doHurtTarget(livingentity);
            	EntityAyeraco.this.circling = true;
               if(!EntityAyeraco.this.isSilent()) EntityAyeraco.this.level().levelEvent(1039, EntityAyeraco.this.blockPosition(), 0);
            } else if(EntityAyeraco.this.horizontalCollision || EntityAyeraco.this.hurtTime > 0) EntityAyeraco.this.circling = true;
         }
      }
	}
    
    class AyeracoCircleAroundAnchorGoal extends AyeracoMoveTargetGoal {
      private float angle, distance, height, clockwise;
      @Override
      public boolean canUse() {
         return EntityAyeraco.this.getTarget() == null || EntityAyeraco.this.circling;
      }
      @Override
      public void start() {
         distance = 5.0F + EntityAyeraco.this.random.nextFloat() * 10.0F;
         height = -4.0F + EntityAyeraco.this.random.nextFloat() * 9.0F;
         clockwise = EntityAyeraco.this.random.nextBoolean() ? 1.0F : -1.0F;
         selectNext();
      }
      @Override
      public void tick() {
         if(EntityAyeraco.this.random.nextInt(adjustedTickDelay(350)) == 0) height = -4.0F + EntityAyeraco.this.random.nextFloat() * 9.0F;
         if(EntityAyeraco.this.random.nextInt(adjustedTickDelay(250)) == 0) {
            ++distance;
            if(distance > 15.0F) {
               distance = 5.0F;
               clockwise = -clockwise;
            }
         }
         if(EntityAyeraco.this.random.nextInt(adjustedTickDelay(450)) == 0) {
            angle = EntityAyeraco.this.random.nextFloat() * 2.0F * (float)Math.PI;
            selectNext();
         }
         if(touchingTarget()) selectNext();
         if(EntityAyeraco.this.moveTargetPoint.y < EntityAyeraco.this.getY() && !EntityAyeraco.this.level().isEmptyBlock(EntityAyeraco.this.blockPosition().below(1))) {
            height = Math.max(1.0F, height);
            selectNext();
         }
         if(EntityAyeraco.this.moveTargetPoint.y > EntityAyeraco.this.getY() && !EntityAyeraco.this.level().isEmptyBlock(EntityAyeraco.this.blockPosition().above(1))) {
            height = Math.min(-1.0F, height);
            selectNext();
         }
      }
      private void selectNext() {
         if(BlockPos.ZERO.equals(EntityAyeraco.this.anchorPoint)) EntityAyeraco.this.anchorPoint = EntityAyeraco.this.blockPosition();
         angle += clockwise * 15.0F * ((float)Math.PI / 180F);
         EntityAyeraco.this.moveTargetPoint = Vec3.atLowerCornerOf(EntityAyeraco.this.anchorPoint).add(distance * Mth.cos(angle), -4.0 + height, distance * Mth.sin(angle));
      }
	}
    
    class AyeracoAttackPlayerTargetGoal extends Goal {
      private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
      private int nextScanTick = reducedTickDelay(20);
      @Override
      public boolean canUse() {
         if(nextScanTick > 0) {
            --nextScanTick;
            return false;
         } else {
            nextScanTick = reducedTickDelay(60);
            List<Player> list = EntityAyeraco.this.level().getNearbyPlayers(attackTargeting, EntityAyeraco.this, EntityAyeraco.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
            if(!list.isEmpty()) {
               list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());
               for(Player player : list) if(EntityAyeraco.this.canAttack(player, TargetingConditions.DEFAULT)) {
            	 EntityAyeraco.this.setTarget(player);
                 return true;
               }
            }
            return false;
         }
      }
      @Override
      public boolean canContinueToUse() {
         LivingEntity livingentity = EntityAyeraco.this.getTarget();
         return livingentity != null ? EntityAyeraco.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
      }
	}
}