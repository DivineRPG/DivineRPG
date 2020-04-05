package divinerpg.objects.entities.entity;

import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.ai.AIDivineLookAround;
import divinerpg.objects.entities.ai.AIDivineRandomFly;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.world.World;

public abstract class EntityDivineGhast extends EntityGhast {

    public EntityDivineGhast(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(5, new AIDivineRandomFly(this));
        this.tasks.addTask(7, new AIDivineLookAround(this));
        this.tasks.addTask(7, createShootAI());
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
    }

    protected abstract AIDivineFireballAttack createShootAI();
}
