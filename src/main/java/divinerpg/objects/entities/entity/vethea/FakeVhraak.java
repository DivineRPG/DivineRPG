package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class FakeVhraak extends Vhraak {

    private int lifeTick = 50;

    public FakeVhraak(World worldIn) {
        super(worldIn);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_FAKE_VHRAAK;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        this.lifeTick--;
        if(this.lifeTick <= 0) {
            this.setDead();
        }
    }
}
