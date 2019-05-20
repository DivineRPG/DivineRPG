package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.ModelMystic;
import naturix.divinerpg.objects.entities.entity.twilight.Spellbinder;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpellbinder extends RenderLiving<Spellbinder> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/spellbinder.png");

    public RenderSpellbinder(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMystic(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Spellbinder entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Spellbinder> {
        @Override
        public Render<? super Spellbinder> createRenderFor(RenderManager manager) {
            return new RenderSpellbinder(manager, new ModelMystic(), 0);
        }
    }
}