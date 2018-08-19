package naturix.divinerpg.entities.hostile.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.hostile.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.dramcryx.ModelDramcryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDramcryx extends RenderLiving<JungleStegosaurus> {
    private ResourceLocation mobTexture = new ResourceLocation("divinerpg:textures/entity/dramcryx_jungle.png");
    public static final IRenderFactory FACTORY = new Factory();
    private final ModelDramcryx ModelDramcryx;

    public RenderDramcryx(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramcryx(), 0.5F);
        ModelDramcryx = (ModelDramcryx) super.mainModel;
    }

    @Override
    public void doRender(JungleStegosaurus entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(JungleStegosaurus entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<JungleStegosaurus> {

        @Override
        public Render<? super JungleStegosaurus> createRenderFor(RenderManager manager) {
            return new RenderDramcryx(manager, new ModelDramcryx(), 0.5F);
        }
    }

}