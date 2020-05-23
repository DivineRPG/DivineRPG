package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityEternalArcher extends EntityDivineRPGBoss {

    private int armSelected;
    private int abilityTick;

    public EntityEternalArcher(World worldIn) {
        super(worldIn);
        this.setSize(3, 5);
        this.experienceValue = 250;
    }

    @Override
    public float getEyeHeight() {
        return 4.5F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 80));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.getAttackTarget() != null) {
            this.getLookHelper().setLookPosition(this.getAttackTarget().posX,
                    this.getAttackTarget().posY + (double) this.getAttackTarget().getEyeHeight(),
                    this.getAttackTarget().posZ, 10.0F, 5);
        }

        if (this.getAttackTarget() == null || this.rand.nextInt(200) == 0) {
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 48D, 48D));
        }
        if (this.getAttackTarget() != null && ((this.getAttackTarget() instanceof EntityPlayer
                && ((EntityPlayer) this.getAttackTarget()).capabilities.isCreativeMode)
                || this.getAttackTarget().isDead)) {
            this.setAttackTarget(null);
        }
        if (this.abilityTick > 0)
            this.abilityTick--;
        if (this.abilityTick == 0) {
            if (this.armSelected < 5)
                this.armSelected++;
            else if (this.armSelected == 5)
                this.armSelected = 0;
            this.abilityTick = 400;
        }

        if (this.abilityTick % 30 == 0 && this.getAttackTarget() != null && !this.world.isRemote) {
            this.world.spawnEntity(new EntityDivineArrow(this.world,
                    ArrowType.getArrowFromId(ArrowType.ETERNAL_ARCHER_FLAME_ARROW.ordinal() + this.armSelected), this,
                    this.getAttackTarget(), 1.6F, 5.0F));
        }
    }

    public int getSelectedArm() {
        return this.armSelected;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ETERNAL_ARCHER;
    }
}
