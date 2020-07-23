package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vanilla.EntityMiner;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderMiner extends RenderBiped<EntityMiner> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/miner.png");

    public RenderMiner(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelZombie(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
            protected void initArmor() {
                this.modelLeggings = new ModelZombie(0.5F, true);
                this.modelArmor = new ModelZombie(1.0F, true);
            }
        };
        this.addLayer(layerbipedarmor);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMiner entity) {
        return texture;
    }
}