package divinerpg.entities.boss;

import divinerpg.blocks.vethea.*;
import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityKaros extends EntityDivineBoss {

    private int ability;
    private final int DEFAULT = 0, CEILING = 1, CANNONS = 2, FLOOR = 3;
    private int abilityCooldown;

    private boolean hasLoadedBlocks = false;

    private List<BlockPos> ceiling = new ArrayList<BlockPos>();
    private List<BlockPos> cannons = new ArrayList<BlockPos>();

    public EntityKaros(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        ability = DEFAULT;
    }

    @Override
    protected void customServerAiStep() {
        this.manageAbilities();
        super.customServerAiStep();
    }


    protected void registerGoals() {
        this.targetSelector.addGoal(0, new SwimGoal(this));
        this.targetSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.targetSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this, PiglinEntity.class));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }


    public void manageAbilities() {
        if (this.abilityCooldown == 0) {
            this.abilityCooldown = 200;
            switch (this.random.nextInt(3)) {
                case 0:
                    ability = CEILING;
                    this.playSound(SoundRegistry.CEILING_EXPLOSIONS, 1.0F, 1.0F);
                    if (!this.level.isClientSide) {
                        List<PlayerEntity> players = this.level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));
                        for (PlayerEntity p : players) {
                            p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.explosion"), p.getUUID());
                        }
                    }
                    break;
                case 1:
                    ability = CANNONS;
                    break;
                case 2:
                    ability = FLOOR;
                    break;
                default:
                    break;
            }
        } else if (this.abilityCooldown > 0) {
            this.abilityCooldown--;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.isExplosion()) {
            return false;
        } else {
            return super.hurt(source, par2);
        }

    }

    @Override
    public void tick() {
        super.tick();
        if (!hasLoadedBlocks) {
            if (!this.level.isClientSide) {
                List<PlayerEntity> players = level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));
                for (PlayerEntity p : players) {
                    this.level.playSound(p, p.blockPosition(), SoundRegistry.KAROS_INTRO, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.game"), p.getUUID());
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.begin"), p.getUUID());
                }
            }
            for (int x = -40; x < 40; x++) {
                for (int y = -5; y < 20; y++) {
                    for (int z = -40; z < 40; z++) {
                        BlockPos currentPos = this.blockPosition().offset(x, y, z);
                        Block currentBlock = this.level.getBlockState(currentPos).getBlock();
                        if (currentBlock == BlockRegistry.helioticBeam) {
                            ceiling.add(currentPos);
                        } else if (currentBlock == BlockRegistry.karosDispenser) {
                            cannons.add(currentPos);
                        }
                    }
                }
            }
            hasLoadedBlocks = true;
        }

        int var2;
        if (ability == CEILING && this.ceiling.size() != 0) {
            var2 = this.random.nextInt(46);
            if ((this.abilityCooldown % 8) == 0) {
                BlockPos currentPos = ceiling.get(this.random.nextInt(ceiling.size()));
                Block currentBlock = this.level.getBlockState(currentPos).getBlock();
                if (currentBlock instanceof BlockHelioticBeam) {
                    ((BlockHelioticBeam) currentBlock).dropBomb(this.level, currentPos);
                }

            }
        } else if (ability == CANNONS && this.cannons.size() != 0) {
            var2 = this.random.nextInt(36);
            if ((this.abilityCooldown % 4) == 0) {
                BlockPos currentPos = cannons.get(this.random.nextInt(cannons.size()));
                Block currentBlock = this.level.getBlockState(currentPos).getBlock();
                if (currentBlock instanceof BlockKarosDispenser) {
                    ((BlockKarosDispenser) currentBlock).dispenseFrom(level.getServer().getLevel(level.dimension()), currentPos);
//                }
                }
            } else if (ability == FLOOR) {
                for (int i = 0; i < 3; i++) {
                    double var4 = 0;
                    while (var4 < 2 * Math.PI) {
                        int var1 = (int) Math.round(Math.sin(var4) * i);
                        int var3 = (int) Math.round(Math.cos(var4) * i);

                        BlockPos currentPos = new BlockPos((int) this.getX() + var1, (int) this.getY() - 1, (int) this.getZ() + var3);
                        if (this.level.getBlockState(currentPos).getBlock() == BlockRegistry.karosHeatTileGreen) {
                            this.level.setBlock(currentPos, BlockRegistry.karosHeatTileRed.defaultBlockState(), 0);
                        }
                        var4 += Math.PI / 8.0D;
                    }
                }
            }
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
//        int s = this.random.nextInt(4);

        String langKey;
        SoundEvent sound;

        switch (random.nextInt(4)) {
            case 0:
                langKey = "message.karos.laugh";
                sound = SoundRegistry.KAROS_LAUGH;
                break;

            case 1:
                langKey = "message.karos.doom";
                sound = SoundRegistry.MEET_DOOM;
                break;

            case 2:
                langKey = "message.karos.cmon";
                sound = SoundRegistry.TRY_YOUR_BEST;
                break;

            default:
                langKey = "message.karos.weak";
                sound = SoundRegistry.YOU_CANT_KILL_ME;
                break;
        }

        level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox()
                .expandTowards(30, 30, 30))
                .forEach(x -> x.sendMessage(LocalizeUtils.getClientSideTranslation(x, langKey), x.getUUID()));

        return sound;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return null;
    }

    @Override
    public SoundEvent getDeathSound() {
        return null;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.karosHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.karosDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.karosSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.karosFollowRange);
    }
}
