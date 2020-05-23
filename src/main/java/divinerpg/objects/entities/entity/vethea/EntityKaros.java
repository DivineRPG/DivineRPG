package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.blocks.vethea.BlockHelioticBeam;
import divinerpg.objects.blocks.vethea.BlockKarosDispenser;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EntityKaros extends EntityDivineRPGBoss {

    private int ability;
    private final int DEFAULT = 0, CEILING = 1, CANNONS = 2, FLOOR = 3;
    private int abilityCooldown;

    private boolean hasLoadedBlocks = false;

    private List<BlockPos> ceiling = new ArrayList<BlockPos>();
    private List<BlockPos> cannons = new ArrayList<BlockPos>();

    public EntityKaros(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3f);
        ability = DEFAULT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_KAROS;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);

    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
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


    public void manageAbilities() {
        if (this.abilityCooldown == 0) {
            this.abilityCooldown = 200;
            switch (this.rand.nextInt(3)) {
                case 0:
                    ability = CEILING;
                    this.playSound(SoundRegistry.CEILING_EXPLOSIONS, 1.0F, 1.0F);
                    if (!this.world.isRemote) {
                        List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
                        for (EntityPlayer p : players) {
                            p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.explosion"));
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
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (source.isExplosion()) {
            return false;
        } else {
            return super.attackEntityFrom(source, par2);
        }

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!hasLoadedBlocks) {
            if (!this.world.isRemote) {
                List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
                for (EntityPlayer p : players) {
                    this.world.playSound(p, p.getPosition(), SoundRegistry.KAROS_INTRO, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.game"));
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.karos.begin"));
                }
            }
            for (int x = -40; x < 40; x++) {
                for (int y = -5; y < 20; y++) {
                    for (int z = -40; z < 40; z++) {
                        BlockPos currentPos = this.getPosition().add(x, y, z);
                        Block currentBlock = this.world.getBlockState(currentPos).getBlock();
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
            var2 = this.rand.nextInt(46);
            if ((this.abilityCooldown % 8) == 0) {
                BlockPos currentPos = ceiling.get(this.rand.nextInt(ceiling.size()));
                Block currentBlock = this.world.getBlockState(currentPos).getBlock();
                if (currentBlock instanceof BlockHelioticBeam) {
                    ((BlockHelioticBeam) currentBlock).dropBomb(this.world, currentPos);
                }

            }
        } else if (ability == CANNONS && this.cannons.size() != 0) {
            var2 = this.rand.nextInt(36);
            if ((this.abilityCooldown % 4) == 0) {
                BlockPos currentPos = cannons.get(this.rand.nextInt(cannons.size()));
                Block currentBlock = this.world.getBlockState(currentPos).getBlock();
                if (currentBlock instanceof BlockKarosDispenser) {
                    ((BlockKarosDispenser) currentBlock).dispense(this.world, currentPos);
                }
            }
        } else if (ability == FLOOR) {
            for (int i = 0; i < 3; i++) {
                double var4 = 0;
                while (var4 < 2 * Math.PI) {
                    int var1 = (int) Math.round(Math.sin(var4) * i);
                    int var3 = (int) Math.round(Math.cos(var4) * i);

                    BlockPos currentPos = new BlockPos((int) this.posX + var1, (int) this.posY - 1, (int) this.posZ + var3);
                    if (this.world.getBlockState(currentPos).getBlock() == BlockRegistry.karosHeatTileGreen) {
                        this.world.setBlockState(currentPos, BlockRegistry.karosHeatTileRed.getDefaultState());
                    }
                    var4 += Math.PI / 8.0D;
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
        int s = this.rand.nextInt(4);

        String langKey;
        SoundEvent sound;

        switch (rand.nextInt(4)) {
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

        world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox()
                .expand(30, 30, 30))
                .forEach(x -> x.sendMessage(LocalizeUtils.getClientSideTranslation(x, langKey)));

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
}
