package net.divinerpg.client.render.block.model;

import net.divinerpg.api.model.DivineModel;
import net.divinerpg.api.model.DivineRenderer;
import net.minecraft.client.model.ModelRenderer;

public class ModelWatcherStatue extends DivineModel
{
    //fields
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Tentacle11;
    ModelRenderer Tentacle12;
    ModelRenderer Tentacle21;
    ModelRenderer Tentacle22;
    ModelRenderer Support;
    ModelRenderer Tentacle32;
    ModelRenderer Tentacle31;

    public ModelWatcherStatue()
    {
        super("statueWatcher", 64, 32);

        Head = new DivineRenderer(this, 0, 0);
        Head.addBox(-5F, -5F, -5F, 10, 10, 10);
        Head.setRotationPoint(0F, 13F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, -1.570796F, 0F);
        Jaw = new DivineRenderer(this, 0, 20);
        Jaw.addBox(-5F, 0F, -10F, 10, 1, 10);
        Jaw.setRotationPoint(0F, 18F, 5F);
        Jaw.setTextureSize(64, 32);
        Jaw.mirror = true;
        setRotation(Jaw, 0.1745329F, 0F, 0F);
        Tentacle11 = new DivineRenderer(this, 40, 0);
        Tentacle11.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle11.setRotationPoint(5F, 13F, 0F);
        Tentacle11.setTextureSize(64, 32);
        Tentacle11.mirror = true;
        setRotation(Tentacle11, 0F, 1.570796F, 0F);
        Tentacle12 = new DivineRenderer(this, 40, 6);
        Tentacle12.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle12.setRotationPoint(9F, 13F, 0F);
        Tentacle12.setTextureSize(64, 32);
        Tentacle12.mirror = true;
        setRotation(Tentacle12, 0F, 4.712389F, 0F);
        Tentacle21 = new DivineRenderer(this, 40, 0);
        Tentacle21.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle21.setRotationPoint(-5F, 13F, 0F);
        Tentacle21.setTextureSize(64, 32);
        Tentacle21.mirror = true;
        setRotation(Tentacle21, 0F, 4.712389F, 0F);
        Tentacle22 = new DivineRenderer(this, 40, 6);
        Tentacle22.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle22.setRotationPoint(-9F, 13F, 0F);
        Tentacle22.setTextureSize(64, 32);
        Tentacle22.mirror = true;
        setRotation(Tentacle22, 0F, 4.712389F, 0F);
        Support = new DivineRenderer(this, 52, 0);
        Support.addBox(-1F, -3F, -1F, 2, 4, 2);
        Support.setRotationPoint(0F, 23F, 0F);
        Support.setTextureSize(64, 32);
        Support.mirror = true;
        setRotation(Support, 0F, 0F, 0F);
        Tentacle32 = new DivineRenderer(this, 40, 6);
        Tentacle32.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle32.setRotationPoint(0F, 4F, 0F);
        Tentacle32.setTextureSize(64, 32);
        Tentacle32.mirror = true;
        setRotation(Tentacle32, 0F, 4.712389F, 0F);
        Tentacle31 = new DivineRenderer(this, 52, 0);
        Tentacle31.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle31.setRotationPoint(0F, 8F, 0F);
        Tentacle31.setTextureSize(64, 32);
        Tentacle31.mirror = true;
        setRotation(Tentacle31, 0F, 0F, 0F);
    }

}
