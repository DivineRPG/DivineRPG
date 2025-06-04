package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.*;

import java.util.*;

import static divinerpg.registries.SoundRegistry.*;

public class EntityAyeraco extends EntityDivineBoss {
	public BlockPos beam;
	
	private Vec3 moveTargetPoint = Vec3.ZERO;
	private boolean circling = true;
	private BlockPos anchorPoint = BlockPos.ZERO;
	public EntityAyeraco(EntityType<? extends EntityAyeraco> type, Level level) {
		this(type, level, BlockPos.ZERO, (byte)0);
	}
	public EntityAyeraco(EntityType<? extends EntityAyeraco> type, Level worldIn, BlockPos beam, byte variant) {
		super(type, worldIn);
		this.beam = beam;
		moveControl = new AyeracoMoveControl(this);
		lookControl = new AyeracoLookControl(this);
        if(!worldIn.isClientSide()) AttachmentRegistry.VARIANT.setSilent(this, variant);
	}
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide()) AttachmentRegistry.VARIANT.requestAttachment(this, null);
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
	@Override
	public void die(DamageSource source) {
		super.die(source);
        if(level().isLoaded(beam)) level().setBlock(beam, Blocks.AIR.defaultBlockState(), 3);
	}
    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source)
                || ((source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW) || source.is(DamageTypes.TRIDENT)) && isProjectileProtected())
                || ((source.is(DamageTypes.MAGIC) || source.is(DamageTypes.DRAGON_BREATH) || source.is(DamageTypes.INDIRECT_MAGIC)) && isMagicProtected());
    }
    public static List<EntityAyeraco> getNearbyAyeracos(Level level, Vec3 pos) {
        return level.getEntitiesOfClass(EntityAyeraco.class, new AABB(pos.x - 32, pos.y - 32, pos.z - 32, pos.x + 32, pos.y + 32, pos.z + 32));
    }
    public boolean isProjectileProtected() {
        for(EntityAyeraco e : getNearbyAyeracos(level(), position())) if(e.isGreen()) return true;
        return false;
    }
    public boolean isMagicProtected() {
        for(EntityAyeraco e : getNearbyAyeracos(level(), position())) if(e.isPink()) return true;
        return false;
    }
    public boolean isGreen() {
        return AttachmentRegistry.VARIANT.get(this) == 1;
    }
    public boolean isPink() {
        return AttachmentRegistry.VARIANT.get(this) == 2;
    }
    public boolean isPurple() {
        return AttachmentRegistry.VARIANT.get(this) == 3;
    }
    public boolean isRed() {
        return AttachmentRegistry.VARIANT.get(this) == 4;
    }
    public boolean isYellow() {
        return AttachmentRegistry.VARIANT.get(this) == 5;
    }
    public boolean isBlue() {
        return AttachmentRegistry.VARIANT.get(this) == 6;
    }
    @Override
	public boolean hurt(DamageSource source, float amount) {
		boolean b = super.hurt(source, amount);
        if(!level().isClientSide() && isAlive()) {
            byte variant = getVariant();
            boolean isRed = variant == 4, isYellow = variant == 5, isBlue = variant == 6;
            for(EntityAyeraco e : getNearbyAyeracos(level(), position())) {
                if(isRed && e != this && e.getHealth() < e.getMaxHealth()) e.setHealth(e.getMaxHealth());
                if(isYellow) e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 255, 2, true, false, false));
                if(isBlue) e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 255, 2, true, false, false));
                if(e.isPurple()) {
                    playSound(SoundRegistry.AYERACO_TELEPORT.get(), 2.0F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
                    teleportRelative(random.nextInt(5) - 2, 3 + random.nextInt(15), random.nextInt(5) - 2);
                }
            }
        }
		return b;
	}
	public byte getVariant() {
        byte variant = AttachmentRegistry.VARIANT.get(this);
		if(variant == 0 && beam != null) {
			BlockState block = level().getBlockState(beam);
			if(block.is(BlockRegistry.ayeracoBeamBlue.get())) return 6;
			else if(block.is(BlockRegistry.ayeracoBeamGreen.get())) return 1;
			else if(block.is(BlockRegistry.ayeracoBeamPink.get())) return 2;
			else if(block.is(BlockRegistry.ayeracoBeamPurple.get())) return 3;
			else if(block.is(BlockRegistry.ayeracoBeamRed.get())) return 4;
			else if(block.is(BlockRegistry.ayeracoBeamYellow.get())) return 5;
		} return variant;
	}

    @Override
    public boolean hasCustomName() {
        return false;
    }

    public EntityAyeraco setVariant(byte variant) {
        AttachmentRegistry.VARIANT.set(this, variant == 0 ? 6 : variant);
        Component component = Component.translatable(switch(variant) {
            case 1 -> "entity.divinerpg.green_ayeraco";
            case 2 -> "entity.divinerpg.pink_ayeraco";
            case 3 -> "entity.divinerpg.purple_ayeraco";
            case 4 -> "entity.divinerpg.red_ayeraco";
            case 5 -> "entity.divinerpg.yellow_ayeraco";
            default -> "entity.divinerpg.blue_ayeraco";
        });
        setCustomName(component);
        return this;
    }
	public void setBeamPos(BlockPos pos) {beam = pos;}
    @Override
    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {}
    @Override
    protected SoundEvent getAmbientSound() {return AYERACO.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return AYERACO_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return AYERACO_HURT.get();}
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
    	super.addAdditionalSaveData(tag);
    	tag.putLong("Beam", beam.asLong());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
    	super.readAdditionalSaveData(tag);
        beam = BlockPos.of(tag.getLong("Beam"));
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
    
    static class AyeracoLookControl extends LookControl {
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
         return livingentity != null && EntityAyeraco.this.canAttack(livingentity, TargetingConditions.DEFAULT);
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
            if(livingentity instanceof Player player && (player.isSpectator() || player.isCreative()))  return false;
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
         if(nextScanTick > 0) nextScanTick--;
         else {
            nextScanTick = reducedTickDelay(60);
            List<Player> list = EntityAyeraco.this.level().getNearbyPlayers(attackTargeting, EntityAyeraco.this, EntityAyeraco.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
            if(!list.isEmpty()) {
               list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());
               for(Player player : list) if(EntityAyeraco.this.canAttack(player, TargetingConditions.DEFAULT)) {
            	 EntityAyeraco.this.setTarget(player);
                 return true;
               }
            }
         } return false;
      }
      @Override
      public boolean canContinueToUse() {
         LivingEntity livingentity = EntityAyeraco.this.getTarget();
         return livingentity != null && EntityAyeraco.this.canAttack(livingentity, TargetingConditions.DEFAULT);
      }
	}
}