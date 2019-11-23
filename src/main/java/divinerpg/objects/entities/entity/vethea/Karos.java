package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.blocks.vethea.BlockHelioticBeam;
import divinerpg.objects.blocks.vethea.BlockKarosCannon;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModSounds;
import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Karos extends EntityDivineRPGBoss {

    private int       ability;
    private final int DEFAULT = 0, CEILING = 1, CANNONS = 2, FLOOR = 3;
    private int       abilityCooldown;

    private int deathTicks;
    private boolean hasLoadedBlocks = false;

    private List<BlockPos> ceiling    = new ArrayList<BlockPos>();
    private List<BlockPos> cannons    = new ArrayList<BlockPos>();

    public Karos(World worldIn) {
		super(worldIn);
		this.setSize(1F, 3f);
        ability = DEFAULT;
	}

    @Override
	protected ResourceLocation getLootTable()
	{
		return DRPGLootTables.ENTITIES_KAROS;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4000.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);

    }

    @Override
    protected void updateAITasks() {
        this.manageAbilities();
        super.updateAITasks();
    }

    public void manageAbilities() {
        if (this.abilityCooldown == 0) {
            this.abilityCooldown = 200;
            switch (this.rand.nextInt(3)) {
                case 0:
                    ability = CEILING;
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
                    this.playSound(ModSounds.CEILING_EXPLOSIONS, 1.0F, 1.0F);
                    if (!this.world.isRemote) {
                        List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
                        for (EntityPlayer p : players) {
                            p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.explosion")));
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
                    this.world.playSound(p, p.getPosition(), ModSounds.KAROS_INTRO, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.game")));
                    p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.begin")));
                }
            }
            for (int x = -40; x < 40; x++) {
                for (int y = -5; y < 20; y++) {
                    for (int z = -40; z < 40; z++) {
                        BlockPos currentPos = this.getPosition().add(x, y, z);
                        Block currentBlock = this.world.getBlockState(currentPos).getBlock();
                        if(currentBlock == ModBlocks.helioticBeam) {
                            ceiling.add(currentPos);
                        }
                        else if(currentBlock == ModBlocks.karosCannon) {
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
                if(currentBlock instanceof BlockHelioticBeam) {
                    ((BlockHelioticBeam)currentBlock).dropBomb(this.world, currentPos);
                }

            }
        } else if (ability == CANNONS && this.cannons.size() != 0) {
            var2 = this.rand.nextInt(36);
            if ((this.abilityCooldown % 4) == 0) {
                BlockPos currentPos = cannons.get(this.rand.nextInt(cannons.size()));
                Block currentBlock = this.world.getBlockState(currentPos).getBlock();
                if(currentBlock instanceof BlockKarosCannon) {
                    ((BlockKarosCannon)currentBlock).dispense(this.world, currentPos);
                }
            }
        } else if (ability == FLOOR) {
            for (int i = 0; i < 3; i++) {
                double var4 = 0;
                while (var4 < 2 * Math.PI) {
                    int var1 = (int) Math.round(Math.sin(var4) * i);
                    int var3 = (int) Math.round(Math.cos(var4) * i);

                    BlockPos currentPos = new BlockPos((int)this.posX + var1, (int)this.posY - 1, (int)this.posZ + var3);
                    if(this.world.getBlockState(currentPos).getBlock() == ModBlocks.karosHeatTileGreen) {
                        this.world.setBlockState(currentPos, ModBlocks.karosHeatTileRed.getDefaultState());
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
        List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
        for (EntityPlayer p : players) {
            switch (s) {
                case 0:
                    if (!this.world.isRemote)
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.laugh")));
                    break;
                case 1:
                    if (!this.world.isRemote)
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.doom")));
                    break;
                case 2:
                    if (!this.world.isRemote)
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.cmon")));
                    break;
                default:
                    if (!this.world.isRemote)
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.karos.weak")));
                    break;
            }

        }

        switch (s) {
            case 0:
                return ModSounds.KAROS_LAUGH;
            case 1:
                return ModSounds.MEET_DOOM;
            case 2:
                return ModSounds.TRY_YOUR_BEST;
            default:
                return ModSounds.YOU_CANT_KILL_ME;

        }
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return null;
    }

    @Override
    public SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
        }

        int var4, var5;

        if (!this.world.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 1000;

                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, var5));
                }
            }
        }

        this.move(MoverType.SELF, 0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.world.isRemote) {
            var4 = 2000;

            while (var4 > 0) {
                var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }

}
